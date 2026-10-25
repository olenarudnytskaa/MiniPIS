import java.time.LocalDate;
import java.time.Period;

enum Sex {
    FEMALE("Female"),
    MALE("Male"),
    OTHER("Other");

    public final String label;

    private Sex(String label) {
        this.label = label;
    }
}

public class Patient extends Person{      
    private String firstName; 
    private String lastName;
    private LocalDate birthDate;
    private String insuranceNumber;
    private float height;
    private float weight;
    private Sex sex;
    


    public Patient(String firstName, String lastName, LocalDate birthDate, String insuranceNumber) {
        super(firstName, lastName);
        this.birthDate = birthDate;
        this.insuranceNumber = insuranceNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    
}