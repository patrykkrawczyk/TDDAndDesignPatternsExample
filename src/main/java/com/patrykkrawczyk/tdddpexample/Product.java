package com.patrykkrawczyk.tdddpexample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class Product extends Part  {
    private final List<Part> mParts;

    public Product(String name){
        super(name);
        this.mParts = new ArrayList<>();
    }

    public int addPart(Part part) {
        if (part == null) throw new IllegalArgumentException("Product cannot be null.");

        mParts.add(part);
        return mParts.size() - 1;
    }

    public int getSize() { return mParts.size(); }

    public Part getPartAt(int index) {
        if (index < 0 && index >= mParts.size())
            throw new IndexOutOfBoundsException();

        return mParts.get(index);
    }
}
