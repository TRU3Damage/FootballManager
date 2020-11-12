package JoshKb.FootballManager.UI;

import JoshKb.FootballManager.Individuals.Player;
import JoshKb.FootballManager.Individuals.Team;

import javax.swing.*;
import java.util.ArrayList;

public class PlayerInfoWindow {
    private JComboBox PositionBox;
    private JComboBox EmploymentBox;
    private JTextField PayBox;
    private JPanel PIPanel;
    public JButton doneButton;
    private JTextField NameBox;
    private Player player;
    private JFrame frame = new JFrame("PlayerInformationWindow");

    public boolean DoneButtonPressed = false;

    public void run() {
        frame.setContentPane(new PlayerInfoWindow().PIPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public PlayerInfoWindow(){

        PositionBox.addItem("GK");
        PositionBox.addItem("DF");
        PositionBox.addItem("MF");
        PositionBox.addItem("FW");

        EmploymentBox.addItem("Full-time");
        EmploymentBox.addItem("Part-time");

        doneButton.addActionListener(e -> {
            player = new Player(NameBox.getText(), PositionBox.getItemAt(PositionBox.getSelectedIndex()).toString(), EmploymentBox.getItemAt(EmploymentBox.getSelectedIndex()).toString(), PayBox.getText());
            frame.setVisible(false);
            DoneButtonPressed = true;

        });
    }

    public Player returnPlayer(){
        return player;
    }

}
