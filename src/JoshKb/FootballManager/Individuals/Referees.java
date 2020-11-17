package JoshKb.FootballManager.Individuals;

public class Referees extends Individual{

    public Referees(String name, String position, String employmentStatus, String pay){
        this.Name = name;
        this.Position = position;
        this.EmploymentStatus = employmentStatus;
        this.Pay = pay;
    }

    public String getName(){
        return Name;
    }


}
