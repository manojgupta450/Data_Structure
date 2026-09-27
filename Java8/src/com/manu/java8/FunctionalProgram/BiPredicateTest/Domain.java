package com.manu.java8.FunctionalProgram.BiPredicateTest;

import lombok.Data;

@Data
public class Domain {

    String name;
    Integer score;

    public Domain(String name, Integer score) {
        this.name = name;
        this.score = score;
    }
    // getters , setters , toString
}
