package de.hsos.swa.ssa.suchen.acl;

import java.util.ArrayList;

public class WarenkorbStaenderImpl implements WarenkorbStaender {
    private ArrayList<Warenkorb> warenkoerbe;

    public WarenkorbStaenderImpl() {
        warenkoerbe = new ArrayList<Warenkorb>();
    }

    @Override
    public Warenkorb holeWarenkorb() {
        Warenkorb warenkorb = new Warenkorb(warenkoerbe.size());
        warenkoerbe.add(warenkorb);
        return warenkorb;
    }

    @Override
    public Warenkorb holeWarenkorb(long warenkorbnummer) {
        for (Warenkorb w : warenkoerbe) {
            if (w.warenkorbnummer == warenkorbnummer) {
                return w;
            }
        }
        return null;
    }

}
