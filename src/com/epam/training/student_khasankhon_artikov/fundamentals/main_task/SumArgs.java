package com.epam.training.student_khasankhon_artikov.fundamentals.main_task;

public class SumArgs {
    public static void main(String[] args) {
        int sum = 0;
        for (String arg : args) sum += Integer.parseInt(arg);
        System.out.printf("Sum of args: %d", sum);

    }
}
