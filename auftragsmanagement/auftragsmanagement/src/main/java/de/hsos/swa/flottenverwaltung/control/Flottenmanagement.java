package de.hsos.swa.flottenverwaltung.control;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sound.sampled.Line;
import javax.transaction.Transactional;

import de.hsos.swa.flottenverwaltung.entity.Schiff;
import de.hsos.swa.flottenverwaltung.gateway.FlottenRepository;

@ApplicationScoped
public class Flottenmanagement {

    @Inject
    FlottenRepository flottenRepository;

    @Transactional
    public void erstelleSchiff(Schiff neuesSchiff) {
        flottenRepository.persist(neuesSchiff);
    }

    public Schiff findById(Long Id) {
        return flottenRepository.findById(Id);
    }

    public List<Schiff> sucheFreieSchiffe() {
        return flottenRepository.findFree();
    }

    public List<Schiff> sucheAlleSchiffe() {
        return flottenRepository.listAll();
    }

    @Transactional
    public void setSchiffGebucht(Long id, boolean status) {
        this.flottenRepository.setGebucht(id, status);
    }

}
