package recruitment;

import enums.Designation;
import enums.Gender;
import enums.Qualification;
import exceptions.NotQualifiedException;
import exceptions.StaffNotAuthorizedException;
import model.Applicant;
import model.Staff;
import model.Store;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecruitmentImplTest {
    Store ugoStore;
    Applicant chibueze;
    Staff cashier;

    @Before
    public void setUp() {
        ugoStore = new Store("Ugo and Sons");
        chibueze = new Applicant("Chibueze", "Nwanjobi", "Owerri", Gender.MALE, Qualification.OND);
        cashier = new Staff("Moses", "Chinelo", Gender.FEMALE, Designation.CASHIER);
    }

    @Test
    public void onlyManagerIsAuthorizedToHireTest() {
        Exception exception = assertThrows(StaffNotAuthorizedException.class, () -> {
            new RecruitmentImpl().singleHire(chibueze, cashier, ugoStore);
        });
        assertEquals("You must be a Manager to perform this operation", exception.getMessage());
    }

    @Test
    public void shouldThrowAnExceptionIfApplicantDontHaveTheRightQualifications() {
        Applicant tunde = new Applicant("tunde", "lawal", "107park", Gender.MALE, Qualification.MSC);
        Staff manager = new Staff("manager", "manager", Gender.MALE, Designation.MANAGER);
        assertThrows(NotQualifiedException.class, () -> {
            new RecruitmentImpl().singleHire(tunde, manager, ugoStore);
        });

    }

    @Test
    public void testForSuccessfulRecruitment() throws NotQualifiedException, StaffNotAuthorizedException {
        Applicant segun = new Applicant("Segun", "lawal", "107park", Gender.MALE, Qualification.BSC);
        Staff manager = new Staff("manager", "manager", Gender.MALE, Designation.MANAGER);
        assertTrue(ugoStore.getListOfStaffs().isEmpty());
        new RecruitmentImpl().singleHire(segun, manager, ugoStore);
        assertFalse(ugoStore.getListOfStaffs().isEmpty());
        assertEquals("Segun", ugoStore.getListOfStaffs().get(0).getFirstName());
        assertEquals("lawal", ugoStore.getListOfStaffs().get(0).getLastName());
    }

}