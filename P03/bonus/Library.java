import java.util.ArrayList;

public class Library {

    private String name;
    private ArrayList<Publication> publications;
    private ArrayList<Patron> patrons;
    
    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public void addPublication(Publication publication) {
    
        publications.add(publication);
    }
    
    public void addPatron(Patron patron) {
    
        patrons.add(patron);
    }

    public String patronMenu() {
        String result = name + "\n";
        
        for(int i = 0; i < patrons.size(); i++) {
            result += i + ") " + patrons.get(i) + "\n";
        }
        
        return result;
    }
       
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

    @Override
    public String toString() {

        String result = name + "\n";
        
        for(int i = 0; i < publications.size(); i++) {
            result += i + ") " + publications.get(i) + "\n";
        }
        
        return result;
        
    }

}

