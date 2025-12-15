import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * RegistrationMethods contains the main DMV logic for the Looney Tunes registration system.
 * 1) Reads registration.csv into a CarOwner[].
 * 2) Writes formatted lists to output.txt and flags overdue/almost-due owners.
 *
 * @author Vy Nguyen
 * @version 1.0
 * @since 12/14/2025
 */
public class RegistrationMethods{
    // Constants
    public static final int REG_MONTH = 4;
    public static final int REG_YEAR = 2025;

    // Instance Variables
    private String inputFileName;
    private String outputFileName;

    /**
     * RegistrationMethods() constructs the object and initializes file names.
     */
    public RegistrationMethods(){
        inputFileName = "";
        outputFileName = "";
    }

    /**
     * setFileNames() prompts the user for the input CSV file and output text file paths.
     * It holds the user until a valid CSV path is entered.
     */
    public void setFileNames(){
        Scanner keyboard = new Scanner(System.in);
        File file;

        System.out.print("Enter the path to the registrations.csv file (ie c:/tmp/registration.csv): ");
        inputFileName = keyboard.nextLine();

        file = new File(inputFileName);

        while (!file.exists()){
            System.out.print("Enter the path to the registrations.csv file (ie c:/tmp/registration.csv): ");
            inputFileName = keyboard.nextLine();
            file = new File(inputFileName);
        }

        System.out.print("Enter the path where output.txt should be saved (ie c:/tmp/output.txt): ");
        outputFileName = keyboard.nextLine();
    }

    /**
     * getArraySize() returns the number of data lines in the CSV (not counting the header).
     *
     * @return The number of car owner records.
     * @throws IOException If the input file cannot be opened.
     */
    public int getArraySize() throws IOException{
        int size = 0;
        String line;

        File file = new File(inputFileName);
        Scanner input = new Scanner(file);

        line = input.nextLine();

        while (input.hasNextLine()){
            line = input.nextLine();
            size++;
        }

        input.close();
        return size;
    }

    /**
     * processTextToArray(CarOwner[]) loads CSV data into the given array.
     * It skips the header line, tokenizes each line using split(","), then adds a CarOwner.
     *
     * @param inArray The array to fill with CarOwner objects.
     * @throws IOException If the input file cannot be opened.
     */
    public void processTextToArray(CarOwner[] inArray) throws IOException{
        int index = 0;
        String line;

        File file = new File(inputFileName);
        Scanner input = new Scanner(file);

        line = input.nextLine();

        while (input.hasNextLine()){
            line = input.nextLine();
            String[] tokens = line.split(",");

            String last = tokens[0];
            String first = tokens[1];
            String license = tokens[2];
            int month = Integer.parseInt(tokens[3]);
            int year = Integer.parseInt(tokens[4]);

            inArray[index] = new CarOwner(first, last, license, month, year);
            index++;
        }
        input.close();
    }

    /**
     * printArrayToFile(CarOwner[], String) prints a header message and the array contents to output.txt.
     * This matches the KeyPoints signature order.
     *
     * @param inArray The array to print.
     * @param inMsg The header message to print.
     * @throws IOException If the output file cannot be written.
     */
    public void printArrayToFile(CarOwner[] inArray, String inMsg) throws IOException{
        FileWriter fw = new FileWriter(outputFileName, true);
        PrintWriter output = new PrintWriter(fw);

        output.println(inMsg);

        for (int i = 0; i < inArray.length; i++){
            output.println(inArray[i]);
        }
        output.println();
        output.close();
    }

    /**
     * printArrayToFile(String, CarOwner[]) prints a header message and the array contents to output.txt.
     * This matches the FinalProject.pdf signature order.
     *
     * @param inMsg The header message to print.
     * @param inArray The array to print.
     * @throws IOException If the output file cannot be written.
     */
    public void printArrayToFile(String inMsg, CarOwner[] inArray) throws IOException{
        printArrayToFile(inArray, inMsg);
    }

    /**
     * flagOverdueOwners(CarOwner[]) returns an array of owners whose registration is over 12 months old.
     *
     * @param inArray The full array of owners.
     * @return A new array containing only overdue owners.
     */
    public CarOwner[] flagOverdueOwners(CarOwner[] inArray){
        int monthsTotal = REG_YEAR * 12 + REG_MONTH;
        int counter = 0;

        for (int i = 0; i < inArray.length; i++){
            int regTotal = inArray[i].getYear() * 12 + inArray[i].getMonth();

            if (monthsTotal - regTotal > 12){
                counter++;
            }
        }

        CarOwner[] overdue = new CarOwner[counter];
        int index = 0;

        for (int i = 0; i < inArray.length; i++){
            int regTotal = inArray[i].getYear() * 12 + inArray[i].getMonth();

            if (monthsTotal - regTotal > 12){
                overdue[index] = inArray[i];
                index++;
            }
        }
        return overdue;
    }

    /**
     * flagAlmostDueOwners(CarOwner[]) returns owners whose registrations are 10-12 months old.
     *
     * @param inArray The full array of owners.
     * @return A new array containing only almost-due owners.
     */
    public CarOwner[] flagAlmostDueOwners(CarOwner[] inArray){
        int monthsTotal = REG_YEAR * 12 + REG_MONTH;
        int counter = 0;

        for (int i = 0; i < inArray.length; i++){
            int regTotal = inArray[i].getYear() * 12 + inArray[i].getMonth();
            int age = monthsTotal - regTotal;

            if (age > 9 && age <= 12){
                counter++;
            }
        }

        CarOwner[] almostDue = new CarOwner[counter];
        int index = 0;

        for (int i = 0; i < inArray.length; i++){
            int regTotal = inArray[i].getYear() * 12 + inArray[i].getMonth();
            int age = monthsTotal - regTotal;

            if (age > 9 && age <= 12){
                almostDue[index] = inArray[i];
                index++;
            }
        }
        return almostDue;
    }

    /**
     * getOutputFileName() returns the output file path.
     *
     * @return The output file path.
     */
    public String getOutputFileName(){
        return outputFileName;
    }
}