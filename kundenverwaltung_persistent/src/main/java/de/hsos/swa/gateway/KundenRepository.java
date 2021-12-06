package de.hsos.swa.gateway;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.hsos.swa.control.KundenService;
import de.hsos.swa.entity.Adresse;
import de.hsos.swa.entity.Kunde;

@RequestScoped
@Transactional
public class KundenRepository implements KundenService {

    @Inject
    EntityManager em;

    @Override
    public Collection<Kunde> kundenAbfragen() {
        return em.createNamedQuery("Kunde.findAll", Kunde.class).getResultList();
    }

    @Override
    public void kundenAnlegen(String vorname, String nachname) {
        Kunde neuerKunde = new Kunde(vorname, nachname);
        em.persist(neuerKunde);
    }

    @Override
    public boolean kundeLoeschen(long kundennr) {
        Kunde zuLoeschen = em.getReference(Kunde.class, kundennr);
        if (zuLoeschen == null) {
            return false;
        }
        em.remove(zuLoeschen);
        return true;
    }

    @Override
    public void adresseAnlegen(long kundennr, Adresse adr) {
        Kunde kunde = this.kundeAbfragen(kundennr);
        if (kunde != null && kunde.getAdresse() == null) {
            kunde.setAdresse(adr);
        }
    }

    @Override
    public void adresseAendern(long kundennr, Adresse neueAdr) {
        Kunde kunde = this.kundeAbfragen(kundennr);
        if (kunde != null) {
            kunde.setAdresse(neueAdr);
            // em.persist(kunde);
        }
    }

    @Override
    public Adresse adresseAbfragen(long kundennr) {
        Kunde kunde = this.kundeAbfragen(kundennr);
        if (kunde != null && kunde.getAdresse() != null) {
            System.out.println("Kundenadresse" + kunde.getAdresse());
            return kunde.getAdresse();
        }
        return null;
    }

    @Override
    public boolean adresseLoeschen(long kundennr) {
        Kunde kunde = em.getReference(Kunde.class, kundennr);
        if (kunde == null) {
            return false;
        }
        Adresse zuLoeschen = kunde.getAdresse();
        if (zuLoeschen == null) {
            return false;
        }
        em.remove(zuLoeschen);
        return true;
    }

    @Override
    public Kunde kundeAbfragen(long kundennr) {
        Kunde kunde = em.find(Kunde.class, kundennr);
        if (kunde != null) {
            return kunde;
        }
        return null;
    }

}
