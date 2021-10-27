package de.hsos.swa.ssa.shared;

import java.util.Scanner;

public class Eingabe {
    Scanner scan;

    public Eingabe() {
        scan = new Scanner(System.in);
    }

    public String leseString() {
        return scan.nextLine();
    }

    public int leseInt() {
        String eingabe = scan.nextLine();
        try {
            return Integer.parseInt(eingabe);
        } catch (Exception e) {
            System.out.println("Die Eingabe ist nicht gülitg. Bitte geben Sie eine Zahl ein.");
            return leseInt();
        }

    }
}
