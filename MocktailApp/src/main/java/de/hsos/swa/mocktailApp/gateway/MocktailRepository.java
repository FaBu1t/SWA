package de.hsos.swa.mocktailApp.gateway;

import de.hsos.swa.mocktailApp.entity.Mocktail;
import de.hsos.swa.mocktailApp.entity.MocktailKatalog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MocktailRepository implements MocktailKatalog {

    private HashMap<Integer, Mocktail> mocktails = new HashMap<Integer, Mocktail>();
    private static MocktailKatalog instance;

    public MocktailRepository() {
        String zutat[] = { "orange" };
        Mocktail startMocktail = new Mocktail(1, "orangensaft", zutat, "KA");
        mocktails.putIfAbsent(1, startMocktail);

    }

    @Override
    public List<Mocktail> mocktailSuchen(String name) {
        List<Mocktail> found = new ArrayList<Mocktail>();
        for (Map.Entry<Integer, Mocktail> entry : mocktails.entrySet()) {

            if (entry.getValue().getName().equals(name)) {
                found.add(entry.getValue());
            }
        }
        return found;
    }

    @Override
    public boolean mocktailAendern(int id, String name, String[] zutaten, String autor) {
        Mocktail mock = new Mocktail(id, name, zutaten, autor);
        mocktails.put(id, mock);
        return true;
    }

    @Override
    public boolean mocktailHinzufuegen(int id, String name, String[] zutaten, String autor) {
        Mocktail mock = new Mocktail(id, name, zutaten, autor);
        mocktails.putIfAbsent(id, mock);
        return true;
    }

    @Override
    public boolean mocktailLoeschen(int id) {
        if (mocktails.containsKey(id)) {
            mocktails.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Mocktail mocktailSuchen(int id) {
        if (mocktails.containsKey(id)) {
            return mocktails.get(id);
        } else {
            return null;
        }
    }

    public static MocktailKatalog getInstance() {
        if (instance == null) {
            instance = new MocktailRepository();
        }
        return instance;
    }

}