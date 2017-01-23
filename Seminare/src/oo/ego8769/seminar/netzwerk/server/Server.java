package oo.ego8769.seminar.netzwerk.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;

public class Server {
	private LinkedList<ServerCommunication> _serverCommunications;
	private ServerSocket _serverSocket;
	private int _port;
	private boolean _isRunning;
	private FileServer _fileServer;

	public Server(int port, FileServer fileserver) {
		_port = port;
		_fileServer = fileserver;
		_serverCommunications = new LinkedList<>();
	}

	public void start() {

		Thread serverThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					_serverSocket = new ServerSocket(_port, 0, InetAddress.getLoopbackAddress());
					_isRunning = true;

					while (_isRunning) {
						Socket connection = _serverSocket.accept();

						ServerCommunication communication = new ServerCommunication(connection, _fileServer);
						_serverCommunications.add(communication);
					}
				} catch (SocketException e) {
					stop();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (_serverSocket != null) {
							_serverSocket.close();
						}
					} catch (IOException e) {
					}
				}
			}
		});

		serverThread.start();
	}

	public void stop() {
		_isRunning = false;
		try {
			if (!_serverSocket.isClosed()) {
				_serverSocket.close();
			}
		} catch (IOException e) {
			// eat up, i can do nothing if by closing an exception comes
			// e.printStackTrace();
		}
		for (ServerCommunication current : _serverCommunications) {
			current.close();

		}

	}

}