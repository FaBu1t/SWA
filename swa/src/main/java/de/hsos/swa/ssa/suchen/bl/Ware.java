package de.hsos.swa.ssa.suchen.bl;

import de.hsos.swa.ssa.shared.*;

public class Ware {
    private long warennummer;
    private String name;
    private Geld preis;
    private String beschreibung;
    private Produktinformation produktInfo;

    public Ware(long warennummer, String name, Geld preis) {
        this.warennummer = warennummer;
        this.name = name;
        this.preis = preis;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setProduktInfo(Produktinformation produktinfo) {
        this.produktInfo = produktinfo;
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

    public String toString(){
        return warennummer + ", " + name + ", " + preis + ", " + beschreibung;
    }

}
