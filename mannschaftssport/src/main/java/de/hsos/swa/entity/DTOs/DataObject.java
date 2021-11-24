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
}
