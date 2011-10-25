package exemplos.oe;

public class DefaultFactory extends AbstractStrategyFactory {

	private DefaultFactory() {
	}// DefaultFactory

	private static DefaultFactory instance;// an instance of the factory

	/**
	 * This method returns the instance of DefaultFactory, creating a new one if
	 * there isn't one initialized already.
	 * 
	 * @return DefaultFactory object ready for use.
	 */
	public static AbstractStrategyFactory getInstance() {
		if (null == instance)// If we don't have an instance
			instance = new DefaultFactory();// Initialize one
		return instance;// return the instance to the DefaultFactory
	}

	public MessageStrategy createMessageStrategy() {
                /*
                 * This is actually really neato here, the constructor is actually
                 * defined right here as it's created.
                 */
                return new MessageStrategy() {
                        /**
                         * This simply gets MessageBody's payload and prints it out
                         */
                        public void sendMessage(MessageBody mb) {
                                System.out.println(mb.getPayload());// finally a println
                        }// sendMessage()
                };// MessageStrategy()
        }// createStrategy
}// DefaultFactory
