package id3;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import util.FileReader;

/**
 *
 * @author Leo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        CommandLine cmd = parseArguments(args);
        String path = cmd.getOptionValue("file");
        FileReader fm = new FileReader();
        
        if (path == null) {
            System.err.println("ERROR: Missing features table file.");
            System.exit(-1);
        }
        
        try {
            RecordSet set = fm.readCSV(path);
            Tree tree = new Tree(set);
            System.out.println(tree.toString());
        }
        catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static Options getOptions() {
       Options options = new Options();
       
       options.addOption("f", "file", true, "The features table file.");
       options.addOption("h", "help", false, "Display this help and exit.");
       
       return options;
    }
    
    private static CommandLine parseArguments(String[] args) {
        CommandLine cmd = null;
        
        try {
            CommandLineParser parser = new DefaultParser();
            Options options = getOptions();
            cmd = parser.parse(options, args);
            
            if (cmd.hasOption("help")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("id3.jar", options);
                System.exit(0);
            }
        }
        catch (ParseException ex) {
            System.err.println("Encountered exception while parsing arguments: " + ex.getMessage());
            System.exit(-1);
        }
        
        return cmd;
    }
}
