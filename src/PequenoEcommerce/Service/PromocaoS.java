package PequenoEcommerce.Service;

import PequenoEcommerce.Desconto.DescontoAniversario;
import PequenoEcommerce.Desconto.DescontoBlackFriday;
import PequenoEcommerce.Desconto.DescontoNatal;
import PequenoEcommerce.Desconto.Promocao;
import PequenoEcommerce.InputUtils.Input;

public class PromocaoS {

    public static Promocao selecionar() {
        while (true) {
            int opcao = Input.lerInt("-- SELECIONE A PROMOÇÃO --" + "\n[1] - BLACKFRIDAY" +
                    "\n[2] - ANIVERSÁRIO" + "\n[3] - NATAL"
                    + "\n[0] - NENHUMA" + "\nInforme a opção desejada: ");

            switch (opcao) {
                case 1:
                    return new DescontoBlackFriday();
                case 2:
                    return new DescontoAniversario();
                case 3:
                    return new DescontoNatal();
                case 0:
                    return null;
                default:
                    System.out.println("ERRO! OPÇÃO INVÁLIDA!");
            }
        }
    }

    public static Promocao promocaoTxt(String nome) {
        switch (nome) {
            case "DescontoBlackFriday":
                return new DescontoBlackFriday();
            case "DescontoAniversario":
                return new DescontoAniversario();
            case "DescontoNatal":
                return new DescontoNatal();
                default:
                    return null;
        }
    }
}
