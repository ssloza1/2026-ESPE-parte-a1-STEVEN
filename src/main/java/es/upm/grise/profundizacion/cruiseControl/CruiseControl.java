package es.upm.grise.profundizacion.cruiseControl;

public class CruiseControl {
	
	@SuppressWarnings("unused")
	private Speedometer speedometer;
	private Integer speedSet;
	private Integer speedLimit;

	/*
	 * Constructor
	 */
	public CruiseControl(Speedometer speedometer) {
		this.speedometer = speedometer;
		this.speedSet = null;
		this.speedLimit = null;
	}
	
	
	
	/*
	 * Method to code / test
	 */
	public void setSpeedSet(int speedSet) throws IncorrectSpeedSetException, SpeedSetAboveSpeedLimitException {
		// Check if speedSet is positive (strictly greater than zero)
		if (speedSet <= 0) {
			throw new IncorrectSpeedSetException("Speed set must be strictly greater than zero");
		}
		
		// Check if speedLimit is set and speedSet exceeds it
		if (speedLimit != null && speedSet > speedLimit) {
			throw new SpeedSetAboveSpeedLimitException("Speed set cannot exceed speed limit");
		}
		
		this.speedSet = speedSet;
	}
	
	

	/*
	 * Other setters & getters
	 */
	public Integer getSpeedLimit() {
		
		return speedLimit;
		
	}

	public void setSpeedLimit(Integer speedLimit) {
		
		this.speedLimit = speedLimit;
		
	}

	public Integer getSpeedSet() {
		
		return speedSet;
		
	}

}
