package JoshKb.FootballManager.UI;

import javax.swing.*;

public class ManagerGUI {
    private JButton button1;
    private JPanel MainP;

    public ManagerGUI() {
        button1.addActionListener(e -> {

        });
    }

    public void run() {
        JFrame frame = new JFrame("ManagerGUI");
        frame.setContentPane(new ManagerGUI().MainP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}

