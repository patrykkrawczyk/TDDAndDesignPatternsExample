package com.patrykkrawczyk.tdddpexample;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class Prototype {
    private String mName;
    private List<Command> mCommands;

    @SuppressWarnings("unused")
    private Prototype(){}

    public Prototype(String name){
        if (name == null) throw new IllegalArgumentException("Name cannot be null.");
        else if(name.length() == 0) throw new IllegalArgumentException("Name cannot be empty.");

        this.mName = name;
        this.mCommands = new LinkedList<Command>();
    }

    public String getName() {
        return this.mName;
    }

    public Queue<Command> getCommands() {
        return new LinkedList<Command>(mCommands);
    }

    public void addCommand(Command command) {
        if(command == null) throw new IllegalArgumentException("Command cannot be null");

        mCommands.add(command);
    }

    public int getNumberOfCommands() {
        return mCommands.size();
    }


}

