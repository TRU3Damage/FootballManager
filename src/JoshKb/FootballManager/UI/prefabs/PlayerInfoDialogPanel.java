package JoshKb.FootballManager.UI.prefabs;

import JoshKb.FootballManager.Individuals.Player;
import JoshKb.FootballManager.Individuals.Referees;
import JoshKb.FootballManager.Individuals.Staff;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import javax.swing.*;

public class PlayerInfoDialogPanel extends JPanel {
    public static final String[] LABEL_TEXTS = { "Last Name", "First Name",
            "Position", "Employment Status", "Pay" };
    public static final int COLS = 8;
    private final Map<String, JTextField> labelFieldMap = new HashMap<>();

    public PlayerInfoDialogPanel() {
        setLayout(new GridBagLayout());
        for (int i = 0; i < LABEL_TEXTS.length; i++) {
            String labelTxt = LABEL_TEXTS[i];
            add(new JLabel(labelTxt), createGbc(0, i));

            JTextField textField = new JTextField(COLS);
            labelFieldMap.put(labelTxt, textField);
            add(textField, createGbc(1, i));
        }

        setBorder(BorderFactory.createTitledBorder("Enter New Player Information"));
    }

    /**
     * Used to make our own grid to keep elements in place
     * @see "https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html"
     * @param x Column
     * @param y Row
     * @return area where element can sit
     */
    public static GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = 1.0;
        gbc.weighty = gbc.weightx;
        if (x == 0) {
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(3, 3, 3, 8);
        } else {
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(3, 3, 3, 3);
        }
        return gbc;
    }

    /**
     * Makes out GUI, can be called in one line from the main program :O
     */
    public static Player createAndShowGui() {
        PlayerInfoDialogPanel mainPanel = new PlayerInfoDialogPanel();

        int optionType = JOptionPane.DEFAULT_OPTION;
        int messageType = JOptionPane.PLAIN_MESSAGE;
        String[] options = { "Submit", "Cancel" };
        Object initialValue = options[0];
        int reply = JOptionPane.showOptionDialog(null, mainPanel, // this is where the window is shown
                "Get User Information", optionType, messageType, null, options,
                initialValue);
        if (reply == 0) {

            return new Player(mainPanel.labelFieldMap.get(LABEL_TEXTS[1]).getText() + mainPanel.labelFieldMap.get(LABEL_TEXTS[0]).getText(),
                    mainPanel.labelFieldMap.get(LABEL_TEXTS[2]).getText(), mainPanel.labelFieldMap.get(LABEL_TEXTS[3]).getText(), mainPanel.labelFieldMap.get(LABEL_TEXTS[4]).getText());
        }
        return null;
    }

    public static Staff createAndShowGuiStaff() {
        PlayerInfoDialogPanel mainPanel = new PlayerInfoDialogPanel();

        int optionType = JOptionPane.DEFAULT_OPTION;
        int messageType = JOptionPane.PLAIN_MESSAGE;
        String[] options = { "Submit", "Cancel" };
        Object initialValue = options[0];
        int reply = JOptionPane.showOptionDialog(null, mainPanel, // this is where the window is shown
                "Get User Information", optionType, messageType, null, options,
                initialValue);
        if (reply == 0) {
            // When submit clicked:

            return new Staff(mainPanel.labelFieldMap.get(LABEL_TEXTS[1]).getText() + mainPanel.labelFieldMap.get(LABEL_TEXTS[0]).getText(),
                    mainPanel.labelFieldMap.get(LABEL_TEXTS[2]).getText(), mainPanel.labelFieldMap.get(LABEL_TEXTS[3]).getText(), mainPanel.labelFieldMap.get(LABEL_TEXTS[4]).getText());
        }
        return null;
    }

    public static Referees createAndShowGuiReferee() {
        PlayerInfoDialogPanel mainPanel = new PlayerInfoDialogPanel();

        int optionType = JOptionPane.DEFAULT_OPTION;
        int messageType = JOptionPane.PLAIN_MESSAGE;
        String[] options = { "Submit", "Cancel" };
        Object initialValue = options[0];
        int reply = JOptionPane.showOptionDialog(null, mainPanel, // this is where the window is shown
                "Get User Information", optionType, messageType, null, options,
                initialValue);
        if (reply == 0) {
            // When submit clicked:

            return new Referees(mainPanel.labelFieldMap.get(LABEL_TEXTS[1]).getText() + mainPanel.labelFieldMap.get(LABEL_TEXTS[0]).getText(),
                    mainPanel.labelFieldMap.get(LABEL_TEXTS[2]).getText(), mainPanel.labelFieldMap.get(LABEL_TEXTS[3]).getText(), mainPanel.labelFieldMap.get(LABEL_TEXTS[4]).getText());
        }
        return null;
    }

}
