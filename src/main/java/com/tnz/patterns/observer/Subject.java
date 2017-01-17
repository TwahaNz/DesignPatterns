package com.tnz.patterns.observer;

import java.util.List;

/**
 * Created by Twaha Nzeyimana
 * This interface will be the important side that will publish their interest to the subscribers
 */
public interface Subject {
    void updateSubscribers();
    void registerSubscriber(Observer subscriber);
    void unregisterSubscriber(Observer subscriber);
    List<Observer> getSubscribers();
}
