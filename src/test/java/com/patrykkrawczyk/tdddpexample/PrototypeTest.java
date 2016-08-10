package com.patrykkrawczyk.tdddpexample;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class PrototypeTest {

    private final String PROTOTYPE_NAME = "TEST";
    Prototype prototype;
    @Mock
    Command command;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        prototype = new Prototype(PROTOTYPE_NAME);
    }

    @Test
    public void Prototype_shouldInitializedObject() {
        assertNotNull(new Prototype(PROTOTYPE_NAME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void Prototype_shouldThrowExceptionIfInitializedWithNull() {
        Prototype prototype = new Prototype(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Prototype_shouldThrowExceptionIfInitializedWithEmptyValue() {
        Prototype prototype = new Prototype("");
    }

    @Test
    public void getName_shouldReturnNotNullString() {
        assertNotNull(prototype.getName());
    }

    @Test
    public void getName_shouldReturnNotEmptyString() {
        assertTrue(prototype.getName().length() != 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCommand_shouldThrowExceptionIfArgumentIsNull() {
        prototype.addCommand(null);
    }

    @Test
    public void addCommand_shouldContainObjectAddReturnsProperSize() {
        int oldSize = prototype.getNumberOfCommands();

        prototype.addCommand(command);

        Queue<Command> commands = prototype.getCommands();

        assertTrue(commands.contains(command) && prototype.getNumberOfCommands() > oldSize);
    }

    @Test
    public void getCommands_shouldReturnNotNullCollection() {
        assertNotNull(prototype.getCommands());
    }

    @Test
    public void getCommands_sholdHaveTheSameSizeAsOriginal() {
        int size = prototype.getNumberOfCommands();
        prototype.addCommand(command);

        Queue<Command> commands = prototype.getCommands();

        assertEquals(commands.size(), prototype.getNumberOfCommands());
    }






}
