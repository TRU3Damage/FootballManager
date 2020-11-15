package JoshKb.FootballManager.Individuals;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {

    public ArrayList<Player> players = new ArrayList<>();
    public ArrayList<Referees> referees= new ArrayList<>();
    public ArrayList<Staff> staff = new ArrayList<>();

    private static final long serialVersionUID = 1234567L;

    private String Name;

    public Team(String name){
        Name = name;
    }

    public String getPlayer(int i) {
        return players.get(i).getName();
    }

    public void setPlayers(Player Players) {
        players.add(Players);
    }

    public ArrayList<Referees> getReferees() {
        return referees;
    }

    public void setReferees(ArrayList<Referees> Referees) {
        referees = Referees;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Staff> Staff) {
        staff = Staff;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return Name;
    }

}
