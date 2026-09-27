package com.manu.abstractFactory.abstractFactory1;

public class RoundedShapeFactory extends AbstractShapeFactory {
    @Override
    public Shape getShape(String shapeType) {

        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new RoundedRectangle();
        }
        else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new RoundedSquare();
        }
        else {
            return null;
        }

    }
}
