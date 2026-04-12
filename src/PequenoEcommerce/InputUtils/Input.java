package PequenoEcommerce.InputUtils;

import java.util.Scanner;

public class Input {
    private static final Scanner ler = new Scanner(System.in);

    public static double lerDouble(String mensagem) {  //LÓGICA QUE CHAMA O SCANNER DE TODOS OS DOUBLES DO SWITCH DA MAIN
        while (true) {System.out.print(mensagem);
            String
             opcaoSelecionada = ler.nextLine().trim(); /*PEDE UM VALOR E LIMPA OS ESPAÇOS VÁZIOS PARA NÃO OCORRER
            NENHUM ERRO*/

            if (opcaoSelecionada.isEmpty()) { //EVITA COM QUE O SISTEMA TRAVE CASO TENHA UM ESPAÇO VAZIO
                continue;
            }

            opcaoSelecionada = opcaoSelecionada.replace(",", "."); //CONVERTE , PARA .

            try {
                return Double.parseDouble(opcaoSelecionada); /*TRADUZ O STRING PARA DOUBLE LÓGICA PARA QUE NÃO FIQUE RESTOS
                NO BUFFERED, SEM ISSO O SISTEMA PEDE PARA CLICAR ENTER VÁRIAS VEZES*/
            } catch (NumberFormatException e) {
                System.out.println("\nERRO! DIGITE APENAS NUMEROS VÁLIDOS.\n"); //LANÇA A EXCEÇÃO CASO O NUMERO SEJÁ INVÁLIDO.
            }
        }
    }

    public static int lerInt(String mensagem) { //LÓGICA QUE CHAMA O SCANNER DE TODOS OS DOUBLES DO SWITCH DA MAIN
        while (true) {
            System.out.print(mensagem);
            String opcao = ler.nextLine().trim(); /*PEDE UM VALOR E LIMPA OS ESPAÇOS VÁZIOS PARA NÃO OCORRER
            NENHUM ERRO*/

            if (opcao.isEmpty()) { //EVITA COM QUE O SISTEMA TRAVE CASO TENHA UM ESPAÇO VAZIO
                continue;
            }

            try {
                return Integer.parseInt(opcao); /*TRADUZ O STRING PARA INT LÓGICA PARA QUE NÃO FIQUE RESTOS
                NO BUFFERED.*/
            } catch (NumberFormatException e) {
                System.out.println("\nERRO! DIGITE APENAS NUMEROS INTEIROS.\n");
            }
        }
    }

    public static String lerString(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String opcao = ler.nextLine().trim();
            opcao = opcao.replace(";", ":");

            if (!opcao.isEmpty()) {
                return opcao;
            }
            System.out.println("\nERRO! O TEXTO NÃO PODE ESTAR VAZIO.\n");
        }
    }
}