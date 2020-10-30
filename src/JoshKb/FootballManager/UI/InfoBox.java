package JoshKb.FootballManager.UI;

import javax.swing.*;

public class InfoBox {

    private JTextField textField1;
    private JPanel IBPanel;
    private JFrame frame = new JFrame("InfoBox");
    private JButton addButton;
    private String EnteredText = "Failed";

    public InfoBox() {
        addButton.addActionListener(e -> {
            EnteredText = textField1.getText();
            System.out.println(EnteredText);
        });

    }

    public void run() {

        frame.setContentPane(new InfoBox().IBPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public String getEnteredText() {
        return EnteredText;
    }
}
