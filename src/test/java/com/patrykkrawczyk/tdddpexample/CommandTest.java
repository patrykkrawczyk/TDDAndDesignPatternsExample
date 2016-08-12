package com.patrykkrawczyk.tdddpexample;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class CommandTest {

    private static final String EXAMPLE_GOOD_CREATE_COMMAND_LINE = "CREATE felga";
    private static final String EXAMPLE_BAD_COMMAND_LINE_BAD_OPERATION    = "CRTEA felga";
    private static final String EXAMPLE_BAD_COMMAND_LINE_BAD_ARGS         = "CREATE";
    private static final String EXAMPLE_BAD_COMMAND_LINE_COMBINE_BAD_ARGS = "COMBINE";
    private static final String EXAMPLE_BAD_COMMAND_LINE_FINISH_BAD_ARGS  = "FINISH";

    @Test
    public void Command_shouldInitializeObject() {
        Command command = new Command(EXAMPLE_GOOD_CREATE_COMMAND_LINE);
        assertNotNull(command);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Command_shouldThrowExceptionIfInitializedWithNull() {
        new Command(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Command_shouldThrowExceptionIfInitializedWithEmptyValue() {
        new Command("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void Command_shouldThrowExceptionIfInitializedWithUnrecognizedOperation() {
        new Command(EXAMPLE_BAD_COMMAND_LINE_BAD_OPERATION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Command_shouldThrowExceptionIfInitializedWithBadArguments() {
        new Command(EXAMPLE_BAD_COMMAND_LINE_BAD_ARGS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Command_shouldThrowExceptionIfInitializedWithBadArgumentsForCombineOperation() {
        new Command(EXAMPLE_BAD_COMMAND_LINE_COMBINE_BAD_ARGS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Command_shouldThrowExceptionIfInitializedWithBadArgumentsForFinishOperation() {
        new Command(EXAMPLE_BAD_COMMAND_LINE_FINISH_BAD_ARGS);
    }

    @Test
    public void getOperation_shouldReturnProperEnumOfOperation() {
        Command command = new Command(EXAMPLE_GOOD_CREATE_COMMAND_LINE);
        assertEquals(Command.Operation.CREATE, command.getOperation());
    }

    @Test
    public void getArguments_shouldReturnArgumentsOfOperation() {
        Command command = new Command(EXAMPLE_GOOD_CREATE_COMMAND_LINE);
        assertNotNull(command.getArguments());
    }
}
