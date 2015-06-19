package enumere;


public enum Etat {

	LOCK("Lock"), UNLOCK("Unlock");
	
	private String etat;
	
	private Etat(String e) {
		this.etat = e;
	}
	
	public String toString() {
		return this.etat;
	}
	
}
