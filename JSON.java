// JSON Import & Export
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSON {
    
    
    static void export(ArrayList<Doctor> doctors, String toFileName) {
        File jsonOutputFile = new File(toFileName);
        try (FileWriter fileWriter = new FileWriter(jsonOutputFile)) {
            JSONArray array = new JSONArray();
            for (Doctor doc : doctors) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("prename", doc.getFirstName());
                jsonObject.put("surname", doc.getLastName());
                jsonObject.put("speciality", doc.getSpeciality().label);
                jsonObject.put("employment", doc.getEmployment());
                array.put(jsonObject);
            }
            fileWriter.write(array.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    static ArrayList<Doctor> importDoctors(String fromFileName) {
        ArrayList<Doctor> result = new ArrayList<Doctor>();
        Path filePath = Path.of(fromFileName);
        try {
            String content = Files.readString(filePath);
            JSONArray array = new JSONArray(content);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                
                String fName = obj.has("prename") ? obj.getString("prename") : obj.getString("firstName");
                String lName = obj.has("surname") ? obj.getString("surname") : obj.getString("lastName");
                
                Doctor doctor = new Doctor(fName, lName);
                String spec = obj.getString("speciality");
                for (Speciality s : Speciality.values()) {
                    if (spec.equals(s.label) || spec.equals(s.name())) {
                        doctor.setSpeciality(s);
                    }
                }
                if (obj.has("employment")) {
                    doctor.setEmploymentLevel(obj.getInt("employment"));
                }

                result.add(doctor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    
    static void exportPatients(ArrayList<Patient> patients, String toFileName) {
        File jsonOutputFile = new File(toFileName);
        try (FileWriter fileWriter = new FileWriter(jsonOutputFile)) {
            JSONArray array = new JSONArray();
            for (Patient pat : patients) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("firstName", pat.getFirstName());
                jsonObject.put("lastName", pat.getLastName());
                jsonObject.put("birthDate", pat.getBirthDate().toString());
                jsonObject.put("weight", pat.getWeight());
                // Выгружаем рост в метрах (например, 1.80), как у одногруппников:
                jsonObject.put("height", pat.getHeight() / 100.0f);
                if (pat.getSex() != null) {
                    jsonObject.put("sex", pat.getSex().name()); // "MALE" / "FEMALE"
                }
                array.put(jsonObject);
            }
            fileWriter.write(array.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Patient> importPatients(String fromFileName) {
        ArrayList<Patient> result = new ArrayList<Patient>();
        Path filePath = Path.of(fromFileName);
        try {
            String content = Files.readString(filePath);
            JSONArray array = new JSONArray(content);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                
                LocalDate birthDate = LocalDate.parse(obj.getString("birthDate"));
                String insNumber = obj.has("insuranceNumber") ? obj.getString("insuranceNumber") : "Unknown";
                
                Patient patient = new Patient(
                    obj.getString("firstName"),
                    obj.getString("lastName"),
                    birthDate,
                    insNumber
                );
                
                if (obj.has("weight")) {
                    patient.setWeight(obj.getFloat("weight"));
                }
                if (obj.has("height")) {
                    float h = obj.getFloat("height");
                    // Если рост записан в метрах (например 1.8), переводим в сантиметры (180.0):
                    if (h < 3.0f) {
                        h = h * 100.0f;
                    }
                    patient.setHeight(h);
                }
                if (obj.has("sex")) {
                    String sexStr = obj.getString("sex");
                    for (Sex s : Sex.values()) {
                        if (sexStr.equalsIgnoreCase(s.name()) || sexStr.equalsIgnoreCase(s.label)) {
                            patient.setSex(s);
                        }
                    }
                }
                result.add(patient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}