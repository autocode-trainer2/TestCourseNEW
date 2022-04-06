package com.epam.training.student_khasankhon_artikov.fundamentals.optional_task1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class FindSortedDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter multiple numbers separated by a space:");
        String[] numbers = scanner.nextLine().split(" ");
        boolean notAscending = true;
        for (String number: numbers){
            String[] digits = number.split("");
            digits = new HashSet<>(Arrays.asList(digits)).toArray(new String[]{});  // removing identical elements
            if (digits.length > 1) {
                Arrays.sort(digits);
                String sortedNumber = String.join("", digits);
                if (Integer.parseInt(number) == Integer.parseInt(sortedNumber)) {
                    System.out.println("The digits of this element are greater that one and are in ascending order: " + number);
                    notAscending = false;
                    break;
                }
            }
        }
        if (notAscending){
            System.out.println("There are no numbers here that digits are in ascending order");
        }
    }
}
