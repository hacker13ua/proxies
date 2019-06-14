package com.esurovskiy.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class CalculatorTest {

    @Test
    public void add() {
        final Calculator calculator = new Calculator();
        final int result = calculator.add(1, 2);
        Assert.assertEquals(3, result);
    }

    @Test
    public void div() {
        final Calculator calculator = new Calculator();
        final double res = calculator.div(10, 5);
        Assert.assertEquals(2, res, 0.000001);

    }
}