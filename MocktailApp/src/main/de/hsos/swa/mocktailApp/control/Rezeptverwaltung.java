package de.hsos.swa.mocktailApp.control;

import de.hsos.swa.mocktailApp.entity.Mocktail;

public class Rezeptverwaltung implements Create, Delete, Change, Read {

    @Override
    public Mocktail[] suchen(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Mocktail suchen(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean change(int id, String[] zutaten, String Autor) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean create(int id, String name, String[] zutaten, String Autor) {
        // TODO Auto-generated method stub
        return false;
    }

}
