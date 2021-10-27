
package de.hsos.swa.ssa.ui.view;

import de.hsos.swa.ssa.suchen.ui.view.SuchenStartControl;

public class MenueControl {

    public static void main(String[] args) {
        MenueControl menuControl = new MenueControl();
        menuControl.startMenueControl();

    }

    public void startMenueControl() {
        MenueView menueView = new MenueView();
        int option = menueView.display();

        switch (option) {
        case 1:
            System.out.println("Suchen");
            SuchenStartControl suchenStartControl = new SuchenStartControl();
            break;
        case 2:
            System.out.println("Warenkorb");
            break;
        case 3:
            System.out.println("Bezahlen");
            break;
        }
    }

}
