package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class Test {

    public static void main(String[] args) {
        EinkaueferIn einkauf = EinkaueferIn.getEinkaueferInObjekt();

        Ware ware = einkauf.sucheWare(23344);

        if (ware == null) {
            System.out.println("null");
        } else {
            System.out.println("Name: " + ware.getName());

            Produktinformation[] info = einkauf.holeDetailinformation(ware);

            if (info.length == 0) {
                System.out.println("null");
            }

            for (Produktinformation i : info) {
                System.out.println("Bezeichnung: " + i.getBezeichnung());
            }

        }
    }

}
