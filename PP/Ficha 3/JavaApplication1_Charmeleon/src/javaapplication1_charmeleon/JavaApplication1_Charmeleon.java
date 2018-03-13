/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1_charmeleon;

import java.util.Random;
import java.lang.Math;
import java.util.Scanner;

/**
 *
 * @author 8160182
 */
public class JavaApplication1_Charmeleon {

    public static void ex1_transposta(int[][] A, int N) {
        //B = transposta de A
        int[][] B = new int[10][10];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                B[j][i] = A[i][j];
            }
        }

        //imprime valores da matriz B
        System.out.println("Matriz B - transposta de B");
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                if (B[i][j] < 10) {
                    System.out.print(B[i][j] + "  | ");
                } else {
                    System.out.print(B[i][j] + " | ");
                }
            }
            System.out.println();
        }
    }

    public static void ex1() {
        int N = 10;
        int[][] A = new int[N][N];
        //gerar valores da matriz A
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = i + (5 * j);
            }
        }

        //imprime valores da matriz A
        System.out.println("Matriz A");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] < 10) {
                    System.out.print(A[i][j] + "  | ");
                } else {
                    System.out.print(A[i][j] + " | ");
                }

            }
            System.out.println();
        }
        //ex1
        ex1_transposta(A, N);
    }

    public static void ex2_primos_perfeitos(int[] V) {
        int[] P = new int[V.length];
        int count = 0, k = 0;
        //verifica se o numero é primo (só é divisiel por 1 e por ele mesmo)
        for (int i = 0; i < V.length; i++) {
            count = 0;
            for (int j = 1; j <= V[i]; j++) {
                if (V[i] % j == 0) {
                    count++;
                }
            }
            //verifica se é primo (count == 2) ou é um numero perfeito (6, 28, 496, 8128)
            if (count == 2 || V[i] == 6 || V[i] == 28 || V[i] == 496 || V[i] == 8128) {
                P[k] = V[i];
                k++;
            }
        }

        //imprimir valores do vetor P
        System.out.print("Vetor P");
        for (int i = 0; i < k; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(P[i] + "\t");
        }
        System.out.println();
    }

    public static void ex2() {
        Random r = new Random();
        int[] V = new int[100];
        //gerar valores no vetor V
        for (int i = 0; i < V.length; i++) {
            V[i] = 2 * i + r.nextInt(3);
        }

        //imprimir valores do vetor V
        System.out.print("Vetor A");
        for (int i = 0; i < V.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(V[i] + "\t");
        }
        System.out.println();
        //ex2
        ex2_primos_perfeitos(V);
    }

    public static int contaNumero(int n, int[][] M) {
        int count = 0;
        //conta quantas vezes o n aparece na matriz
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (n == M[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void ex3_contaMatriz(int[][] M) {
        int[][][] V = new int[4][3][2];

        //copiar os valores em M pra V
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                V[i][j][0] = M[i][j];
            }
        }

        int count = 0, maior = M[0][0], menor = M[0][0];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                count = contaNumero(M[i][j], M);
                V[i][j][1] = count;
                if (M[i][j] > maior) {
                    maior = M[i][j];
                }
                if (M[i][j] < menor) {
                    menor = M[i][j];
                }
            }
        }

        int maisRepetido = V[0][0][1];
        int numMaisRepetido = V[0][0][0];

        //verifica qual o numero mais repetido
        for (int i = 0; i < V.length; i++) {
            for (int j = 0; j < V[i].length; j++) {
                if (V[i][j][1] >= maisRepetido) {
                    maisRepetido = V[i][j][1];
                    numMaisRepetido = V[i][j][0];
                }
            }
        }

        boolean maisQueUmNumeroSurgeMaisVezes = false;
        //verifica se há mais que um numero que mais vezes surge na matriz
        for (int i = 0; i < V.length; i++) {
            for (int j = 0; j < V[i].length; j++) {
                if (V[i][j][1] == maisRepetido && V[i][j][0] != numMaisRepetido) {
                    maisQueUmNumeroSurgeMaisVezes = true;
                }
            }
        }

        if (maisQueUmNumeroSurgeMaisVezes == false) {
            System.out.println("O numero que aparece mais vezes é o " + numMaisRepetido + " que aparece " + maisRepetido + " vezes.");
        } else {
            System.out.println("Há mais que um numero que surge mais vezes repetido nesta matriz.");
            System.out.println("Um dos numero é o " + numMaisRepetido + " que aparece " + maisRepetido + " vezes.");
        }
        System.out.println("O maior é o numero " + maior);
        System.out.println("O menor é o numero " + menor);
    }

    public static void ex3() {
        int[][] M = new int[4][3];
        Random r = new Random();
        //gerar valores na matriz M
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                M[i][j] = r.nextInt(10);
            }
        }
        //imprime os valor da matriz M
        System.out.println("Matriz M");
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] < 10) {
                    System.out.print(M[i][j] + " | ");
                } else {
                    System.out.print(M[i][j] + " | ");
                }

            }
            System.out.println();
        }
        ex3_contaMatriz(M);
    }

    public static void ex4_grausRadianos(double graus) {
        double radianos = graus * Math.PI / 180;
        System.out.printf("%f graus é igual a %.4f radianos.\n", graus, radianos);
    }

    public static void ex4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Graus: ");
        double graus = sc.nextDouble();
        ex4_grausRadianos(graus);
    }

    public static void ex5_moeda() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Currency [e/d]: ");
        char currency = sc.next().charAt(0);
        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        if (currency == 'e') {
            System.out.printf("%.2f€ = %.2f$\n", amount, (amount * 1.232895));
        } else if (currency == 'd') {
            System.out.printf("%.2f$ = %.2f€\n", amount, (amount / 1.232895));
        } else {
            System.out.println("ERRO");
        }
    }

    public static void ex6_centimos() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Centimos: ");
        int centimos = sc.nextInt();
        System.out.println((centimos / 100) + "," + (centimos % 100) + "€");
    }

    public static void ex7_dividir() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dividendo: ");
        int num1 = sc.nextInt();
        System.out.print("Divisor: ");
        int num2 = sc.nextInt();
        int dividendo = num1, divisor = num2, quociente = 0, resto = 0;
        do {
            if (num1 > num2) {
                quociente++;
                num1 -= num2;
            }
        } while (num1 > num2);
        resto = num1;
        System.out.printf("%d / %d = %d e resto %d\n", dividendo, divisor, quociente, resto);
    }

    public static void ex8() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dinherio: ");
        double num1 = sc.nextDouble();
        double dinheiro = num1;
        int[][] moedas = new int[][]{{0, 200}, {0, 100}, {0, 50}, {0, 20}, {0, 10}, {0, 5}, {0, 2}, {0, 1}};
        do {
            if (num1 >= 2) {
                moedas[0][0] += 1;
                num1 -= 2;
            } else if (num1 >= 1) {
                moedas[1][0] += 1;
                num1 -= 1;
            } else if (num1 >= 0.5) {
                moedas[2][0] += 1;
                num1 -= 0.5;
            } else if (num1 >= 0.2) {
                moedas[3][0] += 1;
                num1 -= 0.2;
            } else if (num1 >= 0.1) {
                moedas[4][0] += 1;
                num1 -= 0.1;
            } else if (num1 >= 0.05) {
                moedas[5][0] += 1;
                num1 -= 0.05;
            } else if (num1 >= 0.02) {
                moedas[6][0] += 1;
                num1 -= 0.02;
            } else if (num1 >= 0.01) {
                moedas[7][0] += 1;
                num1 -= 0.01;
            }
        } while (num1 > 0.01);
        for (int i = 0; i < moedas.length; i++) {
            if (moedas[i][0] > 0) {
                if (moedas[i][0] == 1) {
                    System.out.printf("%d moeda de %.02f€\n", moedas[i][0], ((double) moedas[i][1] / 100));
                }
                if (moedas[i][0] > 1) {
                    System.out.printf("%d moedas de %.02f€\n", moedas[i][0], ((double) moedas[i][1] / 100));
                }

            }
        }
    }

    public static void main(String[] args) {
        ex8();
    }

}
