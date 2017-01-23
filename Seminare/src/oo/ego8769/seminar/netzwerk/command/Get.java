package oo.ego8769.seminar.netzwerk.command;

import java.io.Serializable;

public class Get implements Command, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7898709782814994053L;
	String _filename;

	public Get(String filename) {
		_filename = filename;
	}

	public String getFileName() {
		return _filename;
	}
}
