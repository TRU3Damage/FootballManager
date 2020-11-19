package JoshKb.FootballManager.Individuals;

import java.io.Serializable;
import java.util.ArrayList;

public class Role implements Serializable {

    private static final long serialVersionUID = 1234567L;

    ArrayList<Individual> Individuals = new ArrayList<>();

    private String Name;

    public Role(String name){
        Name = name;
    }

    public ArrayList<Individual> getIndividuals() {
        return Individuals;
    }

    public void setIndividuals(ArrayList<Individual> individuals) {
        Individuals = individuals;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return Name;
    }
}
