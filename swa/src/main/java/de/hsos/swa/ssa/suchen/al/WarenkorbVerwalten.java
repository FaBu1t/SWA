package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.acl.*;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class WarenkorbVerwalten {

    private static WarenkorbVerwalten warenkorbVerwaltenObjekt;
    private WarenkorbStaender wStaender;
    private WarenKonverter konverter;
    private WarenkorbFuerSuche warenkorb;

    public WarenkorbVerwalten() {
        wStaender = new WarenkorbStaenderImpl();
        konverter = new WarenKonverter();
    }

    public static WarenkorbVerwalten getWarenkorbVerwalten() {
        if (warenkorbVerwaltenObjekt == null) {
            warenkorbVerwaltenObjekt = new WarenkorbVerwalten();
        }
        return warenkorbVerwaltenObjekt;
    }

    public WarenkorbFuerSuche holeWarenkorb() {
        if (this.warenkorb == null) {
            this.warenkorb = wStaender.holeWarenkorb();
        }

        return warenkorb;

    }

    public WarenkorbFuerSuche holeWarenkorb(long warenkorbnummer) {
        this.warenkorb = wStaender.holeWarenkorb(warenkorbnummer);
        return warenkorb;
    }

    public boolean wareZuWarenkorbHinzufuegen(Ware ware) {
        if (warenkorb == null) {

            return false;

        } else {
            warenkorb.wareHinzufuegen(konverter.wareToDto(ware));
            return true;
        }
    }

}
