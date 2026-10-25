/*
 *  MiniPIS
 *  A playground for developing a simple Patient Information System (PIS)
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.io.File;

class MiniPIS {

    static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    static ArrayList<Patient> patients = new ArrayList<Patient>();
    static ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    static ArrayList<Nurse> nurses = new ArrayList<Nurse>();
    static ArrayList<Bill> bills = new ArrayList<Bill>();

    private static void createData() {
        var doctor = new Doctor("Peter", "Müller");
        doctors.add(doctor);
        doctor = new Doctor("Susanne", "Keller", 80);
        doctor.setSpeciality(Speciality.PEDIA);
        doctors.add(doctor);

        var patient1 = new Patient("Hans", "Müller", LocalDate.of(1985, 5, 12), "756.1234.5678.90");
        patient1.setWeight(80.0f);
        patient1.setHeight(180.0f);
        patient1.setSex(Sex.MALE);
        patients.add(patient1);

        var patient2 = new Patient("Anna", "Meier", LocalDate.of(1992, 11, 23), "756.9876.5432.10");

        patient2.setWeight(62.0f);
        patient2.setHeight(168.0f);
        patient2.setSex(Sex.FEMALE);
        patients.add(patient2);


        var app1 = new Appointment(doctors.get(0), patients.get(0), LocalDateTime.of(2026, 11, 10, 9, 30), "General Checkup");
        appointments.add(app1);

        var app2 = new Appointment(doctors.get(1), patients.get(1), LocalDateTime.of(2026, 11, 12, 14, 0), "Vaccination");
        appointments.add(app2);

        var nurse1 = new Nurse("Laura", "Schmid", 100, "General Medicine");
        nurses.add(nurse1);
        var nurse2 = new Nurse("Marco", "Rossi", 80, "Pediatrics");
        nurses.add(nurse2);

        
        var bill1 = new Bill(app1, 185.50f);
        bill1.payBill(); 
        bills.add(bill1);

        var bill2 = new Bill(app2, 95.00f); // второй счет остается открытым
        bills.add(bill2);
    }

    

    private static void processData() {
        
        CSV.exportDoctors(doctors);
        CSV.exportPatients(patients);
        JSON.export(doctors, "doctors.json");
        JSON.exportPatients(patients, "patients.json");

       
        doctors.addAll(JSON.importDoctors("otherDoctors.json"));

        patients.addAll(JSON.importPatients("otherPatients.json"));
    }
    

    
    private static void analyseData() {
        float totalWeekHours = 0.0f;
        System.out.println("# doctors: " + doctors.size());
        for(Doctor doc: doctors) {
            System.out.println(doc);
            totalWeekHours = totalWeekHours + doc.workingHoursPerWeek();
        }
        System.out.println();
        System.out.println("Total working hours per week: " + String.format("%.1f", totalWeekHours));

        System.out.println();
        System.out.println("# appointments: " + appointments.size());
        for (Appointment app : appointments) {
            System.out.println(app);

        }

        
        System.out.println();
        float totalWeight = 0.0f;
        float totalHeight = 0.0f;
        System.out.println("# patients: " + patients.size());
        for (Patient pat : patients) {
            System.out.println(pat.fullName() + ", Age: " + pat.getAge());
            totalWeight += pat.getWeight();
            totalHeight += pat.getHeight();
        }
        if (patients.size() > 0) {
            System.out.println("Average weight: " + String.format("%.1f", totalWeight / patients.size()) + " kg");
            System.out.println("Average height: " + String.format("%.1f", totalHeight / patients.size()) + " cm");
        }

        System.out.println();
        System.out.println("# nurses: " + nurses.size());
        for (Nurse n : nurses) {
            System.out.println(n);
        }

        System.out.println();
        float totalBilled = 0.0f;
        float openAmount = 0.0f;
        System.out.println("# bills: " + bills.size());
        for (Bill b : bills) {
            System.out.println(b);
            totalBilled += b.getAmount();
            if (!b.isPaid()) {
                openAmount += b.getAmount();
            }
        }
        System.out.println("Total billed amount: CHF " + String.format("%.2f", totalBilled));
        System.out.println("Open unpaid amount: CHF " + String.format("%.2f", openAmount));
    }

    public static void main(String[] args) {
        System.out.println("Welcome to MiniPIS");
        System.out.println("==================");
        createData();
        processData();
        analyseData();
    }

    
    public static float calculateAverageWeight(Patient[] patients) {
        if (patients.length == 0) {
        return 0.0f;
    }
    float sum = 0.0f;
    for (Patient p : patients) {
        sum += p.getWeight(); 
    }
    return sum / patients.length; 
}


    public static float calculateAverageHeight(Patient[] patients) {
        if (patients.length == 0) {
        return 0.0f;
    }
        float sum = 0.0f;
        for (Patient p : patients) {
        sum += p.getHeight(); 
    }
    return sum / patients.length;
}
}   
