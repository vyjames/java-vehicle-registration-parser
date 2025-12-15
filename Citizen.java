/**
 * Citizen defines a basic citizen record for the State of Looney Tunes.
 * 1) Stores a first name and last name.
 * 2) Provides constructors, getters/setters, and a toString method.
 *
 * @author Vy Nguyen
 * @version 1.0
 * @since 12/14/2025
 */
public class Citizen{
    // Instance Variables
    private String firstName;
    private String lastName;

    /**
     * Citizen() is the no-argument constructor.
     * It sets firstName and lastName to "No Name".
     */
    public Citizen(){
        firstName = "No Name";
        lastName = "No Name";
    }

    /**
     * Citizen(String, String) constructs a Citizen with provided names.
     *
     * @param inFirst The first name.
     * @param inLast The last name.
     */
    public Citizen(String inFirst, String inLast){
        firstName = inFirst;
        lastName = inLast;
    }

    /**
     * setFirstName(String) updates the first name.
     *
     * @param inFirst The new first name.
     */
    public void setFirstName(String inFirst){
        firstName = inFirst;
    }

    /**
     * getFirstName() returns the first name.
     *
     * @return The first name.
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * setLastName(String) updates the last name.
     *
     * @param inLast The new last name.
     */
    public void setLastName(String inLast){
        lastName = inLast;
    }

    /**
     * getLastName() returns the last name.
     *
     * @return The last name.
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * toString() returns a String with firstName, a space, and lastName.
     *
     * @return The formatted full name.
     */
    public String toString(){
        return firstName + " " + lastName;
    }
}