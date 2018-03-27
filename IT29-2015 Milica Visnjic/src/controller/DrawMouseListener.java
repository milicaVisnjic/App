package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import hexagon.Hexagon;
import model.Circle;
import model.HexagonAdapter;
import model.Line;
import model.Point;
import model.Rectangle;
import model.Shape;
import model.ShapeRepository;
import model.Square;
import view.DijalogKrug_HexagonCrtanje;
import view.DijalogKvadrataCrtanje;
import view.DijalogPravougaonikCrtanje;
import view.GuiCrtanje;
import view.State;

public class DrawMouseListener extends MouseAdapter{
	private GuiCrtanje gui;
	private int xTacka;
	private int yTacka;
	private ShapeRepository repository;
	
	
	public DrawMouseListener(GuiCrtanje gui) {
		super();
		this.gui = gui;
		repository = ShapeRepository.getInstance();
	}
	


	@Override
	public void mousePressed(MouseEvent e) {
		Shape shape = null;
		
		if (gui.getstate()== State.POINT)
		{
			int xTacka=e.getX();
			int yTacka=e.getY();
			shape = new Point (xTacka, yTacka, gui.getBtnKontura().getBackground());
		}
		else if (gui.getstate() == State.LINE)
		{
			if(gui.getClick() == 1){
				 xTacka=e.getX();
				 yTacka=e.getY();
				 gui.setClick(2);
			}else{
				 int xTacka1=e.getX();
				 int yTacka1=e.getY();
				 
				 shape = new Line( new Point(xTacka,yTacka), new Point(xTacka1,yTacka1),gui.getBtnKontura().getBackground());
				 gui.setClick(1);
			}

		}
		
		else if (gui.getstate() == State.SQUARE)
		{
			xTacka=e.getX();
			yTacka=e.getY();
			DijalogKvadrataCrtanje dk = new DijalogKvadrataCrtanje();
			dk.setVisible(true);
			if(dk.isEnteredData()) {
				shape=new Square(new Point(xTacka, yTacka), dk.getSideLength(), gui.getBtnKontura().getBackground(), gui.getBtnUnutrasnjost().getBackground());
			}
		}
		else if (gui.getstate() == State.RECTANGLE)
		{
			
				xTacka=e.getX();
				yTacka=e.getY();
				
				DijalogPravougaonikCrtanje dijalogPravougaonik = new DijalogPravougaonikCrtanje();
				dijalogPravougaonik.setVisible(true);
				if(dijalogPravougaonik.isEnteredData()) {
					shape= new Rectangle(new Point(xTacka, yTacka), dijalogPravougaonik.getWidthRectangle(),dijalogPravougaonik.getHeightRectangle(),  gui.getBtnKontura().getBackground(), gui.getBtnUnutrasnjost().getBackground());
				}
			
		}
		else if (gui.getstate() == State.CIRCLE)
		{
			xTacka=e.getX();
			yTacka=e.getY();
			//repaint();
			DijalogKrug_HexagonCrtanje dijalogKrug= new DijalogKrug_HexagonCrtanje();
			dijalogKrug.setVisible(true);
			if(dijalogKrug.isEnteredData()) {
				shape= new Circle(new Point(xTacka, yTacka), dijalogKrug.getRadius(), gui.getBtnKontura().getBackground(), gui.getBtnUnutrasnjost().getBackground());
			}
		}else if(gui.getstate() == State.HEXAGON) {
			xTacka=e.getX();
			yTacka=e.getY();
			DijalogKrug_HexagonCrtanje dijalogHexagon= new DijalogKrug_HexagonCrtanje();
			dijalogHexagon.setVisible(true);
			if(dijalogHexagon.isEnteredData()) {
				Hexagon hexagon= new Hexagon(xTacka, yTacka, dijalogHexagon.getRadius());
				hexagon.setAreaColor( gui.getBtnUnutrasnjost().getBackground());
				hexagon.setBorderColor(gui.getBtnKontura().getBackground());
				shape = new HexagonAdapter(hexagon);
			}
			
			
		}else if (gui.getstate() == State.SELECT)
		{
			xTacka=e.getX();
			yTacka=e.getY();
			List<Shape> allShapes = repository.getShapes();
			
			for(int i = allShapes.size() - 1; i >= 0  ; i--)
			{
				if(allShapes.get(i).contains(xTacka, yTacka)){
					Shape selectedShape = allShapes.get(i);
					if(selectedShape.isSelected()) {
						selectedShape.setSelected(false);
						repository.removeSelectedShape(selectedShape);
					
						return;
					}
					repository.addSelectedShape(selectedShape);
					repository.getShapes().remove(i);
					repository.getShapes().add(i, selectedShape);
					
					
					selectedShape.setSelected(true);
					
					gui.repaint();
					return;
				}
				
			}
			repository.removeSelectedShapes();
			repository.getSelectedShapes().stream().forEach(s->s.setSelected(false));
			repository.getShapes().stream().forEach(s->s.setSelected(false));
			gui.repaint();
			
			
		}
		
		if(shape != null) {
			CommandManager commandManager = CommandManager.getInstance();
			AddCommand addCommand = new AddCommand(shape);
			addCommand.execute();
			commandManager.addCommand(addCommand);
			gui.getUndoButton().setEnabled(true);
			gui.getRedoButton().setEnabled(false);
		}
		
		
		
	}
	

}
