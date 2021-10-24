package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;
import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class EinkaueferIn implements HoleWarenkorb, PruefeWare, SucheWare, WaehleWare {

    private static EinkaueferIn einkaueferInObjekt;

    public static synchronized EinkaueferIn getEinkaueferInObjekt() {
        if (einkaueferInObjekt == null) {
            einkaueferInObjekt = new EinkaueferIn();
        }
        return einkaueferInObjekt;
    }

    @Override
    public boolean wareZuWarenkorbHinzufuegen(Ware ware) {
        WarenkorbVerwalten wKorbVerwalten = WarenkorbVerwalten.getWarenkorbVerwalten();
        return wKorbVerwalten.wareZuWarenkorbHinzufuegen(ware);
    }

    @Override
    public Ware[] sucheWare(String warenname) {
        WarenSuchenUndPruefen wSuP = WarenSuchenUndPruefen.getWarenSuchenUndPruefen();
        return wSuP.sucheWare(warenname);
    }

    @Override
    public Ware sucheWare(long warennummer) {
        WarenSuchenUndPruefen wSuP = WarenSuchenUndPruefen.getWarenSuchenUndPruefen();
        return wSuP.sucheWare(warennummer);
    }

    @Override
    public Produktinformation[] holeDetailinformation(Ware ware) {
        WarenSuchenUndPruefen wSuP = WarenSuchenUndPruefen.getWarenSuchenUndPruefen();
        return wSuP.holeDetailinformation(ware);
    }

    @Override
    public WarenkorbFuerSuche holeWarenkorb() {
        WarenkorbVerwalten wKorbVerwalten = WarenkorbVerwalten.getWarenkorbVerwalten();
        return wKorbVerwalten.holeWarenkorb();
    }

    @Override
    public WarenkorbFuerSuche holeWarenkorb(long warenkorbnummer) {
        WarenkorbVerwalten wKorbVerwalten = WarenkorbVerwalten.getWarenkorbVerwalten();
        return wKorbVerwalten.holeWarenkorb(warenkorbnummer);
    }

}
