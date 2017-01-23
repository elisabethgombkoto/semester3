package oo.ego8769.seminar.netzwerk.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import oo.ego8769.seminar.netzwerk.command.Command;
import oo.ego8769.seminar.netzwerk.command.CommandCommunication;
import oo.ego8769.seminar.netzwerk.command.CommandReciveListener;
import oo.ego8769.seminar.netzwerk.command.Dir;
import oo.ego8769.seminar.netzwerk.command.DirACK;
import oo.ego8769.seminar.netzwerk.command.DirFailed;
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
import oo.ego8769.seminar.netzwerk.exeptions.CommandFailedExeption;
import oo.ego8769.seminar.netzwerk.exeptions.InvalideCommandSequenceExeption;
import oo.ego8769.seminar.netzwerk.exeptions.NotLoggedInException;
import oo.ego8769.seminar.netzwerk.exeptions.PutFailedException;
import oo.ego8769.seminar.netzwerk.server.FileContener;

public class ClientCommuniction implements CommandReciveListener {
	private Socket _socket;
	private CommandCommunication _commandCommunication;
	private BlockingQueue<Command> _reciveQueue;

	public ClientCommuniction(int port) throws UnknownHostException, IOException {
		_socket = new Socket(InetAddress.getLoopbackAddress(), port);
		_reciveQueue = new LinkedBlockingQueue<>();
		_commandCommunication = new CommandCommunication(_socket, this);
	}

	public boolean connent(String user, String pw)
			throws IOException, InterruptedException, InvalideCommandSequenceExeption {

		Command answer = sendRecive(new Login(user, pw));
		if (answer instanceof LoginACK) {
			return true;
		} else if (answer instanceof LoginFailed) {
			return false;
		}
		throw new InvalideCommandSequenceExeption();

	}

	private Command sendRecive(Command command) throws InterruptedException, IOException {
		_commandCommunication.writeOut(command);
		return _reciveQueue.take();
	}

	@Override
	public void recive(Command command) throws InterruptedException {
		_reciveQueue.put(command);
	}

	public void close() {
		_commandCommunication.close();
	}

	public boolean put(FileContener filecontener) throws InterruptedException, IOException,
			InvalideCommandSequenceExeption, NotLoggedInException, PutFailedException {
		Command answer = sendRecive(new Put(filecontener));
		if (answer instanceof PutACK) {
			return true;
		} else if (answer instanceof PutFailed) {
			throw new PutFailedException();
		} else if (answer instanceof NotLogedIn) {
			throw new NotLoggedInException();
		} else {
			throw new InvalideCommandSequenceExeption();
		}
	}

	public FileContener get(String filename) throws InterruptedException, InvalideCommandSequenceExeption, IOException {
		Command answer = sendRecive(new Get(filename));
		if (answer instanceof GetACK) {
			return ((GetACK) answer).getFileContener();
		} else if (answer instanceof GetFailed) {
			throw new FileNotFoundException();
		} else {
			throw new InvalideCommandSequenceExeption();
		}
	}

	public ArrayList<String> dir()
			throws InterruptedException, IOException, CommandFailedExeption, InvalideCommandSequenceExeption {
		Command answer = sendRecive(new Dir());
		if (answer instanceof DirACK) {
			return ((DirACK) answer).getFilenames();
		} else if (answer instanceof DirFailed) {
			throw new CommandFailedExeption();
		} else {
			throw new InvalideCommandSequenceExeption();
		}
	}
}
