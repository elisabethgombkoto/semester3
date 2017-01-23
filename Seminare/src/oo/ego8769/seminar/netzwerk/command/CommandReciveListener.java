package oo.ego8769.seminar.netzwerk.command;

import java.io.IOException;

import oo.ego8769.seminar.netzwerk.exeptions.NotRegistredExeption;

public interface CommandReciveListener {
	void recive(Command command) throws IOException, InterruptedException, NotRegistredExeption;
}
