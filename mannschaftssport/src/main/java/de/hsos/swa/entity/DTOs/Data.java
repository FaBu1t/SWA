package de.hsos.swa.entity.DTOs;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Link;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;

import de.hsos.swa.entity.Type;

public class Data {

    @NotNull
    public int id;

    @NotNull
    public Type type;

    public Attribute attributes;
    // public Links links;
    public Relationship relationship;

    @JsonbProperty("links")
    public Map<String, URI> links = new HashMap<>();

    @Override
    public String toString() {
        return "Data [attributes=" + attributes + ", id=" + id + ", links=" + links + ", relationships=" + relationship
                + ", type=" + type + "]";
    }

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

    public void addLinks(String name, URI link) {
        this.links.put(name, link);
    }

}
