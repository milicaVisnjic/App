package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SerializeLog;
import model.Serializer;

public class SaveLogListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Serializer serializer = new Serializer(new SerializeLog());
		serializer.save();

	}

}
