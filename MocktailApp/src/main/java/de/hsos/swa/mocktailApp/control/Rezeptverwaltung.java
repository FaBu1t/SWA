package de.hsos.swa.mocktailApp.control;

import de.hsos.swa.mocktailApp.entity.Mocktail;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Rezeptverwaltung implements Create, Delete, Change, Read {
    SucheMocktail sucheService;
    EntferneMocktail entfernenService;
    FuegeMocktailHinzu hinzufuegenService;
    AendereMocktail aenderenService;

    @Override
    public List<Mocktail> suchen(String name) {
        if (sucheService == null)
            sucheService = new SucheMocktail();

        List<Mocktail> mocktails = sucheService.suchen(name);
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
    public boolean change(Mocktail mocktail) {
        if (aenderenService == null) {
            aenderenService = new AendereMocktail();
        }
        return aenderenService.aendere(mocktail);
    }

    @Override
    public boolean delete(int id) {
        if (entfernenService == null) {
            entfernenService = new EntferneMocktail();
        }
        return entfernenService.delete(id);
    }

    @Override
    public boolean create(Mocktail mocktail) {
        if (hinzufuegenService == null) {
            hinzufuegenService = new FuegeMocktailHinzu();
        }
        return hinzufuegenService.create(mocktail);
    }

}
