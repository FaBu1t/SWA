package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.shared.*;
import de.hsos.swa.ssa.suchen.acl.WareDTO;

import de.hsos.swa.ssa.suchen.bl.Ware;

public class WarenKonverter {

    public WareDTO wareToDto(Ware ware) {
        long wNummer = ware.getWarennummer();
        String wName = ware.getName();
        Geld wPreis = ware.getPreis();
        String wBeschreibung = ware.getBeschreibung();
        WareDTO convertedWare = new WareDTO(wNummer, wName, wPreis, wBeschreibung);
        return convertedWare;
    }
}
