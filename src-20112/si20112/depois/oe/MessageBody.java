package si20112.depois.oe;

public class MessageBody {

	private Object payload;// This is the data that this class will be handling
	private final MessageStrategy strategy;

	public MessageBody(MessageStrategy strategy) {
		this.strategy = strategy;
	}

	public Object getPayload() {
		return payload;
	}// getPayload

	public void setPayload(Object obj) {
		payload = obj;
	}// configure

	public void send() {
		strategy.sendMessage(this);
	}
}