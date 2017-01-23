package oo.ego8769.seminar.netzwerk.server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import oo.ego8769.seminar.netzwerk.exeptions.NotRegistredExeption;

public interface FileServer {

	public boolean verifyLogin(String userName, String password) throws NotRegistredExeption;

	public FileContener get(String fileName) throws FileNotFoundException, IOException;

	public boolean put(FileContener filecontener);

	public ArrayList<String> dir();

}
