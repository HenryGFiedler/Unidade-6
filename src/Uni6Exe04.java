import java.util.Scanner;

/**
 * Faça um programa para ler os valores de dois vetores de inteiros, cada um
 * contendo 10 elementos. Crie um terceiro vetor em que cada elemento é a soma
 * dos valores contidos nas posições respectivas dos vetores originais. Por
 * exemplo, vetor1 = [1,2,3] vetor2 = [1,5,6] vetor3 = [2,7,9]. Exiba, ao final,
 * os três vetores na tela. Faça três métodos: um método para ler valores dos
 * vetores, outro para somar e outro para escrever os vetores.
 */

public class Uni6Exe04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] valores1 = new int[10];
        int[] valores2 = new int[10];
        int[] somaValores = new int[10];

        System.out.println("Vetor 1 ~");
        ler(s, valores1);
        //
        System.out.println("Vetor 2 ~");
        ler(s, valores2);

        somaVetores(valores1, valores2, somaValores);
        escrever(valores1, valores2, somaValores);

    }

    public static void ler(Scanner s, int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º valor: ");
            vetor[i] = s.nextInt();
        }
    }

    public static void somaVetores(int[] v1, int[] v2, int[] soma) {
        for (int i = 0; i < soma.length; i++) {
            soma[i] = v1[i] + v2[i];
        }
    }

    public static void escrever(int[] v1, int[] v2, int[] v3) {
        System.out.println("Vetor 1: ");
        for (int n : v1) {
            System.out.print(n + " ");
        }
        System.out.println("Vetor 2: ");
        for (int n : v2) {
            System.out.print(n + " ");
        }
        System.out.println("Vetor 3: ");
        for (int n : v3) {
            System.out.print(n + " ");
        }
    }

}
