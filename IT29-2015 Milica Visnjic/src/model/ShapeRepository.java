package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ShapeRepository extends Observable{
	
	private List<Shape> shapes;

	private List<Shape> selectedShapes;
	
	private static ShapeRepository instance = null;
	
	private ShapeRepository() {
		this.shapes = new ArrayList<>();
		this.selectedShapes = new ArrayList<>();
	}
	
	public static ShapeRepository getInstance() {
		if(instance == null) {
			instance = new ShapeRepository();
		}
		return instance;
	}
	
	public List<Shape> getShapes() {
		return shapes;
	}

	public List<Shape> getSelectedShapes() {
		return selectedShapes;
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
		setChanged();
		notifyObservers();
	}
	
	public void removeShape(List<Shape> shapes) {
		this.shapes.removeAll(shapes);
		setChanged();
		notifyObservers();
	}
	
	public void removeShape(Shape shape) {
		this.shapes.remove(shape);
		setChanged();
		notifyObservers();
	}
	
	public void addSelectedShape(Shape shape) {
		selectedShapes.add(shape);
		setChanged();//stavlja flag da se desila promena a notify ce odreagovati tek kada je taj flag ukljucen
		notifyObservers(true);//obavestava sve observere koji posmatraju ovaj objekat
	}
	
	public void removeSelectedShape(Shape shape) {
		selectedShapes.remove(shape);
		setChanged();//stavlja flag da se desila promena a notify ce odreagovati tek kada je taj flag ukljucen
		notifyObservers(true);//obavestava sve observere koji posmatraju ovaj objekat
	}
	
	public void removeSelectedShapes() {
		selectedShapes.clear();
		shapes.stream().forEach(s->s.setSelected(false));
		setChanged();//stavlja flag da se desila promena a notify ce odreagovati tek kada je taj flag ukljucen
		notifyObservers(false);//obavestava sve observere koji posmatraju ovaj objekat
	}
	
	
}
