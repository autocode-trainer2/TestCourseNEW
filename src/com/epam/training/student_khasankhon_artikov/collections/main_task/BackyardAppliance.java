package com.epam.training.student_khasankhon_artikov.collections.main_task;

public class BackyardAppliance extends HouseholdAppliance{
    public BackyardAppliance(String name, String manufacturer, int power) {
        super(name, manufacturer, power);
    }

    @Override
    public String toString() {
        return "BackyardAppliance{" +
                "name='" + getName() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", power=" + getPower() + "W" +
                '}';
    }
}
