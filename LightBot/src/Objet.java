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
	
	public Couleur toCouleur(){
		if (Objet.FRAISE == this){
			return Couleur.ROUGE;
		}
		if (Objet.PASTEQUE == this){
			return Couleur.VERT;
		}
		if (Objet.MYRTILLE == this){
			return Couleur.VIOLET;
		}
		return Couleur.BLANC;
	}
	
}
