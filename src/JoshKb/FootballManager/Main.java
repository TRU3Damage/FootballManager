package JoshKb.FootballManager;

import JoshKb.FootballManager.UI.ManagerGUI;

import javax.swing.*;

public class Main {

    public static void NewVisuals() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        NewVisuals();
        ManagerGUI gui = new ManagerGUI();
        gui.run();

    }
}
