package de.hsos.swa.mocktailApp.control;

import de.hsos.swa.mocktailApp.entity.Mocktail;

public class DTOFactory {

    public MocktailDTO getMocktailDtoFromMocktail(Mocktail mocktail) {
        if (mocktail == null) {
            return null;
        }
        MocktailDTO mocktailDTO = new MocktailDTO();
        mocktailDTO.autor = mocktail.getAutor();
        mocktailDTO.id = mocktail.getId();
        mocktailDTO.name = mocktail.getName();
        mocktailDTO.zutaten = mocktail.getZutaten();
        return mocktailDTO;
    }

    public Mocktail getMocktailFromMocktailDto(MocktailDTO mocktailDTO) {
        if (mocktailDTO == null) {
            return null;
        }
        String autor = mocktailDTO.autor;
        int id = mocktailDTO.id;
        String name = mocktailDTO.name;
        String zutaten = mocktailDTO.zutaten;
        return new Mocktail(id, name, zutaten, autor);
    }

}
