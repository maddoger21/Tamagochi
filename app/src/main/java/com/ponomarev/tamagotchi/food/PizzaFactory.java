package com.ponomarev.tamagotchi.food;

public class PizzaFactory implements IFoodFactory {
    @Override
    public IFood Create() {
        return new Pizza();
    }
}
