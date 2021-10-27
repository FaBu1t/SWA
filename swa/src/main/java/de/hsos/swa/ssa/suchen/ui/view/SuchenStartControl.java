package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;
import de.hsos.swa.ssa.suchen.al.EinkaueferIn;
import de.hsos.swa.ssa.suchen.al.HoleWarenkorb;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class SuchenStartControl {
    private HoleWarenkorb einkauferIn;
    private SuchenStartView view;
    private PruefControl pruefControl;
    private SuchControl suchControl;
    private AuswahlControl auswahlControl;
    private WarenkorbFuerSuche warenkorb;

    private Ware[] suchergebnisse;

    public SuchenStartControl() {
        einkauferIn = EinkaueferIn.getEinkaueferInObjekt();
        view = new SuchenStartView();
        suchControl = new SuchControl();
        pruefControl = new PruefControl();
        auswahlControl = new AuswahlControl();
        unterMenuAuswahl(startDialog());

    }

    private int startDialog() {
        int warenkorbnummer = view.benutzerEingabeWarenkorb();
        if (warenkorbnummer > 0) {
            warenkorb = einkauferIn.holeWarenkorb(warenkorbnummer);
        } else {
            if (warenkorbnummer == 0) {
                warenkorb = einkauferIn.holeWarenkorb();
            }
        }
        suchergebnisse = suchControl.start();
        if (view.detailAbfrage()) {
            pruefControl.start(suchergebnisse);
        }
        return view.menuEingabe();
    }

    private void unterMenuAuswahl(int menuPunkt) {
        while (menuPunkt != -1) {
            switch (menuPunkt) {
            case (1):
                suchergebnisse = suchControl.start();
                if (view.detailAbfrage()) {
                    pruefControl.start(suchergebnisse);
                    menuPunkt = view.menuEingabe();
                } else {
                    menuPunkt = view.menuEingabe();
                }
                break;
            case (2):
                if (suchergebnisse != null) {
                    pruefControl.start(suchergebnisse);
                }
                menuPunkt = view.menuEingabe();
                break;
            case (3):
                auswahlControl.start(suchergebnisse);
                menuPunkt = view.menuEingabe();
                break;
            default:
                view.error();
                menuPunkt = view.menuEingabe();
                break;
            }
        }
    }
}
