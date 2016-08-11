package com.patrykkrawczyk.tdddpexample;

/**
 * Created by Patryk Krawczyk on 11.08.2016.
 */
public abstract class Part {

    private String mName;

    protected Part(String name){
        if (name == null) throw new IllegalArgumentException("Name cannot be null.");
        if (name.length() == 0) throw new IllegalArgumentException("Name cannot be empty.");

        this.mName = name;
    }

    public String getName() { return mName; }
}
