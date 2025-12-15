/**
 * CarOwner extends Citizen and adds vehicle registration information.
 * 1) Stores license, month, and year.
 * 2) Overrides toString() to line up output using tabs.
 *
 * @author Vy Nguyen
 * @version 1.0
 * @since 12/14/2025
 */
public class CarOwner extends Citizen{
    // Instance Variables
    private String license;
    private int month;
    private int year;

    /**
     * CarOwner() is the no-argument constructor.
     * It sets first and last name to "No Name", license to "Not Assigned",
     * and month/year to 0.
     */
    public CarOwner(){
        super();
        license = "Not Assigned";
        month = 0;
        year = 0;
    }

    /**
     * CarOwner(String, String, String, int, int) constructs a CarOwner with full data.
     *
     * @param inFirst The first name.
     * @param inLast The last name.
     * @param inLicense The license plate.
     * @param inMonth The registration month.
     * @param inYear The registration year.
     */
    public CarOwner(String inFirst, String inLast, String inLicense, int inMonth, int inYear){
        super(inFirst, inLast);
        license = inLicense;
        month = inMonth;
        year = inYear;
    }

    /**
     * setLicense(String) updates the license plate.
     *
     * @param inLicense The new license plate.
     */
    public void setLicense(String inLicense){
        license = inLicense;
    }

    /**
     * getLicense() returns the license plate.
     *
     * @return The license plate.
     */
    public String getLicense(){
        return license;
    }

    /**
     * setmonth(int) updates the registration month.
     * Note: method name matches UML (lowercase 'm').
     *
     * @param inMonth The new registration month.
     */
    public void setmonth(int inMonth){
        month = inMonth;
    }

    /**
     * getMonth() returns the registration month.
     *
     * @return The registration month.
     */
    public int getMonth(){
        return month;
    }

    /**
     * setYear(int) updates the registration year.
     *
     * @param inYear The new registration year.
     */
    public void setYear(int inYear){
        year = inYear;
    }

    /**
     * getYear() returns the registration year.
     *
     * @return The registration year.
     */
    public int getYear(){
        return year;
    }

    /**
     * toString() returns a String with: first last, then license, then month/year.
     * Tabs are used so output lines up like the provided output.txt.
     *
     * @return The formatted car owner record.
     */
    public String toString(){
        return super.toString() + "\t\t" + license + "\t\t" + month + "/" + year;
    }
}