package com.vandenbreemen.site.person.impl;

import com.vandenbreemen.site.person.Person;
import com.vandenbreemen.site.person.api.PersonView;

public class PersonConsoleView implements PersonView<String> {

    private Person person;

    public PersonConsoleView(Person person) {
        this.person = person;
    }

    @Override
    public String say(String message) {
        return new StringBuilder(person.getFullName()).append(" says '")
                .append(message).append("'").toString();
    }
}
