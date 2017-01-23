package oo.ego8769.seminar.netzwerk.command;

import java.io.Serializable;

public class Login implements Serializable, Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2837490272134731314L;
	String _userName;
	String _password;

	public Login(String userName, String password) {
		_userName = userName;
		_password = password;
	}

	public String getUserName() {
		return _userName;
	}

	public String getPassword() {
		return _password;
	}

}
