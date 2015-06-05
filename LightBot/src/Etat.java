
public enum Etat {

	BLOQUE("Bloque"), NONBLOQUE("Non bloque");
	
	private String etat;
	
	private Etat(String e) {
		this.etat = e;
	}
	
	public String toString() {
		return this.etat;
	}
	
}
