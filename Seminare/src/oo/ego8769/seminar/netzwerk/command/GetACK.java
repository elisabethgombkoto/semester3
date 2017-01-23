package oo.ego8769.seminar.netzwerk.command;

import java.io.Serializable;

import oo.ego8769.seminar.netzwerk.server.FileContener;

public class GetACK implements Serializable, Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 940234325671859212L;
	FileContener _fileContener;

	public GetACK(FileContener fileContener) {
		_fileContener = fileContener;
	}

	public FileContener getFileContener() {
		return _fileContener;
	}
}
