package recruitment;

import enums.Designation;
import enums.Qualification;
import exceptions.NotQualifiedException;
import exceptions.StaffNotAuthorizedException;
import model.Applicant;
import model.Store;
import model.Staff;


public class RecruitmentImpl implements Recruitment{

    @Override
    public void singleHire (Applicant applicant, Staff staff, Store store) throws StaffNotAuthorizedException, NotQualifiedException {
       if (staff.getDesignation().equals(Designation.MANAGER)){
           if (applicant.getQualification().equals(Qualification.OND) || applicant.getQualification().equals(Qualification.HND) || applicant.getQualification().equals(Qualification.BSC)){
               employApplicant(store, applicant);
           } else throw new NotQualifiedException("You are not qualified for the position!");
       }
       else {
           throw new StaffNotAuthorizedException("You must be a Manager to perform this operation");
       }
    }
    private void employApplicant(Store store, Applicant applicant){
        Staff newStaff = new Staff(
                            applicant.getFirstName(),
                            applicant.getLastName(),
                            applicant.getGender(),
                            Designation.CASHIER
                        );

        store.getListOfStaffs().add(newStaff);
        store.getApplicants().remove(applicant);
    }
}
