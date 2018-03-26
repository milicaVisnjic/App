package controller;

import model.Shape;
import model.ShapeRepository;

public class ModificationCommand extends AbstractComand {

	private Shape oldShape;
	private Shape newShape;
	private ShapeRepository repository;

	public ModificationCommand(Shape oldShape, Shape newShape) {
		super();
		this.oldShape =oldShape;
		this.newShape = newShape;
		
		this.repository = ShapeRepository.getInstance();
	}

	@Override
	public void execute() {
		repository.removeSelectedShapes();
		this.oldShape.setSelected(false);
		this.newShape.setSelected(false);
		repository.removeShape(oldShape);
		repository.addShape(newShape);
	}

	@Override
	public void unexecute() {
		repository.removeSelectedShapes();
		this.oldShape.setSelected(false);
		this.newShape.setSelected(false);
		repository.removeShape(newShape);
		repository.addShape(oldShape);
		
	}

	@Override
	public String getDescription() {
		String description = "Modifaction->from "+ oldShape.toString()+" to "+newShape.toString() ;
		return description;
	}
	
}
