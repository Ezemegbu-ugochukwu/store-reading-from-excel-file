package application;

import enums.*;
import exceptions.ApplicantAlreadyAppliedException;
import model.Applicant;
import model.Store;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationImplTest {
    ApplicationImpl application;
    Applicant applicant;
    Store store;

    @Before
    public void setUp() throws Exception {
        application = new ApplicationImpl();
        applicant = new Applicant("simon","peter","106park", Gender.MALE, Qualification.BSC);
        store = new Store("hugoStore");
    }

    @Test
    public void applicantCanApplyToCompanySuccessfully() throws ApplicantAlreadyAppliedException {
        assertEquals(0, store.getApplicants().size());
        application.apply(applicant,store);
        assertEquals(1, store.getApplicants().size());
    }

    @Test
    public void shouldThrowAnExceptionIfApplicantHasAppliedBefore() throws ApplicantAlreadyAppliedException {
       application.apply(applicant, store);
        assertThrows(ApplicantAlreadyAppliedException.class, ()-> { application.apply(applicant, store);});
    }
}