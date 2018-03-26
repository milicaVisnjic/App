package controller;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
	private List<AbstractComand> commands;
	private int index;
	private static CommandManager instance=null;
	
	private CommandManager() {
		setIndex(-1);
		commands = new ArrayList<>();
	}
	
	public static CommandManager getInstance() {
		if(instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	public void addCommand(AbstractComand command) {
		if(index != commands.size()-1 ) {//promena za dodatnu komandu u sred undo operacije !!!!!!!!!!!!!!!!!
			for(int i = commands.size()-1; i>index; i--) {
				commands.remove(i);
			}
		}
		commands.add(command);
		setIndex(getIndex() + 1);
		
	}
	
	public void removeCommand(AbstractComand command) {
		commands.remove(command);
		setIndex(getIndex() - 1);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public AbstractComand getCommand(int index) {
		return commands.get(index);
	}
	
	public int numberOfCommands() {
		return commands.size();
	}
	
	
}
