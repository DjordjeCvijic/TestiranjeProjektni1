package exception;

/**
* <h1>NotSupportedOperationException</h1>
* The exception is thrown in case of an attempt to execute an operation that is not supported.
*/
public class NotSupportedOperationException extends Exception{
	public NotSupportedOperationException() {
		super();
	
	}

	public NotSupportedOperationException(String message) {
		super(message);
		
	}

}
