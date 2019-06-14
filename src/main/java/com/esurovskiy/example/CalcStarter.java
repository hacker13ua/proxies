package com.esurovskiy.example;

import java.lang.reflect.Proxy;

public class CalcStarter {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        final int addRes = calculator
                .add(2, 4);
        final int mulRes = calculator
                .mul(2, 4);
        System.out.println(addRes);
        System.out.println(mulRes);

        ICalculator proxyCalculator =
                (ICalculator) Proxy.newProxyInstance(
                        calculator.getClass().getClassLoader(),
                        calculator.getClass().getInterfaces(),
                        new LogHandler(calculator));
        System.out.println(proxyCalculator.getClass());
        System.out.println(proxyCalculator instanceof ICalculator);
        final int add = proxyCalculator.add(2, 6);
        final int mul = proxyCalculator.mul(2, 6);
        System.out.println(add);
        System.out.println(mul);
    }
}
