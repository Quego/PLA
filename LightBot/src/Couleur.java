
public enum Couleur {

	BLANC("Blanc"), GRIS("Gris"), BLEU("Bleu"), JAUNE("Jaune"), ROUGE("Rouge"), VERT("Vert");
	
	private String couleur;
	
	private Couleur(String c) {
		this.couleur = c;
	}
	
	public String toString() {
		return this.couleur;
	}
	
}
