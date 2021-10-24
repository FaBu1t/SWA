package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;
import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class EinkaueferIn implements HoleWarenkorb, PruefeWare, SucheWare, WaehleWare {
    private WarenSuchenUndPruefen warenSuP;

    @Override
    public boolean wareZuWarenkorbHinzufuegen(Ware ware) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Ware[] sucheWare(String warenname) {

        return warenSuP.sucheWare(warenname);
    }

    @Override
    public Ware sucheWare(long warennummer) {

        return warenSuP.sucheWare(warennummer);
    }

    @Override
    public Produktinformation[] holeDetailinformation(Ware ware) {

        return warenSuP.holeDetailinformation(ware);
    }

    @Override
    public WarenkorbFuerSuche holeWarenkorb() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WarenkorbFuerSuche holeWarenkorb(long warenkorbnummer) {
        // TODO Auto-generated method stub
        return null;
    }

}
