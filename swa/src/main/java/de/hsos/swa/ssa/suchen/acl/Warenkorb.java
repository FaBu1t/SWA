package de.hsos.swa.ssa.suchen.acl;

import java.util.ArrayList;

public class Warenkorb implements WarenkorbFuerSuche {
    public ArrayList<WareDTO> waren;
    public long warenkorbnummer;

    public Warenkorb(long nummer) {
        this.warenkorbnummer = nummer;
        waren = new ArrayList<WareDTO>();
    }

    @Override
    public void wareHinzufuegen(WareDTO ware) {
        waren.add(ware);

    }

    @Override
    public long gebeWarenkorbnummer() {

        return this.warenkorbnummer;
    }

}
