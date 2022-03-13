package com.epam.training.student_khasankhon_artikov.fundamentals.optional_task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        ArrayList<Integer> numbersArray = new ArrayList<Integer>();
        for (String number : numbers) numbersArray.add(Integer.parseInt(number));
        Collections.sort(numbersArray);
        System.out.println(numbersArray);
    }
}
