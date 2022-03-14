package exception;

public class BooksNotFoundException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No Request in the Collection yet! Please add book!";
	}
	
	
}
