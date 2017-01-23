package oo.ego8769.seminar.netzwerk.command;

import java.io.Serializable;

import oo.ego8769.seminar.netzwerk.server.FileContener;

public class Put implements Serializable, Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8098677107254412061L;

	FileContener _filecontener;

	public Put(FileContener filecontener) {
		_filecontener = filecontener;
	}

	public FileContener getFilecontener() {
		return _filecontener;
	}

}
