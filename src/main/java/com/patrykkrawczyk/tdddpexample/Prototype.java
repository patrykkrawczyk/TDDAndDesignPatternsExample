package com.patrykkrawczyk.tdddpexample;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Used for holding information about single Prototype of object to create
 * Created by Patryk Krawczyk on 10.08.2016.
 */
class Prototype {
    private String mName;
    private List<Command> mCommands;

    /**
     * @param name The name used to identify this Prototype. Cannot be empty or null.
     */
    public Prototype(String name){
        if (name == null) throw new IllegalArgumentException("Name cannot be null.");
        else if(name.length() == 0) throw new IllegalArgumentException("Name cannot be empty.");

        this.mName = name;
        this.mCommands = new LinkedList<>();
    }

    /**
     * @return Name of the given Prototype
     */
    public String getName() {
        return this.mName;
    }

    /**
     * @return Unmodifiable Queue of commands to perform in process of creation of this Prototype
     */
    public Queue<Command> getCommands() {
        return new LinkedList<>(Collections.unmodifiableList(mCommands));
    }

    /**
     * @param command Instance of Command that should be performed in process of creating this Prototype. Cannot be null.
     */
    public void addCommand(Command command) {
        if(command == null) throw new IllegalArgumentException("Command cannot be null");

        mCommands.add(command);
    }

    /** Get the amount of Commands used to create this Prototype
     * @return the amount of Commands used to create this Prototype
     */
    public int getNumberOfCommands() {
        return mCommands.size();
    }


    /** Check if given Prototype instance is a valid Prototype
     * @return True if this is a valid Prototype
     */
    public boolean isValid() {
        return mCommands.get(mCommands.size()-1).getOperation() == Command.Operation.FINISH;
    }
}

