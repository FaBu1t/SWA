package de.hsos.swa.mocktailApp.gateway;

import java.util.ArrayList;
import java.util.List;

import de.hsos.swa.mocktailApp.entity.Mocktail;

public class MockMocktailRepository implements MocktailRepository{
    private List<Mocktail> mocktails = new ArrayList<Mocktail>();
    

    @Override
    public Mocktail get(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean create(int id, String name, String[] zutaten, String autor) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(int id, String name, String[] zutaten, String autor) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
