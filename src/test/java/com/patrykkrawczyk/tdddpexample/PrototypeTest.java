package com.patrykkrawczyk.tdddpexample;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Patryk Krawczyk on 10.08.2016.
 */
public class PrototypeTest {

    private final String EXAMPLE_PROTOTYPE_NAME = "TEST";
    private Prototype mPrototype;
    @Mock
    private Command mCommand;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mPrototype = new Prototype(EXAMPLE_PROTOTYPE_NAME);
    }

    @Test
    public void Prototype_shouldInitializedObject() {
        assertNotNull(new Prototype(EXAMPLE_PROTOTYPE_NAME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void Prototype_shouldThrowExceptionIfInitializedWithNull() {
        new Prototype(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Prototype_shouldThrowExceptionIfInitializedWithEmptyValue() {
        new Prototype("");
    }

    @Test
    public void getName_shouldReturnNotNullString() {
        assertNotNull(mPrototype.getName());
    }

    @Test
    public void getName_shouldReturnNotEmptyString() {
        assertTrue(mPrototype.getName().length() != 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCommand_shouldThrowExceptionIfArgumentIsNull() {
        mPrototype.addCommand(null);
    }

    @Test
    public void addCommand_shouldContainObjectAddReturnsProperSize() {
        int oldSize = mPrototype.getNumberOfCommands();

        mPrototype.addCommand(mCommand);

        Queue<Command> commands = mPrototype.getCommands();

        assertTrue(commands.contains(mCommand) && mPrototype.getNumberOfCommands() > oldSize);
    }

    @Test
    public void getCommands_shouldReturnNotNullCollection() {
        assertNotNull(mPrototype.getCommands());
    }

    @Test
    public void getCommands_shouldHaveTheSameSizeAsOriginal() {
        mPrototype.addCommand(mCommand);
        Queue<Command> commands = mPrototype.getCommands();
        assertEquals(commands.size(), mPrototype.getNumberOfCommands());
    }

    @Test
    public void isValid_prototypeShouldBeValidWithLastCommandBeingFinish() {
        Prototype p = new Prototype(EXAMPLE_PROTOTYPE_NAME);
        p.addCommand(new Command("FINISH x"));
        assertTrue(p.isValid());
    }

    @Test
    public void isValid_prototypeShouldFailWithLastCommandNotBeingFinish() {
        Prototype p = new Prototype(EXAMPLE_PROTOTYPE_NAME);
        p.addCommand(new Command("COMBINE x y z"));
        assertFalse(p.isValid());
    }

}






