import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CSV {

    
    static void exportDoctors(ArrayList<Doctor> doctors) {
        File csvOutputFile = new File("doctors.csv");
        try (FileWriter fileWriter = new FileWriter(csvOutputFile)) {
            StringBuilder output = new StringBuilder();
            
            
            output.append("First Name,Last Name,Employment,Speciality\n");
            
            
            for (Doctor doc : doctors) {
                output.append(doc.getFirstName());
                output.append(",");
                output.append(doc.getLastName());
                output.append(",");
                output.append(String.valueOf(doc.getEmployment()) + "%");
                output.append(",");
                output.append(doc.getSpeciality().label);
                output.append("\n");
            }
            String utf8EncodedString = new String(output.toString().getBytes(), StandardCharsets.UTF_8);
            fileWriter.write(utf8EncodedString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    static void exportPatients(ArrayList<Patient> patients) {
        File csvOutputFile = new File("patients.csv");
        try (FileWriter fileWriter = new FileWriter(csvOutputFile)) {
            StringBuilder output = new StringBuilder();
           
            output.append("First Name,Last Name,Birth Date,Age,Sex,Weight,Height,Insurance Number\n");
            
            
            for (Patient pat : patients) {
                output.append(pat.getFirstName());
                output.append(",");
                output.append(pat.getLastName());
                output.append(",");
                output.append(pat.getBirthDate());
                output.append(",");
                output.append(pat.getAge());
                output.append(",");
                output.append(pat.getSex() != null ? pat.getSex().label : "");
                output.append(",");
                output.append(pat.getWeight());
                output.append(",");
                output.append(pat.getHeight());
                output.append(",");
                output.append(pat.getInsuranceNumber());
                output.append("\n");
            }
            String utf8EncodedString = new String(output.toString().getBytes(), StandardCharsets.UTF_8);
            fileWriter.write(utf8EncodedString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}