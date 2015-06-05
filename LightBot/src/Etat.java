
public enum Etat {

	ACTIF("Actif"), INACTIF("Inactif");
	
	private String couleur;
	
	private Etat(String e) {
		this.couleur = e;
	}
	
	public String toString() {
		return this.couleur;
	}
	
}
