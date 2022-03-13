package com.epam.training.student_khasankhon_artikov.fundamentals.optional_task1;

import java.util.Arrays;
import java.util.Scanner;

public class FindSortedDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        for (String number: numbers){
            String[] digits = number.split("");
            Arrays.sort(digits);
            String numberSorted = String.join("", digits);
            if (Integer.parseInt(number) == Integer.parseInt(numberSorted)){
                System.out.println(number);
                break;
            }
        }
    }
}
