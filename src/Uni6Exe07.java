import java.util.Scanner;

/**
 * Faça um programa que leia um valor N inteiro limitado a 20 posições. Com base
 * neste valor, crie um vetor do tipo inteiro. Em seguida, solicite ao usuário
 * para digitar um número inteiro várias vezes, até preencher o vetor. Esse
 * número deverá ser armazenado no vetor caso ainda não exista, e se o valor já
 * existir deve ser pedido um novo valor. Isto é, se o usuário informar o número
 * 2 e já existir o número 2 em alguma posição do vetor, o número não deve ser
 * adicionado. Após ter adicionado todos os números dentro do vetor, o mesmo
 * deve ser ordenado. Para isso reordene os elementos internos do vetor de modo
 * que este fique em ordem crescente, conforme no exemplo:
 * 
 * Vetor origem: [0][4][2][6][3]
 * Vetor ordenado: [0][2][3][4][6]
 * 
 * Crie um método para inserir os valores no vetor, outro para ordenar o vetor e
 * outro para informar o vetor resultante. Para "método ordenar" se pode usar o
 * "método bolha" explicado neste vídeo
 */

public class Uni6Exe07 {
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

        int[] vetor = new int[numVetor];
        popularVetor(s, vetor);
        ordenarVetor(vetor);
        escrever(vetor);
    }

    /** Popula o vetor */
    public static void popularVetor(Scanner s, int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.print("Informe o " + (i + 1) + "º valor: ");
            int valor = s.nextInt();
            if (!verificacarNumero(valor, v, i)) {
                v[i] = valor;

            } else {
                i--;
            }

        }
    }

    /** Checa se o numerido inserido já existe no vetor */
    public static boolean verificacarNumero(int valor, int[] v, int i) {
        boolean check = false;

        for (int j = 0; j < i; j++) {
            if (v[j] == valor) {
                System.out.println("Valor já inserito");
                check = true;
                break;
            }
        }
        return check;
    }

    public static void ordenarVetor(int[] v) {
        int i = 0;

        while (i < (v.length - 1)) {
            if (v[i] > v[i + 1]) {
                int placeHolder = v[i];
                v[i] = v[i + 1];
                v[i + 1] = placeHolder;
                i = 0;

            } else {
                i++;
            }
        }
    }

    public static void escrever(int[] v) {
        for (int n : v) {
            System.out.print(n + " ");
        }
    }
}