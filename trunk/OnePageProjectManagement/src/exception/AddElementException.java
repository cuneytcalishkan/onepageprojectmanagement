package exception;

public class AddElementException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddElementException() {
	}

	public AddElementException(String message) {
		super(message);
	}

	public AddElementException(Throwable cause) {
		super(cause);
	}

	public AddElementException(String message, Throwable cause) {
		super(message, cause);
	}

}
