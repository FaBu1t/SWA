package de.hsos.swa.mocktailApp.gateway;

import de.hsos.swa.mocktailApp.entity.Mocktail;

public interface MocktailRepository {

    public Mocktail get(int id);

    public boolean create(int id, String name, String[] zutaten, String autor);

    public boolean update(int id, String name, String[] zutaten, String autor);

    public boolean delete(int id);
}
