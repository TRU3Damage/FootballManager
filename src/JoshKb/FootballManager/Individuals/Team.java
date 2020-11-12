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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> Players) {
        players = Players;
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
