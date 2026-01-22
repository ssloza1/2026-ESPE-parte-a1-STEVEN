package es.upm.grise.profundizacion.cruiseControl;

public class SpeedSetAboveSpeedLimitException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public SpeedSetAboveSpeedLimitException() {
		super();
	}

	public SpeedSetAboveSpeedLimitException(String message) {
		super(message);
	}

	public SpeedSetAboveSpeedLimitException(String message, Throwable cause) {
		super(message, cause);
	}

	public SpeedSetAboveSpeedLimitException(Throwable cause) {
		super(cause);
	}

}
