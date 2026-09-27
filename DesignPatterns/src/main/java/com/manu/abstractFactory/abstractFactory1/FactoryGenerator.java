package com.manu.abstractFactory.abstractFactory1;

public class FactoryGenerator {
    public AbstractShapeFactory getFactory(boolean isRounded) {
        if (isRounded) {
            return new RoundedShapeFactory();
        }
        else {
            return new ShapeFactory();
        }
    }
}
