package server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable {

	static ServerSocket serverSocket;
	protected final static int port = 8888;

	public Server() {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				new Thread(new Game(serverSocket.accept())).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
