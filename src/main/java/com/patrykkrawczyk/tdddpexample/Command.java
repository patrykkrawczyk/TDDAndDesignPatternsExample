package com.patrykkrawczyk.tdddpexample;

import java.util.Arrays;

/**
 * Command used for Part manipulating, takes advantage of Command Design Pattern.
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class Command {

    /**
     * Type of command.
     */
    public enum Operation {
        /**
         * Command used for creating new parts.
         *
         */
        CREATE,
        /**
         * Command used for combining multiple parts into one part.
         */
        COMBINE,
        /**
         * Command used for creating final product.
         */
        FINISH
    }

    private Operation mOperation;
    private String[] mArguments;

    /**
     * @param input Text line containing command with parameters. Example: "COMMAND param1 param2"
     */
    public Command(String input) {
        if (input == null) throw new IllegalArgumentException("Input cannot be null.");
        if (input.length() == 0) throw new IllegalArgumentException("Input cannot be empty.");

        String[] splittedInput = input.split(" ");

        readOperation(splittedInput);
        readArguments(splittedInput);
        handleOperation();
    }

    /**
     * @return Type of command operation
     */
    public Operation getOperation() { return mOperation; }

    /**
     * @return String[] containing command arguments.
     */
    public String[] getArguments() { return mArguments; }

    private void readOperation(String[] splittedInput) {
        String operation  = splittedInput[0];

        try {
            this.mOperation = Operation.valueOf(operation);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Operation " + operation + " unrecognized.");
        }
    }

    private void readArguments(String[] splittedInput) {
        mArguments = Arrays.copyOfRange(splittedInput, 1, splittedInput.length);
    }

    private void handleOperation() {
        switch (this.mOperation) {
            case CREATE:
                handleCreateOperationArguments();
                break;
            case COMBINE:
                handleCombineOperationArguments();
                break;
            case FINISH:
                handleFinishOperationArguments();
                break;
        }
    }

    private void handleFinishOperationArguments() {
        if (mArguments.length != 1)
            throw new IllegalArgumentException("Arguments count for FINISH should be in format of [FINISH product_name]");
    }

    private void handleCombineOperationArguments() {
        if (mArguments.length != 3)
            throw new IllegalArgumentException("Arguments count for COMBINE should be in format of [COMBINE part_name_1 part_name_2 product_name]");
    }

    private void handleCreateOperationArguments() {
        if (mArguments.length != 1)
            throw new IllegalArgumentException("Arguments count for " + mOperation + " should be 1.");
    }
}
