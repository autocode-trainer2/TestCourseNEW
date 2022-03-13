package com.epam.training.student_khasankhon_artikov.fundamentals.main_task;

public class ReverseArgs {
    public static void main(String[] args) {
        for (int i = args.length - 1 ; i >= 0 ; i--) {
            System.out.printf("Arg = %s%n", args[i]);
        }
    }
}
