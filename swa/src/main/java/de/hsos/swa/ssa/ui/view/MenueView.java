package de.hsos.swa.ssa.ui.view;

import de.hsos.swa.ssa.shared.Eingabe;

public class MenueView {
    private final String[] MENU = { "Suchen", "Warenkorb", "Bezahlen" };
    private SimpleShoppingAppView simpleShoppingAppView;
    private Eingabe scanner;

    public MenueView() {
        simpleShoppingAppView = new SimpleShoppingAppView();
        simpleShoppingAppView.display();
        scanner = new Eingabe();
    }

    public int display() {
        System.out.println("Bitte waehlen Sie!");
        boolean validInput = false;
        int input;

        do {
            printMenu();
            input = scanner.leseInt();
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

    private void printMenu() {
        for (int i = 0; i < MENU.length; i++) {
            int menupunkt = i + 1;
            System.out.println("(" + menupunkt + "): " + MENU[i]);
        }
    }

}
