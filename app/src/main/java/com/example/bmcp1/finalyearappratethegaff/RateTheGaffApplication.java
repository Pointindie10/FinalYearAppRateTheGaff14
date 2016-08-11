package com.example.bmcp1.finalyearappratethegaff;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by bmcp1 on 12/05/2016.
 */
public class RateTheGaffApplication extends Application {
    @Override
    public void onCreate()
    {
        // Enable Local Datastore.
        super.onCreate();
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "XONU8Cm4MJGwfUIzVJHBwzHctKAshYNntRZpIW8Y", "yScAZuKMDXglwIb8J9ZxVnAG1rtOJIoWAIdMQ7nA");

    }
}
