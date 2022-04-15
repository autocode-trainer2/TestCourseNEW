package com.epam.training.student_khasankhon_artikov.threads.main_task;

import java.util.ArrayList;
import java.util.Random;

public class Parking {
    public static void main(String[] args) {
        String[] parking = {"FREE", "FREE", "FREE"};
        System.out.println("The parking have " + parking.length + " parking places");
        int waitingTime = 5;
        Random random = new Random();

        ArrayList<Car> cars = new ArrayList<>();
        for (int i=1; i<6; i++) {
            int parkingTime = random.nextInt(10) + 1;
            cars.add(new Car("CAR #"+i, parking, parkingTime, waitingTime));
        }

        for (Car car: cars) car.start();
    }
}
