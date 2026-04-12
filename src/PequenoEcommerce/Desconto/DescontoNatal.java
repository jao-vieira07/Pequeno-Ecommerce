package PequenoEcommerce.Desconto;

public class DescontoNatal implements Promocao {
    @Override
    public double aplicar(double valorPreco) {
        return valorPreco * (1 - 0.50);
    }
}
