package JoshKb.FootballManager.UI;

import JoshKb.FootballManager.Individuals.*;
import JoshKb.FootballManager.UI.prefabs.PlayerInfoDialogPanel;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class TeamInformation {

    private JComboBox<Team> teamComboBox;
    private JComboBox<Role> roleBox;
    private JButton searchButton;
    private JComboBox<String> personBox;//TODO change ? for appropriate class when implemented
    private JButton addTeamButton;
    private JButton deleteTeamButton;
    private JButton addPersonButton;
    private JButton deletePersonButton;
    private ArrayList<Team> Teams;
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
            Teams = ReadFromFile(f);
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
        teamComboBox.addActionListener(e -> {
            personBox.removeAllItems();
            if (Teams != null && (roleBox.getItemAt(roleBox.getSelectedIndex()).getName().equals("Player"))){
                System.out.println(Teams.get(teamComboBox.getSelectedIndex()).players.size());
                for (int i = 0; i < Teams.get(teamComboBox.getSelectedIndex()).players.size(); i++)
                {
                    personBox.addItem(Teams.get(teamComboBox.getSelectedIndex()).getPlayer(i));
                }
            }
            else if(Teams != null && (roleBox.getItemAt(roleBox.getSelectedIndex()).getName().equals("Staff"))){
                System.out.println(Teams.get(teamComboBox.getSelectedIndex()).staff.size());
                for (int i = 0; i < Teams.get(teamComboBox.getSelectedIndex()).staff.size(); i++)
                {
                    personBox.addItem(Teams.get(teamComboBox.getSelectedIndex()).getStaff(i));
                }
            }
            else{
                System.out.println(Teams.get(teamComboBox.getSelectedIndex()).referees.size());
                for (int i = 0; i < Teams.get(teamComboBox.getSelectedIndex()).referees.size(); i++)
                {
                    personBox.addItem(Teams.get(teamComboBox.getSelectedIndex()).getReferees(i));
                }
            }
        });
        roleBox.addActionListener(e -> {
            personBox.removeAllItems();
            if (Teams != null && (roleBox.getItemAt(roleBox.getSelectedIndex()).getName().equals("Player"))){
                for (int i = 0; i < Teams.get(teamComboBox.getSelectedIndex()).players.size(); i++)
                {
                    personBox.addItem(Teams.get(teamComboBox.getSelectedIndex()).getPlayer(i));
                }
            }
            else if(Teams != null && (roleBox.getItemAt(roleBox.getSelectedIndex()).getName().equals("Staff"))){
                System.out.println(Teams.get(teamComboBox.getSelectedIndex()).staff.size());
                for (int i = 0; i < Teams.get(teamComboBox.getSelectedIndex()).staff.size(); i++)
                {
                    personBox.addItem(Teams.get(teamComboBox.getSelectedIndex()).getStaff(i));
                }
            }
            else{
                System.out.println(Teams.get(teamComboBox.getSelectedIndex()).referees.size());
                for (int i = 0; i < Teams.get(teamComboBox.getSelectedIndex()).referees.size(); i++)
                {
                    personBox.addItem(Teams.get(teamComboBox.getSelectedIndex()).getReferees(i));
                }
            }
        });

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
                addStaff();
                break;
            default:
                addReferee();
                break;
        }
    }

    public void addPlayer(){
        Player p = PlayerInfoDialogPanel.createAndShowGui();
        Team t = teamComboBox.getItemAt(teamComboBox.getSelectedIndex());
        t.setPlayers(p);
        personBox.addItem(p.Name);
    }

    public void addStaff(){
        Staff s = PlayerInfoDialogPanel.createAndShowGuiStaff();
        Team t = teamComboBox.getItemAt(teamComboBox.getSelectedIndex());
        t.setStaff(s);
        personBox.addItem(s.Name);
    }

    public void addReferee(){
        Referees r = PlayerInfoDialogPanel.createAndShowGuiReferee();
        Team t = teamComboBox.getItemAt(teamComboBox.getSelectedIndex());
        t.setReferees(r);
        personBox.addItem(r.Name);
    }

    public void search() {

    }
}
