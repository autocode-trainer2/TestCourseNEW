package com.epam.training.student_khasankhon_artikov.collections.main_task;

public class BedroomAppliance extends HouseholdAppliance{
    public BedroomAppliance(String name, String manufacturer, int power) {
        super(name, manufacturer, power);
    }

    @Override
    public String toString() {
        return "BedroomAppliance{" +
                "name='" + getName() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", power=" + getPower() + "W" +
                '}';
    }
}
