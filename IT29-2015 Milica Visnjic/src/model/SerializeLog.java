package model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import controller.AbstractComand;
import controller.AddCommand;
import controller.CommandManager;
import controller.DeleteCommand;
import controller.ModificationCommand;

public class SerializeLog implements SerializeStrategy{

	private CommandManager manager;
	
	public  SerializeLog() {
		manager = CommandManager.getInstance();
	}
	
	@Override
	public void save() {
		PrintWriter out = null;
		try {
			out = new PrintWriter("log.txt");
			for(int i = 0 ; i < manager.numberOfCommands(); i++) {
				AbstractComand command = manager.getCommand(i);
				out.write(command.getDescription());
				out.write("\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
		}
		
	}

	@Override
	public void load() {
		
		Scanner scanner = new Scanner("log.txt");
		
		while(scanner.hasNextLine()) {
			AbstractComand command=null;
			Shape shape =null;
			Shape newShape = null;
			String line = scanner.nextLine();
			String[] splitLine =line.split("->");
			
			String[] shapeLine = splitLine[1].split(":");
			
			String shapeString = shapeLine[0]; 
			switch(shapeString) {
				case "Point" : {
					//shapeLine.
					//shape = new Point(x, y, color)
					//ovde smo stali!!!!!
				}
				case "Line" :{}
				case "Square":{}
				case "Rectangle":{}
				case "Circle":{}
				case "Hexagon":{}
			
			}
			
			
			String commandString = splitLine[0];
			if(commandString.equals("Add")) {
				command = new AddCommand(shape);
			}else if(commandString.equals("Delete")) {
				//command = new DeleteCommand(shape);
			}else if(commandString.equals("Modification")) {
				command = new ModificationCommand(shape, newShape);
			}
			
			command.execute();
			
		}
		
	}

}
