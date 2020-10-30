package JoshKb.FootballManager.Individuals;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {

    ArrayList<Player> Players = new ArrayList<>();
    ArrayList<Staff> Staff = new ArrayList<>();

    private String Name;

    public Team(String name){
        Name = name;
    }

    public ArrayList<Player> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<Player> players) {
        Players = players;
    }

    public ArrayList<JoshKb.FootballManager.Individuals.Staff> getStaff() {
        return Staff;
    }

    public void setStaff(ArrayList<JoshKb.FootballManager.Individuals.Staff> staff) {
        Staff = staff;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return Name;
    }
}
