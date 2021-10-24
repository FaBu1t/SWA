package de.hsos.swa.ssa.suchen.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    // Strategy Pattern nachschauen
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

        return null;
    }

    @Override
    public Ware[] suchen(long warennummer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Produktinformation[] gebeProduktinformationen(Ware ware) {
        // TODO Auto-generated method stub
        return null;
    }

    public void insertTable() {

    }

    public void insertData() {

    }

    public void deleteData() {

    }

    public void deleteTable() {

    }

}
