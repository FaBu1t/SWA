package de.hsos.swa.ssa.suchen.bl;

import de.hsos.swa.ssa.shared.*;

public class Ware {
    private long warennummer;
    private String name;
    private Geld preis;
    private String beschreibung;

    public Ware(long warennummer, String name, Geld preis) {
        this.warennummer = warennummer;
        this.name = name;
        this.preis = preis;
        this.beschreibung = null;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public long getWarennummer() {
        return this.warennummer;
    }

    public String getName() {
        return name;
    }

    public Geld getPreis() {
        return this.preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String toString() {
        String toStringFormat = String.format("\n%1$-11s", String.valueOf(warennummer));
        toStringFormat += String.format(" |%1$-15s", this.name);
        toStringFormat += String.format(" |%1$-7s", String.valueOf(preis.getMenge()));
        toStringFormat += String.format(" |%1$-8s", this.preis.getWaehrung());
        toStringFormat += String.format(" |%1$-20s", this.beschreibung);
        toStringFormat += "\n";
        return toStringFormat;
    }

}
