package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.bl.Ware;

public interface SucheWare {
    public Ware[] sucheWare(String warenname);

    public Ware sucheWare(long warennummer);
}
