import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
	// add user input for name
	    // scanner ?, 
	    
	    // Scanner user_name = new Scanner(System.in);
	    
	    // System.out.println("What is your name?"); 
	    
	    // String name = user_name.nextLine();
	    
	    String user_name = System.getProperty("user.name");
	    
        System.out.println("Hello, " + user_name + "!");
    }
}
