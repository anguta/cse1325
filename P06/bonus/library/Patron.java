package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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
    * Restores name and email from the stream
    * @param br where we are reading from
    * @since 1.3
    *@throws IOException when something we access isn't in the file or there is there is improper data
    */
    public Patron(BufferedReader br) throws IOException {
        
        this.name = br.readLine();
        this.email = br.readLine();
    }
    /**
    * Writes name and email to the stream
    * @param bw where we a writing to
    * @since 1.3
    *@throws IOException when something we access isn't in the file or there is there is improper data
    */
    public void save(BufferedWriter bw) throws IOException {
        
        bw.write(name + "\n");
        bw.write(email + "\n");
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
