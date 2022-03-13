package com.epam.training.student_khasankhon_artikov.fundamentals.main_task;

import java.util.Scanner;

public class FindNameOfMonth {
    public static void main(String[] args) {
        String[] months = {"January", "February", "March", "April", "May", "Jun", "July", "August",
                "September", "October", "November", "December"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of month");
        int numberOfMonth = scanner.nextInt();
        if (numberOfMonth > 0 && numberOfMonth < 13) {
            System.out.printf("The month you have chosen: %s%n",months[numberOfMonth - 1]);
        } else {
            System.out.println("Entered number was incorrect");
        }
    }
}
