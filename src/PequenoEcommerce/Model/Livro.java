package PequenoEcommerce.Model;

public class Livro extends Produto {

    public Livro( String nome, double preco) {
        super(nome,preco);
    }

    @Override
    public double CalcularPrecoFinal() {
        double precoDoLivroComDesconto = getPreco() * (1 - 0.10); //LÓGICA PARA QUE O LIVRO JÁ VENHA COM DESCONTO DE 10%
        if (getPromocao() != null) { //FAZ A VERIFICAÇÃO SE EXISTE OU NÃO UMA PROMOÇÃO E LANÇA A LÓGICA.
            return getPromocao().aplicar(precoDoLivroComDesconto);
        } else {
            return precoDoLivroComDesconto;
        }
    }

    @Override
    public String obterDadosArquivo() {
        return "L;" + getNome() + ";" + getPreco() + ";" + promocaoTxt(); //RETORNA O FORMATO PARA O ARQUIVO TXT
        // EX: L; HARRY POTTER; 120; NATAL.
    }
}
