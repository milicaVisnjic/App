package controller;

import java.util.ArrayList;
import java.util.List;

import model.Shape;
import model.ShapeRepository;

public class DeleteCommand extends AbstractComand{

	private List<Shape> shapes;
	private ShapeRepository repository;
	
	
	public DeleteCommand(List<Shape> shapes) {
		super();
		this.shapes= new ArrayList<>(shapes);
		this.repository = ShapeRepository.getInstance();
	}

	@Override
	public void execute() {
		repository.removeShape(shapes);
		
	}

	@Override
	public void unexecute() {
		for(Shape shape : this.shapes) {
			repository.addShape(shape);
		}
		
	}

	@Override
	public String getDescription() {
		String description= "Delete->";
		for(Shape shape : this.shapes) {
			description+= shape.toString()+"\n\t";
		}
		return description;
	}

}
