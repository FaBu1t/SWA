package de.hsos.swa.pizza4me.control;

import de.hsos.swa.pizza4me.entity.Bestellung;

public interface BestellungService {
    
    public void bestellungHinzufuegen(Bestellung bestellung);

    public boolean bestellungLoeschen(int bestellungId);

    public Bestellung pizzaHinzufuegen(int bestellungId,int pizzaId,int menge);

    public Bestellung pizzaLoeschen(int bestellungId,int bestellpostenId);

    public Bestellung bestellpostenAendern(int bestellungId,int bestellpostenId,int neueMenge);

    public boolean bestellungAbschließen(int bestellung);

    public Bestellung bestellungAnzeigen(int bestellungId);
}    
