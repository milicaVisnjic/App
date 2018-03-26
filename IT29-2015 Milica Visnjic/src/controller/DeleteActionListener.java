package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import model.ShapeRepository;
import view.Brisanje;
import view.GuiCrtanje;

public class DeleteActionListener implements ActionListener {
	
	private GuiCrtanje gui;
	private ShapeRepository repository;
	
	
	public DeleteActionListener(GuiCrtanje gui) {
		super();
		this.gui = gui;
		repository = ShapeRepository.getInstance();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		Brisanje b= new Brisanje();
		b.setVisible(true);
		
		if (b.getOptions()==1)
		{
			CommandManager commandManager = CommandManager.getInstance();
			DeleteCommand deleteCommand = new DeleteCommand(repository.getSelectedShapes());
			commandManager.addCommand(deleteCommand);
			deleteCommand.execute();
			
			gui.getUndoButton().setEnabled(true);
			gui.getRedoButton().setEnabled(false);

			
		}
	
	
	}


}
