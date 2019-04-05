package com.ashim.java8.memory_leak;

import java.net.URL;
import java.net.URLClassLoader;

class CounterFactory {
    static ICounter newInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        URLClassLoader tmp =
                new URLClassLoader(new URL[]{getClassPath()}) {
                    public Class loadClass(String name) throws ClassNotFoundException {
                        if ("com.ashim.java8.memory_leak.Counter".equals(name))
                            return findClass(name);
                        return super.loadClass(name);
                    }
                };

        return (ICounter)
                tmp.loadClass("com.ashim.java8.memory_leak.Counter").newInstance();
    }

    private static URL getClassPath() {
        return CounterFactory.class.getResource("com.ashim.java8.memory_leak");
    }
}