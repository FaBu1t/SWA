package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;
import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class EinkaueferIn implements HoleWarenkorb, PruefeWare, SucheWare, WaehleWare {

    @Override
    public boolean wareZuWarenkorbHinzufuegen(Ware ware) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Ware[] sucheWare(String warenname) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Ware sucheWare(long warennummer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Produktinformation[] holeDetailinformation(Ware ware) {
        // TODO Auto-generated method stub
        return null;
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
