import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class MiniPISTest {

    
    @Test
    public void testDoctorEmploymentAndHours() {
        Doctor doc = new Doctor("Peter", "Müller", 50);
        
        
        assertEquals(21.0f, doc.workingHoursPerWeek(), 0.01f);
        assertFalse(doc.worksFullTime());

        
        assertThrows(IllegalArgumentException.class, () -> {
            doc.setEmploymentLevel(150);
        });
    }

    
    @Test
    public void testDoctorEmailValidation() {
        Doctor doc = new Doctor("Anna", "Keller");
        
        
        doc.setEmail("anna.keller@hospital.com");

        
        assertThrows(IllegalArgumentException.class, () -> {
            doc.setEmail("invalid-email.com");
        });
    }

  
    @Test
    public void testPatientAge() {

        LocalDate birthDate = LocalDate.now().minusYears(30);
        Patient pat = new Patient("Hans", "Meier", birthDate, "756.1234.5678.90");

        assertEquals(30, pat.getAge());
    }
}