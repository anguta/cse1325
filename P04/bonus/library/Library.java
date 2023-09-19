package library;

import java.util.ArrayList;

/**
 * A library containing a collection of different publications and patrons
 * 
 * @author Angel Cabrera
 * @version 1.0
 * @since 1.0
 */
public class Library {

    private String name;
    private ArrayList<Publication> publications;
    private ArrayList<Patron> patrons;
    
    /**
    * Constructs a new library and initializes new collections
    *@param name The name of the library
    *@since 1.0
    */
    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }
    
    /**
    * Appends publication to the publications field
    * @param publication The publication passed
    * @since 1.0
    */
    public void addPublication(Publication publication) {
    
        publications.add(publication);
    }
    
    /**
    * Appends patron to the patrons field
    * @param patron The patron passed
    * @since 1.0
    */
    public void addPatron(Patron patron) {
    
        patrons.add(patron);
    }
    
    /**
    * Displays the list of patrons in the library
    *
    * @return String value of the patron menu
    * @since 1.0
    */
    public String patronMenu() {
        String result = name + "\n";
        
        for(int i = 0; i < patrons.size(); i++) {
            result += i + ") " + patrons.get(i) + "\n";
        }
        
        return result;
    }
    
    /**
    * Checks out publication index and validates it
    * @param publicationIndex Index of the publication 
    * @param patronIndex Index of the patron
    *@throws IndexOutOfBoundsException when the index is out of bounds
    * @return Status message of validity
    * @since 1.0
    */
    public String checkOut(int publicationIndex, int patronIndex) {
        try {
            
            Publication publication = publications.get(publicationIndex);
            Patron patron = patrons.get(patronIndex);
            
            publication.checkOut(patron);
            
            return " ";
         } catch(IndexOutOfBoundsException e) {
            return "\u001B[31m" + "Exception Caught: Your index/book is out of bounds!!!" + "\u001B[0m";
        }
    }

    /**
    * Returns the name of the library and the menu of the publications
    * @return String value of the library menu
    * @since 1.0
    */
    @Override
    public String toString() {

        String result = name + "\n";
        
        for(int i = 0; i < publications.size(); i++) {
            result += i + ") " + publications.get(i) + "\n";
        }
        
        return result;
        
    }

}

