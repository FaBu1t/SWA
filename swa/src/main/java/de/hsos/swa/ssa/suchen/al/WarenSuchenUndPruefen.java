package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.bl.Katalog;

import de.hsos.swa.ssa.suchen.bl.Ware;
import de.hsos.swa.ssa.suchen.bl.Produktinformation;

public class WarenSuchenUndPruefen {
    private Katalog katalog;

    public Ware[] sucheWare(String warenname) {
        return katalog.suchen(warenname);
    }

    public Ware sucheWare(long warennummer) {

        return katalog.suchen(warennummer)[0];
    }

    public Produktinformation[] holeDetailinformation(Ware ware) {
        return katalog.gebeProduktinformationen(ware);
    }
}
