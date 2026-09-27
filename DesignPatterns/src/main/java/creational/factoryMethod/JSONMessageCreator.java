package creational.factoryMethod;


import creational.factoryMethod.message.JSONMessage;
import creational.factoryMethod.message.Message;

/**
 * Provides implementation for creating JSON messages
 */
public class JSONMessageCreator extends MessageCreator {

	@Override
	public Message createMessage() {
		return new JSONMessage();
	}

	
}
