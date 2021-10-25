package de.hsos.swa.ssa.shared;

public enum Waehrung {
    EURO, DOLLAR, YEN;

    public static Waehrung fromString(String string) {
        for (Waehrung waehrung : Waehrung.values()) {
            if (string == waehrung.toString())
                ;
            return waehrung;
        }
        return null;
    }
}
