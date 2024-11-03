import java.util.Scanner;

/**
 * Faça um programa que leia um valor N inteiro. Com base neste valor, crie um
 * vetor do tipo real. Em seguida, solicite ao usuário informar essa quantidade
 * N de valores reais para popular o vetor. Após ter preenchido o vetor,
 * solicite que o usuário informe um outro valor real. Informe para o usuário se
 * este valor informado se encontra cadastrado no vetor. Faça um método para ler
 * o vetor e outro, que retorne verdadeiro ou falso, para encontrar o valor.
 */

public class Uni6Exe06 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Quantos valores você quer no seu vetor?");
        int[] valores = new int[s.nextInt()];
        popularVetor(s, valores);

        if (checkNumNoVetor(s, valores)) {
            System.out.println("O valor se encontra no vetor");

        } else {
            System.out.println("O valor não se encontra no vetor");
        }

    }

    public static void popularVetor(Scanner s, int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print("Informe o " + (i + 1) + "º valor: ");
            v[i] = s.nextInt();
        }
    }

    public static boolean checkNumNoVetor(Scanner s, int[] v) {
        boolean check = false;

        System.out.println("Que valor você gostaria de ver se existe no vetor?");
        int num = s.nextInt();

        for (int valor : v) {
            if (valor == num) {
                check = true;
                break;
            }
        }

        return check;
    }
}
