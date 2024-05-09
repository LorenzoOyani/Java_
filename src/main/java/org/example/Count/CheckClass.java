package org.example.Count;

import java.lang.reflect.Method;

public class CheckClass {
    void main() {
        Class<?> objectClass = Object.class;
        System.out.println(STR."Name of class is \{objectClass.getName()}");

        Method[] methods = objectClass.getMethods();
        for (Method methodValues : methods) {
            System.out.println(STR."The method name is \{methodValues.getName()}");
        }
        Object object = new Object();
        if (object.getClass() == Object.class) {
            System.out.println("this is an instances of class");
        }
    }
}
