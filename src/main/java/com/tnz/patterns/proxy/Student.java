package com.tnz.patterns.proxy;

/**
 * Created by nzetwa01 on 1/17/2017.
 */
public abstract class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract void signAttendance();

    public String getName() {
        return name;
    }
}
