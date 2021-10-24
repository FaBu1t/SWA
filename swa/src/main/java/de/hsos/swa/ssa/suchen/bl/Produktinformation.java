package de.hsos.swa.ssa.suchen.bl;

public class Produktinformation {
    private final String bezeichnung;
    private final Object information;

    public Produktinformation(String bezeichnung, Object information) {
        this.bezeichnung = bezeichnung;
        this.information = information;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;

        }
        Produktinformation other = (Produktinformation) obj;
        return other.bezeichnung.equals(bezeichnung) && other.information.equals(information);
    }
}
