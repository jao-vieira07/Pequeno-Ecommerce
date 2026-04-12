package PequenoEcommerce.Model;

public class Vestuario extends Produto {

    public Vestuario( String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double CalcularPrecoFinal() {
        double precoDoVestuarioComDesconto = getPreco();
        if (getPreco() > 100) {  //FAZ A LÓGICA APARTIR DE SE FOR MAIOR DO QUE 100 JÁ VEM COM 10% DE DESCONTO.
            precoDoVestuarioComDesconto = getPreco() * (1 - 0.10);
        } else {
            getPreco();
        }
        if (getPromocao() != null) { //FAZ A VERIFICAÇÃO SE EXISTE OU NÃO UMA PROMOÇÃO E LANÇA A LÓGICA.
            return getPromocao().aplicar(precoDoVestuarioComDesconto);
        } else {
            return precoDoVestuarioComDesconto;
        }
    }

    @Override
    public String obterDadosArquivo() {
        return "V;" + getNome() + ";" + getPreco() + ";" + promocaoTxt(); //RETORNA O FORMATO PARA O ARQUIVO TXT
        // EX: V; NIKE SHOX; 120; DESCONTO BLACKFRIDAY.
    }
}

