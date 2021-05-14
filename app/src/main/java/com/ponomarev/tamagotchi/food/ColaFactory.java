package com.ponomarev.tamagotchi.food;

public class ColaFactory implements IFoodFactory {
    @Override
    public IFood Create() {
        return new Cola();
    }
}
