package JoshKb.FootballManager.UI;

import javax.swing.*;

public class InfoBox {

    private JPanel IBPanel;
    private JLabel playerName;
    private JLabel playerPosition;
    private JLabel playerPay;
    private JLabel playerEmploymentStatus;
    private String EnteredText = "Failed";

    public InfoBox(String name, String pay, String position, String employment) {
        playerName.setText(name);
        playerPay.setText(pay);
        playerPosition.setText(position);
        playerEmploymentStatus.setText(employment);
    }

    public void run() {
        JFrame frame = new JFrame("IBPanel");
        frame.setContentPane(new InfoBox(playerName.getText(), playerPay.getText(), playerPosition.getText(), playerEmploymentStatus.getText()).IBPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);;
    }
}
