package com.esurovskiy.example;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class LogStarter {
    public static void main(String[] args) {
        List proxyList = (List) Proxy.newProxyInstance(
                ArrayList.class.getClassLoader(),
                ArrayList.class.getInterfaces(),
                new LogHandler(new ArrayList<>()));
        proxyList.add("1");
        proxyList.add("2");
        proxyList.get(1);
        proxyList.size();
        proxyList.getClass();
        System.out.println(proxyList);
    }
}
