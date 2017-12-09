package com.vandenbreemen.site.person;

import com.vandenbreemen.site.person.impl.PersonConsoleView;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests for the person (core character in the tutorials)
 */
public class PersonTest {

    @Test
    public void testDeclarePerson(){
        Person.Builder bld = new Person.Builder();
        bld.setFirstName("Mister").setLastName("Tutorial");
        Person person = bld.build();

        assertEquals("Full name expected", "Mister Tutorial", person.getFullName());
    }

    @Test
    public void testSpeak(){

        PersonConsoleView personView = new PersonConsoleView(new Person.Builder()
            .setFirstName("Mister").setLastName("Tutorial")
            .build());

        String output = personView.say("Hello, World");

        assertEquals("Basic text output on console expected",
                "Mister Tutorial says 'Hello, World'",
                output
                );

    }

}
