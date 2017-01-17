package com.tnz.patterns.proxy;

/**
 * Created by nzetwa01 on 1/17/2017.
 */
public class ProxyStudent extends Student {

    private Student student;

    public ProxyStudent (Student student) {
        super(student.getName());
        this.student = student;
    }

    public void signAttendance() {
        student.signAttendance();
    }

    public String getName() {
        return student.getName();
    }
}
