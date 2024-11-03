import java.util.Scanner;

public class Uni6Exe10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean ligado = true;

        int[] vetor = new int[50];
        int counter = 0;

        do {
            System.out.println("----------------------");
            System.out.println("1 - Incluir valor");
            System.out.println("2 - Pesquisar valor");
            System.out.println("3 - Alterar valor");
            System.out.println("4 - Excluir valor");
            System.out.println("5 - Mostrar valores");
            System.out.println("6 - Ordenar valores");
            System.out.println("7 - Inverter valores");
            System.out.println("8 - Sair do sistema");
            System.out.println("----------------------");

            int opcao = verificacao(s);

            switch (opcao) {
                case 1:
                    incluirValor(s, vetor, counter);
                    counter++;
                    break;

                case 2:
                    pesquisarValor(s, vetor, counter);
                    break;

                case 3:
                    alterarValor(s, vetor, counter);
                    break;

                case 4:
                    excluirValor(s, vetor, counter);
                    counter--;
                    break;

                case 5:
                    mostrarValores(vetor, counter);
                    break;

                case 6:
                    ordenarValores(vetor, counter);
                    break;

                case 7:
                    inverterValores(vetor, counter);
                    break;

                case 8:
                    ligado = false;
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (ligado);
    }

    /** Verifica se o valor é inteiro */
    public static int verificacao(Scanner s) {
        int opcao = 0;
        while (true) {
            if (s.hasNextInt()) {
                opcao = s.nextInt();
                break;
            } else {
                System.out.println("Caractere inválido");
                s.nextLine();
            }
        }
        return opcao;
    }

    /** Cria um vetor apenas com os valores adicionados */
    public static int[] vetorReal(int[] v, int c) {
        int[] vetorReal = new int[c];

        for (int i = 0; i < c; i++) {
            vetorReal[i] = v[i];
        }
        return vetorReal;
    }

    /** Checa se o valor existe no vetor */
    public static boolean existe(int[] vetor, int valor) {
        boolean existe = false;
        for (int val : vetor) {
            if (val == valor) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    /** Adiciona um valor no vetor, se for possível */
    public static void incluirValor(Scanner s, int[] v, int c) {
        if (v.length > c) {
            System.out.print("Insira o valor a ser adicionado: ");
            v[c] = s.nextInt();
            System.out.println("valor adicionado");
        } else {
            System.out.println("Vetor cheio");
        }
    }

    /** Fala se o valor dado está no vetor */
    public static void pesquisarValor(Scanner s, int[] v, int c) {
        System.out.println("Insira o valor a ser pesquisado: ");
        int valor = verificacao(s);

        boolean found = existe(v, valor);

        if (found) {
            System.out.println("O valor está no vetor");

        } else {
            System.out.println("O valor não se encontra no vetor");
        }
    }

    /** Altera o valor desejado para um novo */
    public static void alterarValor(Scanner s, int[] v, int c) {
        System.out.println("Que valor deve ser alterado?");
        int valorVelho = verificacao(s);
        //
        int[] vetor = vetorReal(v, c);
        //
        boolean valorExiste = existe(vetor, valorVelho);

        if (valorExiste) {
            System.out.println("Que valor entrará em seu lugar?");
            int valorNovo = verificacao(s);
            for (int i = 0; i < vetor.length; i++) {
                if (vetor[i] == valorVelho) {
                    v[i] = valorNovo;
                }

            }
        } else {
            System.out.println("O valor não existe no vetor");
        }
    }

    /** Exclui um valor */
    public static void excluirValor(Scanner s, int[] v, int c) {
        int[] vetor = vetorReal(v, c);

        System.out.println("Insira o valor que você deseja excluir");
        int valorExcluir = verificacao(s);
        //
        boolean existe = existe(vetor, valorExcluir);

        if (existe) {
            int posicao = 0;
            for (int i = 0; i < vetor.length; i++) {
                if (vetor[i] == valorExcluir) {
                    posicao = i;
                }
            }

            for (int i = posicao; i < vetor.length; i++) {
                v[i] = v[i + 1];
            }
            v[vetor.length - 1] = 0;

        } else {
            System.out.println("Valor não encontrado");
        }
    }

    /** Mostra os valores no vetor */
    public static void mostrarValores(int[] v, int c) {
        int[] vetor = vetorReal(v, c);

        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("");
    }

    /** Ordena os valores em ordem crescente */
    public static void ordenarValores(int[] v, int c) {
        int[] vetor = vetorReal(v, c);

        int i = 0;
        while (i < (vetor.length - 1)) {
            if (vetor[i] > vetor[i + 1]) {
                int placeHolder = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = placeHolder;
                i = 0;
            } else {
                i++;
            }

            for (int j = 0; j < vetor.length; j++) {
                v[j] = vetor[j];
            }
        }
    }

    /** Inverte a posição de todos os valores */
    public static void inverterValores(int[] v, int c) {
        int[] vetor = vetorReal(v, c);
        int[] vetorInvertido = new int[vetor.length];
        //
        int posicao = 0;

        for (int i = (vetor.length - 1); i >= 0; i--) {
            vetorInvertido[posicao] = vetor[i];
            posicao++;
        }

        for (int i = 0; i < vetor.length; i++) {
            v[i] = vetorInvertido[i];
        }
    }
}
