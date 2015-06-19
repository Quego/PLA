package enumere;


public enum Couleur {

	BLEU("Bleu"), JAUNE("Jaune"), BLANC("Blanc"), GRIS("Gris"), INDIGO("Indigo"), ROUGE("Rouge"), BLANCBLEU("Blanc-Bleu"),
	_ROUGE("_Rouge"), VERT("Vert"), _VERT("_Vert"), VIOLET("Violet"), _VIOLET("_Violet"), INCONNUE("Inconnue"),
	ROUGEIN("RougeIn"), VERTIN("VertIn"), VIOLETIN("VioletIn"), INDIGOIN("IndigoIn");
	
	private String couleur;
	
	private Couleur(String c) {
		this.couleur = c;
	}
	
	public String toString() {
		return this.couleur;
	}
	
}
