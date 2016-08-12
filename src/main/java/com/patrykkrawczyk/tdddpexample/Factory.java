package com.patrykkrawczyk.tdddpexample;

import java.util.Queue;

/**
 * Factory used for creating new Product from Prototype.
 * Used Factory Design Pattern.
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class Factory {

    private static Factory mInstance;
    private int mFinishedOrdersAmount;

    /**
     * @return Existing instance of Factory class.
     */
    public static Factory getInstance() {
        if (mInstance == null) mInstance = new Factory();
        return mInstance;
    }

    /**
     * Creates new Product based on Prototype.
     * @param prototype Specified prototype. Cannot be null.
     * @return Product.
     */
    public Product createProductFromPrototype(Prototype prototype) {
        if (prototype == null) throw new IllegalArgumentException("Prototype cant be null");

        Product product = createFromPrototype(prototype);
        if (product != null) mFinishedOrdersAmount++;

        return product;
    }

    /**
     * @return Overall number of Products created by Factory.
     */
    public int getFinishedOrdersAmount() {
        return mFinishedOrdersAmount;
    }

    private Product createFromPrototype(Prototype prototype){
        Product product = null;
        Warehouse warehouse = new Warehouse();
        Queue<Command> commands = prototype.getCommands();

        for (Command command : commands) {
            switch (command.getOperation()) {
                case CREATE:
                    Part part = new Product(command.getArguments()[0]);
                    warehouse.addPart(part);
                    break;
                case COMBINE:
                    Part part1 = warehouse.retrievePart(command.getArguments()[0]);
                    Part part2 = warehouse.retrievePart(command.getArguments()[1]);
                    Product combined = new Product(command.getArguments()[2]);

                    combined.addPart(part1);
                    combined.addPart(part2);
                    warehouse.addPart(combined);
                    break;
                case FINISH:
                    product = (Product) warehouse.retrievePart(command.getArguments()[0]);
                    break;
            }
        }

        return product;
    }


}
