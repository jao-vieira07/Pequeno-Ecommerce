package PequenoEcommerce.Desconto;

public class DescontoAniversario implements Promocao {

    @Override
    public double aplicar(double valorPreco) {
        return valorPreco * (1 - 0.15);
    }
}
