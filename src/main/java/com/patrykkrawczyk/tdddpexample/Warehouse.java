package com.patrykkrawczyk.tdddpexample;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Patryk Krawczyk on 12.08.2016.
 */
public class Warehouse {
    private List<Part> mParts;

    public Warehouse() {
        this.mParts = new ArrayList<>();
    }

    public boolean addPart(Part mPart) {
        if (mPart == null) throw new IllegalArgumentException("Part cannot be null.");

        return mParts.add(mPart);
    }

    public Part retrievePart(String partName) {
        if (partName == null) throw new IllegalArgumentException("Part name cannot be null.");
        if (partName.length() == 0) throw new IllegalArgumentException("Part name cannot be empty.");

        for (Part part : mParts) {
            if (part.getName().equals(partName)) {
                return mParts.remove(mParts.indexOf(part));
            }
        }

        throw new NoSuchElementException("No part found with given name.");
    }
}
