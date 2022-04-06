package com.epam.training.student_khasankhon_artikov.collections.main_task;

import com.epam.training.student_khasankhon_artikov.fundamentals.main_task.HelloUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class MyAppliances {

    private List<? extends HouseholdAppliance> appliances;

    public MyAppliances(List<HouseholdAppliance> appliances) {
        this.appliances = appliances;
    }

    public List<BackyardAppliance> getBackyardAppliances() {
        List<BackyardAppliance> backyardAppliances = new ArrayList<>();
        for (HouseholdAppliance appliance: appliances){
            if (appliance instanceof BackyardAppliance){
                backyardAppliances.add((BackyardAppliance) appliance);
            }
        }
        return backyardAppliances;
    }

    public List<BedroomAppliance> getBedroomAppliances() {
        List<BedroomAppliance> bedroomAppliances = new ArrayList<>();
        for (HouseholdAppliance appliance: appliances){
            if (appliance instanceof BedroomAppliance){
                bedroomAppliances.add((BedroomAppliance) appliance);
            }
        }
        return bedroomAppliances;
    }

    public List<KitchenAppliance> getKitchenAppliances() {
        List<KitchenAppliance> kitchenAppliances = new ArrayList<>();
        for (HouseholdAppliance appliance: appliances){
            if (appliance instanceof KitchenAppliance){
                kitchenAppliances.add((KitchenAppliance) appliance);
            }
        }
        return kitchenAppliances;
    }

    public List<HallAppliance> getHallAppliances() {
        List<HallAppliance> hallAppliances = new ArrayList<>();
        for (HouseholdAppliance appliance: appliances){
            if (appliance instanceof HallAppliance){
                hallAppliances.add((HallAppliance) appliance);
            }
        }
        return hallAppliances;
    }

    public HouseholdAppliance get(int index){
        return appliances.get(index);
    }

    public MyAppliances sortByPower(){
        appliances.sort((Comparator<HouseholdAppliance>) (o1, o2) -> o1.getPower() - o2.getPower() );
        System.out.println("Applications were sorted by power in ascending order...");
        return this;
    }

    public HouseholdAppliance getMaxPowerAppliance(){
        HouseholdAppliance maxPowerAppliance = appliances.get(0);
        for (HouseholdAppliance appliance: appliances){
            if (appliance.getPower() > maxPowerAppliance.getPower()){
                maxPowerAppliance = appliance;
            }
        }
        return maxPowerAppliance;
    }

    public void print() {
        System.out.println("Appliances = {");
        for (HouseholdAppliance appliance : appliances) {
            System.out.println(appliance);
        }
        System.out.println("}");
    }

    @Override
    public String toString() {
        return "MyAppliances" + appliances.toString() +
                '}';
    }

}
