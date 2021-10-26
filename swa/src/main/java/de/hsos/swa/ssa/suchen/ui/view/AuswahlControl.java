package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;
import de.hsos.swa.ssa.suchen.al.EinkaueferIn;
import de.hsos.swa.ssa.suchen.al.WaehleWare;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class AuswahlControl {
    private WaehleWare einkauferIn;
    private AuswahlView view;

    public AuswahlControl() {
        einkauferIn = EinkaueferIn.getEinkaueferInObjekt();
        view = new AuswahlView();
    }

    public void start(Ware[] waren) {
        for (Ware ware : waren) {
            System.out.println("waren>0");
            if (einkauferIn.wareZuWarenkorbHinzufuegen(ware)) {

                view.display(ware);
            }
        }

    }
}
