package com.example.instragram2;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("lSXVhexk5xnQg5BwPKEdw89p5LhcPbNwPK5seFeS")
                // if defined
                .clientKey("KzISrz1k5HdKp2v3ZlXpGiFY2lOYiOPlq94KZfac")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}