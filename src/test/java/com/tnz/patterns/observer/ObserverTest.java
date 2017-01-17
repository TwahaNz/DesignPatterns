package com.tnz.patterns.observer;

import com.tnz.patterns.observer.impl.GmailSubscriber;
import com.tnz.patterns.observer.impl.OutlookSubscriber;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Twaha Nzeyimana
 */
public class ObserverTest {

    private Observer gmailSubscriber;
    private Observer outlookSubscriber;

    @Before
    public void setup(){
        gmailSubscriber = new GmailSubscriber();
        outlookSubscriber = new OutlookSubscriber();
    }

    @Test
    public void whenSubscribersGetNotifiedAboutAnUpdate_testIfTheUpdateNotificationIsCorrect() {
        gmailSubscriber.showUpdatedStatus("Tnz: Has just recorded a new song!");
        outlookSubscriber.showUpdatedStatus("Tomorrow Tnz plans on going to the moon");
    }

}
