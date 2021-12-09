package de.hsos.swa.pizza4me.gateway;

import de.hsos.swa.pizza4me.control.KundenService;
import de.hsos.swa.pizza4me.entity.Bestellung;

public class KundenRepository implements KundenService {

    @Override
    public Bestellung bestellungHinzufuegen() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean bestellungLoeschen() {
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
    public boolean bestellungAbschliessen(int bestellungId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Bestellung bestellungAnzeigen(int bestellungId) {
        // TODO Auto-generated method stub
        return null;
    }

}
