package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Game implements Runnable {
	private Socket connection;
	
	public Game(Socket _connection) {
		connection = _connection;
		writeResponse("Hello, World!");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		writeResponse("" + System.currentTimeMillis());
	}
	
	private void writeResponse(String response) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(
					connection.getOutputStream()));
			bw.write(response);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("Game " + System.currentTimeMillis());
	}

}
