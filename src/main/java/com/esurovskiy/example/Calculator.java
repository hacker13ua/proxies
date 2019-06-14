package com.esurovskiy.example;

public class Calculator implements ICalculator {
    @Logger(prefix = "YUUUHUUUUU!!!!!: ")
    public int add(final int a, final int b) {
        System.out.println(this + " invoke original add");
        return a + b;
    }

    public int mul(final int a, final int b) {
        return a * b;
    }

    public double div(final double i, final double i1) {
        return i/i1;
    }
}
