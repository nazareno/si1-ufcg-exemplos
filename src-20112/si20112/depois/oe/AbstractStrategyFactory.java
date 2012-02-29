package si20112.depois.oe;

public abstract class AbstractStrategyFactory {

	/**
	 * Abstract method that creates the MessageStrategy. Any classes that
	 * inherit this abstract class should use this method to create their
	 * MessageStrategies.
	 * 
	 */
	public abstract MessageStrategy createMessageStrategy();
}
