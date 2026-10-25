public class Nurse extends Person {
    private int employmentLevel; 
    private String department;   

    public Nurse(String firstName, String lastName, int employmentLevel, String department) {
        super(firstName, lastName); // передаем имя и фамилию в Person
        this.setEmploymentLevel(employmentLevel);
        this.department = department;
    }

    public int getEmploymentLevel() {
        return employmentLevel;
    }

    public void setEmploymentLevel(int employmentLevel) {
        if (employmentLevel < 0 || employmentLevel > 100) {
            throw new IllegalArgumentException("Employment level must be between 0 and 100.");
        }
        this.employmentLevel = employmentLevel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return fullName() + ", Nurse (" + department + ", " + employmentLevel + "%)";
    }
}
