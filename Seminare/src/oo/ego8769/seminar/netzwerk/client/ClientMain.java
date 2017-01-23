package oo.ego8769.seminar.netzwerk.client;

import java.io.IOException;
import java.net.UnknownHostException;

import oo.ego8769.seminar.netzwerk.server.FileServerImplementation;
import oo.ego8769.seminar.netzwerk.server.Server;
import oo.ego8769.seminar.netzwerk.server.ServerCommunication;

public class ClientMain {

	public static void main(String[] args) {
		Server server = null;
		Client client = null;

		ServerCommunication serverComunication = null;

		server = new Server(8001, new FileServerImplementation("text.txt", serverComunication));
		server.start();
		try {
			client = new Client(8001);
			client.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			client.close();
		}

	}

}
