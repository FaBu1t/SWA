package de.hsos.swa.pizza4me.gateway;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
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
    public boolean bestellungHinzufuegen(int kundenId) {
        try {
            Kunde kunde = em.find(Kunde.class, kundenId);
            Bestellung bestellung = new Bestellung();
            em.persist(bestellung);
            System.out.println("BestestellungId: " + bestellung.getId());

            if (kunde != null) {
                kunde.addBestellung(bestellung);
                em.persist(kunde);
                return true;
            }
            return false;

        } catch (IllegalArgumentException | TransactionRequiredException | EntityExistsException e) {
            System.out.println("Catch");
            // Logger?
            return false;
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
            if (pizza == null) {
                System.out.println("Pizza = NULL");
                return null;
            }
            Bestellposten bestellposten = new Bestellposten(pizza, menge);
            em.persist(bestellposten);
            Bestellung bestellung = em.find(Bestellung.class, bestellungId);
            if (bestellung != null) {
                bestellung.addBestellposten(bestellposten);
                em.persist(bestellung);
                return bestellung;
            }
            return null;

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
            if (bestellung != null) {
                return bestellung;
            }
            return null;
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            return null;
        }
    }

    public void importKunde() {
        Kunde kunde = new Kunde();
        em.persist(kunde);
        System.out.println("KundenId:" + kunde.getId());
    }

}
