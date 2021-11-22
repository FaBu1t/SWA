package de.hsos.swa.entity.DTOs;

import javax.validation.constraints.NotNull;

import de.hsos.swa.entity.Type;

public class Data {

    @NotNull
    private int id;

    @NotNull
    private Type type;
    
    private Attribute attributes;
    private Links links;
    private Relationship relationship;


    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationships) {
        this.relationship = relationships;
    }
    // evtl noch rausnehmen
    public Data() {
    }

    public Data(int id, Type type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Attribute getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute attributes) {
        this.attributes = attributes;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

}
