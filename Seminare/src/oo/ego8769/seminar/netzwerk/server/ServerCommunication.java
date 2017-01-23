package oo.ego8769.seminar.netzwerk.server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import oo.ego8769.seminar.netzwerk.command.Command;
import oo.ego8769.seminar.netzwerk.command.CommandCommunication;
import oo.ego8769.seminar.netzwerk.command.CommandReciveListener;
import oo.ego8769.seminar.netzwerk.command.Dir;
import oo.ego8769.seminar.netzwerk.command.DirACK;
import oo.ego8769.seminar.netzwerk.command.Get;
import oo.ego8769.seminar.netzwerk.command.GetACK;
import oo.ego8769.seminar.netzwerk.command.GetFailed;
import oo.ego8769.seminar.netzwerk.command.Login;
import oo.ego8769.seminar.netzwerk.command.LoginACK;
import oo.ego8769.seminar.netzwerk.command.LoginFailed;
import oo.ego8769.seminar.netzwerk.command.NotLogedIn;
import oo.ego8769.seminar.netzwerk.command.Put;
import oo.ego8769.seminar.netzwerk.command.PutACK;
import oo.ego8769.seminar.netzwerk.command.PutFailed;
import oo.ego8769.seminar.netzwerk.exeptions.NotRegistredExeption;

public class ServerCommunication implements CommandReciveListener {
	private Socket _socket;
	private FileServer _fileServer;
	private CommandCommunication _commandCommunication;
	private boolean _logedIn;

	public ServerCommunication(Socket socket, FileServer fileServer) throws IOException {
		_socket = socket;
		_fileServer = fileServer;
		_commandCommunication = new CommandCommunication(socket, this);

	}

	@Override
	public void recive(Command command) throws IOException, NotRegistredExeption {
		// System.out.println("Recieved Command: " +
		// command.getClass().getName());
		if (command instanceof Login) {
			Login login = (Login) command;
			if (_fileServer.verifyLogin(login.getUserName(), login.getPassword())) {
				_commandCommunication.writeOut(new LoginACK());
				_logedIn = true;
			} else {
				_commandCommunication.writeOut(new LoginFailed());
			}

		} else if (command instanceof Put) {
			if (_logedIn == true) {
				Put put = (Put) command;
				if (_fileServer.put(put.getFilecontener())) {
					_commandCommunication.writeOut(new PutACK());
				} else {
					_commandCommunication.writeOut(new PutFailed());
				}
			} else {
				_commandCommunication.writeOut(new NotLogedIn());
			}

		} else if (command instanceof Get) {
			if (_logedIn == true) {
				Get get = (Get) command;
				try {
					FileContener fileContener = _fileServer.get(get.getFileName());
					_commandCommunication.writeOut(new GetACK(fileContener));
				} catch (FileNotFoundException e) {
					_commandCommunication.writeOut(new GetFailed());
				}
			} else {
				_commandCommunication.writeOut(new NotLogedIn());
			}
		} else if (command instanceof Dir) {
			if (_logedIn == true) {
				Dir dir = (Dir) command;
				ArrayList<String> directoryContents = _fileServer.dir();
				_commandCommunication.writeOut(new DirACK(directoryContents));
				// _commandCommunication.writeOut(new DirFailed());

			} else {
				_commandCommunication.writeOut(new NotLogedIn());
			}

		}

	}

	public void close() {
		_commandCommunication.close();
	}

}
