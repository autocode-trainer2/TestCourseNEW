package com.epam.training.student_khasankhon_artikov.classes.main_task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book[] books = new Book[5];
        books[0] = new Book(1, "Code", new String[]{"Charles Petzold"}, "Microsoft Press", 2000,
                400, 25, "Hardcover");
        books[1] = new Book(2, "Clean Code", new String[]{"Robert C.Martin"},
                "Pearson Education Inc", 2009, 460, 38, "Paperback");
        books[2] = new Book(3, "Effective Java", new String[]{"Joshua Bloch"}, "Addison Wesley",
                2018, 461, 43, "Paperback");
        books[3] = new Book(4, "Python: The Complete Reference", new String[]{"Martin C. Brown"},
                "McGraw Hill Education", 2018, 720, 8, "Paperback");
        books[4] = new Book(5, "Coding in Python", new String[]{"Robert C Matthews"},
                "Greenwich Publishing Ltd", 2020, 680, 40, "Paperback");

        for (Book book: books){
            List<String> authorsList = new ArrayList<>(Arrays.asList(book.authors));
            if (authorsList.contains("Charles Petzold")){       // a) print books by a given author
                System.out.println(book);
            }

            if (book.publisher.equals("Addison Wesley")){       // b) print books published by a publishing house
                System.out.println(book);
            }

            if (book.year > 2019) {                             // c) print books released after a given year
                System.out.println(book);
            }
        }
    }
}

