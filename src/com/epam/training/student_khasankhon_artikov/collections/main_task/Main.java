package com.epam.training.student_khasankhon_artikov.collections.main_task;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<HouseholdAppliance> appliances = new ArrayList<>();
        appliances.add(new KitchenAppliance("microwave", "BOSCH", 1200));
        appliances.add(new BedroomAppliance("air conditioner", "LG", 1500));
        appliances.add(new HallAppliance("42 inch LED TV", "Panasonic", 60));
        appliances.add(new KitchenAppliance("refrigerator", "Galanz", 200));
        appliances.add(new BackyardAppliance("lawnmower", "Greenworks", 1100));
        appliances.add(new HallAppliance("electric keyboard", "Casio", 50));
        appliances.add(new HallAppliance("laptop", "HP", 80));

        appliances.sort((o1, o2) -> o1.getPower() - o2.getPower());
        System.out.println("\t\tsorting appliances by power use...");
        appliances.forEach(o -> System.out.println(o.toString()));
        System.out.println("\t\tturning on some appliances...");
        appliances.get(0).power_on();
        appliances.get(2).power_on();
        appliances.get(4).power_on();
    }
}
