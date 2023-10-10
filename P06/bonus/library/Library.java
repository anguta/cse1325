package library;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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
    * Reads and assigns name field, creates new ArrayList and it restores the contents of publications, does the same with patrons, only this time it restores the contents from patrons
    * @param br where we are reading from
    * @since 1.3
    *@throws IOException when something we access isn't in the file or there is there is improper data
    */
    public Library(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.publications = new ArrayList<>();
        this.patrons = new ArrayList<>();
        
        int publicationSize = Integer.parseInt(br.readLine());
        for(int i = 0; i < publicationSize; i++) {
            
            if(br.readLine().trim().equals("publication")) {
                
                publications.add(new Publication(br));
            } else {
                
                publications.add(new Video(br));
            }
        }
        
        int patronSize = Integer.parseInt(br.readLine().trim());
        for(int i = 0; i < patronSize; i++) {
            
            patrons.add(new Patron(br));
        }
    }
    /**
    * Writes name to its own line, iterates over ArrayList and invokes constructor, does the same with patrons ArrayList only this time it saves patron to the BufferedWriter
    * @param bw where we a writing to
    * @since 1.3
    *@throws IOException when something we access isn't in the file or there is there is improper data
    */
    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n");
        
        bw.write(publications.size() + "\n");
        for(int i = 0; i < publications.size(); i++) {
            Publication pubs = publications.get(i);
           
            if(pubs instanceof Video) {
                bw.write("video" + "\n");
            } else {
                bw.write("publication" + "\n");
            }
            
            pubs.save(bw);
        }
        
        bw.write(patrons.size() + "\n");
        for(int i = 0; i < patrons.size(); i++) {
            Patron pat = patrons.get(i);
                
            pat.save(bw);
        }
    
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
    * Checks in publication index and validates it
    * @param publicationIndex Index of the publication 
    *@throws IndexOutOfBoundsException when the index is out of bounds
    * @return Status message of validity
    * @since 1.0
    */
	public String checkIn(int publicationIndex) {
        try {
			
            Publication publication = publications.get(publicationIndex);
			
            publication.checkIn();
			
            return "Thank you for returning the publication";
        } catch(IndexOutOfBoundsException e) {
            return "\u001B[31m" + "Exception Caught: Your index is out of bounds!!!" + "\u001B[0m";
        }
		
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
            return "\u001B[31m" + "Exception Caught: Your index is out of bounds!!!" + "\u001B[0m";
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
