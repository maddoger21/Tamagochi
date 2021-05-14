package com.ponomarev.tamagotchi.food;

public class Fish implements IFood {
    public static String name = "Fish";
    public static int EnergyRegen = 2;
    public static int HealthRegen = 10;
    public static int HungryRegen = 15;
    public static int cost = 15;
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
