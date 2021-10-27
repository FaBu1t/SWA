package de.hsos.swa.ssa.suchen.ui.view;

import java.util.Scanner;

import org.apache.derby.shared.common.security.SystemPermission;

import de.hsos.swa.ssa.shared.Eingabe;
import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;

public class SuchenStartView {
    private Eingabe reader;
    private final String[] MENU = { "Ware suchen", "Detailinformationen anzeigen", "Ware zu Warenkorb hinzufügen" };

    public SuchenStartView() {
        reader = new Eingabe();
        welcomeMessage();
    }

    private void welcomeMessage() {
        System.out.println("Hallo und Willkommen im Shop!");
    }

    public int userInputWarenkorb() {
        System.out.println(
                "Geben Sie bitte Ihre Warenkorbnummer ein. Wenn Sie noch keine Warenkorb haben, geben sie bitte 0 ein.");
        int eingabe = reader.leseInt();
        if (eingabe < 0) {
            error();
            userInputWarenkorb();
        }
        return eingabe;
    }

    public int menuInput() {

        for (int i = 0; i < MENU.length; i++) {
            int menupunkt = i + 1;
            System.out.println("(" + menupunkt + "): " + MENU[i]);
        }

        int input = reader.leseInt();
        if (input < -1 || input == 0 || input > MENU.length) {
            error();
            return menuInput();
        }
        return input;
    }

    public void error() {
        System.out.println("Das hat leider nicht geklappt! Probieren Sie es nocheinmal.");
    }

    public boolean detailAbfrage() {
        System.out.println("Möchtest du nach Detailinformationen zu diesem Produkt suchen?\n(0) nein\n(1) ja");
        int input = reader.leseInt();
        switch (input) {
        case (0):
            return false;
        case (1):
            return true;
        default:
            error();
            return detailAbfrage();
        }

    }
}
