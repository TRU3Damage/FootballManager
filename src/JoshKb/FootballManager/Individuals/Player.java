package JoshKb.FootballManager.Individuals;

import java.io.Serializable;

public class Player extends Individual implements Serializable {

    private static final long serialVersionUID = 1234567L;
    public int GoalsScored;

    public Player(String name, String position, String employmentStatus, String pay){
        this.Name = name;
        this.Position = position;
        this.EmploymentStatus = employmentStatus;
        this.Pay = pay;

        int GoalsScored;

    }

    public String getName(){
        return Name;
    }

    public String getPosition(){
        return Position;
    }
    public String getEmployment(){
        return EmploymentStatus;
    }
    public String getPay(){
        return Pay;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean isPlayer() {
        return true;
    }
}
