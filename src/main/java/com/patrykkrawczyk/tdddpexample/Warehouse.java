package com.patrykkrawczyk.tdddpexample;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/** Used to hold information about available Parts
 * Created by Patryk Krawczyk on 12.08.2016.
 */
class Warehouse {
    private final List<Part> mParts;

    public Warehouse() {
        this.mParts = new ArrayList<>();
    }

    /**
     * @param mPart Object to be added to Warehouse for future usage. Cannot be null.
     * @return True if successfully added given object to List
     */
    public boolean addPart(Part mPart) {
        if (mPart == null) throw new IllegalArgumentException("Part cannot be null.");

        return mParts.add(mPart);
    }

    /** Retrieves Part with given Name, then removes its instance from Warehouse list
     * @param partName Identifcation name of the Part instance to retrieve. Cannot be empty or null.
     * @return Part instance if found object with given name
     * @throws NoSuchElementException if no such item exists
     */
    public Part retrievePart(String partName) throws NoSuchElementException {
        if (partName == null) throw new IllegalArgumentException("Part name cannot be null.");
        if (partName.length() == 0) throw new IllegalArgumentException("Part name cannot be empty.");

        for (Part part : mParts)
            if (part.getName().equals(partName)) {
                return mParts.remove(mParts.indexOf(part));
            }

        throw new NoSuchElementException("No part found with given name.");
    }
}
