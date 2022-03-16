package com.epam.training.student_khasankhon_artikov.collections.main_task;

public class HallAppliance extends HouseholdAppliance{
    public HallAppliance(String name, String manufacturer, int power) {
        super(name, manufacturer, power);
    }

    @Override
    public String toString() {
        return "HallAppliance{" +
                "name='" + getName() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", power=" + getPower() + "W" +
                '}';
    }
}
