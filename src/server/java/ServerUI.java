package server.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class ServerUI {
	private JFrame frame;
	private JButton startButton, stopButton;
	private JLabel titleLabel;
	private JScrollPane logPane;
	private JTextPane log;
	private Server server;

	ServerUI() {
		frame = new JFrame("Server");
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		titleLabel = new JLabel("Server Log");
		log = new JTextPane();
		logPane = new JScrollPane(log);

		frame.setSize(500, 500);
		titleLabel.setBounds(0, 10, 500, 30);
		logPane.setBounds(50, 50, 400, 300);
		startButton.setBounds(100, 400, 100, 40);
		stopButton.setBounds(300, 400, 100, 40);

		titleLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stopButton.setEnabled(false);
		log.setEditable(false);
		log.setBackground(Color.BLACK);
		logPane.setBorder(new MatteBorder(5, 5, 5, 5, Color.GRAY));

		startButton.addActionListener((e) -> {
			log.setText("");
//			server = new Server(log, 3000);
			startButton.setEnabled(false);
			stopButton.setEnabled(true);
		});

		stopButton.addActionListener((e) -> {
			try {
				server.stopServer();
				startButton.setEnabled(true);
				stopButton.setEnabled(false);

			} catch (Exception exc) {
				Server.logWriter("Error in Stop Button : " + exc, Server.error);
			}
		});
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().add(titleLabel);
		frame.getContentPane().add(logPane);
		frame.getContentPane().add(startButton);
		frame.getContentPane().add(stopButton);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		centreWindow(frame);
	}

	public static void centreWindow(Window frame) {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
	}

	public static void main(String[] args) {
		new ServerUI();
	}
}
