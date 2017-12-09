package com.vandenbreemen.site.person;

import org.junit.Test;
import static junit.framework.TestCase.*;

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

}
