package de.hsos.swa.ssa.suchen.ui.view;

import java.util.Scanner;

import de.hsos.swa.ssa.suchen.bl.Ware;

public class SuchView {
    private Scanner reader;

    public SuchView() {
        reader = new Scanner(System.in);
    }

    public String displayMenu() {
        System.out.println("Geben Sie eine Warennummer oder einen Suchbegriff ein.");
        return reader.nextLine();

    }

    public void displaySearch(Ware ware) {
        System.out.println(ware.toString());
    }

    public void displaySearch(Ware[] waren) {
        for (Ware ware : waren) {
            System.out.println(ware.toString());
        }
    }

    public void displayError() {
        System.out.println("Da hat etwas nicht geklappt. Probiere es nocheinmal:)");
    }
}
