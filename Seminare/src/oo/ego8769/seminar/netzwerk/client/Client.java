package oo.ego8769.seminar.netzwerk.client;

import java.awt.Panel;
import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;

public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -916495949120910151L;

	private ClientCommuniction _clientCommuniction;

	private FrameClientLogin _frameClientLogin;
	private FrameClientServer _frameClientServer;

	private int _port;

	public Client(int port) throws UnknownHostException, IOException {
		_port = port;
	}

	public void start() throws UnknownHostException, IOException {
		_clientCommuniction = new ClientCommuniction(_port);
		_frameClientLogin = new FrameClientLogin(getClientCommuniction(), this);
	}

	public ClientCommuniction getClientCommuniction() {
		return _clientCommuniction;
	}

	public void close() {
		_clientCommuniction.close();
	}

	public void nextFrame() {
		_frameClientLogin.close();
		_frameClientServer = new FrameClientServer(getClientCommuniction());
	}

	class SharedFilesPanel extends Panel {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2555477512513641848L;

		public SharedFilesPanel(ClientCommuniction _clientCommuniction) {

		}

	}
}