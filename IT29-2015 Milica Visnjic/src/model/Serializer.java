package model;

public class Serializer {
	
	private SerializeStrategy serializeStrategy;
	
	public Serializer(SerializeStrategy serializeStrategy) {
		this.setSerializeStrategy(serializeStrategy);
	}
	public void save() {
		serializeStrategy.save();
	}
	
	public void load() {
		serializeStrategy.load();
	}
	
	public void setSerializeStrategy(SerializeStrategy serializeStrategy) {
		this.serializeStrategy = serializeStrategy;
	}
}
