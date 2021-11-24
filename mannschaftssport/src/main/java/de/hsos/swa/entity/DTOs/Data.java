package de.hsos.swa.entity.DTOs;

import javax.validation.constraints.NotNull;

import de.hsos.swa.entity.Type;

public class Data {

    @NotNull
    public int id;

    @NotNull
    public Type type;

    public Attribute attributes;
    public Links links;
    public Relationship relationship;

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

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
        result = prime * result + id;
        result = prime * result + ((links == null) ? 0 : links.hashCode());
        result = prime * result + ((relationship == null) ? 0 : relationship.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Data other = (Data) obj;
        if (attributes == null) {
            if (other.attributes != null)
                return false;
        } else if (!attributes.equals(other.attributes))
            return false;
        if (id != other.id)
            return false;
        if (links == null) {
            if (other.links != null)
                return false;
        } else if (!links.equals(other.links))
            return false;
        if (relationship == null) {
            if (other.relationship != null)
                return false;
        } else if (!relationship.equals(other.relationship))
            return false;
        if (type != other.type)
            return false;
        return true;
    }

}
