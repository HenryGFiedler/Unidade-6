import java.util.Scanner;

/**
 * Um cinema pretende fazer uma pesquisa para avaliar o grau de satisfação de
 * seus clientes. Trinta deles foram ouvidos e para cada um perguntou-se o sexo
 * (1=feminino 2=masculino), uma nota para o cinema (zero até dez, valor
 * inteiro) e a idade.
 * 
 * Baseado nisto faça um programa que informe:
 * 
 * qual a nota média recebida pelo cinema;
 * qual a nota média atribuída pelos homens;
 * qual a nota atribuída pela mulher mais jovem;
 * quantas das mulheres com mais de 50 anos deram nota superior a média recebida
 * pelo cinema.
 * Utilize os conceitos aprendidos sobre vetores (ou mesmo o uso de matriz) e
 * métodos para a resolução deste exercício.
 */

public class Uni6Exe09 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[][] nota = new int[30][3];
        getNotas(s, nota);

        double media = media(nota);
        double mediaHomens = mediaHomens(nota);
        int notaMulherMaisJovem = notaMulherMaisJoven(nota);
        int acima50MaiorMedia = acimaDe50NotaAcimaMedia(media, nota);

        System.out.println("A nota média é de: " + media);
        System.out.println("A nota média dos homens é de: " + mediaHomens);
        System.out.println("A nota da mulher mais jovem é de: " + notaMulherMaisJovem);
        System.out.println("A quantidade de mulheres acima de 50 anos que deram uma nota acima da média foi de: " + acima50MaiorMedia);

    }

    /** Pega as notas */
    public static void getNotas(Scanner s, int[][] v) {
        for (int i = 0; i < v.length; i++) {

            int sexo = 0;
            int nota = 0;
            int idade = 0;

            // Sexo
            System.out.println("Qual o seu sexo?");
            System.out.println("1 - Feminino");
            System.out.println("2 - Masculino");
            while (true) {
                if (s.hasNextInt()) {
                    sexo = s.nextInt();
                    if (sexo == 1 || sexo == 2) {
                        break;
                    } else {
                        System.out.println("Opção inválida");
                    }
                } else {
                    System.out.println("Charactere inválido");
                }
            }
            // Nota
            System.out.println("Que nota de 0 a 10 você da para o cinema?");
            while (true) {
                if (s.hasNextInt()) {
                    nota = s.nextInt();
                    if (nota < 0 || nota > 10) {
                        System.out.println("Nota inválida");

                    } else {
                        break;
                    }
                } else {
                    System.out.println("Charactere inválido");
                }

            }
            // Idade
            System.out.println("Qual a sua idade?");
            while (true) {
                if (s.hasNextInt()) {
                    idade = s.nextInt();
                    if (idade < 1) {
                        System.out.println("Idade inválida");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Charactere inválido");
                }

            }

            v[i][0] = sexo;
            v[i][1] = nota;
            v[i][2] = idade;
        }
    }

    /** Calcula a média */
    public static double media(int[][] v) {
        double media = 0;
        for (int[] p : v) {
            media += p[1];
        }
        media = media / v.length;
        return media;
    }

    /** Calcula a média dos homens */
    public static double mediaHomens(int[][] v) {
        double media = 0;
        int qtdHomens = 0;
        for (int[] p : v) {
            if (p[0] == 2) {
                media += p[1];
                qtdHomens++;
            }
        }
        media = media / qtdHomens;
        return media;
    }

    /** Encontra a nota da mulher mais jovem */
    public static int notaMulherMaisJoven(int[][] v) {

        int notaMaisJovem = 0;
        int idadeMaisJovem = Integer.MAX_VALUE;

        for (int[] p : v) {
            if (p[0] == 1) {
                if (p[2] < idadeMaisJovem) {
                    notaMaisJovem = p[1];
                    idadeMaisJovem = p[2];
                }
            }
        }
        return notaMaisJovem;
    }

    /**
     * Decobre quantas mulheres acima de 50 anos deram uma nota maior que a média
     */
    public static int acimaDe50NotaAcimaMedia(double m, int[][] v) {
        int counter = 0;

        for (int[] p : v) {
            if (p[0] == 1 && p[2] < 50 && p[1] > m) {
                counter++;
            }
        }
        return counter;
    }
}