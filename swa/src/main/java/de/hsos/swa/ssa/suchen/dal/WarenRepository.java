package de.hsos.swa.ssa.suchen.dal;

import java.sql.Connection;

import de.hsos.swa.ssa.suchen.bl.Katalog;
import de.hsos.swa.ssa.suchen.bl.Suchalgorithmus;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class WarenRepository implements Katalog {
    public static String jdbcURL = "jdbc:derby:simple_shopping_app_db;create=true";
    public static String jdbcClose = "jdbc:derby:simple_shopping_app_db;shutdown=true";

    private WarenSuche suchalgorithmus = new KeywordMatching();

    //Strategy Pattern nachschauen
    @Override
    public void legeSuchalgorithmusFest(Suchalgorithmus algo) {
        
    }

    @Override
    public Ware[] suchen(String warenname) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Ware[] suchen(long warennummer) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Ware gebeProduktinformationen(Ware ware) {
        // TODO Auto-generated method stub
        return null;
    }

    public void insertTable(){
        
    }

    public void insertData() {
        
    }

    public void deleteData() {

    }

    public void deleteTable() {

    }

}
