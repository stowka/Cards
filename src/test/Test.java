package test;

import java.io.IOException;
import java.net.UnknownHostException;

import server.Server;
import client.Client;

public class Test {
	public static void main(String[] argv) {
		new Thread(new Server()).start();
		try {
			Client client = new Client("127.0.0.1", 8888);
			client.connect();
			client.readResponse();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
