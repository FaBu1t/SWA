package de.hsos.swa.ssa.suchen.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import org.apache.derby.tools.sysinfo;

import de.hsos.swa.ssa.shared.Geld;
import de.hsos.swa.ssa.shared.Waehrung;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class db {
    public static String jdbcURL = "jdbc:derby:simpleShoppingAppDB;create=true";
    public static String insertSQLTest = "Insert into Ware (Warennummer, Name,Preis, Waehrung, Beschreibung) values (1232, \'Topfplanze\',15.59, \'Dollar\', \'lebt noch\')";

    public static String createTableWareSQL = "Create Table Ware (" + "Warennummer int NOT NULL,"
            + "Name varchar(25) NOT NULL," + "Preis double NOT NULL," + "Waehrung varchar(25) NOT NULL,"
            + "Beschreibung varchar(150)," + "PRIMARY KEY(Warennummer))";
    public static String createTableProductInfo = "Create Table Produktinfos (Warennummer int NOT NULL, Bezeichnung varchar(150), Information BLOB, FOREIGN KEY(Warennummer) REFERENCES Ware(Warennummer))";

    public static String deleteAllRowsInfo = "Delete From Produktinfos";
    public static String deleteAllRowsWare = "Delete From Ware";

    public static String readSQLTest = "Select * From Ware";
    public static String deleteSQLTest = "Drop Table Ware";

    public static String insertSQLInfoTest = "Insert into Produktinfos(Warennummer, Bezeichnung) values (2166, \'Ein bisschen Cool\')";

    public static void main(String[] args) throws Exception {

    }

    public static String helpInsert(int warennummer, String ware, double preis, Waehrung waehrung,
            String beschreibung) {
        System.out.println(String.format(Locale.ROOT,
                "Insert into Ware(Warennummer, Name, Preis, Waehrung, Beschreibung) values (%d, \'%s\', %.2f,\'%s\',\'%s\')",
                warennummer, ware, preis, waehrung, beschreibung));
        return String.format(Locale.ROOT,
                "Insert into Ware(Warennummer, Name, Preis, Waehrung, Beschreibung) values (%d, \'%s\', %.2f,\'%s\',\'%s\')",
                warennummer, ware, preis, waehrung, beschreibung);
    }

    public static void printArray(Object[] waren) {
        for (Object ware : waren) {
            System.out.println(ware);
        }
    }

    public static void printResultSet(ResultSet rs) throws SQLException {
        while (rs.next()) {
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getString(i) + " ");
            }
            System.out.println();
        }
    }

}
