package com.esurovskiy.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class LogHandler implements InvocationHandler {
    private Object o;

    public LogHandler(final Object o) {
        this.o = o;
    }

    public Object invoke(final Object proxy,
                         final Method method,
                         final Object[] args) throws Throwable {
        final Object result = method.invoke(o, args);
        final Method originalMethod =
                o.getClass().getMethod(method.getName(),
                        method.getParameterTypes());
        if (originalMethod.isAnnotationPresent(Logger.class)) {
            Logger logger = originalMethod
                    .getAnnotation(Logger.class);
            System.out.println(logger.prefix() +
                    "Invoke method " + method.getName()
                    + " with args " + Arrays.toString(args));
            System.out.println(logger.prefix() +
                    "Method " + method.getName() +
                    " result " + result);
        }
        return result;


    }
}
