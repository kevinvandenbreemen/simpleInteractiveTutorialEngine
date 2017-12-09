package com.vandenbreemen.site.core;

import org.junit.Test;
import static junit.framework.TestCase.*;

public class CommandLineArgumentsTest {

    @Test
    public void testParseIndividualArgumentPresent(){
        CommandLineArguments args = new CommandLineArguments(new String[]{
                "-c", "Command"
        });
        assertTrue("Argument expected", args.valueOf("c").isPresent());

    }

    @Test
    public void testParseIndividualArgument(){
        CommandLineArguments args = new CommandLineArguments(new String[]{
                "-c", "Command"
        });
        assertEquals("Argument value expected", "Command", args.valueOf("c").get());
    }

    @Test
    public void testParseMultiwordArgument(){
        CommandLineArguments args = new CommandLineArguments(new String[]{
                "-c", "This is a test"
        });
        assertEquals("Argument value expected", "This is a test", args.valueOf("c").get());
    }

    @Test
    public void testNoArgumentsGiven() throws Exception{
        CommandLineArguments args = new CommandLineArguments(new String[]{});
    }

}
