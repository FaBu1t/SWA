package de.hsos.swa.pizza4me.gateway;

import de.hsos.swa.pizza4me.control.BestellungService;
import de.hsos.swa.pizza4me.entity.Bestellung;

public class BestellungRepository implements BestellungService {

    @Override
    public void bestellungHinzufuegen(Bestellung bestellung) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean bestellungLoeschen(int bestellungId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Bestellung pizzaHinzufuegen(int bestellungId, int pizzaId, int menge) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Bestellung pizzaLoeschen(int bestellungId, int bestellpostenId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Bestellung bestellpostenAendern(int bestellungId, int bestellpostenId, int neueMenge) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean bestellungAbschließen(int bestellung) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Bestellung bestellungAnzeigen(int bestellungId) {
        // TODO Auto-generated method stub
        return null;
    }

}
