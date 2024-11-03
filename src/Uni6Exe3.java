import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Descreva um algoritmo que leia 12 valores reais e os coloque em um vetor de
 * 12 posições do tipo real. Em seguida, modifique o vetor de modo que os
 * valores das posições ímpares sejam aumentados em 5% e os das posições pares
 * sejam aumentados em 2%. Imprima o vetor resultante. Faça um método para ler
 * os valores, outro para ajustar os valores dentro do vetor e outro para
 * escrever os valores atualizados do vetor.
 */

public class Uni6Exe3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        double[] valores = ler(s);
        valores = ajustarValores(valores);
        escrever(df, valores);
    }

    public static double[] ler(Scanner s) {
        double[] valores = new double[12];
        for (int i = 0; i < valores.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º valor: ");
            valores[i] = s.nextDouble();
        }
        return valores;
    }

    public static double[] ajustarValores(double[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = nums[i] * 1.02;

            } else {
                nums[i] = nums[i] * 1.05;
            }
        }
        return nums;
    }

    public static void escrever(DecimalFormat df, double[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(df.format(nums[i]));
        }

    }
}
