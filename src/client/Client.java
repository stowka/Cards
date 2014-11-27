package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private String hostname;
	private int port;
	private Socket socketClient;
	
	public Client(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}
	
	public void connect() throws UnknownHostException, IOException {
		System.out.println("Attempting to connect to " + hostname + ":" + port);
		socketClient = new Socket(hostname, port);
		System.out.println("Connection established !");
	}
	
	public void readResponse() throws IOException {
		String userInput;
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
		
		System.out.println("Response from server : ");
		
		while ((userInput = stdIn.readLine()) != null) {
			System.out.println(userInput);
		}
	}
	
	public static void main(String args[]) {
		Client client = new Client("127.0.0.1", 8888);
		
		try {
			client.connect();
			client.readResponse();
		} catch (UnknownHostException e) {
			System.err.println("Host unknown !");
		} catch (IOException e) {
			System.err.println("Cannot establish connection. Server may be down.");
		}
		
	}
}
