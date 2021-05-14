package com.ponomarev.tamagotchi.food;

public class CoffeeFactory implements IFoodFactory {
    @Override
    public IFood Create() {
        return new Coffee();
    }
}
