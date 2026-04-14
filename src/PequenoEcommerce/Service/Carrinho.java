package PequenoEcommerce.Service;

import PequenoEcommerce.Exception.CarrinhoVazioException;
import PequenoEcommerce.Exception.PosicaoInvalidaException;
import PequenoEcommerce.Exception.ValorInvalidoException;
import PequenoEcommerce.Model.Eletronicos;
import PequenoEcommerce.Model.Livro;
import PequenoEcommerce.Model.Produto;
import PequenoEcommerce.Model.Vestuario;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Carrinho {
    private final List<Produto> item;


    public Carrinho() {  //INICIA UMA NOVA LISTA E CARREGA OS DADOS DO ARQUIVO TXT CASO EXISTAM.
        item = new ArrayList<>();
        carregarArquivo();
    }

    public void adicionarItem(Produto p) { //LÓGICA PARA ADD PRODUTO
        if (p.getPreco() <= 0) {
            throw new ValorInvalidoException("ERRO! INFORME UM VALOR MAIOR DO QUE 0\n");
        }
        item.add(p);
        System.out.println("Produto adicionado com sucesso!");
        salvarArquivo(); //SALVA NO ARQUIVO TXT


    }

    public void removerItem(int i) { //LÓGICA QUE REMOVE O PRODUTO.
        if (i >= 0 && i < item.size()) {
            item.remove(i);
            System.out.println("Produto removido com sucesso!");
            salvarArquivo();
        } else {
            throw new PosicaoInvalidaException("ERRO!O INDICE NÃO INDICA NENHUM PRODUTO!"); /*
            EXCEÇÃO CASO O INDICE NÃO EXISTA NA LISTA*/
        }
    }

    public void imprimirItens() { //LÓGICA PARA IMPRIMIR A LISTA PARA QUE O USUÁRIO SAIBA O QUE QUER REMOVER.
        for (int i = 0; i < item.size(); i++) {
            System.out.printf("[%d] %s - R$ %.2f%n", i, item.get(i).getNome(), item.get(i).getPreco());
        }
    }

    public void calcular() {
        double somaTotal = 0.0;
        double somaTotalComDesconto = 0.0;

        if (item.isEmpty()) { //LANÇA EXCEÇÃO SE O CARRINHO ESTIVER VÁZIO.
            throw new CarrinhoVazioException("\nERRO! O CARRINHO NÃO POSSUÍ NENHUM ITEM!");
        }

        for (Produto p : item) { //PERCORRE A LISTA SOMA O TOTAL BRUTO E O TOTAL COM OS DESCONTOS.
            somaTotal = somaTotal + p.getPreco();
            somaTotalComDesconto += p.CalcularPrecoFinal();
        }

        double economia = somaTotal - somaTotalComDesconto; //CONTA BÁSICA PARA SABER O VALOR DO DESCONTO.

        notaFiscal(); //IMPRIME A NOTA FISCAL
        if  (economia > 0) { //VERIFICA SE HOUVE DESCONTO E LANÇA UMA MENSAGEM BONITINHA.
            System.out.print("\nDesconto concedido com sucesso!");
            System.out.printf("\nValor descontado: R$ %.2f\n", economia);
        }
        System.out.printf("\nValor total do Carrinho: R$ %.2f\n", somaTotalComDesconto); /*MOSTRA O VALOR TOTAL DO
        CARRINHO JÁ COM DESCONTOS*/

    }

    public void notaFiscal() {
        //LÓGICA DA NOTA FISCAL
        Calendar cl = Calendar.getInstance();
        DateFormat df = DateFormat.getDateInstance();
        System.out.println("--- Nota Fiscal ---");

        System.out.println("\nData da compra: " + df.format(cl.getTime()));
        for (Produto p : item) { //PERCORRE TODOS OS ITENS E IMPRIME
            System.out.printf("Produto: %s | VALOR: R$ %.2f\n", p.getNome(), p.getPreco());
        }
    }

    private void carregarArquivo() {
        File arquivo = new File("NOTA_FISCAL.txt"); //LOCALIZA O ARQUIVO TXT NA MAQUINA
        if (arquivo.exists()) { //VERIFICA SE EXISTE ALGUM ARQUIVO
            try {
                Scanner lerArquivo = new Scanner(arquivo);

                while (lerArquivo.hasNextLine()) {
                    Produto p;
                    String linha = lerArquivo.nextLine();

                    if (linha.trim().isEmpty() || !linha.contains(";")) { //CONTINUA MESMO COM ESPAÇOS VAZIOS OU; EM LUGARES INDEVIDOS.
                        continue;
                    }

                    String[] linhaSplit = linha.split(";");//CORTA CADA PARTE AO CHEGAR NO ";"
                    String parte = linhaSplit[0]; //CORTA O TIPO "L","E","V"
                    String nome = linhaSplit[1]; //CORTA O NOME DO PRODUTO
                    double preco = Double.parseDouble(linhaSplit[2]); //CORTA O VALOR DO PRODUTO
                    String promoTxt = linhaSplit[3]; //POR ÚLTIMO CORTA O DESCONTO, CASO NÃO HAJA INFORMA DESCONTO COMO "NENHUM"

                    p = switch (parte) { //VERIFICA QUAL É A LETRA E DEVOLVE O OBJETO
                        case "L" -> new Livro(nome, preco);
                        case "E" -> new Eletronicos(nome, preco);
                        case "V" -> new Vestuario(nome, preco);
                        default -> null;
                    };

                    if (p != null) {
                        p.setPromocao(PromocaoS.promocaoTxt(promoTxt));
                        item.add(p);
                    }
                }
                lerArquivo.close();
            } catch (IOException ex) {
                System.err.println("ERRO!NOTA FISCAL NÃO ENCONTRADA!");
            }
        }
    }

    private void salvarArquivo() {
        try {
            File arquivo = new File("NOTA_FISCAL.txt"); //CRIA O ARQUIVO NOTA_FISCAL.TXT
            PrintWriter gravarArquivo = new PrintWriter(arquivo); ;//GRAVA AS INFORMAÇÕES

            for (Produto p : item) { //DA UM PRINTLN NO ARQUIVO TXT COM AQUELA LÓGICA DO LIVRO, ELETRÔNICO E VESTUARIO.
                gravarArquivo.println(p.obterDadosArquivo());
            }
            gravarArquivo.close();

        } catch (IOException ex) {
            System.err.println("ERRO! AO GERAR O ARQUIVO");
        }

    }

}
