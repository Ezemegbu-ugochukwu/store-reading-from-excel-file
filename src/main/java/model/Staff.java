package model;

import model.common.Person;
import enums.Designation;
import enums.Gender;

public class Staff extends Person {
    private Designation designation;

    public Staff(String firstName, String lastName, Gender gender, Designation designation){
        super(firstName, lastName, gender);
        this.designation = designation;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", gender=" + getGender() +
                "designation=" + designation +
                '}';
    }
}
