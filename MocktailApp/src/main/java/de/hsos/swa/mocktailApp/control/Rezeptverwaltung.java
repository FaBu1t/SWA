package de.hsos.swa.mocktailApp.control;

import de.hsos.swa.mocktailApp.entity.Mocktail;
import de.hsos.swa.mocktailApp.entity.MocktailDTO;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Rezeptverwaltung implements Create, Delete, Change, Read {
    DTOFactory dtoFactory;
    SucheMocktail sucheService;
    EntferneMocktail entfernenService;
    FuegeMocktailHinzu hinzufuegenService;
    AendereMocktail aenderenService;

    public Rezeptverwaltung() {
        this.dtoFactory = new DTOFactory();
    }

    @Override
    public List<MocktailDTO> suchen(String name) {
        if (sucheService == null)
            sucheService = new SucheMocktail();

        List<Mocktail> mocktails = sucheService.suchen(name);
        List<MocktailDTO> mocktailDTOs = new ArrayList<MocktailDTO>();
        for (Mocktail m : mocktails) {
            mocktailDTOs.add(dtoFactory.getMocktailDtoFromMocktail(m));
        }
        return mocktailDTOs;
    }

    @Override
    public MocktailDTO suchen(int id) {
        if (sucheService == null)
            sucheService = new SucheMocktail();

        Mocktail mocktail = sucheService.suchen(id);

        return dtoFactory.getMocktailDtoFromMocktail(mocktail);
    }

    @Override
    public boolean change(MocktailDTO mocktailDTO) {
        if (aenderenService == null) {
            aenderenService = new AendereMocktail();
        }
        return aenderenService.aendere(dtoFactory.getMocktailFromMocktailDto(mocktailDTO));
    }

    @Override
    public boolean delete(int id) {
        if (entfernenService == null) {
            entfernenService = new EntferneMocktail();
        }
        return entfernenService.delete(id);
    }

    @Override
    public boolean create(MocktailDTO mocktail) {
        if (hinzufuegenService == null) {
            hinzufuegenService = new FuegeMocktailHinzu();
        }
        return hinzufuegenService.create(dtoFactory.getMocktailFromMocktailDto(mocktail));
    }

}
