package JoshKb.FootballManager.Individuals;

public class Player extends Individual{

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
}
