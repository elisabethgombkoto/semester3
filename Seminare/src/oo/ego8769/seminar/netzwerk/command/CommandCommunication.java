package oo.ego8769.seminar.netzwerk.command;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import oo.ego8769.seminar.netzwerk.exeptions.NotRegistredExeption;

public class CommandCommunication implements Runnable {

	private Socket _socket;
	private ObjectInputStream _in;
	private ObjectOutputStream _out;
	private CommandReciveListener _commandReciveListener;
	private boolean _isRunning;

	public CommandCommunication(Socket socket, CommandReciveListener commandReciveListener) throws IOException {
		_socket = socket;
		_commandReciveListener = commandReciveListener;

		try {
			_out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {

			_in.close();
			_out.close();

			throw e;
		}
		new Thread(this).start();
	}

	@Override
	public void run() {
		_isRunning = true;
		while (_isRunning) {
			if (_in == null) {
				try {
					_in = new ObjectInputStream(_socket.getInputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Object message = _in.readObject();
				if (message instanceof Command) {
					try {
						_commandReciveListener.recive((Command) message);
					} catch (InterruptedException | NotRegistredExeption e) {
						// eat up
						e.printStackTrace();
					}
				} else {
					_out.writeObject(new InvalideCommand(message));
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				// eat up, can not acure
				e.printStackTrace();
			} catch (IOException e) {
				close();
			}
		}
	}

	public void close() {
		_isRunning = false;

		try {
			_in.close();
			_out.close();
			_socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeOut(Command command) throws IOException {
		_out.writeObject(command);
		_out.flush();
	}

}
