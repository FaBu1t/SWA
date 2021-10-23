package de.hsos.swa.ssa.suchen.dal;

import java.sql.SQLException;
import java.util.List;

public class db {
    public static String jdbcURL = "jdbc:derby:simpleShoppingAppDB;create=true";
    public static String insertSQLTest = "Insert into Ware (Warennummer, Name, Preis, Beschreibung) values (322, \'Fahrrad\', 1304, \'Fahr öfter Fahrrad.\')";
    public static String readSQLTest = "Select * From Ware";
    public static String deleteSQLTest = "Drop Table Ware";
    public static String createTableSQLTest = "Create Table Ware (" + "Warennummer int NOT NULL,"
            + "Name varchar(25) NOT NULL," + "Preis float NOT NULL," + "Beschreibung varchar(150),"
            + "PRIMARY KEY(Warennummer))";

    public static void main(String[] args) throws Exception {
        try {
            TransaktionPool tm = new TransaktionManagement(jdbcURL);
            tm.create(createTableSQLTest);
            tm.update(insertSQLTest);
            // tm.delete(deleteSQLTest);
            List<String> result = tm.read(readSQLTest);
            for (String string : result) {
                System.out.print(string + " ");
            }
        } catch (SQLException e) {
        }

    }
}
