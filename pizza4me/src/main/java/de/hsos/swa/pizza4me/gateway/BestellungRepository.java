package de.hsos.swa.pizza4me.gateway;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;
import javax.transaction.Transactional;

import de.hsos.swa.pizza4me.control.BestellungService;
import de.hsos.swa.pizza4me.entity.Bestellposten;
import de.hsos.swa.pizza4me.entity.Bestellung;
import de.hsos.swa.pizza4me.entity.Kunde;
import de.hsos.swa.pizza4me.entity.Pizza;

@RequestScoped
@Transactional
public class BestellungRepository implements BestellungService {

    @Inject
    EntityManager em;

    @Override
    public Bestellung bestellungHinzufuegen(int kundenId) {
        // nur für Testen!!
        Kunde k = new Kunde();
        em.persist(k);
        System.out.println(k.getId());

        try {
            Kunde kunde = em.find(Kunde.class, kundenId);
            Bestellung bestellung = new Bestellung();
            kunde.addBestellung(bestellung);
            em.persist(kunde);
            return bestellung;
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            // Logger?
            return null;
        }
    }

    @Override
    public boolean bestellungLoeschen(int bestellungId) {
        try {
            Bestellung bestellung = em.find(Bestellung.class, bestellungId);
            em.remove(bestellung);
            return true;
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            // Logger?
            return false;
        }
    }

    @Override
    public Bestellung pizzaHinzufuegen(int bestellungId, int pizzaId, int menge) {
        try {
            Pizza pizza = em.find(Pizza.class, pizzaId);
            Bestellposten bestellposten = new Bestellposten(pizza, menge);
            Bestellung bestellung = em.find(Bestellung.class, bestellungId);
            bestellung.addBestellposten(bestellposten);
            em.persist(bestellung);
            return bestellung;
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            return null;
        }
    }

    @Override
    public Bestellung pizzaLoeschen(int bestellungId, int bestellpostenId) {
        try {
            Bestellung bestellung = em.find(Bestellung.class, bestellungId);
            if (!bestellung.removeBestellposten(bestellpostenId)) {
                return null;
            }
            em.persist(bestellung);
            return bestellung;
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            return null;
        }
    }

    @Override
    public Bestellung bestellpostenAendern(int bestellungId, int bestellpostenId, int neueMenge) {
        try {
            Bestellung bestellung = em.find(Bestellung.class, bestellungId);
            Optional<Bestellposten> opt = bestellung.findBestellposten(bestellpostenId);
            if (opt.isPresent()) {
                opt.get().setMenge(neueMenge);
                em.persist(bestellung);
                return bestellung;
            }
            return null;
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            return null;
        }
    }

    @Override
    public boolean bestellungAbschliessen(int bestellungId) {
        try {
            Bestellung bestellung = em.find(Bestellung.class, bestellungId);
            bestellung.setBestellt(true);
            em.persist(bestellung);
            return true;

        } catch (IllegalArgumentException | TransactionRequiredException e) {
            return false;
        }
    }

    @Override
    public Bestellung bestellungAnzeigen(int bestellungId) {
        try {
            Bestellung bestellung = em.find(Bestellung.class, bestellungId);
            return bestellung;

        } catch (IllegalArgumentException | TransactionRequiredException e) {
            return null;
        }
    }

}
