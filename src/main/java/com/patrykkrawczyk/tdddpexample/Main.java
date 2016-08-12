package com.patrykkrawczyk.tdddpexample;

import java.util.List;

/**
 * 1. Read *.prototype files from working directory using Singleton PrototypeManager.
 * 2. Get list of valid instances of Prototype class from PrototypeManager.
 * 3. Prototype uses Composite Design Pattern via Part abstract class.
 * 4. Use Singleton Factory instance to generate new Product based on Prototype.
 * 5. Print produced Product in Tree form
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class Main {

    /**
     * @param args Arguments received when running application
     */
    public static void main(String[] args) {
        Factory factory = Factory.getInstance();
        PrototypeManager prototypeManager = PrototypeManager.getInstance();

        List<Prototype> prototypes = prototypeManager.getPrototypes();

        prototypes.stream().forEach(prototype ->
            System.out.println(factory.createProductFromPrototype(prototype).toString())
        );
    }
}
