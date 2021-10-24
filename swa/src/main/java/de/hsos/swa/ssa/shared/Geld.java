package de.hsos.swa.ssa.shared;

public final class Geld {
    private final double Menge;
    private final Waehrung waehrung;

    public Geld(double Menge, Waehrung waehrung) {
        this.Menge = Menge;
        this.waehrung = waehrung;
    }

    public double getMenge() {
        return Menge;
    }

    public Waehrung getWaehrung() {
        return waehrung;
    }

    public String toString() {
        return Menge + " " + waehrung;
    }

}
