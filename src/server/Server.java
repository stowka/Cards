package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

	static ServerSocket serverSocket;
	protected final static int port = 8888;
	static Socket connection;

	public Server() {
	}

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(port);
			connection = serverSocket.accept();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			bw.write("Hello, World!");
			bw.flush();
			bw.close();
			System.out.println("[SERVER]" + connection);
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
