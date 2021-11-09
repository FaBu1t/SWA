package de.hsos.swa.mocktailApp.gateway;

import java.util.HashMap;

import de.hsos.swa.mocktailApp.entity.Mocktail;

public class MockMocktailRepository implements MocktailRepository {
    private HashMap<Integer, Mocktail> mocktails = new HashMap<Integer, Mocktail>();

    @Override
    public Mocktail get(int id) {
        if (mocktails.containsKey(id)) {
            return mocktails.get(id);
        } else {
            return null;
        }
    }

    @Override
    public boolean create(int id, String name, String[] zutaten, String autor) {
        Mocktail mock = new Mocktail(id, name, zutaten, autor);
        mocktails.putIfAbsent(id, mock);
        return true;
    }

    @Override
    public boolean update(int id, String name, String[] zutaten, String autor) {
        Mocktail mock = new Mocktail(id, name, zutaten, autor);
        mocktails.put(id, mock);
        return true;
    }

    @Override
    public boolean delete(int id) {
        if (mocktails.containsKey(id)) {
            mocktails.remove(id);
            return true;
        }
        return false;
    }

}
