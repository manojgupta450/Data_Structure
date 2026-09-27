package creational.factoryPattern;

public class ShapeFactoryDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape rectangle = factory.getShape("rectangle");
        rectangle.draw();

        Shape circle = factory.getShape("CIRCLE");
        circle.draw();

        Shape square = factory.getShape("SQUARE");
        square.draw();


    }

}
