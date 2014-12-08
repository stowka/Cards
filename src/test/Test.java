package test;

import server.Server;

public class Test {
	public static void main(String[] argv) {
		new Thread(new Server()).start();
	}
}
