package de.hsos.swa.ssa.suchen.dal;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hsos.swa.ssa.shared.Geld;
import de.hsos.swa.ssa.shared.Waehrung;
import de.hsos.swa.ssa.suchen.bl.Katalog;
import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.Suchalgorithmus;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class WarenRepository implements Katalog {
    private TransaktionManagement tm;
    private WarenSuche suchalgorithmus = new KeywordMatching();

    public WarenRepository() {
        try {
            tm = new TransaktionManagement("jdbc:derby:simpleShoppingAppDB;create=true");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void legeSuchalgorithmusFest(Suchalgorithmus algo) {
        if (algo == Suchalgorithmus.KeywordMatching && !(suchalgorithmus instanceof KeywordMatching)) {
            suchalgorithmus = new KeywordMatching();
        } else if (algo == Suchalgorithmus.SemanticMatching && !(suchalgorithmus instanceof SemanticMatching)) {
            suchalgorithmus = new SemanticMatching();
        }

    }

    @Override
    public Ware[] suchen(String warenname) {
        ResultSet rs = tm.read(suchalgorithmus.sucheWare(warenname));
        List<Ware> result = new ArrayList<Ware>();
        int counter = 0;
        if (rs != null) {
            try {
                while (rs.next()) {
                    counter++;
                    Waehrung waehrung = Waehrung.fromString(rs.getString("Waehrung"));
                    Geld geld = new Geld(rs.getDouble("Preis"), waehrung);
                    Ware ware = new Ware(rs.getLong("Warennummer"), rs.getString("Name"), geld);
                    ware.setBeschreibung(rs.getString("Beschreibung"));
                    result.add(ware);
                }
                return result.toArray(new Ware[counter]);
            } catch (SQLException e) {
                // TODO: handle exception
            }
        } else {
            System.out.println("Keine Treffer gefunden!");
            return null;
        }
        return null;
    }

    @Override
    public Ware[] suchen(long warennummer) {
        return this.suchen(String.valueOf(warennummer));
    }

    @Override
    public Produktinformation[] gebeProduktinformationen(Ware ware) {
        ResultSet rs = tm.read("Select * From Produktinfos Where Warennummer = " + ware.getWarennummer());
        if (rs != null) {
            List<Produktinformation> produktinfos = new ArrayList<>();
            int counter = 0;
            try {
                while (rs.next()) {
                    // TODO Blob handling
                    produktinfos.add(new Produktinformation(rs.getString("bezeichnung"), null));
                }
                return produktinfos.toArray(new Produktinformation[counter]);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
