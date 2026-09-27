package creational.override;

public class Child extends Parent {

    Child() {
        System.out.println("Child");
        i = 20;
    }

    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.i);
    }
}
