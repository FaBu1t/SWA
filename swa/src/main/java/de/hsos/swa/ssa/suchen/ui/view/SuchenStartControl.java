package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;
import de.hsos.swa.ssa.suchen.al.EinkaueferIn;
import de.hsos.swa.ssa.suchen.al.HoleWarenkorb;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class SuchenStartControl {
    private HoleWarenkorb einkauferIn;
    private SuchenStartView ssv;
    private PruefControl pC;
    private SuchControl suchC;
    private AuswahlControl auswahlC;
    private WarenkorbFuerSuche warenkorb;

    private Ware[] suchergebnisse;

    public SuchenStartControl() {
        einkauferIn = EinkaueferIn.getEinkaueferInObjekt();
        ssv = new SuchenStartView();
        suchC = new SuchControl();
        pC = new PruefControl();
        auswahlC = new AuswahlControl();
        unterMenuAuswahl(startDialog());

    }

    private int startDialog() {
        int warenkorbnummer = ssv.userInputWarenkorb();
        if (warenkorbnummer > 0) {
            warenkorb = einkauferIn.holeWarenkorb();
        } else {
            warenkorb = einkauferIn.holeWarenkorb(warenkorbnummer);
        }
        suchergebnisse = suchC.start();
        if (ssv.detailAbfrage()) {
            pC.start(suchergebnisse);
        }
        return ssv.menuInput();

    }

    private void unterMenuAuswahl(int menuPunkt) {
        while (menuPunkt != -1) {
            switch (menuPunkt) {
            case (1):
                suchergebnisse = suchC.start();
                if (ssv.detailAbfrage()) {
                    pC.start(suchergebnisse);
                    menuPunkt = ssv.menuInput();
                } else {
                    menuPunkt = ssv.menuInput();
                }
                break;

            case (2):
                if (suchergebnisse != null) {
                    pC.start(suchergebnisse);
                }
                menuPunkt = ssv.menuInput();
                break;
            case (3):
                auswahlC.start(suchergebnisse);
                menuPunkt = ssv.menuInput();
                break;
            default:
                ssv.error();
                menuPunkt = ssv.menuInput();
                break;
            }
        }
    }
}
