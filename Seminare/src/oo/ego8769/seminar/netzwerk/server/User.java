package oo.ego8769.seminar.netzwerk.server;

import java.io.Serializable;
import java.util.LinkedList;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 223798677981504499L;
	String _username;
	String _password;
	LinkedList<User> _clients;

	public User(String username, String password) {
		_username = username;
		_password = password;
		_clients.add(this);

	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		_username = username;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}
}
