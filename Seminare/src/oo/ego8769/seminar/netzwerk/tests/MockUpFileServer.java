package oo.ego8769.seminar.netzwerk.tests;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import oo.ego8769.seminar.netzwerk.server.FileContener;
import oo.ego8769.seminar.netzwerk.server.FileServer;

public class MockUpFileServer implements FileServer {

	String _username = "username";
	String _password = "password";

	HashMap<String, FileContener> _localFileCache;

	public MockUpFileServer() {
		_localFileCache = new HashMap<>();
	}

	@Override
	public boolean verifyLogin(String userName, String password) {
		if (_username.equals(userName) && (_password.equals(password))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public FileContener get(String fileName) throws FileNotFoundException {
		if (_localFileCache.containsKey(fileName)) {
			return _localFileCache.get(fileName);
		} else {
			throw new FileNotFoundException();
		}
	}

	@Override
	public boolean put(FileContener filecontener) {
		_localFileCache.put(filecontener.getFilename(), filecontener);
		return true;
	}

	@Override
	public ArrayList<String> dir() {
		return new ArrayList<>(_localFileCache.keySet());
	}

}
