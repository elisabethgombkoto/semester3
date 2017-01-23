package oo.ego8769.seminar.netzwerk.server;

import java.io.Serializable;
import java.util.Collection;

public class FileContener implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -61044560924458205L;

	private String _name;
	private Collection<String> _file;

	public FileContener(String name, Collection<String> file) {
		_name = name;
		_file = file;
	}

	public String getFilename() {
		return _name;
	}

	public Collection<String> getFilecontents() {
		return _file;
	}
}
