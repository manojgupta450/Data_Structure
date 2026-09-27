package com.manu.abstractFactory.abstractFactory1;

public class ShapeFactory extends AbstractShapeFactory {

    @Override
    public Shape getShape(final String shapeType) {
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        else {
            return null;
        }
    }
}
