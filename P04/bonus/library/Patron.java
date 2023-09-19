package library;

/**
 * Patron objects that are represented in the Library, Can also check out publications 
 * 
 * @author Angel Cabrera
 * @version 1.0
 * @since 1.0
 *
 */
public class Patron {

    private String name;
    private String email;
    
    /**
    * Constructs a new patron with the name and email passed
    * @param name The name of the patron
    * @param email The email of the patron
    * @since 1.0
    */
    public Patron(String name, String email) {
    
        this.name = name;
        this.email = email;  
    }
    
    /**
    * Returns the string value of the patron, and their respective email
    *@return String value of the patron
    *@since 1.0
    */
    @Override
    public String toString() {
    // for testing will format if necessary
        return name + " " + " (" + email + ") ";
        
    }

}
