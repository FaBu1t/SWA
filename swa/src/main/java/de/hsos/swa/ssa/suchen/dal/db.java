package de.hsos.swa.ssa.suchen.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db {
    public static String jdbcURL = "jdbc:derby:shoppingdb;create=true";

    public static void main(String[] args) throws Exception {
        createTable();
        insertWare(3, "Buch2", 8f, "Ein Buch kann man lesen");
        // insertWare(4, "Film2", 12f, "Einen Film kann man gucken");
        showWare();
    }

    public static void createTable() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(jdbcURL);
            String sql = "Create Table Ware (" + "Warennummer int NOT NULL," + "Name varchar(25) NOT NULL,"
                    + "Preis float NOT NULL," + "Beschreibung varchar(150)," + "PRIMARY KEY(Warennummer))";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("createTable nicht erfolgreich");
            e.printStackTrace();
        }
    }

    public static void insertWare(int Warennummer, String Name, float Preis, String Beschreibung) {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "Insert into Ware (Warennummer, Name, Preis, Beschreibung) values (" + Warennummer + ",'"
                    + Name + "'," + Preis + ",'" + Beschreibung + "')";
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);

            if (rows > 0) {
                System.out.println("Insert erfolgreich!");
            }
        } catch (SQLException e) {
            System.out.println("insert nicht erfolgreich");
            e.printStackTrace();
        }
    }

    public static void showWare() {
        try {
            Connection connection = DriverManager.getConnection(jdbcURL);
            String sql = "Select * From Ware";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Warennummer: " + rs.getString("Warennummer"));
                System.out.println("Name: " + rs.getString("Name"));
                System.out.println("Preis: " + rs.getString("Preis"));
                System.out.println("Beschreibung " + rs.getString("Beschreibung"));
                System.out.println(" ");
            }
        } catch (SQLException e) {
            System.out.println("Ausgabe hat nicht geklappt");
        }
    }
}
