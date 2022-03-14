package exception;

// if a custom exception extends Exception it becomes a checked exception 
// if a custom exception extends RuntimeException it becomes a unchecked exception
public class SystemException extends Exception {

	@Override
	public String getMessage() {
		return "Application Failed! Please try after sometime!";
	}

	
}
