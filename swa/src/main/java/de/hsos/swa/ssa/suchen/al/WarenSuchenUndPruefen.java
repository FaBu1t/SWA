package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.bl.Katalog;
import de.hsos.swa.ssa.suchen.bl.Ware;
import de.hsos.swa.ssa.suchen.dal.WarenRepository;
import de.hsos.swa.ssa.suchen.bl.Produktinformation;

public class WarenSuchenUndPruefen {

    private static WarenSuchenUndPruefen WarenObjekt;
    private Katalog katalog;

    public static synchronized WarenSuchenUndPruefen getWarenSuchenUndPruefen() {
        if (WarenObjekt == null) {
            WarenObjekt = new WarenSuchenUndPruefen();
        }
        return WarenObjekt;
    }

    public WarenSuchenUndPruefen() {
        katalog = new WarenRepository();
    }

    public Ware[] sucheWare(String warenname) {
        return katalog.suchen(warenname);
    }

    public Ware sucheWare(long warennummer) {
        Ware[] waren = katalog.suchen(warennummer);
        if (waren.length == 0) {
            return null;
        }
        return waren[0];
    }

    public Produktinformation[] holeDetailinformation(Ware ware) {
        return katalog.gebeProduktinformationen(ware);
    }
}
