package com.tnz.patterns.observer;

import com.tnz.patterns.observer.impl.Celebrity;
import com.tnz.patterns.observer.impl.GmailSubscriber;
import com.tnz.patterns.observer.impl.OutlookSubscriber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Twaha Nzeyimana
 */
public class SubjectTest {

    private final String TAG = "Subject Test: ";
    private Subject celebrityTnz;

    @Before
    public void setup() {
        celebrityTnz = new Celebrity.Builder()
                .build();
    }

    @Test
    public void whenAddingAStatus_testIfTheStatusIsUpdatedSuccessfully() {
        celebrityTnz = new Celebrity.Builder()
                .copyTnzCeleb((Celebrity) celebrityTnz)
                .setStatus("Going to record a new song")
                .build();
    }

    @Test
    public void whenAddingAListOfSubscribers_testTheTotalAmountOfSubscribers() {
        List<Observer> subscribers = new ArrayList<Observer>();

        subscribers.add(new GmailSubscriber());
        subscribers.add(new GmailSubscriber());
        subscribers.add(new OutlookSubscriber());

        celebrityTnz = new Celebrity.Builder()
                .copyTnzCeleb((Celebrity) celebrityTnz)
                .setSubscribers(subscribers)
                .build();

        int celebrityTnzSubscriberSize = celebrityTnz.getSubscribers().size();
        int registeredSubscribersSize = subscribers.size();

        Assert.assertEquals(TAG, celebrityTnzSubscriberSize, registeredSubscribersSize);
    }

    @Test
    public void whenAddingASubscriber_testIfTheyAreRegistered() {

        Observer gmailUser = new GmailSubscriber();

        celebrityTnz.registerSubscriber(gmailUser);

        boolean isMySubscriber = celebrityTnz.getSubscribers().contains(gmailUser);

        Assert.assertTrue(isMySubscriber);

    }

    @Test
    public void whenRemovingASubscriber_testIfTheyAreUnregistered() {

        Observer gmailUser = new GmailSubscriber();

        celebrityTnz.registerSubscriber(gmailUser);

        celebrityTnz.unregisterSubscriber(gmailUser);

        boolean isMySubscriber = celebrityTnz.getSubscribers().contains(gmailUser);

        Assert.assertFalse(isMySubscriber);
    }

    @Test
    public void whenACelebrityUpdatesTheirStatus_testToSeeIfAllTheirSubcribersAreNotified() {

        List<Observer> subscribers = new ArrayList<Observer>();

        celebrityTnz = new Celebrity.Builder()
                .setStatus("I have just recieved a nomination")
                .build();

        for (int i = 0; i < 5; i++) {
            subscribers.add(new GmailSubscriber());
            subscribers.add(new OutlookSubscriber());
            celebrityTnz.registerSubscriber(subscribers.get(i));
            celebrityTnz.registerSubscriber(subscribers.get(i+1));
        }

        celebrityTnz.updateSubscribers();
    }

    @Test
    public void whenCelebrityHasNoSubscriber_testThatAppDoesNotThrowExceptiion() {
        celebrityTnz = new Celebrity.Builder()
                .setSubscribers(null)
                .build();

        celebrityTnz.unregisterSubscriber(new GmailSubscriber());
    }
}
