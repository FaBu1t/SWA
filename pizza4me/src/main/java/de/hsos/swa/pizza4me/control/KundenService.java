package de.hsos.swa.pizza4me.control;

import de.hsos.swa.pizza4me.entity.Bestellung;

public interface KundenService {
    public Bestellung bestellungHinzufuegen();

    public boolean bestellungLoeschen();

    public Bestellung pizzaHinzufuegen(int bestellungId, int pizzaId, int menge);

    public Bestellung pizzaLoeschen(int bestellungId, int bestellpostenId);

    public Bestellung bestellpostenAendern(int bestellungId, int bestellpostenId, int neueMenge);

    public boolean bestellungAbschliessen(int bestellungId);

    public Bestellung bestellungAnzeigen(int bestellungId);
}
