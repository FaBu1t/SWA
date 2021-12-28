package de.hsos.swa.pizza4me.gateway;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.hsos.swa.pizza4me.control.KundenService;
import de.hsos.swa.pizza4me.entity.Kunde;


@Named("KundenRepo")
@Transactional
@ApplicationScoped
public class KundenRepository implements KundenService {

    @Inject
    EntityManager entityManager;

    @Override
    public Kunde kundeHinzufuegen(Kunde kunde) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean kundeLoeschen(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Kunde kundeAendern(Kunde kunde) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Kunde kundeAnzeigen(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Kunde> alleKundenAnzeigen() {
        // TODO Auto-generated method stub
        return null;
    }

}
