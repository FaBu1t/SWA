package de.hsos.swa.ssa.suchen.bl;

import java.io.Serializable;

public class Produktinformation {
    private final String bezeichnung;
    private Serializable information;

    public Produktinformation(String bezeichnung, Serializable information) {
        this.bezeichnung = bezeichnung;
        this.information = information;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;

        }
        Produktinformation other = (Produktinformation) obj;
        return other.bezeichnung.equals(bezeichnung) && other.information.equals(information);
    }

    public String toString() {
        return bezeichnung + ", " + information;
    }

    public String getBezeichnung() {
        return this.bezeichnung;
    }

    public Serializable getInformation() {
        return this.information;
    }
}
