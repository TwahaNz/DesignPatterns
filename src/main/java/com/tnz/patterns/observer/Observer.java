package com.tnz.patterns.observer;

/**
 * Created By Twaha Nzeyimana.
 * This interface will act as the interested party that wishes to get updates.
 */
public interface Observer {
    void showUpdatedStatus(String status);
}
