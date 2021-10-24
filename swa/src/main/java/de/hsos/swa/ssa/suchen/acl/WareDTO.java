package de.hsos.swa.ssa.suchen.acl;

import de.hsos.swa.ssa.shared.Geld;

public class WareDTO {
    public long nummer;
    public String name;
    public Geld preis;
    public String beschreibung;

    public WareDTO(long nummer, String name, Geld preis, String beschreibung) {
        this.nummer = nummer;
        this.name = name;
        this.preis = preis;
        this.beschreibung = beschreibung;
    }
}
