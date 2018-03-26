package model;

import java.awt.font.ShapeGraphicAttribute;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDrawing implements SerializeStrategy {

	
	private ShapeRepository repository;
	
	public  SerializeDrawing() {
		repository = ShapeRepository.getInstance();
	}
	@Override
	public void save() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("drawing.bin"))) ){
			for(Shape shape : repository.getShapes()) {
				oos.writeObject(shape);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void load() {
		
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("drawing.bin"))) ){
			repository.getShapes().clear();
			repository.getSelectedShapes().clear();
			Shape shape;
			while( (shape=(Shape) ois.readObject()) != null) {
					repository.addShape(shape);
			}
		}catch (Exception e) {
			
		}
	}

}
