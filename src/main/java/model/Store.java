package model;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final String name;
    private final List<Staff> ListOfStaffs = new ArrayList<>();
    private final List<Applicant> applicants = new ArrayList<>();
    private final Stocks stocks = new Stocks();

    public Store (String name){
        this.name = name;
    }

    public List<Staff> getListOfStaffs() {
        return ListOfStaffs;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public Stocks getStocks (){ return stocks;}

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", ListOfStaffs=" + ListOfStaffs +
                ", applicants=" + applicants +
                '}';
    }
}
