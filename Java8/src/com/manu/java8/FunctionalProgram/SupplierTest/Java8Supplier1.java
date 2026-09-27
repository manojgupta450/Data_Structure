package com.manu.java8.FunctionalProgram.SupplierTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

// Supplier is a functional interface; it takes no arguments and returns a result.
public class Java8Supplier1<T> {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();
        System.out.println(time);

        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();
        System.out.println(time2);

        Java8Supplier1<String> obj = new Java8Supplier1();
        List<String> list = obj.supplier().get();
        list.add("Hello");
        System.out.println(list);

        Developer devObj = factory(Developer::new);
        System.out.println(devObj);

        Developer devObj1 = factory(() -> new Developer("mkyong"));
        System.out.println(devObj1);

        Supplier<? extends Developer> supplier = () -> new Developer("Manoj");
        Developer devObj2 = factory(supplier);
        System.out.println(devObj2);
    }

    public Supplier<List<T>> supplier() {
        // return () -> new ArrayList<>();
        // constructor reference
        return ArrayList::new;

    }

    public static Developer factory(Supplier<? extends Developer> supplier) {

        Developer developer = supplier.get();
        if (developer.getName() == null || "".equals(developer.getName())) {
            developer.setName("default");
        }
        developer.setSalary(BigDecimal.ONE);
        developer.setStart(LocalDate.of(2017, 8, 8));

        return developer;
    }
}

class Developer {
    String name;
    BigDecimal salary;
    LocalDate start;

    // for factory(Developer::new);
    public Developer() {}

    // for factory(() -> new Developer("mkyong"));
    public Developer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", start=" + start +
                '}';
    }
}
