package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class LogListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JTextPane textPane = new JTextPane();
		
		CommandManager commandManager = CommandManager.getInstance();
		String log = "";
		for(int i = 0 ; i< commandManager.numberOfCommands(); i++) {
			log += commandManager.getCommand(i).getDescription();
			log += "\n";		
		}
		textPane.setText(log);
		
		panel.add(textPane);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		

	}

}
