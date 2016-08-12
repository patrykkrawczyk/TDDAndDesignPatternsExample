package com.patrykkrawczyk.tdddpexample;

/**
 * Abstract class used in Composite Design Pattern for creating Product
 * Created by Patryk Krawczyk on 11.08.2016.
 */
public abstract class Part {

    private String mName;

    /**
     * @param name Name of Part. Cannot be null or empty.
     */
    Part(String name){
        if (name == null) throw new IllegalArgumentException("Name cannot be null.");
        if (name.length() == 0) throw new IllegalArgumentException("Name cannot be empty.");

        this.mName = name;
    }

    /**
     * @return Retreives name used for identification of this Part
     */
    public String getName() { return mName; }
}
