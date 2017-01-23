package oo.ego8769.seminar.netzwerk.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import oo.ego8769.seminar.netzwerk.exeptions.NotRegistredExeption;

public class FileServerImplementation implements FileServer {

	@Override
	public boolean verifyLogin(String userName, String password) throws NotRegistredExeption {
		Iterator<User> userIterator = _clients.iterator();
		while (userIterator.hasNext() == true) {
			User next = userIterator.next();
			if (next.getUsername().equals(userName) && next.getPassword().equals(password)) {
				return true;
			}
		}
		throw new NotRegistredExeption();

	}

	@Override
	public FileContener get(String fileName) throws IOException {
		ArrayList<String> files = (ArrayList<String>) Arrays.asList(_sharedDirectory.list());
		Collection<String> content = new ArrayList<>();
		if (files.contains(fileName)) {

			File getFile = new File(_sharedDirectory.getAbsolutePath() + "//" + fileName);
			BufferedReader out;
			out = new BufferedReader(new InputStreamReader(new FileInputStream(getFile)));
			String line = null;
			while ((line = out.readLine()) != null) {
				content.add(line);
			}
		} else {
			throw new FileNotFoundException();
		}
		return new FileContener(fileName, content);
	}

	@Override
	public boolean put(FileContener fileContener) {

		File file = new File(fileContener.getFilename());
		if (file.exists()) {
			file = new File(fileContener.getFilename() + "2");
		}
		try {
			file.createNewFile();
			BufferedWriter out;
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

			for (String courrent : fileContener.getFilecontents()) {
				out.write(courrent);
			}
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public ArrayList<String> dir() {
		ArrayList<String> results = new ArrayList<String>();

		File[] files = new File("").listFiles();

		for (File file : files) {
			if (file.isFile()) {
				results.add(file.getName());
			}
		}
		System.out.println(results.toString());

		return results;
	}

	private File _sharedDirectory;
	private LinkedList<User> _clients;
	private ServerCommunication _serverCommunication;

	public FileServerImplementation(String sharedDir, ServerCommunication serverCommunication) {
		_sharedDirectory = new File(sharedDir);
		_serverCommunication = serverCommunication;

		if (!_sharedDirectory.isDirectory()) {
			throw new InvalidParameterException();
		}
	}

	public LinkedList<User> getClients() {
		return _clients;
	}
}
