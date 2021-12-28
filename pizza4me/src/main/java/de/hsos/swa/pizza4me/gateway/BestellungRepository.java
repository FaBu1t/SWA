package de.hsos.swa.pizza4me.gateway;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;
import javax.transaction.Transactional;

import de.hsos.swa.pizza4me.control.BestellungService;
import de.hsos.swa.pizza4me.entity.Bestellposten;
import de.hsos.swa.pizza4me.entity.Bestellung;
import de.hsos.swa.pizza4me.entity.Kunde;

@RequestScoped
@Transactional
@Named("BestellungRepos")
public class BestellungRepository implements BestellungService {

    @Inject
    EntityManager em;

    @Override
    public int bestellungHinzufuegen(int kundenId) {
        kundenId = importKunde();
        try {
            Kunde kunde = em.find(Kunde.class, kundenId);
            if (kunde != null) {
                Bestellung bestellung = new Bestellung();
                em.persist(bestellung);
                System.out.println("BestestellungId: " + bestellung.getId());
                kunde.addBestellung(bestellung);
                em.persist(kunde);
                return bestellung.getId();
            }
            return -1;

        } catch (IllegalArgumentException | TransactionRequiredException | EntityExistsException e) {
            System.out.println("Catch");
            // Logger?
            return -1;
        }
    }

    @Override
    public List<Kunde> bestellungLoeschen(int bestellungId) {
        try {
            Bestellung bestellung = em.find(Bestellung.class, bestellungId);
            List<Kunde> kunden = em
                    .createQuery("Select k from Kunde k, IN (k.bestellungen) b Where b.id = :bestellungId",
                            Kunde.class)
                    .setParameter("bestellungId", bestellungId)
                    .getResultList();
            for (Kunde kunde : kunden) {
                kunde.deleteBestellung(bestellungId);
                em.persist(kunde);
            }
            em.remove(bestellung);
            return kunden;
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            // Logger?
            return null;
        }
    }

    @Override
    public Bestellung bestellpostenHinzufuegen(int bestellungId, Bestellposten bestellposten) {
        try {
            em.persist(bestellposten);
            Bestellung bestellung = em.find(Bestellung.class, bestellungId);
            System.out.println("1. true");
            if (bestellung != null) {
                System.out.println("2. true");
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
    public Bestellung bestellpostenLoeschen(int bestellpostenId) {
        Kunde kunde = em
                .createQuery(
                        "Select k from Kunde k, IN (k.bestellungen) b, IN (b.bestellposten) bp WHERE bp.id = :bestellpostenId",
                        Kunde.class)
                .setParameter("bestellpostenId", bestellpostenId)
                .getSingleResult();
        for (Bestellung bestellung : kunde.getBestellungen()) {
            if (bestellung.findBestellposten(bestellpostenId).isPresent()) {
                bestellung.removeBestellposten(bestellpostenId);
                em.remove(em.find(Bestellposten.class, bestellpostenId));
                em.persist(bestellung);
                em.persist(kunde);
                return bestellung;
            }
        }
        return null;
    }

    @Override
    public Bestellung bestellpostenAendern(int bestellpostenId, Bestellposten neuerBestellposten) {
        Kunde kunde = em
                .createQuery(
                        "Select k from Kunde k, IN (k.bestellungen) b, IN (b.bestellposten) bp WHERE bp.id = :bestellpostenId",
                        Kunde.class)
                .setParameter("bestellpostenId", bestellpostenId)
                .getSingleResult();
        for (Bestellung bestellung : kunde.getBestellungen()) {
            if (bestellung.findBestellposten(bestellpostenId).isPresent()) {
                for (Bestellposten bestellposten : bestellung.getBestellposten()) {
                    if (bestellposten.getId() == bestellpostenId) {
                        bestellposten.setMenge(neuerBestellposten.getMenge());
                        bestellposten.setPizza(neuerBestellposten.getPizza());
                        // em.persist(bestellposten);
                        em.persist(bestellung);
                        em.persist(kunde);
                        return bestellung;
                    }
                }
            }
        }
        return null;
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

    public int importKunde() {
        Kunde kunde = new Kunde();
        em.persist(kunde);
        return kunde.getId();
    }

    @Override
    public List<Bestellung> alleBestellungenAnzeigen() {
        return em.createQuery("Select b from Bestellung b", Bestellung.class).getResultList();
    }

    @Override
    public List<List<Bestellung>> alleBestellungenfureKundenAnzeigen(int kundenId) {
        return em.createQuery("Select k.bestellungen from Kunde k WHERE k.id = :kundenId")
                .setParameter("kundenId", kundenId).getResultList();
    }

    @Override
    public boolean isAbgeschlossen(int bestellungId) {
        try {
            Bestellung bestellung = em.find(Bestellung.class, bestellungId);
            return bestellung.isBestellt();
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            return false;
        }
    }

    @Override
    public int findBestellungId(int bestellpostenId) {
        return em.createQuery("Select b from Bestellung b, IN (b.bestellposten) bp WHERE bp.id = :bestellpostenId",
                Bestellung.class).setParameter("bestellpostenId", bestellpostenId).getSingleResult().getId();
    }

}
