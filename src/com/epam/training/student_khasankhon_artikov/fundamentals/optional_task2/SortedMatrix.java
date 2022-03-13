package com.epam.training.student_khasankhon_artikov.fundamentals.optional_task2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortedMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number n = ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        fillMatrix(matrix);
        System.out.println("Generated matrix with random elements:");
        showMatrix(matrix);
        int k = 1;
        System.out.printf("Sorted matrix columns ordered by %d elements of row%n", k);
        Arrays.sort(matrix, (row, column) -> row[k] - column[k]);
        showMatrix(matrix);
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
}
