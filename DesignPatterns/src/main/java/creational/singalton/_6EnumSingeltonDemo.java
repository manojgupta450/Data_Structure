package creational.singalton;

enum _6EnumSingleton {
    INSTANCE;

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class _6EnumSingeltonDemo {

    public static void main(String[] args) {
        _6EnumSingleton singleton = _6EnumSingleton.INSTANCE;

        System.out.println(singleton.getValue());
        singleton.setValue(2);
        System.out.println(singleton.getValue());
    }
}
