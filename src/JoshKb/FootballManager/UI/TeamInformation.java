package JoshKb.FootballManager.UI;

import JoshKb.FootballManager.Individuals.Player;
import JoshKb.FootballManager.Individuals.Role;
import JoshKb.FootballManager.Individuals.Team;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class TeamInformation {

    private JComboBox<Team> teamComboBox;
    private JComboBox<Role> roleBox;
    private JButton searchButton;
    private JComboBox<?> personBox;//TODO change ? for appropriate class when implemented
    private JButton addTeamButton;
    private JButton deleteTeamButton;
    private JButton addPersonButton;
    private JButton deletePersonButton;
    private ArrayList<Team> Teams;
    private ArrayList<Player> Players;
    private JPanel TIPanel;

    public TeamInformation() {
        File f = new File("teams.txt");
        if (f.exists()) {
            Teams = ReadFromFile(f);
            for (Team team :
                    Teams) {
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
        addPersonButton.addActionListener(e -> {
            addPerson();
        });
        deletePersonButton.addActionListener(e -> personBox.removeItemAt(personBox.getSelectedIndex()));
        searchButton.addActionListener(e -> search());

        Role player = new Role("Player");
        Role staff = new Role("Staff");
        Role referee = new Role("Referee");
        roleBox.addItem(player);
        roleBox.addItem(staff);
        roleBox.addItem(referee);

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

    public void addPerson(){
        switch (roleBox.getItemAt(roleBox.getSelectedIndex()).getName()) {
            case "Player":
                addPlayer();
                break;
            case "Staff":
                System.out.println("1");
                break;
            default:
                System.out.println("3");
                break;
        }
    }

    public void addPlayer(){
        PlayerInfoWindow PIWindow = new PlayerInfoWindow();
        PIWindow.run();

//        while (PIWindow.DoneButtonPressed == false){
//            continue;
//        }
    }

    public void search() {

    }
}
