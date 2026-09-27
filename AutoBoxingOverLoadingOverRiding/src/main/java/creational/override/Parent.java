package creational.override;

public abstract class Parent {

    protected Integer i;

    protected Parent() {
        System.out.println("Parent");
        i = new Integer(10);
    }
}
