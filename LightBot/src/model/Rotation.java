package model;

public enum Rotation {

	GAUCHE("Gauche"), DROITE("Droite");
	
	private String rotation;
	
	private Rotation(String r) {
		this.rotation = r;
	}
	
	public String toString() {
		return this.rotation;
	}
	
}
