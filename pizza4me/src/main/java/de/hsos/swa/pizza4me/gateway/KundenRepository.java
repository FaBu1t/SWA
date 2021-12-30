package de.hsos.swa.pizza4me.gateway;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.hsos.swa.pizza4me.control.KundenService;
import de.hsos.swa.pizza4me.entity.Kunde;

@RequestScoped
@Named("KundenRepo")
@Transactional
public class KundenRepository implements KundenService {

    @Inject
    EntityManager entityManager;

    @Override
    public Kunde kundeHinzufuegen(String name) {
        Kunde kunde = new Kunde();
        kunde.setName(name);
        entityManager.persist(kunde);
        return kunde;
    }

    @Override
    public boolean kundeLoeschen(int id) {

        Kunde kunde = entityManager.find(Kunde.class, id);
        entityManager.remove(kunde);

        if (entityManager.find(Kunde.class, id) == null) {
            return true;
        }
        return false;
    }

    @Override
    public Kunde kundeAendern(Kunde kunde) {

        return null;
    }

    @Override
    public Kunde kundeAnzeigen(int id) {
        Kunde kunde = entityManager.find(Kunde.class, id);
        return kunde;
    }

    @Override
    public List<Kunde> alleKundenAnzeigen() {
        List<Kunde> kunden = entityManager.createQuery("Select k From Kunde k", Kunde.class).getResultList();
        return kunden;
    }

}
