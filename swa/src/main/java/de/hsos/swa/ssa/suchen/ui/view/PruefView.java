package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class PruefView {
    public void zeigeDetailinformation(Produktinformation[] produktinformationen) {
        for (Produktinformation produktinformation : produktinformationen) {
            System.out.println(produktinformation.toString());
        }
    }
}
