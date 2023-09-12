import java.util.Scanner;

public class LibraryManager {
    
    public static void main(String[] args) {
    
        Library library = new Library("East Library and Rec Center");
        
        library.addPublication(new Publication("\"Diary of a Wimpy Kid\"", "Jeff Kinney", 2007));
        library.addPublication(new Publication("\"The Giver\"", "Lois Lowry", 1993));
        library.addPublication(new Publication("\"Blue Lock\"", "Muneyuki Kaneshiro", 2018));
        
        library.addPatron(new Patron("Angel Cabrera", "axc7208@mavs.uta.edu"));
        library.addPatron(new Patron("Wang", "DonWang@gmail.com"));
        library.addPatron(new Patron("Jerry", "JerryXGamer24@gmail.com"));
    
        System.out.println(library);
        Scanner scanner = new Scanner(System.in);
    	
        try {
    	    
    	    System.out.print("Which book would you like?: ");
    	    int book = Integer.parseInt(scanner.nextLine().trim()); // trim allowed EX: "2 " to work alongside EX: "2"
    	    
    	    System.out.println("Patrons");
            System.out.println(library.patronMenu());
            
            System.out.print("What is your name? : ");
            // String patron = scanner.nextLine();
            int patron = Integer.parseInt(scanner.nextLine().trim());
        	
            String valid = library.checkOut(book, patron);
            System.out.println(valid);
   
    	} catch(NumberFormatException e) {
            System.out.println("\u001B[31m" + "Enter a valid INTEGER" + "\u001B[0m"); // checks to see if its an integer, "nope" would not work
    	}
    	
    	// prints new library
        System.out.println(library);
        
    }

}

