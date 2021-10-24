package de.hsos.swa.ssa.suchen.dal;

import de.hsos.swa.ssa.suchen.bl.Ware;

public class KeywordMatching implements WarenSuche {

    @Override
    public String sucheWare(String suchbegriff) {
        System.out.println("KeyWordMatching");
        // String sqlCommand = "Select * From Ware";
        // String sqlCommand = "Select * From Ware Where Warennummer = suchbegriff OR
        // Name = \'suchbegriff\' OR Preis = suchbegriff OR Beschreibung =
        // \'suchbegriff\'";

        String sqlCommand;
        if (isNumeric(suchbegriff)) {
            sqlCommand = "Select * From Ware Where " + suchbegriff + " IN (Warennummer, Preis)";
        } else {
            sqlCommand = "Select * From Ware Where \'" + suchbegriff + "\' IN (Name, Beschreibung, Waehrung)";
        }
        return sqlCommand;
    }

    private boolean isNumeric(String suchbegriff) {
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
