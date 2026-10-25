import java.time.LocalDateTime;

public class Appointment {
    private Doctor doctor;        
    private Patient patient;      
    private LocalDateTime dateTime; 
    private String reason;         

   
    public Appointment(Doctor doctor, Patient patient, LocalDateTime dateTime, String reason) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
        this.reason = reason;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    
    @Override
    public String toString() {
        return dateTime + ": " + patient.fullName() + " with Dr. " + doctor.fullName() + " (" + reason + ")";
    }
}
