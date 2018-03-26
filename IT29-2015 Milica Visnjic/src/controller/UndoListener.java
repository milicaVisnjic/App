package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ShapeRepository;
import view.GuiCrtanje;

public class UndoListener implements ActionListener {
	
	private GuiCrtanje gui;
	
	
	public UndoListener(GuiCrtanje gui) {
		super();
		this.gui = gui;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		ShapeRepository.getInstance().removeSelectedShapes();
		CommandManager commandManager = CommandManager.getInstance();
		int index = commandManager.getIndex();
		AbstractComand command = commandManager.getCommand(index);
		command.unexecute();
		commandManager.setIndex(index-1);
		
		gui.getRedoButton().setEnabled(true);
		if(index == 0) {
			gui.getUndoButton().setEnabled(false);
		}

	}

}
