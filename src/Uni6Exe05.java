import java.util.Scanner;

/**
 * Com o objetivo de determinar o índice de afinidade entre um rapaz e uma moça
 * cada um respondeu um questionário com 5 perguntas, como por exemplo:
 * 
 * Gosta de música sertaneja?
 * Gosta de futebol?
 * Gosta de seriados?
 * Gosta de redes sociais?
 * Gosta da Oktoberfest?
 * 
 * A resposta a cada pergunta pode ser: SIM, NÃO ou IND (indiferente). O índice
 * de afinidade é medido da seguinte maneira:
 * 
 * se ambos deram a mesma resposta soma-se 3 pontos ao índice;
 * se um respondeu IND e o outro SIM ou NÃO soma-se 1;
 * se um respondeu SIM e o outro NÃO subtrai-se 2 ao índice.
 * Crie um vetor para armazenar as respostas do rapaz e outro para armazenar as
 * respostas da moça. Crie um método que possa ler tanto as respostas do rapaz
 * como da moça, e outro para calcular e retornar a afinidade. Por fim, escreva
 * a afinidade considerando os seguintes intervalos:
 */

// Se pelo menos funcionasse assim...

public class Uni6Exe05 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        final String[] perguntas = {
                "Você gosta de Minecraft?",
                "Você gosta de Limbus Company?",
                "Você gosta de Thomas the Tank Engine?",
                "Você gosta de Rock?",
                "Você gosta de Tomate?"
        };

        String[] respostasBoy = new String[5];
        String[] respostasGirl = new String[5];

        System.out.println("Respostas garoto");
        getResposta(s, perguntas, respostasBoy);
        //
        System.out.println("Respostas garota");
        getResposta(s, perguntas, respostasGirl);

        int compatibilidade = compararRespostas(respostasBoy, respostasGirl);

        if (compatibilidade == 15) {
            System.out.println("Casem!");
        } else if (compatibilidade >= 10) {
            System.out.println("Vocês têm muita coisa em comum!");
        } else if (compatibilidade >= 5) {
            System.out.println("Talvez não dê certo :(");
        } else if (compatibilidade >= 0) {
            System.out.println("Vale um encontro.");
        } else if (compatibilidade >= -9) {
            System.out.println("Melhor não perder tempo");
        } else {
            System.out.println("Vocês se odeiam!");
        }
    }

    public static void getResposta(Scanner s, String[] p, String[] r) {
        System.out.println("Você pode responder com:");
        System.out.println("Sim");
        System.out.println("Não");
        System.out.println("Ind (Indiferente)");

        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);

            String resposta = s.next().toLowerCase();
            while (!resposta.equals("sim") && !resposta.equals("nao") && !resposta.equals("ind")) {
                System.out.println("Resposnta inválida, tente de novo:");
                resposta = s.next().toLowerCase();
            }
            r[i] = resposta;

        }

    }

    public static int compararRespostas(String[] boy, String[] girl) {
        int compatibilidade = 0;

        for (int i = 0; i < boy.length; i++) {
            if (boy[i].equals(girl[i])) {
                compatibilidade += 3;

            } else if (boy[i].equals("ind") && !girl[i].equals("ind") ||
                    girl[i].equals("ind") && !boy[i].equals("ind")) {
                compatibilidade += 1;

            } else {
                compatibilidade -= 2;
            }
        }
        System.out.println("-----");

        return compatibilidade;
    }
}