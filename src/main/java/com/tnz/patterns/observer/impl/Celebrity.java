package com.tnz.patterns.observer.impl;

import com.tnz.patterns.observer.Observer;
import com.tnz.patterns.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Twaha Nzeyimana
 * The person/thing of interest that will publish their interests
 */
public class Celebrity implements Subject {

    private List<Observer> subscribers;
    private String status;

    private Celebrity(Builder builder) {
        this.status = builder.status;
        this.subscribers = builder.subscribers;
    }

    public void updateSubscribers() {

        handleSubscribersInitialization();

        for (Observer subscriber : subscribers) {
            subscriber.showUpdatedStatus(status);
        }
    }

    public void registerSubscriber(Observer subscriber) {
        handleSubscribersInitialization();

        subscribers.add(subscriber);
    }

    public void unregisterSubscriber(Observer subscriber) {

        handleSubscribersInitialization();

        if (!subscribers.isEmpty()) {
            subscribers.remove(subscriber);
        }
    }

    public List<Observer> getSubscribers() {
        return new ArrayList<Observer>(subscribers);
    }

    private void handleSubscribersInitialization() {

        if (subscribers == null) {
            subscribers = new ArrayList<Observer>();
        }
    }

    public static class Builder {

        private String status;
        private List<Observer> subscribers;

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setSubscribers(List<Observer> subscribers) {
            this.subscribers = subscribers;
            return this;
        }

        public Builder copyTnzCeleb(Celebrity celebrity) {
            this.status = celebrity.status;
            return this;
        }

        public Celebrity build() {
            return new Celebrity(this);
        }
    }
}
