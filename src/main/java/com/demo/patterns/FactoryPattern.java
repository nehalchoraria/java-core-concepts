package com.demo.patterns;

import com.demo.patterns.classes.Android;
import com.demo.patterns.classes.IOS;
import com.demo.patterns.classes.OS;

/**
 * Adding a new platform makes us mandatory add a new instance as well else code won't compile
 */
enum Platforms {
    ANDROID,
    IOS,
}

public class FactoryPattern {
    public OS getInstance(Platforms platform) {
        return switch(platform){
            case ANDROID -> Android.getAndroid();
            case IOS -> new IOS();
        };
    }
}
