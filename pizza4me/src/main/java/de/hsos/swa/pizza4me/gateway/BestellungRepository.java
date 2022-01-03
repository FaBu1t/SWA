package de.hsos.swa.pizza4me.gateway;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import de.hsos.swa.pizza4me.control.BestellungService;
import de.hsos.swa.pizza4me.entity.Bestellposten;
import de.hsos.swa.pizza4me.entity.Bestellung;
import de.hsos.swa.pizza4me.entity.Kunde;

@RequestScoped
@Transactional(value = TxType.REQUIRED)
@Named("BestellungRepos")
public class BestellungRepository implements BestellungService {

    @Inject
    EntityManager em;

    @Override
    public Bestellung bestellungHinzufuegen(int kundenId) {
        // nur für Tests: es wird jedesmal ein neuer Kunde erstellt
        // kundenId = importKunde();
        try {
            Kunde kunde = em.find(Kunde.class, kundenId);
            if (kunde != null) {
                Bestellung bestellung = new Bestellung();
                kunde.addBestellung(bestellung);
                em.persist(kunde);
                return bestellung;
            }
            System.out.println("Kunde ist null");
            return null;

        } catch (IllegalArgumentException | TransactionRequiredException | EntityExistsException e) {
            // Logger?
            return null;
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
    public Bestellposten bestellpostenAendern(int bestellpostenId, Bestellposten neuerBestellposten) {
        try {
            Bestellposten bestellposten = em.find(Bestellposten.class, bestellpostenId);
            if (bestellposten != null) {
                bestellposten.setMenge(neuerBestellposten.getMenge());
                bestellposten.setPizza(neuerBestellposten.getPizza());
                em.persist(bestellposten);
                return bestellposten;
            }
        } catch (IllegalArgumentException | TransactionRequiredException e) {
            return null;
        }
        return null;
    }

    @Override
    public boolean bestellungAbschliessen(int bestellungId) {
        try {
            Bestellung bestellung = em.find(Bestellung.class, bestellungId);
            if (bestellung != null) {
                bestellung.setBestellt(true);
                em.persist(bestellung);
                return true;
            }
            return false;

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
            if (bestellung != null) {
                return bestellung.isBestellt();
            }
            return false;
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
