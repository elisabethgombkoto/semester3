package oo.ego8769.seminar.netzwerk.command;

public class InvalideCommand implements Command {
	private Object _message;

	public InvalideCommand(Object message) {
		_message = message;
	}

	public Object getInvalideMessage() {
		return _message;
	}
}
