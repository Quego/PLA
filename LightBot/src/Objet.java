package src;

public enum Objet {

	FRAISE("Fraise"), PASTEQUE("Pastèque"), MYRTILLE("Myrtille"), RIEN("Rien");
	
	private String objet;
	
	private Objet(String o) {
		this.objet = o;
	}
	
	public String toString() {
		return this.objet;
	}
	
}
