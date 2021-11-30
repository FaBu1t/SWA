package de.hsos.swa.flottenverwaltung.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Schiff {
    @Id
    @SequenceGenerator(name = "schiffSeq", sequenceName = "schiff_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "schiffSeq")
    private Long id;

    private String name;

    private boolean gebucht;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getGebucht() {
        return this.gebucht;
    }

    public void setGebucht(boolean status) {
        this.gebucht = status;
    }

}
