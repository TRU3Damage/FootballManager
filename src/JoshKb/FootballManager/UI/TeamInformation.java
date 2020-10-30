package JoshKb.FootballManager.UI;

import JoshKb.FootballManager.Individuals.Team;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class TeamInformation {

    private JComboBox<Team> teamComboBox;
    private JComboBox<?> roleBox; //TODO change ? for appropriate class when implemented
    private JButton searchButton;
    private JComboBox<?> personBox;//TODO change ? for appropriate class when implemented
    private JButton addTeamButton;
    private JButton deleteTeamButton;
    private JButton addPersonButton;
    private JButton deletePersonButton;
    private JButton addRoleButton;
    private JButton deleteRoleButton;
    private JPanel TIPanel;

    public TeamInformation() {
        File f = new File("teams.txt");
        if (f.exists()) {
            ArrayList<Team> t = ReadFromFile(f);
            for (Team team :
                    t) {
                teamComboBox.addItem(team);
            }
        }

        addTeamButton.addActionListener(e -> {
            teamComboBox.addItem(new Team(JOptionPane.showInputDialog("Enter team name")));
            WriteToFile(getTeamBoxItems(teamComboBox));
        });
        deleteTeamButton.addActionListener(e -> {
            teamComboBox.removeItemAt(teamComboBox.getSelectedIndex());
            WriteToFile(getTeamBoxItems(teamComboBox));
        });
        deleteRoleButton.addActionListener(e -> roleBox.removeItemAt(roleBox.getSelectedIndex()));
        deletePersonButton.addActionListener(e -> personBox.removeItemAt(personBox.getSelectedIndex()));
        searchButton.addActionListener(e -> search());
        addRoleButton.addActionListener(e -> {
            //TODO implement
        });
        addPersonButton.addActionListener(e -> {
            //TODO implement
        });
    }

    public static void WriteToFile(ArrayList<Team> T) {
        try {
            FileOutputStream FOutputStream = new FileOutputStream(new File("teams.txt"));
            ObjectOutputStream OOutputStream = new ObjectOutputStream(FOutputStream);
            OOutputStream.writeObject(T);
            OOutputStream.close();
            FOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Team> ReadFromFile(File FileLocation) {
        ArrayList<Team> T1 = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(FileLocation);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            T1 = (ArrayList<Team>) objectInputStream.readObject();
            System.out.println(T1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return T1;
    }

    public void run() {
        JFrame frame = new JFrame("TeamInformation");
        frame.setContentPane(new TeamInformation().TIPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ArrayList<Team> getTeamBoxItems(JComboBox<Team> jComboBox) {
        ArrayList<Team> arrayList = new ArrayList<>();
        for (int i = 0; i < jComboBox.getItemCount(); i++) {
            arrayList.add(jComboBox.getItemAt(i));
        }

        return arrayList;
    }

    public void search() {

    }
}
