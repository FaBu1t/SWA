package de.hsos.swa.ssa.ui.view;

import java.util.Scanner;

public class BegruessungView {

    public void display() {
        Scanner input = new Scanner(System.in);
        System.out.println("Herzlich Willkommen in der Simple Shopping App");
        System.out.println("Drücken sie eine Enter zum Fortfahren!");
        input.nextLine();
    }

}
