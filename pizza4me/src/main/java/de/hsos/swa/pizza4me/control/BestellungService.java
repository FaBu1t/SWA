package de.hsos.swa.pizza4me.control;

import javax.enterprise.context.RequestScoped;

import de.hsos.swa.pizza4me.entity.Bestellung;

@RequestScoped
public interface BestellungService {

    public Bestellung bestellungHinzufuegen(int kundenId);

    public boolean bestellungLoeschen(int bestellungId);

    public Bestellung pizzaHinzufuegen(int bestellungId, int pizzaId, int menge);

    public Bestellung pizzaLoeschen(int bestellungId, int bestellpostenId);

    public Bestellung bestellpostenAendern(int bestellungId, int bestellpostenId, int neueMenge);

    public boolean bestellungAbschliessen(int bestellungId);

    public Bestellung bestellungAnzeigen(int bestellungId);
}
