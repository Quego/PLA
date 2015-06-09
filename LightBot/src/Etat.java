package src;

public enum Etat {

	INACTIF("Bloque"), ACTIF("Non bloque");
	
	private String etat;
	
	private Etat(String e) {
		this.etat = e;
	}
	
	public String toString() {
		return this.etat;
	}
	
}
