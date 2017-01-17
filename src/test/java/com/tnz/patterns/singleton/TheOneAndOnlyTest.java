package com.tnz.patterns.singleton;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Twaha Nzeyimana
 */
public class TheOneAndOnlyTest {

    private final String TAG = "Singleton Test: ";
    private TheOneAndOnly person;

    @Before
    public void setup() {
        person = TheOneAndOnly.getInstance();
    }

    @Test
    public void whenGettingAnotherInstanceOfTheOneAndOnly_testThatTheyAreTheSameInstance() {
        TheOneAndOnly person2 = TheOneAndOnly.getInstance();
        Assert.assertEquals(TAG, person, person2);
    }

}
