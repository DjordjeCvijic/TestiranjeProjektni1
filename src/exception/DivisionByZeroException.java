package exception;
/**
* <h1>DivisionByZeroException</h1>
* The exception is thrown in case of an attempt to divide by 0.
*/
public class DivisionByZeroException extends Exception {
	
	public DivisionByZeroException() {
		super();
	
	}

	public DivisionByZeroException(String message) {
		super(message);
		
	}


}
