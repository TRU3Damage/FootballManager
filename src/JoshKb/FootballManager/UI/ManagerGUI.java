package JoshKb.FootballManager.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerGUI{

    private JPanel MainP;
    private JButton teamInformationButton;
    private JButton matchResultsButton;
    private JButton leagueTableButton;

    public ManagerGUI() {

    }

    public void run() {
        JFrame frame = new JFrame("ManagerGUI");
        frame.setContentPane(new ManagerGUI().MainP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        JButton teamInformationButton = new JButton("teamInformationButton");
        teamInformationButton.addActionListener(e -> {

            System.out.println("asd");
            JFrame frame2 = new JFrame("TeamInformation");
            frame2.setContentPane(new ManagerGUI().MainP);
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.pack();
            frame2.setVisible(true);

            //TeamInformation teamInformation = new TeamInformation();
            //teamInformation.setVisible(true);
        });
    }

}

