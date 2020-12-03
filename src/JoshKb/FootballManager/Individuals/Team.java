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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Player Players) {
        players.add(Players);
    }

    public String getStaff(int i) {
        return staff.get(i).getName();
    }

    public void setStaff(Staff Staff) {
        staff.add(Staff);
    }

    public String getReferees(int i) {
        return referees.get(i).getName();
    }

    public void setReferees(Referees Referees) {
        referees.add(Referees);
    }

    public String getName() {
        return Name;
    }

    public ArrayList<Referees> getReferees() {
        return referees;
    }

    public ArrayList<Staff> getStaff() {
        return staff;
    }

    public void deletePlayer(int p){
        players.remove(p);
    }
    public void deleteStaff(int s){ staff.remove(s); }
    public void deleteReferee(int r){
        referees.remove(r);
    }

    @Override
    public String toString() {
        return Name;
    }

    public ArrayList<Player> getPlayerList(){
        return players;
    }

}
