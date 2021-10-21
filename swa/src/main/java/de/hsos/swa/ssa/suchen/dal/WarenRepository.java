package de.hsos.swa.ssa.suchen.dal;

import de.hsos.swa.ssa.suchen.bl.Katalog;
import de.hsos.swa.ssa.suchen.bl.Suchalgorithmus;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class WarenRepository implements Katalog {
    private WarenSuche suchalgorithmus = new KeywordMatching();

    @Override
    public void legeSuchalgorithmusFest(Suchalgorithmus algo) {
        if (algo == Suchalgorithmus.KeywordMatching) {
            suchalgorithmus = new KeywordMatching();
        } else if (algo == Suchalgorithmus.SemanticMatching) {
            suchalgorithmus = new SemanticMatching();
        }
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

    public void insertData(){

    }

    public void deleteData(){

    }

    public void deleteTable(){

    }
    


}
