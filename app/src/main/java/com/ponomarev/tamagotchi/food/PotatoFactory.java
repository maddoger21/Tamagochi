package com.ponomarev.tamagotchi.food;

public class PotatoFactory implements IFoodFactory {
    @Override
    public IFood Create() {
        return new Potato();
    }
}
