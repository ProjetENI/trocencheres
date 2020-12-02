package fr.eni.trocencheres.exceptions;

public class BllException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BllException() {
		super();
	}

    public BllException(String message) {
        super(message);
    }

    public BllException(String message, Throwable cause) {
        super(message, cause);
    }

}
