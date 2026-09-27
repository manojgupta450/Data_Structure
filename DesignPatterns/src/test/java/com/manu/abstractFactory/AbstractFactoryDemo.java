package com.manu.abstractFactory;

import com.manu.abstractFactory.abstractFactory1.AbstractShapeFactory;
import com.manu.abstractFactory.abstractFactory1.FactoryGenerator;
import com.manu.abstractFactory.abstractFactory1.Shape;

public class AbstractFactoryDemo {

    public static void main(String[] args) {
        FactoryGenerator generator = new FactoryGenerator();
        AbstractShapeFactory roundedShapeFactory = generator.getFactory(true);
        Shape roundedSquare = roundedShapeFactory.getShape("SQUARE");
        roundedSquare.draw();
        Shape roundedRectangle = roundedShapeFactory.getShape("RECTANGLE");
        roundedRectangle.draw();

        AbstractShapeFactory shapeFactory = generator.getFactory(false);
        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();

    }

}
