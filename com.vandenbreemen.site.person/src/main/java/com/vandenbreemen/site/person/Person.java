package com.vandenbreemen.site.person;

import org.apache.commons.lang3.StringUtils;
/**
 * A person/character in the engine
 */
public class Person {



    /**
     * Builder for creating new {@link Person} object
     */
    public static class Builder {

        Person newPerson;

        public Builder() {
            this.newPerson = new Person();
        }


        public Builder setFirstName(String firstName) {
            this.newPerson.firstName = firstName;
            return this;
        }


        public Builder setLastName(String lastName) {
            this.newPerson.lastName = lastName;
            return this;
        }


        public Person build() {
            return this.newPerson;
        }
    }

    private String firstName;
    private String lastName;

    private Person(){}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        if(StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)){
            return "MissingNa";
        }
        return this.firstName + " "+this.lastName;
    }
}
