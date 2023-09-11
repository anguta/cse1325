import java.util.Scanner;

public class LibraryManager {
    
    public static void main(String[] args) {
    
        Library library = new Library("East Library and Rec Center");
        
        library.addPublication(new Publication("\"Diary of a Wimpy Kid\"", "Jeff Kinney", 2007));
        library.addPublication(new Publication("\"The Giver\"", "Lois Lowry", 1993));
        library.addPublication(new Publication("\"Blue Lock\"", "Muneyuki Kaneshiro", 2018));
    
        System.out.println(library);
        Scanner scanner = new Scanner(System.in);
    	
    	try {
    	    
            System.out.print("Which book would you like?: "); 
            int book = Integer.parseInt(scanner.nextLine().trim()); // trim allowed EX: "2 " to work alongside EX: "2"
        	
            System.out.print("What is your name? : ");
            String patron = scanner.nextLine();
        	
            String valid = library.checkOut(book, patron);
            System.out.println();
            
        } catch(NumberFormatException e) {
            System.out.println("Enter a valid INTEGER"); // checks to see if its an integer, "nope" would not work
    	}
    	
    	// prints new library
        System.out.println(library);
        
    }

}

