package com.patrykkrawczyk.tdddpexample;

import java.util.List;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        Factory factory = Factory.getInstance();
        PrototypeManager prototypeManager = PrototypeManager.getInstance();

        List<Prototype> prototypes = prototypeManager.getPrototypes();

        prototypes.stream().forEach(prototype ->
            System.out.println(factory.createProductFromPrototype(prototype).toString())
        );
    }
}
