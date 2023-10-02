package library;

import java.lang.ArithmeticException;

/**
 * Exception that is thrown when the runtime is invalid
 * 
 * @author Angel Cabrera
 * @version 1.0
 * @since 1.0
 * 
 * 
 *
 */
public class InvalidRuntimeException extends ArithmeticException {
    
    /**
    * Constructs an InvalidRuntimeException
    *
    *
    *
    */
    public InvalidRuntimeException() { super(); }
    
    /**
    * Constructs an InvalidRuntimeException with message
    *
    * @param message The message
    *
    */
    public InvalidRuntimeException(String message) { super(message); }
    
    /**
    * Constructs an InvalidRuntimeException with message and the invalid runtime
    *
    * @param message The message
    * @param runtime The value of the invalid runtime
    */
    public InvalidRuntimeException(String message, int runtime) { super(message + " has invalid runtime " + runtime); }




}
