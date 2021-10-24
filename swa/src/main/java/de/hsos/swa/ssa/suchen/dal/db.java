package de.hsos.swa.ssa.suchen.dal;

import java.sql.SQLException;
import java.util.List;

import de.hsos.swa.ssa.suchen.bl.Ware;

public class db {
    public static String jdbcURL = "jdbc:derby:simpleShoppingAppDB;create=true";
    public static String insertSQLTest = "Insert into Ware (Warennummer, Name, Preis, Beschreibung) values (100, \'Fahrrad\', 1304, \'Fahr öfter Fahrrad.\')";
    public static String readSQLTest = "Select * From Produktinfos";
    public static String deleteSQLTest = "Drop Table Ware";
    public static String createTableSQLTest = "Create Table Ware (" + "Warennummer int NOT NULL,"
            + "Name varchar(25) NOT NULL," + "Preis float NOT NULL," + "Beschreibung varchar(150),"
            + "PRIMARY KEY(Warennummer))";
    public static String createTableProductInfo = "Create Table Produktinfos (Warennummer int NOT NULL, Bezeichnung varchar(150), Information BLOB, FOREIGN KEY(Warennummer) REFERENCES Ware(Warennummer))";
    public static String insertSQLInfoTest = "Insert into Produktinfos(Warennummer, Bezeichnung ) values (322, \'Fahrrad\')";

    public static void main(String[] args) throws Exception {

        try {

            TransaktionPool tm = new TransaktionManagement(jdbcURL);

            // tm.create(createTableProductInfo);
            tm.update(insertSQLTest);
            tm.update(insertSQLInfoTest);
            // tm.delete(deleteSQLTest);
            List<String> result = tm.read(readSQLTest);
            for (String string : result) {
                System.out.print(string + " ");
            }
        } catch (SQLException e) {
        }
        /*
         * try { WarenRepository wr = new WarenRepository(); Ware ware = new Ware(322);
         * System.out.println("RepositoryTest: " + wr.gebeProduktinformationen(ware)); }
         * catch (Exception e) { // TODO: handle exception }
         */
    }
}
