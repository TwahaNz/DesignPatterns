package com.tnz.patterns.singleton;

/**
 * Created by nzetwa01 on 1/17/2017.
 */
class TheOneAndOnly {

    private TheOneAndOnly() {}

    //Note I have decided to use Bill Pugh Solution for this singleton
    private static class Singleton {
        private final static TheOneAndOnly person = new TheOneAndOnly();
    }

    static TheOneAndOnly getInstance() {
        return Singleton.person;
    }
}
