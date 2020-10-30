package JoshKb.FootballManager.UI;

import javax.swing.*;

public class ManagerGUI {

    private JPanel MainP;
    private JFrame frame = new JFrame("ManagerGUI");
    private JButton teamInformationButton;
    private JButton matchResultsButton;
    private JButton leagueTableButton;

    public ManagerGUI() {
        teamInformationButton.addActionListener(e -> {
            TeamInformation TIWindow = new TeamInformation();
            TIWindow.run();
        });
    }

    public void run() {
        frame.setContentPane(new ManagerGUI().MainP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}

