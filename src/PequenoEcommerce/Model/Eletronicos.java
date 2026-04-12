package PequenoEcommerce.Model;

public class Eletronicos extends Produto{

    public Eletronicos( String nome, double preco) {
        super( nome, preco);
    }

    @Override
    public double CalcularPrecoFinal() {
        double precoEletronicoComDesconto = this.getPreco() * (1 - 0.15);

        if (getPromocao() != null) {
            return getPromocao().aplicar(precoEletronicoComDesconto);
        }
        return precoEletronicoComDesconto;
    }

    @Override
    public String obterDadosArquivo() {
        return "E;" + getNome() + ";" + getPreco() + ";" + promocaoTxt(); //RETORNA O FORMATO PARA O ARQUIVO TXT
        // EX: E; TV SAMSUNG; 2500; DESCONTO ANIVERSARIO.
    }


}
