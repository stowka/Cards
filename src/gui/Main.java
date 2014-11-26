package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame {

	public Main() {
		super();
		setTitle("Card game - Beliter");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(640, 480));
	}
}
