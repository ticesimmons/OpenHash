import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
//import java.util.concurrent.TimeUnit;

/**
 * @author Tice Simmons
 * 
 * allows the thing to read from files and acts as a normal checksum,
 * basically reads the file and creates a code based on 
 * 
 */

public class FileFunctionality{

    //to-do: find a way to automatically obtain or select file and get name
    //private String fileName = "File functionality test file.txt";
    private String outputString = "";
    private Scanner scnr = null;
    private FileInputStream fileByteStream = null;

    /**
     * 
     * @param fileName name of the file to be parsed
     * @throws IOException
     */
    public String fileParse(String fileName) throws IOException {

        fileByteStream = new FileInputStream(fileName);
        scnr = new Scanner(fileByteStream);

        while(scnr.hasNextLine()){

            outputString += scnr.nextLine();
        }
        scnr.close();

        return outputString;
    }

}