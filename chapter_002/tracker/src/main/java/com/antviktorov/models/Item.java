package com.antviktorov.models;

public class Item {
    public String name;

    public String description;
    public long created;

    public Item() {

    }

    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreated() {
        return this.created;
    }
}