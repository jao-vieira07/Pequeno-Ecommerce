package PequenoEcommerce.Main;

import PequenoEcommerce.Exception.CarrinhoVazioException;
import PequenoEcommerce.Exception.PosicaoInvalidaException;
import PequenoEcommerce.Exception.ValorInvalidoException;
import PequenoEcommerce.Model.Produto;
import PequenoEcommerce.Service.PromocaoS;
import PequenoEcommerce.InputUtils.Input;
import PequenoEcommerce.Model.Eletronicos;
import PequenoEcommerce.Model.Livro;
import PequenoEcommerce.Model.Vestuario;
import PequenoEcommerce.Service.Carrinho;

public class Main {
    static void main() {
        Carrinho c = new Carrinho();

        int opcao;

        do {
            opcao = Input.lerInt("""
                    
                    -- E-COMMERCE --
                    1. ADICIONAR LIVRO
                    2. ADICIONAR ELETRÔNICO
                    3. ADICIONAR VESTUÁRIO
                    4. IMPRIMIR NOTA FISCAL
                    5. REMOVER ITEM
                    0. SAIR
                    
                    Informe a opção que deseja:\s"""); //IMPRIME NA TELA O MENU.

            Produto p;
            switch (opcao) { //APARTIR DA OPÇÃO SELECIONADA SOLICITA AO USUÁRIO QUE INFORME NOME, VALOR E DESCONTO.
                case 1:
                    String nomeDoLivro = Input.lerString("Informe o nome do livro: ");
                    double precoDoLivro = Input.lerDouble("Informe o valor do livro: ");
                    try {
                        p = new Livro(nomeDoLivro, precoDoLivro); //TENTA CRIAR UM OBJETO LIVRO NA LISTA.
                        p.setPromocao(PromocaoS.selecionar()); //CHAMA O MENU DE PROMOÇÕES
                        c.adicionarItem(p); //ADICIONA O PRODUTO NO CARRINHO
                    } catch (ValorInvalidoException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    String nomeDoEletronico = Input.lerString("Informe o nome do eletronico: ");
                    double precoDoEletronico = Input.lerDouble("Informe valor do eletrônico: ");

                    try {
                        p = new Eletronicos(nomeDoEletronico, precoDoEletronico); //CRIA UM PRODUTO NA LISTA.
                        p.setPromocao(PromocaoS.selecionar()); //CHAMA O MENU DE PROMOÇÕES.
                        c.adicionarItem(p); //ADD NA LISTA.
                    } catch (ValorInvalidoException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    String nomeDaRoupa = Input.lerString("Informe o nome do roupa: ");
                    double precoDaRoupa = Input.lerDouble("Informe o valor da roupa: ");

                    try {
                        p = new Vestuario(nomeDaRoupa, precoDaRoupa); //CRIA UMA ROUPA NA LISTA.
                        p.setPromocao(PromocaoS.selecionar()); //CHAMA A INTERFACE DE PROMOÇÕES.
                        c.adicionarItem(p); //ADD O ITEM.
                    } catch (ValorInvalidoException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    try { //TENTA EXECUTAR O METODO QUE IMPRIME A NOTA FISCAL, CASO NÃO EXISTA LANÇA UMA EXCEÇÃO.
                        c.calcular();
                    } catch (CarrinhoVazioException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 5:
                    c.imprimirItens();
                    String leia = Input.lerString("Informe qual item deseja excluir: ");

                    try {
                        int idx = Integer.parseInt(leia); //FAZ A TRADUÇÃO DE STRING PARA INT, EVITANDO QUE O SCANNER DEIXEI LIXO NO BUFFERED.
                        c.removerItem(idx);
                    } catch (CarrinhoVazioException | PosicaoInvalidaException ex) {
                        System.err.println(ex.getMessage());
                    } catch (NumberFormatException ex) {
                        System.out.println("\nERRO! DIGITE APENAS NUMEROS");
                    }
                    break;
                case 0:
                    System.out.println("Obrigado por utlizar nossos serviços!");


            }
        } while (opcao != 0);
    }
}
