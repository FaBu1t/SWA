package de.hsos.swa.ssa.suchen.ui.view;

import de.hsos.swa.ssa.suchen.al.EinkaueferIn;
import de.hsos.swa.ssa.suchen.al.SucheWare;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class SuchControl {
    private SucheWare einkauferIn;
    private SuchView view;
    private Ware[] suchergebnisse;

    public SuchControl() {
        einkauferIn = EinkaueferIn.getEinkaueferInObjekt();
        view = new SuchView();
    }

    public Ware[] start() {
        String suchbegriff = view.displayMenu();
        try {
            int suchbegriffNumber = Integer.parseInt(suchbegriff);
            Ware ware = einkauferIn.sucheWare(suchbegriffNumber);
            if (ware == null) {
                view.error();
                start();
            } else {
                view.zeigeSuchergebnisse(ware);
                suchergebnisse = new Ware[1];
                suchergebnisse[0] = ware;
            }
        } catch (NumberFormatException nfe) {
            suchergebnisse = einkauferIn.sucheWare(suchbegriff);
            if (suchergebnisse == null) {
                view.error();
                start();
            } else {
                view.zeigeSuchergebnisse(suchergebnisse);
            }
        }
        return suchergebnisse;
    }
}
