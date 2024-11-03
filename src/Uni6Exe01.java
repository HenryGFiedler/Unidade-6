import java.util.Scanner;

/**
 * Descreva um algoritmo que leia 10 números inteiros e os coloque em um vetor
 * de 10 posições do tipo inteiro. Escreva na ordem inversa em que foram lidos.
 * Faça um método para ler e outro para escrever.
 */

public class Uni6Exe01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] numeros = new int[10];
        numeros = ler(s);

        System.out.println("Os valores em ordem inversa são:");
        escrever(numeros);

    }

    public static int[] ler(Scanner s) {
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º número intero: ");
            array[i] = s.nextInt();
        }

        return array;
    }

    public static void escrever(int[] nums) {
        for (int i = (nums.length - 1); i >= 0; i--) {
            System.out.println(nums[i]);
        }

    }
}
