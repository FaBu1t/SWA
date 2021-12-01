package de.hsos.swa.flottenverwaltung.gateway;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import de.hsos.swa.flottenverwaltung.entity.Schiff;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FlottenRepository implements PanacheRepository<Schiff> {

    public Schiff findById(Long Id) {
        return find("id", Id).firstResult();
    }

    public List<Schiff> findFree() {
        return list("gebucht", false);
    }

    public void setGebucht(Long Id, boolean status) {
        if (status) {
            update("gebucht = true where id =?1", Id);
        } else {
            update("gebucht = false where id =?1", Id);
        }

    }

}
