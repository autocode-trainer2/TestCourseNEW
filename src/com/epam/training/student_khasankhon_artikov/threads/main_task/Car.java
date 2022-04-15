package com.epam.training.student_khasankhon_artikov.threads.main_task;

import java.util.concurrent.locks.ReentrantLock;

public class Car extends Thread {
    private String name;
    private int parkingTime;
    private int waitingTime;
    private int parkingPlace = -1;
    String[] parking;
    ReentrantLock locking = new ReentrantLock(true);


    public Car(String name, String[] parking, int parkingTime, int waitingTime) {
        super(name);
        this.name = name;
        this.parking = parking;
        this.parkingTime = parkingTime;
        this.waitingTime = waitingTime;
    }


    @Override
    public void run() {
        System.out.println(this.name + " come to parking...");
        while (true) {
            locking.lock();
            this.parkingPlace = chooseParkingPlace();
//            locking.unlock();
            if (this.parkingPlace < 0) {
                try {
                    System.out.println("All places are already busy! " + this.name + " waiting time is: " + waitingTime);
                    Thread.sleep(waitingTime * 1000L);
                    if (!haveFreeParkingPLace()) {
                        System.out.println(this.name + " going to other parking!");
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                try {
                    System.out.println(this.name + " parked at " + this.parkingPlace + " place for time: " + parkingTime);
                    Thread.sleep(parkingTime * 1000L);
                    System.out.println(this.name + " leaves parking");
//                    locking.lock();
                    this.parking[this.parkingPlace] = "FREE";
                    locking.unlock();
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            locking.unlock();

        }

    }

    private boolean haveFreeParkingPLace() {
        for (String parkingState : parking) {
            if (parkingState.equals("FREE")) {
                return true;
            }
        }
        return false;
    }

    private int chooseParkingPlace() {
        int result = -1;
        for (int i = 0; i < parking.length; i++) {
            if (parking[i].equals("FREE")) {
                result = i;
                parking[i] = "BUSY";
                break;
            }
        }
        return result;
    }
}
