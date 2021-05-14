package com.ponomarev.tamagotchi.food;

public class Coffee implements IFood {
    public static String name = "Coffee";
    public static int EnergyRegen = 25;
    public static int HealthRegen = 0;
    public static int HungryRegen = 0;
    public static int cost = 25;
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
