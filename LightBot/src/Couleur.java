package src;

public enum Couleur {

	VIOLETINTH("Violet Interrupteur Haut"), VIOLETINTB("Violet Interrupteur Bas"), VERTINTH("Vert Interrupteur Haut"), VERTINTB("Vert Interrupteur Bas"), ORANGE("Orange"), ORANGEINTH("Orange Interrupteur Haut"), ORANGEINTB("Orange Interrupteur Bas"), INDIGO("Indigo"), INDIGOINTH("Indigo Interrupteur Haut"), INDIGOINTB("Indigo Interrupteur Bas"), BLANC("Blanc"), GRIS("Gris"), BLEU("Bleu"), JAUNE("Jaune"), ROUGE("Rouge"), ROUGEAL("Rouge allumé"), VERT("Vert"), VERTAL("Vert allumé"), VIOLET("Violet"), VIOLETAL("Violet allumé");
	
	private String couleur;
	
	private Couleur(String c) {
		this.couleur = c;
	}
	
	public String toString() {
		return this.couleur;
	}
	
	public Couleur toOpposee(){
		if (Couleur.BLEU == this) return Couleur.JAUNE;
		if (Couleur.JAUNE == this) return Couleur.BLEU;
		
		if (Couleur.ROUGE == this) return Couleur.ROUGEAL;
		if (Couleur.ROUGEAL == this) return Couleur.ROUGE;
		
		if (Couleur.VERT == this) return Couleur.VERTAL;
		if (Couleur.VERTAL == this) return Couleur.VERT;
		
		if (Couleur.VIOLET == this) return Couleur.VIOLETAL;
		if (Couleur.VIOLETAL == this) return Couleur.VIOLET;
		
		if (Couleur.VIOLETINTH == this) return Couleur.VIOLETINTB;
		if (Couleur.VIOLETINTB == this) return Couleur.VIOLETINTH;
		
		if (Couleur.VERTINTH == this) return Couleur.VERTINTB;
		if (Couleur.VERTINTB == this) return Couleur.VERTINTH;
		
		if (Couleur.ORANGEINTH == this) return Couleur.ORANGEINTB;
		if (Couleur.ORANGEINTB == this) return Couleur.ORANGEINTH;
		
		if (Couleur.INDIGOINTH == this) return Couleur.INDIGOINTB;
		if (Couleur.INDIGOINTB == this) return Couleur.INDIGOINTH;
		
		return this;
	}
	
}
