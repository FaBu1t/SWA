package de.hsos.swa.control;

import java.util.Collection;

import de.hsos.swa.entity.Adresse;
import de.hsos.swa.entity.Kunde;

public class KundenService {

    public void kundenAnlegen(String name) {

    }

    public Collection<Kunde> kundenAbfragen() {
        return null;
    }

    public Kunde kundeAbfragen(long kundennr) {
        return null;
    }

    public boolean kundeLoeschen(long kundennr) {
        return false;
    }

    public void adresseAnlegen(long kundennr, Adresse adr) {

    }

    public void adresseAendern(long kundennr, Adresse neueAdr) {

    }

    public Adresse adresseAbfragen(long kundennr) {
        return null;
    }

    public boolean adresseLoeschen(long kundenr) {
        return false;
    }
}
