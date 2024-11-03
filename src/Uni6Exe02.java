import java.util.Scanner;

/**
 * Descreva um algoritmo que leia 12 valores reais e os coloque em um vetor de
 * 12 posições do tipo real. Imprima quais valores desses informados são maiores
 * que a média dos valores. Faça um método para ler os valores, outro para
 * calcular a média e outro para informar os valores maiores que a média.
 */

public class Uni6Exe02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        final double[] valores = ler(s);
        final double media = calcular(valores);
        maiorQueAMedia(valores, media);

    }

    public static double[] ler(Scanner s) {
        double[] valores = new double[12];
        for (int i = 0; i < valores.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º valor: ");
            valores[i] = s.nextDouble();
        }
        return valores;
    }

    public static double calcular(double[] nums) {
        double media = 0;
        for (int i = 0; i < nums.length; i++) {
            media += nums[i];
        }
        media = media / nums.length;

        return media;
    }

    public static void maiorQueAMedia(double[] nums, double m) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > m) {
                System.out.println(nums[i] + " é maior que a média");
            }
        }
    }
}
