//  Doctor

enum Speciality {
    GP("General Practitioner"),
    CARDIO("Cardiologist"),
    DERMA("Dermatologist"),
    GYNE("Gynecologist"),
    ONCO("Oncologist"),
    PEDIA("Pediatrician"),
    PSYCH("Psychiatrist"),
    RADIO("Radiologist");

    public final String label;

    private Speciality(String label) {
        this.label = label;
    }
}

public class Doctor extends Person {
    
    private int employmentLevel; // in percent
    private Speciality speciality = Speciality.GP;
    private String email;

    private static final int WEEKLYWORKINGHOURS = 42;

    public Doctor(String firstName, String lastName) {
        super(firstName, lastName);
        this.employmentLevel = 100;
    }

    public Doctor(String firstName, String lastName, int employment) {
        super(firstName, lastName);
        this.setEmploymentLevel(employment);
    }

    public String getEmailAddress() {
        return getFirstName().toLowerCase() + "." + getLastName().toLowerCase() + "@hospital.com";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (email == null || !email.matches(regex)) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        this.email = email;
    }

    public void setEmploymentLevel(int employmentLevel) {
        if (employmentLevel < 0 || employmentLevel > 100) {
            throw new IllegalArgumentException("Employment level must be between 0 and 100.");
        }
        this.employmentLevel = employmentLevel;
    }

    public int getEmployment() {
        return employmentLevel;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality spec) {
        this.speciality = spec;
    }

    @Override
    public String toString() {
        return fullName() + ", " + speciality.label;
    }

    public boolean worksFullTime() {
        return employmentLevel >= 100;
    }

    public float workingHoursPerWeek() {
        return (float) employmentLevel / 100.0f * (float) WEEKLYWORKINGHOURS;
    }
}