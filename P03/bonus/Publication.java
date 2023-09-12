import java.time.LocalDate;

public class Publication {

    private String title;
    private String author;
    private int copyright;
    private Patron loanedTo;
    private LocalDate dueDate; //.plusDays(14); ?
    
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
    
    /* public void checkIn() {
        // we need not write it?
    } */
    
    public void checkOut(Patron patron) {
    
        this.loanedTo = patron;
        this.dueDate = LocalDate.now().plusDays(14);
    }
    
    @Override
    public String toString() {
        String result = title + " by " + author + ", " + "\u001B[4m" + "\u001B[3m" + "Copyright: " + copyright + "\u001B[0m";
        
        if(loanedTo != null) {
            result += ", borrowed by " + "\u001B[1m" + loanedTo + "\u001B[0m" + " till " + dueDate;
        
        }
        
        return result;
    }

}

