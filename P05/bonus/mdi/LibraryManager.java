package mdi;

import java.util.Scanner;
import library.Patron;
import library.Video;
import library.Publication;
import library.Library;
import library.InvalidRuntimeException;

public class LibraryManager {

    Library library;
    
    public LibraryManager(Library library) {
        this.library = library;
    }
    
    Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Library library = new Library("\nEast Library and Rec Center");
        LibraryManager libraryManager = new LibraryManager(library);
			
            libraryManager.presetPublications();
			
            while(true) {
                try {
                    libraryManager.loadMenu();
                    
                    System.out.print("Enter choice (7 to exit): ");

                    int userChoice = Integer.parseInt(libraryManager.scanner.nextLine().trim());
                    
                    switch (userChoice) {
                        case 0:
                            libraryManager.printLibrary();
                            break;
                       case 1:
                            libraryManager.addPublications();
                            break;
                       case 2:
                            libraryManager.addVideo();
                            break;
                       case 3:
                            libraryManager.addPatrons();
                            break;
                       case 4:
                            libraryManager.listPatrons();
                            break;
                       case 5:
                            libraryManager.checkOut();
                            break;
                       case 6:
                            libraryManager.checkIn();
                            break;
                       case 7: 
                            System.out.println("Thanks for visiting East Library and Rec Center, come again!");
                            System.exit(0);
                        default:
                            throw new IllegalArgumentException("Enter valid choice!!!");          
                    }
                    
                    } catch(NumberFormatException e) {
                        System.out.println("\u001B[31m" + "Enter a valid INTEGER: " + "\u001B[0m" + e); // checks to see if its an integer, "nope" would not work
                    } catch(Exception e) {
                          System.err.println(e);
                    }
            
            }
    }
    
    public void loadMenu() {
        System.out.print("\n\n\n\t\t\t\t" + "MENU\n");
        System.out.println("0. List Publications");
        System.out.println("1. Add new publication");
        System.out.println("2. Add new video");
        System.out.println("3. Add new patron");
        System.out.println("4. List Patrons");
        System.out.println("5. Check Out");
        System.out.println("6. Check In");
        System.out.println("7. Exit");
    }
    
    public void printLibrary() {
        System.out.println(library);
    }
    
    public void addPublications() {
        System.out.print("Enter the title of the publication: ");
        String title = scanner.nextLine();
						
        System.out.print("Who is the author of the publication? ");
        String author = scanner.nextLine();
						
        System.out.print("Enter the copyright year of the publication: ");
        int copyright = Integer.parseInt(scanner.nextLine().trim());
						
        library.addPublication(new Publication(title, author, copyright));
    }
    
    public void addVideo() {
        System.out.print("Enter the title of the video: ");
        String title = scanner.nextLine();
						
        System.out.print("Who is the author of the video?: ");
        String author = scanner.nextLine();
						
        System.out.print("Enter the copyright year of the video: ");
        int copyright = Integer.parseInt(scanner.nextLine().trim());
						
        System.out.print("Enter the runtime of the video (in minutes): ");
        int runtime = Integer.parseInt(scanner.nextLine().trim());
						
        library.addPublication(new Video(title, author, copyright, runtime));    
    }
    
    public void addPatrons() {
        System.out.print("Enter new patron's name: " );
        String name = scanner.nextLine();
						
        System.out.print("Enter new patron's email: ");
        String email = scanner.nextLine();
						
        library.addPatron(new Patron(name, email));
						
        System.out.println("Added new patron " + name);
    }
    
    public void checkOut() {
        System.out.println(library);
		
        System.out.print("Which book would you like?: ");
        int publication = Integer.parseInt(scanner.nextLine().trim());
						
        System.out.println("Patrons ");
        System.out.println(library.patronMenu());
						
        System.out.print("What is your name?: ");
        int patron = Integer.parseInt(scanner.nextLine().trim());
						
        String valid = library.checkOut(publication, patron);
        System.out.println(valid);
						
        System.out.println(library);
    }
    
    public void checkIn() {
        System.out.println(library);
						
        System.out.print("What would you like to return?: ");
        int publication = Integer.parseInt(scanner.nextLine().trim());
						
        String valid = library.checkIn(publication);
        System.out.println(valid);
						
        System.out.println(library);
    }
    
    public void listPatrons() {
        System.out.print("\nPatrons");
        System.out.println(library.patronMenu());
    }
    
    public void presetPublications() {
        library.addPublication(new Publication("Diary of a Wimpy Kid", "Jeff Kinney", 2007));
        library.addPublication(new Publication("The Giver", "Lois Lowry", 1993));
        library.addPublication(new Publication("Blue Lock", "Muneyuki Kaneshiro", 2018));
           
        library.addPublication(new Video("Chainsaw Man", "MAPPA & Tatsuki Fujimoto", 2022, 288));
        library.addPublication(new Video("Jujutsu Kaisen 0", "MAPPA & Gege Akutami", 2021, 105));
        library.addPublication(new Video("Dragon Ball Super", "Akira Toriyama", 2015, 2620));
            
        library.addPatron(new Patron("Angel Cabrera", "axc7208@mavs.uta.edu"));
        library.addPatron(new Patron("Wang", "DonWang@gmail.com"));
        library.addPatron(new Patron("Jerry", "JerryXGamer24@gmail.com"));
    }
}
