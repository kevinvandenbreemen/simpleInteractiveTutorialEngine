package com.vandenbreemen.site.person.api;

/**
 * View for displaying a person and what they are doing
 * @param <E>
 */
public interface PersonView<E> {

    /**
     * Say something as this person
     * @param message
     */
    public E say(String message);
}
