package oo.ego8769.seminar.netzwerk.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import oo.ego8769.seminar.netzwerk.client.ClientCommuniction;
import oo.ego8769.seminar.netzwerk.exeptions.CommandFailedExeption;
import oo.ego8769.seminar.netzwerk.exeptions.InvalideCommandSequenceExeption;
import oo.ego8769.seminar.netzwerk.exeptions.NotLoggedInException;
import oo.ego8769.seminar.netzwerk.exeptions.PutFailedException;
import oo.ego8769.seminar.netzwerk.server.FileContener;
import oo.ego8769.seminar.netzwerk.server.Server;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CommunicationTest {// es täscht vor ein echte file server zu sein
								// coooool :-D :-D

	private Server _server;
	private ClientCommuniction _clientcommunicator;

	@Before
	public void befor() throws UnknownHostException, IOException {
		// ertse 2 zeilezu server starten
		_server = new Server(8001, new MockUpFileServer());
		_server.start();
		// die ganze file server implementiren
		//
		_clientcommunicator = new ClientCommuniction(8001);
	}

	@After
	public void after() {
		_clientcommunicator.close();
		_server.stop();
		_clientcommunicator = null;
		_server = null;
	}

	@Test
	public void loginTest() throws IOException, InterruptedException, InvalideCommandSequenceExeption {
		assertTrue("Login failes!", _clientcommunicator.connent("username", "password"));
	}

	@Test
	public void loginTestFailed() throws IOException, InterruptedException, InvalideCommandSequenceExeption {
		assertFalse("Login Successful!", _clientcommunicator.connent("falseusername", "falsepassword"));
	}

	@Test
	public void putTestNotLogIn()
			throws InterruptedException, IOException, InvalideCommandSequenceExeption, PutFailedException {
		Collection<String> conntents = null;
		FileContener filecontener = new FileContener("filename", conntents);
		try {
			assertFalse("Not Login!", _clientcommunicator.put(filecontener));
		} catch (NotLoggedInException e) {
			assertTrue(true);// wir haben es erwartet darum steht da falls es
								// auftritt dann ist der Test richtig
		}
	}

	@Test
	public void putTestLogIn() throws IOException, InterruptedException, InvalideCommandSequenceExeption,
			NotLoggedInException, PutFailedException {
		_clientcommunicator.connent("username", "password");
		Collection<String> conntents = null;
		FileContener filecontener = new FileContener("filename", conntents);
		assertTrue("Can not be put, put FAILED", _clientcommunicator.put(filecontener));

	}

	@Test
	public void getTestFileNotFound() throws InterruptedException, InvalideCommandSequenceExeption, IOException {
		_clientcommunicator.connent("username", "password");

		try {
			_clientcommunicator.get("testFile");
			assertTrue("File should not be found", false);
		} catch (FileNotFoundException e) {
			assertTrue(true);
		}

	}

	@Test
	public void getTestFileFound() throws IOException, InterruptedException, InvalideCommandSequenceExeption,
			NotLoggedInException, PutFailedException {
		Collection<String> conntents = null;
		FileContener filecontener = new FileContener("filename", conntents);
		_clientcommunicator.connent("username", "password");
		_clientcommunicator.put(filecontener);
		assertTrue("File can not found", _clientcommunicator.get("filename") != null);

	}

	@Test
	public void dirTest() throws InterruptedException, IOException, InvalideCommandSequenceExeption,
			NotLoggedInException, PutFailedException, CommandFailedExeption {
		Collection<String> conntents = null;
		FileContener filecontener = new FileContener("filename", conntents);
		_clientcommunicator.connent("username", "password");
		_clientcommunicator.put(filecontener);
		assertTrue("Dir can not be read", _clientcommunicator.dir().contains("filename"));
	}
}
