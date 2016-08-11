package com.patrykkrawczyk.tdddpexample;

import java.util.Arrays;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class Command {

    public enum Operation { CREATE, COMBINE, FINISH }

    private Operation mOperation;
    private String[] mArguments;

    @SuppressWarnings("unused")
    private Command() {}
    public Command(String input) {
        if (input == null) throw new IllegalArgumentException("Input cannot be null.");
        if (input.length() == 0) throw new IllegalArgumentException("Input cannot be empty.");

        String[] splittedInput = input.split(" ");

        readOperation(splittedInput);
        readArguments(splittedInput);
        handleOperation();
    }

    public Operation getOperation() { return mOperation; }

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
        if (mArguments.length != 2)
            throw new IllegalArgumentException("Arguments count for " + mOperation + " should be 2.");
        else {
            try {
                new Double(mArguments[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Arguments count for CREATE should be in format of [CREATE part_name weight]");
            }
        }
    }
}
