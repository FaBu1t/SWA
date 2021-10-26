package de.hsos.swa.ssa.ui.view;

import java.util.Scanner;

import de.hsos.swa.ssa.suchen.ui.view.SuchenStartControl;

public class MenueView {
    SimpleShoppingAppView simpleShoppingAppView;

    public MenueView() {
        simpleShoppingAppView = new SimpleShoppingAppView();
        simpleShoppingAppView.display();
    }

    public int display() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte waehlen Sie!");
        boolean validInput = false;
        int input;

        do {
            System.out.println("Ware suchen: 1 ------------ Warenkorb anzeigen: 2 ------------ Bezahlen: 3");
            input = scanner.nextInt();

            switch (input) {
            case 1:
                validInput = true;
                break;
            case 2:
            case 3:
            default:
                System.out.println("Eingabe nicht gültig. Bitte versuchen Sie es erneut.");
                break;
            }

        } while (!validInput);

        return input;
    }

}
