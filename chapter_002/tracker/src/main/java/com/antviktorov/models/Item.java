package com.antviktorov.models;

import java.util.Arrays;

/**
 * Base class for entities.
 * @author antonviktorov
 * @since 1.0
 */
public class Item {
    /**
     * Identifier.
     */
    private String id;
    /**
     * Entity name.
     */
    protected String name;
    /**
     * Entity description.
     */
    protected String description;
    /**
     * Creation data UTS.
     */
    protected long created;
    /**
     * Comments.
     */
    protected String[] comments = new String[10];
    /**
     * Comments position.
     */
    protected int commentsPosition = 0;
    /**
     * Base constructor.
     */
    public Item() {
    }

    /**
     * Entity constructor with parameters.
     * @param name - entity name
     * @param description - entity description
     * @param created - created date UTS
     */
    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }

    /**
     * Get entity name.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get entity description.
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get date of creation.
     * @return creation date
     */
    public long getCreated() {
        return this.created;
    }

    /**
     * Get entity id.
     * @return entity id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Get comments.
     * @return comments
     */
    public String[] getComments() {
        return  Arrays.copyOfRange(this.comments, 0, this.commentsPosition);
    }

    /**
     * Add comment.
     * @param comment - comment string
     */
    public void addComment(String comment) {
        this.comments[commentsPosition++] = comment;
    }

    /**
     * Set entity id.
     * @param id - entity id
     */
    public void setId(String id) {
        this.id = id;
    }
}