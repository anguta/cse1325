package library;

import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 *  Library Publications that can be checked out by a patron
 * @author Angel Cabrera
 * @version 1.0
 * @since 1.0
 *
 */
public class Publication {

    private String title;
    private String author;
    private int copyright;
    private Patron loanedTo;
    private LocalDate dueDate; //.plusDays(14); ?
    /**
    * Constructs a new Publication with the title, author, copyright year
    * @param title The title of the publication
    * @param author The author of the publication
    * @param copyright The copyright year of the publication
    * @throws IllegalArgumentException when copyright year is less than 1900 or more than the present year
    * @since 1.0
    *
    */
    public Publication(String title, String author, int copyright) {
        this.title = title;
        this.author = author;
        
        int presentYr = LocalDate.now().getYear();
        if(copyright < 1900 || copyright > presentYr) {
            throw new IllegalArgumentException("\u001B[31m" + "Exception Caught: Your Copyright is out of bounds!!!" + "\u001B[0m");
        }
        
        this.copyright = copyright;
        
        this.loanedTo = null;
        this.dueDate = null;
    }
    /**
    * Read each line from BufferedReader stream, checks fourth value to see if its checked in, if not it reconstructs objects and creates a new LocalDate
    * @param br where we are reading from
    * @since 1.3
    *@throws IOException when something we access isn't in the file or there is there is improper data
    */
    public Publication(BufferedReader br) throws IOException{
        this.title = br.readLine().trim();
        this.author = br.readLine().trim();
        this.copyright = Integer.parseInt(br.readLine().trim());
        String fourth = br.readLine().trim();
        
        if(fourth.equals("checked in")) {    
            
            this.loanedTo = null;
            this.dueDate = null;
        
        } else {
            
            this.loanedTo = new Patron(br);
            this.dueDate = LocalDate.parse(br.readLine());
            System.out.print("\n");
            
        }
        
    }
    /**
    * Writes each field to the Buffered Writer stream, deals with loanedTo and dueDate if they are null, creates new or identical LocalDate
    * @param bw where we a writing to
    * @since 1.3
    *@throws IOException when something we access isn't in the file or there is there is improper data
    */
    public void save(BufferedWriter bw) throws IOException{
        
        bw.write(title + "\n");
        bw.write(author + "\n");
        bw.write("" + copyright + "\n");
        
        if(loanedTo == null) {
            bw.write("checked in" + "\n");
        } else { 
            bw.write("checked out" + "\n"); 
            
            loanedTo.save(bw); 
            bw.write(dueDate.toString() + "\n");
        }
        
    }
    
	/**
    * Checks in a publication and resets due date and patron
    * @param patron The patron returning the publication
    * @since 1.0
    *
    */
    public void checkIn() {
    
        if(this.loanedTo == null) throw new IllegalArgumentException("Publication is not checked out.");
		
        this.loanedTo = null;
        this.dueDate = null;
    }
    /**
    * Checks out a publication to the patron and sets the due date to 14 days from today
    * @param patron The patron borrowing the publication
    * @since 1.0
    *
    */
    public void checkOut(Patron patron) {
    
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }
    
    /**Returns string value of the publication (book or video) including the title, author, copyright year, runtime, the patron and the due date
    * @param pre The word Book or Video 
    * @param mid More information, like runtime, if the patron checks out a Video
    * @return String value of the publication
    * @since 1.0
    *
    */
    protected String toStringBuilder(String pre, String mid) {
        String result = pre + ") " + "\"" + title + "\"" +  " by " + author + ", " + "\u001B[4m" + "\u001B[3m" + "Copyright: " + copyright + "\u001B[0m";
        
        if(!mid.isEmpty()) {
            result += ", " + mid;
        }
        
        if(loanedTo != null) {
            result += ", borrowed by " + "\u001B[1m" + loanedTo + "\u001B[0m" + " till " + dueDate; 

        }
        
        return result;
    }
    
    /**
    * Returns/Passes Book to toStringBuilder
    * @return Book to toStringBuilder
    * @since 1.0
    *
    */
    @Override
    public String toString() {
        
        return toStringBuilder("Book", "");
    }

}
