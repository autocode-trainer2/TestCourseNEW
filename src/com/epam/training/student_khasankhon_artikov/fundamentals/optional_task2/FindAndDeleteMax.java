package com.epam.training.student_khasankhon_artikov.fundamentals.optional_task2;

import java.util.Random;
import java.util.Scanner;

public class FindAndDeleteMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number n = ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        fillMatrix(matrix);
        System.out.println("Generated matrix with random elements:");
        showMatrix(matrix);
        int[] maxElementRowColumn = findMax(matrix);
        System.out.printf("Max element of matrix is %s%n", maxElementRowColumn[0]);
        System.out.println("Deleting column and row which contains the Max element of matrix...\nResult:");
        deleteColumnAndRow(matrix, maxElementRowColumn);
    }

    private static void fillMatrix(int[][] matrix) {
        int M = 100;
        Random random = new Random(0);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(-M, M);
            }
        }
    }

    private static void showMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%5d", anInt);
            }
            System.out.println();
        }
    }

    private static int[] findMax(int[][] matrix) {
        int[] max = new int[3];
        max[0] = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max[0]) {
                    max[0] = matrix[i][j];
                    max[1] = i;
                    max[2] = j;
                }
            }
        }
        return max;
    }

    private static void deleteColumnAndRow(int[][] matrix, int[] max) {
        int[][] newMatrix = new int[matrix.length - 1][matrix[0].length - 1];
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (i >= max[1] && j >= max[2]) {
                    newMatrix[i][j] = matrix[i + 1][j + 1];
                } else if (i < max[1] && j >= max[2]) {
                    newMatrix[i][j] = matrix[i][j + 1];
                } else if (i >= max[1] && j < max[2]) {
                    newMatrix[i][j] = matrix[i + 1][j];
                } else {
                    newMatrix[i][j] = matrix[i][j];
                }
            }
        }
        showMatrix(newMatrix);
    }
}

