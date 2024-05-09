package org.example.DesignPatterns;

import org.example.threads.Synchronization;

public class ClassicSingleton {
    static ClassicSingleton singleton = null;

    ClassicSingleton() {

    }

    public static synchronized ClassicSingleton getInstance() { // A thread safe instance method.
        if (singleton == null) {
            singleton = new ClassicSingleton();
        }
        return singleton;
    }




}
