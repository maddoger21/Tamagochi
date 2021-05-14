package com.ponomarev.tamagotchi.food;

public class Apple implements IFood {
    public static String name = "Apple";
    public static int EnergyRegen = 5;
    public static int HealthRegen = 5;
    public static int HungryRegen = 5;
    public static int cost = 5;
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
