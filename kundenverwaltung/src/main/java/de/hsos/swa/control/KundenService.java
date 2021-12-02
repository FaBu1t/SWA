package de.hsos.swa.control;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.enterprise.context.ApplicationScoped;

import de.hsos.swa.entity.Adresse;
import de.hsos.swa.entity.Kunde;

@ApplicationScoped
public class KundenService {
    private HashMap<Long, Kunde> kunden = new HashMap<Long, Kunde>();
    private AtomicLong counter = new AtomicLong(1);

    public void kundenAnlegen(String vorname, String nachname) {
        if (vorname != null && nachname != null) {
            kunden.put(counter.getAndIncrement(), new Kunde(vorname, nachname));
        }
    }

    public Collection<Kunde> kundenAbfragen() {
        return kunden.values();
    }

    public Kunde kundeAbfragen(long kundennr) {
        if (kunden.containsKey(kundennr)) {
            return kunden.get(kundennr);
        }
        return null;
    }

    public boolean kundeLoeschen(long kundennr) {
        if (kunden.containsKey(kundennr)) {
            return kunden.remove(kundennr, kunden.get(kundennr));
        }
        return false;
    }

    public void adresseAnlegen(long kundennr, Adresse adr) {
        if (kunden.containsKey(kundennr)) {
            if (kunden.get(kundennr).getAdresse() == null) {
                kunden.get(kundennr).setAdresse(adr);
            }
        }
    }

    public void adresseAendern(long kundennr, Adresse neueAdr) {
        if (kunden.containsKey(kundennr)) {
            kunden.get(kundennr).setAdresse(neueAdr);
        }
    }

    public Adresse adresseAbfragen(long kundennr) {
        if (kunden.containsKey(kundennr)) {
            return kunden.get(kundennr).getAdresse();    
        }
        return null;
    }

    public boolean adresseLoeschen(long kundennr) {
        if (kunden.containsKey(kundennr)) {
            kunden.get(kundennr).setAdresse(null);
            return true;
        }
        return false;
    }
}
