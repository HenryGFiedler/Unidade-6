import java.util.Scanner;

/**
 * Faça um programa que leia um valor N inteiro limitado a 20 posições. Com base
 * neste valor, crie um vetor do tipo real. Faça o usuário informar valores para
 * as posições deste vetor e coloque-as nas posições na sequência informada pelo
 * usuário. Imprima uma tabela contendo cada valor diferente e o número de vezes
 * que o valor aparece no vetor (veja exemplo a seguir).
 */

public class Uni6Exe08 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int numVetor = 0;
        do {
            System.out.println("Quantos números você quer no seu vetor? (máximo 20)");
            numVetor = s.nextInt();

            if (numVetor > 20 || numVetor <= 0) {
                System.out.println("Valor inválido");

            } else {
                break;
            }
        } while (true);

        double[] vetor = new double[numVetor];
        popularVetor(s, vetor);

        double[] valoresUnicos = valoresUnicos(vetor);
        int[] quantidadeUnico = quantidadePorUnico(valoresUnicos, vetor);
        escrever(valoresUnicos, quantidadeUnico);
    }

    /** Adiciona os numeros ao vetor na ordem informada pelo usuário */
    public static void popularVetor(Scanner s, double[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print("Informe a posição que você quer o valor: ");
            int posicao = s.nextInt();
            //
            System.out.print("Informe o valor que você quer nessa posição: ");
            v[posicao - 1] = s.nextDouble();
        }
    }

    /** Verifica quais valores são únicos em um vetor */
    public static double[] valoresUnicos(double[] v) {
        double[] placeHolderUnicos = new double[v.length];
        int numUnicos = 0;

        for (int i = 0; i < v.length; i++) {
            boolean unico = true;
            for (int j = 0; j < i; j++) {
                if (v[i] == placeHolderUnicos[j]) {
                    unico = false;
                    break;
                }
            }
            if (unico) {
                placeHolderUnicos[numUnicos] = v[i];
                numUnicos++;
            }
        }

        double[] unicos = new double[numUnicos];
        for (int i = 0; i < unicos.length; i++) {
            unicos[i] = placeHolderUnicos[i];
        }

        return unicos;
    }

    /** Informa a quantidade que existe de cada número único */
    public static int[] quantidadePorUnico(double[] u, double[] v) {
        int[] quantidades = new int[u.length];

        for (int i = 0; i < u.length; i++) {
            int quantidade = 0;
            for (int j = 0; j < v.length; j++) {
                if (u[i] == v[j]) {
                    quantidade++;
                }
            }
            quantidades[i] = quantidade;
        }
        return quantidades;
    }

    /** Imprime a tabela de quantidades */
    public static void escrever(double[] u, int[] q) {
        System.out.println("Valores   |   Frequência");
        for (int i = 0; i < u.length; i++) {
            System.out.println(u[i] + " ---------- " + q[i]);
        }
    }
}
