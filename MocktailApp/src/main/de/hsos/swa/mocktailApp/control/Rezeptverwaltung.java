package de.hsos.swa.mocktailApp.control;

import de.hsos.swa.mocktailApp.entity.Mocktail;

public class Rezeptverwaltung implements Create, Delete, Change, Read {
    SucheMocktail sucheService;
    EntferneMocktail entfernenService;
    FuegeMocktailHinzu hinzufuegenService;
    AendereMocktail aenderenService;

    @Override
    public Mocktail[] suchen(String name) {
        if (sucheService == null)
            sucheService = new SucheMocktail();

        Mocktail[] mocktails = sucheService.suchen(name);
        return mocktails;
    }

    @Override
    public Mocktail suchen(int id) {
        if (sucheService == null)
            sucheService = new SucheMocktail();

        Mocktail mocktail = sucheService.suchen(id);

        return mocktail;
    }

    @Override
    public boolean change(int id, String[] zutaten, String Autor) {
        if (aenderenService == null) {
            aenderenService = new AendereMocktail();
        }
        return aenderenService.aendere(id, zutaten, Autor);
    }

    @Override
    public boolean delete(int id) {
        if (entfernenService == null) {
            entfernenService = new EntferneMocktail();
        }
        return entfernenService.delete(id);
    }

    @Override
    public boolean create(int id, String name, String[] zutaten, String autor) {
        if (hinzufuegenService == null) {
            hinzufuegenService = new FuegeMocktailHinzu();
        }
        return hinzufuegenService.create(id, name, zutaten, autor);
    }

}
