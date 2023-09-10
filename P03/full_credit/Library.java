import java.util.ArrayList;

public class Library {

    private String name;
    private ArrayList<Publication> publications;
    
    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>();
    }

    public void addPublication(Publication publication) {
    
        publications.add(publication);
    }
    
    public String checkOut(int publicationIndex, String patron) {
        try {
            
            Publication publication = publications.get(publicationIndex);
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

