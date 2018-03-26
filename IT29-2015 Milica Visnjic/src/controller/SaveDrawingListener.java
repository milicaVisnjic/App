package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SerializeDrawing;
import model.Serializer;

public class SaveDrawingListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Serializer serializer = new Serializer(new SerializeDrawing());
		serializer.save();

	}

}
