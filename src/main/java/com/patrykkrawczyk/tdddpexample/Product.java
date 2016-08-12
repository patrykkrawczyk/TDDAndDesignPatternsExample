package com.patrykkrawczyk.tdddpexample;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to store CREATEd or COMBINEd products
 * Takes advantage of Composite Design Pattern
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class Product extends Part  {
    private final List<Part> mParts;

    /**
     * @param name The name that should be associated with Product instance
     */
    public Product(String name){
        super(name);
        this.mParts = new ArrayList<>();
    }

    /** Method for providing objects that make this Product
     * @param part One of the components creating given Product. Cannot be null.
     * @return Index of just added object
     */
    public int addPart(Part part) {
        if (part == null) throw new IllegalArgumentException("Product cannot be null.");

        mParts.add(part);
        return mParts.size() - 1;
    }

    /** Size of currently held parts
     * @return Size of currently held parts
     */
    public int getSize() { return mParts.size(); }

    /** Use this method to retrieve one of the Parts which Product consists of
     * @param index index of desired object. Must be within bounds.
     * @return Object containing information about given Part
     */
    public Part getPartAt(int index) {
        if (index < 0 || index >= mParts.size())
            throw new IndexOutOfBoundsException();

        return mParts.get(index);
    }

    /** Print structure of Product in Tree form
     * @return String containing structure of Product in Tree form
     */
    @Override
    public String toString() {
        int indent = 0;
        StringBuilder sb = new StringBuilder();
        printDirectoryTree(this, indent, sb);
        return sb.toString();
    }

    private static void printDirectoryTree(Product product, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent));
        sb.append("+--");
        sb.append(product.getName());
        sb.append("\n");
        for (int k = 0; k < product.getSize(); k++) {
            Product part = (Product) product.getPartAt(k);
            printDirectoryTree(part, indent + 1, sb);
        }
    }

    private static String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) sb.append("|  ");

        return sb.toString();
    }
}
