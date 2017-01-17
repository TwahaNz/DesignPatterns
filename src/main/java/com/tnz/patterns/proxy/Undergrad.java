package com.tnz.patterns.proxy;

/**
 * Created by nzetwa01 on 1/17/2017.
 */
public class Undergrad extends Student {

    public Undergrad(String name) {
        super(name);
    }

    public void signAttendance() {
        System.out.println(super.getName() + " has signed the attendance");
    }
}
