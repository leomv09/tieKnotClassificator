package utilities;

import decisiontree.Record;
import decisiontree.RecordSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class that handles the file operations.
 * 
 * @author Leo
 */
public class FileReader {

    /**
     * Reads a CSV file.
     * 
     * @param path The path where the file is located.
     * @return A list containing the records.
     * @throws FileNotFoundException If file is not found.
     */
    public RecordSet readCSV(String path) throws Exception {
        RecordSet records = new RecordSet();
        File file = new File(path);
        String[] header = null;
        Record record;
        int count = 0;
        
        Scanner inputStream = new Scanner(file);
        
        while (inputStream.hasNext()) {
            String line = inputStream.nextLine();
            if (count == 0) {
                header = line.split(",");
            }
            else {
                record = parseRecord(line, count, header);
                records.add(record);
            }
            count++;
        }

        return records;
    }
    
    /**
     * Creates a Record object containing the line data.
     * 
     * @param line The file line.
     * @param number The case number.
     * @param header The header of the file.
     * @return A Record object.
     * @throws IOException If there are more tokens than expected.
     */
    private Record parseRecord(String line, int number, String[] header) throws IOException {
        Record record = new Record();
        
        try {
            String[] tokens = line.split(",");
            for (int i = 0; i < tokens.length; i++) {
                if (!tokens[i].isEmpty()) {
                    record.addAttribute(header[i].trim(), tokens[i].trim());
                }
            }
        }
        catch (IndexOutOfBoundsException e) {
            throw new IOException("Too many tokens in line: " + (number+1));
        }
        
        return record;
    }
    
}