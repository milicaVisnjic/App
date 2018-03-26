package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SerializeDrawing;
import model.Serializer;

public class LoadDrawingListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Serializer serializer = new Serializer(new SerializeDrawing());
		serializer.load();

	}

}
