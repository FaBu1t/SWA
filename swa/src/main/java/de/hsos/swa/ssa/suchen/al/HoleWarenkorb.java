package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;

public interface HoleWarenkorb {

    public WarenkorbFuerSuche holeWarenkorb();

    public WarenkorbFuerSuche holeWarenkorb(long warenkorbnummer);

}
