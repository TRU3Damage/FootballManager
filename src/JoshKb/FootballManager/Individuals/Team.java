package JoshKb.FootballManager.Individuals;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {

    public ArrayList<Role> Roles = new ArrayList<>();

    private String Name;

    public Team(String name){
        Name = name;
    }

    public ArrayList<Role> getRoles() {
        return Roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        Roles = roles;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return Name;
    }

    public void addRole(Role role){

    }
}
