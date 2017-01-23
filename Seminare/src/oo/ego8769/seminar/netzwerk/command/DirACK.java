package oo.ego8769.seminar.netzwerk.command;

import java.io.Serializable;
import java.util.ArrayList;

public class DirACK implements Command, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6766459593112667760L;
	private ArrayList<String> _filenames;

	public DirACK(ArrayList<String> filenames) {
		_filenames = filenames;
	}

	public ArrayList<String> getFilenames() {
		return _filenames;
	}
}
