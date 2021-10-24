package de.hsos.swa.ssa.suchen.bl;

import de.hsos.swa.ssa.shared.*;

public class Ware {
    private long warennummer;
    private String name;
    private Geld preis;
    private String beschreibung;
    private Produktinformation produktInfo;

    // nur Test
    public Ware(long warennummer) {
        this.warennummer = warennummer;
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
}
