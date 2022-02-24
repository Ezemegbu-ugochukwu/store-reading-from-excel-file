package model;

import model.common.Person;
import enums.*;

public class Applicant extends Person {
       private final Qualification qualification;

       public Applicant(String firstName, String lastName, String address, Gender gender, Qualification qualification){
           super(firstName, lastName, gender);
           this.qualification = qualification;

       }

    public Qualification getQualification() {
        return qualification;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", gender=" + getGender() +
                "qualification=" + qualification +
                '}';
    }
}
