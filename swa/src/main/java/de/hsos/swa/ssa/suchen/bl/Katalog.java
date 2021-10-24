package de.hsos.swa.ssa.suchen.bl;

public interface Katalog {
    public void legeSuchalgorithmusFest(Suchalgorithmus algo);

    public Ware[] suchen(String warenname);

    public Ware[] suchen(long warennummer);

    public Produktinformation[] gebeProduktinformationen(Ware ware);
}
