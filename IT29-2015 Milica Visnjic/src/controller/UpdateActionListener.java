package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Circle;
import model.HexagonAdapter;
import model.Line;
import model.Point;
import model.Rectangle;
import model.Shape;
import model.ShapeRepository;
import model.Square;
import view.DijalogKrugModifikacija;
import view.DijalogKvadratModifikacija;
import view.DijalogLinija;
import view.DijalogPravougaonikModifikacija;
import view.DijalogTackaModifikacija;
import view.GuiCrtanje;

public class UpdateActionListener implements ActionListener{
	private ShapeRepository repository;
	private GuiCrtanje gui;
	

	public UpdateActionListener(GuiCrtanje gui) {
		super();
		repository = ShapeRepository.getInstance();
		this.gui = gui; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(repository.getSelectedShapes().size() != 1) {
			return;
		}
		
		Shape shape = null;
		Shape selectedShape = repository.getSelectedShapes().get(0);
		
		if ( selectedShape instanceof Point)
		{

			 DijalogTackaModifikacija dt = new DijalogTackaModifikacija(selectedShape);
			
		     dt.setVisible(true);
		     
		     if (dt.getPodaci()!=null)
		     {
		    	 shape = dt.getPodaci(); 	
		     }
			
		}else if(selectedShape instanceof Line) {
			DijalogLinija dl = new DijalogLinija(selectedShape);
			dl.setVisible(true);
			 if (dl.getPodaci()!=null)
		     {
		    	 shape = dl.getPodaci(); 	
		     }
		}else if(selectedShape instanceof Rectangle) {
			DijalogPravougaonikModifikacija dp = new DijalogPravougaonikModifikacija(selectedShape);
			dp.setVisible(true);
			 if (dp.getPodaci()!=null)
		     {
		    	 shape = dp.getPodaci(); 	
		     }
		}else if(selectedShape instanceof Square) {
			DijalogKvadratModifikacija dk = new DijalogKvadratModifikacija(selectedShape);
			dk.setVisible(true);
			 if (dk.getPodaci()!=null)
		     {
		    	 shape = dk.getPodaci(); 	
		     }
		}else if(selectedShape instanceof Circle) {
			DijalogKrugModifikacija dk = new DijalogKrugModifikacija(selectedShape);
			dk.setVisible(true);
			 if (dk.getPodaci()!=null)
		     {
		    	 shape = dk.getPodaci(); 	
		     }
		}else if(selectedShape instanceof HexagonAdapter) {
			DijalogKrugModifikacija dk = new DijalogKrugModifikacija(selectedShape);
			dk.setVisible(true);
			 if (dk.getPodaci()!=null)
		     {
		    	 shape = dk.getPodaci(); 	
		     }
		}
		
		if(shape == null) {
			return;
		}
		
		CommandManager commandManager = CommandManager.getInstance();
		ModificationCommand modificationCommand = new ModificationCommand(selectedShape,shape);
		modificationCommand.execute();
		commandManager.addCommand(modificationCommand);
		gui.getUndoButton().setEnabled(true);
		gui.getRedoButton().setEnabled(false);

	}

}
