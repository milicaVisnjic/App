package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ShapeRepository;
import view.GuiCrtanje;

public class RedoListener implements ActionListener {

	private GuiCrtanje gui;
	
	
	public RedoListener(GuiCrtanje gui) {
		super();
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ShapeRepository.getInstance().removeSelectedShapes();
		CommandManager commandManager = CommandManager.getInstance();
		int index = commandManager.getIndex();
		AbstractComand command = commandManager.getCommand(index+1);
		command.execute();
		commandManager.setIndex(index+1);
		gui.getUndoButton().setEnabled(true);
		if( (index+1) == (commandManager.numberOfCommands()-1) ) {
			gui.getRedoButton().setEnabled(false);
		}
	}

}
