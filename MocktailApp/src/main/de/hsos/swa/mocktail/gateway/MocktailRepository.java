package de.hsos.swa.mocktail.gateway;

public interface MocktailRepository {
    public Collection<Mocktail> allMocktails();

    public Mocktail get(int id);

    public boolean create(int id, String name, String[] zutaten, String autor);

    public boolean update(int id, String name, String[] zutaten, String autor);

    public boolean delete(int id);
}