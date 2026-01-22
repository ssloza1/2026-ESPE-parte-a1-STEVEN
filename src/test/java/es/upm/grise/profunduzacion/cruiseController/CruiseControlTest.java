package es.upm.grise.profunduzacion.cruiseController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import es.upm.grise.profundizacion.cruiseControl.*;

class CruiseControlTest {
	
	private CruiseControl cruiseControl;
	private Speedometer speedometer;
	
	@BeforeEach
	public void setUp() {
		speedometer = new Speedometer();
		cruiseControl = new CruiseControl(speedometer);
	}
	
	
	@Test
	public void testConstructorInitializesSpeedSetToNull() {
		assertNull(cruiseControl.getSpeedSet(), "speedSet should be initialized to null");
	}
	
	@Test
	public void testConstructorInitializesSpeedLimitToNull() {
		assertNull(cruiseControl.getSpeedLimit(), "speedLimit should be initialized to null");
	}
	
	
	@Test
	public void testSetSpeedSetWithPositiveValue() throws IncorrectSpeedSetException, SpeedSetAboveSpeedLimitException {
		cruiseControl.setSpeedSet(100);
		assertEquals(100, cruiseControl.getSpeedSet(), "speedSet should be set to 100");
	}
	
	@Test
	public void testSetSpeedSetWithSmallPositiveValue() throws IncorrectSpeedSetException, SpeedSetAboveSpeedLimitException {
		cruiseControl.setSpeedSet(1);
		assertEquals(1, cruiseControl.getSpeedSet(), "speedSet should be set to 1");
	}
	
	
	@Test
	public void testSetSpeedSetWithZeroThrowsException() {
		assertThrows(IncorrectSpeedSetException.class, () -> {
			cruiseControl.setSpeedSet(0);
		}, "setSpeedSet should throw IncorrectSpeedSetException when speedSet is 0");
	}
	
	@Test
	public void testSetSpeedSetWithNegativeValueThrowsException() {
		assertThrows(IncorrectSpeedSetException.class, () -> {
			cruiseControl.setSpeedSet(-50);
		}, "setSpeedSet should throw IncorrectSpeedSetException when speedSet is negative");
	}
	
	
	@Test
	public void testSetSpeedSetBelowSpeedLimit() throws IncorrectSpeedSetException, SpeedSetAboveSpeedLimitException {
		cruiseControl.setSpeedLimit(120);
		cruiseControl.setSpeedSet(100);
		assertEquals(100, cruiseControl.getSpeedSet(), "speedSet should be set to 100");
	}
	
	@Test
	public void testSetSpeedSetEqualToSpeedLimit() throws IncorrectSpeedSetException, SpeedSetAboveSpeedLimitException {
		cruiseControl.setSpeedLimit(120);
		cruiseControl.setSpeedSet(120);
		assertEquals(120, cruiseControl.getSpeedSet(), "speedSet should be equal to speedLimit");
	}
	
	@Test
	public void testSetSpeedSetAboveSpeedLimitThrowsException() {
		cruiseControl.setSpeedLimit(120);
		assertThrows(SpeedSetAboveSpeedLimitException.class, () -> {
			cruiseControl.setSpeedSet(150);
		}, "setSpeedSet should throw SpeedSetAboveSpeedLimitException when speedSet exceeds speedLimit");
	}
	
	@Test
	public void testSetSpeedSetWithoutSpeedLimitSet() throws IncorrectSpeedSetException, SpeedSetAboveSpeedLimitException {
		cruiseControl.setSpeedSet(200);
		assertEquals(200, cruiseControl.getSpeedSet(), "speedSet should be set to 200 when speedLimit is not set");
	}
	

	@Test
	public void testSetSpeedSetZeroWithSpeedLimitSetThrowsIncorrectSpeedSetException() {
		cruiseControl.setSpeedLimit(120);
		assertThrows(IncorrectSpeedSetException.class, () -> {
			cruiseControl.setSpeedSet(0);
		}, "setSpeedSet should throw IncorrectSpeedSetException for zero even when speedLimit is set");
	}
	
	@Test
	public void testSetSpeedSetNegativeWithSpeedLimitSetThrowsIncorrectSpeedSetException() {
		cruiseControl.setSpeedLimit(120);
		assertThrows(IncorrectSpeedSetException.class, () -> {
			cruiseControl.setSpeedSet(-30);
		}, "setSpeedSet should throw IncorrectSpeedSetException for negative value even when speedLimit is set");
	}
}
