import vista.MenuPrincipal;

import javax.swing.*;

public class Main {

    public static void main(String[] args){

        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.pack();
        menuPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuPrincipal.setVisible(true);

    }

}
