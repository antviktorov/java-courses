package com.antviktorov.models;

import java.sql.Timestamp;

/**
 * Task entity.
 * @author antonviktorov
 * @since 1.0
 */
public class Task extends Item {
    /**
     * Override constructor.
     * @param name - entity name
     * @param description - entity description
     */
    public Task(String name, String description) {
        this.name = name;
        this.description = description;

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        this.created = timestamp.getTime();
    }

    /**
     * Sample method.
     * @return calculateed price
     */
    public String calculatePrice() {
        return  "100%";
    }
}