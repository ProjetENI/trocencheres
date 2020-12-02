package fr.eni.trocencheres.exceptions;

public class DalException extends Exception {

	private static final long serialVersionUID = 1L;

	public DalException() {
		super();
	}

    public DalException(String message) {
        super(message);
    }

    public DalException(String message, Throwable cause) {
        super(message, cause);
    }
	
}
