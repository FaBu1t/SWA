package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.bl.Produktinformation;

public class PruefView {
    public void zeigeDetailinformation(Produktinformation[] produktinformationen) {
        int counter = 0;
        for (Produktinformation produktinformation : produktinformationen) {
            counter++;
            System.out.println(counter + ". " + produktinformation.toString());
        }
    }
}
