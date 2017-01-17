package com.tnz.patterns.observer.impl;

import com.tnz.patterns.observer.Observer;

import static java.lang.System.out;

/**
 * Created by Twaha Nzeyimana
 * An interested subscriber
 */
public class GmailSubscriber implements Observer {
    public void showUpdatedStatus(String status) {
        out.println( this.hashCode() + ": " + status);
    }
}
