package es.upm.grise.profundizacion.cruiseControl;

public class IncorrectSpeedSetException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public IncorrectSpeedSetException() {
		super();
	}

	public IncorrectSpeedSetException(String message) {
		super(message);
	}

	public IncorrectSpeedSetException(String message, Throwable cause) {
		super(message, cause);
	}

	public IncorrectSpeedSetException(Throwable cause) {
		super(cause);
	}

}
