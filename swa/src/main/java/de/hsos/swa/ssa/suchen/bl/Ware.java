package de.hsos.swa.ssa.suchen.bl;

public class Ware {
    private long warennummer;
    private String name;
    private double preis;
    private String beschreibung;
    private Produktinformation produktInfo;

    // nur Test
    public Ware(long warennummer){
        this.warennummer = warennummer;
    }

    public long getWarennummer() {
        return this.warennummer;
    }

}
