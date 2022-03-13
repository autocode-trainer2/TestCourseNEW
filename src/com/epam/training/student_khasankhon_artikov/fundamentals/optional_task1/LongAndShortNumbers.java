package com.epam.training.student_khasankhon_artikov.fundamentals.optional_task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LongAndShortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        ArrayList<Integer> numbersArray = new ArrayList<Integer>();
        for (String number : numbers) numbersArray.add(Integer.parseInt(number));
        Collections.sort(numbersArray);
        int maxNumber = Collections.max(numbersArray);
        int minNumber = Collections.min(numbersArray);
        int lengthOfMaxNumber = Integer.toString(maxNumber).length();
        int lengthOfMinNumber = Integer.toString(minNumber).length();
        System.out.printf("Longest Number is: %d, %d digit(s)%n", maxNumber, lengthOfMaxNumber);
        System.out.printf("Shortest Number is: %d, %d digit(s)%n", minNumber, lengthOfMinNumber);

    }
}
