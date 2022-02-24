package recruitment;

import exceptions.NotQualifiedException;
import exceptions.StaffNotAuthorizedException;
import model.Applicant;
import model.Store;
import model.Staff;

public interface Recruitment {
    void singleHire (Applicant applicant, Staff staff, Store company) throws StaffNotAuthorizedException, NotQualifiedException;
}
