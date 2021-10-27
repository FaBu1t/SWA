package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.bl.Ware;

public class AuswahlView {

    public void display(Ware ware) {
        System.out.println(ware.toString() + " wurde zu denem Warenkorb hinzugefügt.");
    }
}
