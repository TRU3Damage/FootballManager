package JoshKb.FootballManager.Individuals;

public class Staff extends Individual{

    public Staff(String name, String position, String employmentStatus, String pay){
        this.Name = name;
        this.Position = position;
        this.EmploymentStatus = employmentStatus;
        this.Pay = pay;
    }

    public String getName(){
        return Name;
    }


}
