/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import decisiontree.Case;
import decisiontree.Attribute;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that handles the file operations.
 * @author Leo
 */
public class FileManager {
    
    
    public FileManager(){  
    }
    
    /**
     * Reads a csv file.
     * @param path The path where the file is located.
     * @return A list containing the cases.
     * @throws Exception If file is not found.
     */
    public ArrayList<Case> readCSVFile(String path) throws Exception
    {
        ArrayList<Case> cases = new ArrayList<>();
        File file = new File(path);
        String[] header = null;
        int case_number = 0;
        try
        {
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNext()){
                String line = inputStream.nextLine();
                if(case_number == 0)
                {
                    header = line.split(",");
                }
                else
                {
                    Case new_case = getCase(line, case_number, header);
                    cases.add(new_case);
                }
                case_number++;
            }   
        }
        catch(FileNotFoundException e)
        {
              throw new Exception("File not found");
        }
        return cases;
    }
    
    /**
     * Creates a Case object containing the line data.
     * @param line The file line.
     * @param number The case number.
     * @param header The header of the file.
     * @return A Case object.
     * @throws Exception If there are more tokens than expected.
     */
    private Case getCase(String line, int number, String[] header) throws Exception
    {
        Case file_case = new Case(number);
        try
        {
            String[] tokens = line.split(",");
            for(int i = 0; i < tokens.length; i++)
            {
                if(!tokens[i].isEmpty())
                {
                    Attribute att = new Attribute(header[i], tokens[i]);
                    file_case.addAttribute(att);
                }
            }
        }
        catch(IndexOutOfBoundsException e)
        {
            throw new Exception("Too many tokens in line: " +(number+1));
        }
        return file_case;
    }
    
}
