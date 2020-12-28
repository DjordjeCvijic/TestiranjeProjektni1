package exception;
/**
* <h1>NumberNotInAreaException</h1>
* The exception is thrown in case of an attempt to do an operation on the number that is not in the expected area.
*/
public class NumberNotInAreaException extends Exception {
	public NumberNotInAreaException() {
		super();
	
	}

	public NumberNotInAreaException(String message) {
		super(message);
		
	}

}
