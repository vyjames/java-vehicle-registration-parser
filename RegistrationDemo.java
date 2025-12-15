import java.io.IOException;

/**
 * RegistrationDemo is the driver class for the DMV registration project.
 * 1) Prompts for file paths, loads the CSV into an array, and prints results to output.txt.
 * 2) Prints the output file location to the screen.
 *
 * @author Vy Nguyen
 * @version 1.0
 * @since 12/14/2025
 */
public class RegistrationDemo{
    /**
     * main(String[] args) runs the registration tracking program.
     *
     * @param args Command line arguments not used.
     * @throws IOException If file input/output fails.
     */
    public static void main(String[] args) throws IOException{
        RegistrationMethods dmv = new RegistrationMethods();

        dmv.setFileNames();

        int size = dmv.getArraySize();

        CarOwner[] ltState = new CarOwner[size];

        dmv.processTextToArray(ltState);

        dmv.printArrayToFile(ltState, "List of Car Owners");

        CarOwner[] overdue = dmv.flagOverdueOwners(ltState);
        dmv.printArrayToFile(overdue, "Owners with Expired Registration");

        CarOwner[] almostDue = dmv.flagAlmostDueOwners(ltState);
        dmv.printArrayToFile(almostDue, "Owners with registration expiring in three months or less");

        System.out.println("The output file can be found at: " + dmv.getOutputFileName());
    }
}