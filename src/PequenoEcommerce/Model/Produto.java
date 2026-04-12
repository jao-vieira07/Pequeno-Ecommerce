package PequenoEcommerce.Model;

import PequenoEcommerce.Desconto.Promocao;

public abstract class Produto {
    private String nome;
    private double preco;
    private Promocao promocao;

    public Produto( String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public abstract double CalcularPrecoFinal();

    public abstract String obterDadosArquivo();

    protected String promocaoTxt() {
        if (promocao == null) {
            return "NÃO HÁ PROMOÇÕES";
        } return this.promocao.getClass().getSimpleName();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Promocao getPromocao() {
        return promocao;
    }
    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }
}
