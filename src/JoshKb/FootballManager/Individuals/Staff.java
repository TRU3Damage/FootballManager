package JoshKb.FootballManager.Individuals;

import java.io.Serializable;

public class Staff extends Individual implements Serializable {

    private static final long serialVersionUID = 1234567L;

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
