package de.hsos.swa.entity.DTOs;

import java.util.ArrayList;

public class DataObject {

    public ArrayList<Data> data = new ArrayList<Data>();
    public Included included;
    public Error error;

    public DataObject(Data data) {
        this.data.add(data);
    }

    public DataObject(Included included) {
        this.included = included;
    }

    public DataObject(Error error) {
        this.error = error;
    }

    public DataObject() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((error == null) ? 0 : error.hashCode());
        result = prime * result + ((included == null) ? 0 : included.hashCode());
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
        DataObject other = (DataObject) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (error == null) {
            if (other.error != null)
                return false;
        } else if (!error.equals(other.error))
            return false;
        if (included == null) {
            if (other.included != null)
                return false;
        } else if (!included.equals(other.included))
            return false;
        return true;
    }

}
