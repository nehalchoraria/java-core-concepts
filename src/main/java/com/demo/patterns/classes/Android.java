package com.demo.patterns.classes;

public class Android extends OS{

    private static Android object = null;

    public static Android getAndroid() {
        if (object == null) object = new Android();
        return object;
    }

    private Android() {
        create("Android", "10");
    }
}
