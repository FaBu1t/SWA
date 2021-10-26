package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.al.EinkaueferIn;
import de.hsos.swa.ssa.suchen.al.PruefeWare;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class PruefControl {

    private PruefeWare einkauferIn;
    private PruefView view;

    public PruefControl() {
        einkauferIn = EinkaueferIn.getEinkaueferInObjekt();
        view = new PruefView();
    }

    public void start(Ware[] waren) {
        for (Ware ware : waren) {
            view.zeigeDetailinformation(einkauferIn.holeDetailinformation(ware));
        }
       
    }

}
