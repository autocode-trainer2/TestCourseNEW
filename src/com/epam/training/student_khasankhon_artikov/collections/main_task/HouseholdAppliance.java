package com.epam.training.student_khasankhon_artikov.collections.main_task;

public class HouseholdAppliance {
    private String name;
    private String manufacturer;
    private int power;
    private Boolean state = Boolean.FALSE;

    public HouseholdAppliance(String name, String manufacturer, int power) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.power = power;
    }

    public void power_on() {
        if (!this.state) {
            this.state = Boolean.TRUE;
            System.out.println(this.name + " (" + this.manufacturer + ") turning on..");
        } else {
            System.out.println(this.name + " (" + this.manufacturer + ") is already turned on!");
        }
    }

    public void power_off() {
        if (this.state) {
            this.state = Boolean.FALSE;
            System.out.println(this.name + " (" + this.manufacturer + ") turning off..");
        } else {
            System.out.println(this.name + " (" + this.manufacturer + ") is already turned off!");
        }
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "HouseholdAppliance{" +
                "name='" + this.name + '\'' +
                ", model='" + this.manufacturer + '\'' +
                ", power=" + this.power + "W" +
                ", state=" + this.state +
                '}';
    }
}
