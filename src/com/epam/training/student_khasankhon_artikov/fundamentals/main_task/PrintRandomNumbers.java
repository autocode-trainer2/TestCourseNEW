package com.epam.training.student_khasankhon_artikov.fundamentals.main_task;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PrintRandomNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of random numbers you want n = ");
        int n = scanner.nextInt();
        int[] numbersArray = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            numbersArray[i] = random.nextInt();
        }
        for (int item : numbersArray) {
            System.out.print(item + ", ");
        }
        System.out.println("\n");
        for (int item : numbersArray) {
            System.out.println(item);
        }
    }
}
