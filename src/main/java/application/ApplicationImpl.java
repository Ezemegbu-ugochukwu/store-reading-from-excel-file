package application;

import exceptions.ApplicantAlreadyAppliedException;
import model.Applicant;
import model.Store;


public class ApplicationImpl implements Application {

    @Override
    public void apply(Applicant applicant, Store store) throws ApplicantAlreadyAppliedException {
        if (store.getApplicants().contains(applicant)){
            System.out.println("Exception thrown!");
            throw new ApplicantAlreadyAppliedException("You have already applied for this position");
        }
        store.getApplicants().add(applicant);
    }
}
