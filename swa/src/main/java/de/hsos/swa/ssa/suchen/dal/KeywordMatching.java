package de.hsos.swa.ssa.suchen.dal;

public class KeywordMatching implements WarenSuche {

    @Override
    public String sucheWare(String suchbegriff) {

        String sqlCommand;
        if (istZahl(suchbegriff)) {
            sqlCommand = "Select * From Ware Where " + suchbegriff + " IN (Warennummer, Preis)";
        } else {
            sqlCommand = "Select * From Ware Where \'" + suchbegriff + "\' IN (Name, Beschreibung, Waehrung)";
        }
        return sqlCommand;
    }

    private boolean istZahl(String suchbegriff) {
        if (suchbegriff == null) {
            return false;
        }
        try {
            float f = Float.parseFloat(suchbegriff);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
