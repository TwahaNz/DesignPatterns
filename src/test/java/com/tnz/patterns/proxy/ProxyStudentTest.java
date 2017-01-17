package com.tnz.patterns.proxy;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nzetwa01 on 1/17/2017.
 */
public class ProxyStudentTest {

    private final String TAG = "ProxyStudent Test: ";
    private ProxyStudent student;

    @Test
    public void whenCreatingAStudent_testThatTheProxyStudentSignsTheAttendanceForTheStudent() {
        Student absentStudent = new Undergrad("James");
        student = new ProxyStudent(absentStudent);
        student.signAttendance();

        Assert.assertEquals(TAG, absentStudent.getName(), student.getName());
    }


}
