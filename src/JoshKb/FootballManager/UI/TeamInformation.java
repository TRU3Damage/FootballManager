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
        //creates a new file
        //or if file already exists reads the info from the file and adds it to the comboboxes
        File f = new File("teams.txt");
        if (f.exists()) {
            Teams = ReadFromFile(f);
            for (Team team :
                    Teams) {
                teamComboBox.addItem(team);
            }
        }
        //action listeners for button presses and option changes
        addTeamButton.addActionListener(e -> {
            teamComboBox.addItem(new Team(JOptionPane.showInputDialog("Enter team name")));
            WriteToFile(getTeamBoxItems(teamComboBox));
            Teams = ReadFromFile(f);
            enableButtons();
        });
        deleteTeamButton.addActionListener(e -> {
            if(teamComboBox.getItemCount() == 0 || teamComboBox.getSelectedItem() == null){
                return;
            }
            Team t = (Team) teamComboBox.getSelectedItem();
            Teams.remove(t);
            teamComboBox.removeItemAt(teamComboBox.getSelectedIndex());
            teamComboBox.setSelectedItem(null);
            WriteToFile(getTeamBoxItems(teamComboBox));
            enableButtons();
        });
        addPersonButton.addActionListener(e -> {
            addPerson();
        });
        deletePersonButton.addActionListener(e ->{
            Team t = (Team) teamComboBox.getSelectedItem();
            if (roleBox.getItemAt(roleBox.getSelectedIndex()).getName().equals("Player")) {
                if (t.players != null && personBox.getItemCount() > 0){
                    t.deletePlayer(personBox.getSelectedIndex());
                    personBox.removeItemAt(personBox.getSelectedIndex());
                    personBox.setSelectedItem(null);
                }
            }
            else if (roleBox.getItemAt(roleBox.getSelectedIndex()).getName().equals("Staff")) {
                if (t.staff != null && personBox.getItemCount() > 0){
                    t.deleteStaff(personBox.getSelectedIndex());
                    personBox.removeItemAt(personBox.getSelectedIndex());
                    personBox.setSelectedItem(null);
                }
            }
            else if((roleBox.getItemAt(roleBox.getSelectedIndex()).getName().equals("Referees"))){
                if (t.referees != null && personBox.getItemCount() > 0){
                    t.deleteReferee(personBox.getSelectedIndex());
                    personBox.removeItemAt(personBox.getSelectedIndex());
                    personBox.setSelectedItem(null);
                }
            }


        });
        searchButton.addActionListener(e -> search());
        teamComboBox.addActionListener(e -> {


            personBox.removeAllItems();
            if(Teams == null || Teams.size() == 0 || teamComboBox.getItemCount() == 0){
                return;
            }
            if (!(teamComboBox.getSelectedItem() == null)) {
                Team t = (Team) teamComboBox.getSelectedItem();
                switch (roleBox.getItemAt(roleBox.getSelectedIndex()).getName()) {
                    case "Player":
                        for (Player p:t.getPlayers()) {
                            personBox.addItem(p.getName());
                        }
                        break;
                    case "Staff":
                        for (Staff s:t.getStaff()) {
                            personBox.addItem(s.getName());
                        }
                        break;
                    case "Referee":
                        for (Referees r:t.getReferees()) {
                            personBox.addItem(r.getName());
                        }
                        break;
                }
            }

//           if (Teams != null && teamComboBox.getItemCount() > 0 && Teams.size() > 0 && Teams.get(teamComboBox.getSelectedIndex()).players.size() > 0){
//                if (Teams != null && (roleBox.getItemAt(roleBox.getSelectedIndex()).getName().equals("Player"))){

//                }
//                else if(Teams != null && (roleBox.getItemAt(roleBox.getSelectedIndex()).getName().equals("Staff"))){
//                    for (int i = 0; i < Teams.get(teamComboBox.getSelectedIndex()).staff.size(); i++)
//                    {
//                        personBox.addItem(Teams.get(teamComboBox.getSelectedIndex()).getStaff(i));
//                    }
//                }
//                else{
//                    if(Teams != null) {
//                        for (int i = 0; i < Teams.get(teamComboBox.getSelectedIndex()).referees.size(); i++) {
//                            personBox.addItem(Teams.get(teamComboBox.getSelectedIndex()).getReferees(i));
//                        }
//                    }
//                }
//            }

        });
        roleBox.addActionListener(e -> {

            //Changing the contents of the person box depending on which team and role is selected

            personBox.removeAllItems();
            if(Teams == null || Teams.size() == 0 || teamComboBox.getItemCount() == 0){
                return;
            }
            if (!(teamComboBox.getSelectedItem() == null)) {
                Team t = (Team) teamComboBox.getSelectedItem();
                switch (roleBox.getItemAt(roleBox.getSelectedIndex()).getName()) {
                    case "Player":
                        for (Player p:t.getPlayers()) {
                            personBox.addItem(p.getName());
                        }
                        break;
                    case "Staff":
                        for (Staff s:t.getStaff()) {
                            personBox.addItem(s.getName());
                        }
                        break;
                    case "Referee":
                        for (Referees r:t.getReferees()) {
                            personBox.addItem(r.getName());
                        }
                        break;
                }
            }

//            personBox.removeAllItems();
//            if (Teams != null && (roleBox.getItemAt(roleBox.getSelectedIndex()).getName().equals("Player"))){
//                for (int i = 0; i < Teams.get(teamComboBox.getSelectedIndex()).players.size(); i++)
//                {
//                    personBox.addItem(Teams.get(teamComboBox.getSelectedIndex()).getPlayer(i));
//                }
//            }
//            else if(Teams != null && (roleBox.getItemAt(roleBox.getSelectedIndex()).getName().equals("Staff"))){
//                for (int i = 0; i < Teams.get(teamComboBox.getSelectedIndex()).staff.size(); i++)
//                {
//                    personBox.addItem(Teams.get(teamComboBox.getSelectedIndex()).getStaff(i));
//                }
//            }
//            else{
//                if(Teams != null) {
//                    for (int i = 0; i < Teams.get(teamComboBox.getSelectedIndex()).referees.size(); i++) {
//                        personBox.addItem(Teams.get(teamComboBox.getSelectedIndex()).getReferees(i));
//                    }
//                }
//            }
        });

        //making of the 3 roles as other roles don't need to be added
        Role player = new Role("Player");
        Role staff = new Role("Staff");
        Role referee = new Role("Referee");
        roleBox.addItem(player);
        roleBox.addItem(staff);
        roleBox.addItem(referee);
        enableButtons();


    }

    public void enableButtons(){
        boolean enable = false;
        if(Teams != null && teamComboBox.getItemCount() > 0){
            System.out.println(Teams.size());
            for (Team t:
                 Teams) {
                System.out.println(t);
            }
            enable = true;
        }
        personBox.setEnabled(enable);
        roleBox.setEnabled(enable);
        addPersonButton.setEnabled(enable);
        deletePersonButton.setEnabled(enable);
        searchButton.setEnabled(enable);
    }

    //write to file method
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

    // creation of the Jframe
    public void run() {
        JFrame frame = new JFrame("TeamInformation");
        frame.setContentPane(new TeamInformation().TIPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //returns an arraylist of items in the Teambox
    public ArrayList<Team> getTeamBoxItems(JComboBox<Team> jComboBox) {
        ArrayList<Team> arrayList = new ArrayList<>();
        for (int i = 0; i < jComboBox.getItemCount(); i++) {
            arrayList.add(jComboBox.getItemAt(i));
        }
        return arrayList;
    }

    //switch cases to add people to each role selected
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
        //runs the infodialogpanel and saves the player name to the person box
        Player p = PlayerInfoDialogPanel.createAndShowGui();
        Team t = teamComboBox.getItemAt(teamComboBox.getSelectedIndex());
        t.setPlayers(p);
        personBox.addItem(p.Name);
    }

    public void addStaff(){
        //runs the infodialogpanel and saves the staff name to the person box
        Staff s = PlayerInfoDialogPanel.createAndShowGuiStaff();
        Team t = teamComboBox.getItemAt(teamComboBox.getSelectedIndex());
        t.setStaff(s);
        personBox.addItem(s.Name);
    }

    public void addReferee(){
        //runs the infodialogpanel and saves the ref name to the person box
        Referees r = PlayerInfoDialogPanel.createAndShowGuiReferee();
        Team t = teamComboBox.getItemAt(teamComboBox.getSelectedIndex());
        t.setReferees(r);
        personBox.addItem(r.Name);
    }

    public void search() {
        if(teamComboBox.getItemCount() > 0) {
            Team t = (Team) teamComboBox.getSelectedItem(); // needs to not be null
            if(t != null) {
                if (roleBox.getItemAt(roleBox.getSelectedIndex()).getName().equals("Player")) {
                    ArrayList<Player> players = t.getPlayers();
                    //getting the player information based on which player is currently selected in the personBox
                    String pName = personBox.getItemAt(personBox.getSelectedIndex());
                    System.out.println(players);
                    String pPosition, pEmploymentStatus, pPay;
                    for (Player player :
                            players) {
                        System.out.println("test");
                        if (player.Name.equals(pName)) {
                            pPosition = player.Position;
                            pPay = player.Pay;
                            pEmploymentStatus = player.EmploymentStatus;
                            System.out.println("fds");
                            InfoBox IBWindow = new InfoBox(pName, pPay, pPosition, pEmploymentStatus);
                            IBWindow.run();
                        }
                    }
                }

            }
        }
    }
}
