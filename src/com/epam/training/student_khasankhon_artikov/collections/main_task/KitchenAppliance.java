package com.epam.training.student_khasankhon_artikov.collections.main_task;

public class KitchenAppliance extends HouseholdAppliance{
    public KitchenAppliance(String name, String manufacturer, int power) {
        super(name, manufacturer, power);
    }

    @Override
    public String toString() {
        return "KitchenAppliance{" +
                "name='" + getName() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", power=" + getPower() + "W" +
                '}';
    }
}
