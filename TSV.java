/*  
 *  Export data as file of tab-seperated values (tsv format) 
 *  You then can edit tsv file in your spreadsheet app (e.g., import in Excel or open in Numbers)
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TSV {
    
    static void export(ArrayList<Doctor> doctors) {
        File tsvOutputFile = new File("doctors.tsv");
        try (FileWriter fileWriter = new FileWriter(tsvOutputFile)) {
            StringBuilder output = new StringBuilder();
            
            // write header
            output.append("First Name\tLast Name\tEmployment\n");
            // write tab-seperated records
            for(Doctor doc: doctors) {
                output.append(doc.getFirstName());
                output.append("\t");
                output.append(doc.getLastName());
                output.append("\t");
                output.append(String.valueOf(doc.getEmployment()) + "%");
                output.append("\n");
            }
            String utf8EncodedString = new String(output.toString().getBytes(), StandardCharsets.UTF_8);
            fileWriter.write(utf8EncodedString);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
