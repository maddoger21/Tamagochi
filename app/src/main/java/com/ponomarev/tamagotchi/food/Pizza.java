package com.ponomarev.tamagotchi.food;

public class Pizza implements IFood {
    public static String name = "Pizza";
    public static int EnergyRegen = 10;
    public static int HealthRegen = 2;
    public static int HungryRegen = 10;
    public static int cost = 10;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int energyRestore() {
        return EnergyRegen;
    }

    @Override
    public int healthRestore() {
        return HealthRegen;
    }

    @Override
    public int hungryRestore() {
        return HungryRegen;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
