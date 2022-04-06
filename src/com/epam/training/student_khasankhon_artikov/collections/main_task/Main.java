package com.epam.training.student_khasankhon_artikov.collections.main_task;

import java.util.Arrays;
import java.util.List;

public class Main {
    static List<HouseholdAppliance> appliances = Arrays.asList(
            new KitchenAppliance("microwave", "BOSCH", 1200),
            new BedroomAppliance("air conditioner", "LG", 1500),
            new HallAppliance("42 inch LED TV", "Panasonic", 60),
            new KitchenAppliance("refrigerator", "Galanz", 200),
            new BackyardAppliance("lawnmower", "Greenworks", 1100),
            new HallAppliance("electric keyboard", "Casio", 50),
            new HallAppliance("laptop", "HP", 80)
    );

    public static void main(String[] args) {
        MyAppliances myAppliances = new MyAppliances(appliances);

        myAppliances.sortByPower();
        myAppliances.print();
        myAppliances.get(0).power_on();
        myAppliances.get(5).power_on();
        myAppliances.get(2).power_off();
        System.out.println("Max power appliance is: " + myAppliances.getMaxPowerAppliance());
    }
}
