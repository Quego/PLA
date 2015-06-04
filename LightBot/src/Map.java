import java.util.List;

public class Map {

	private List<List<Cellule>> map;
	private int largeur, longueur, niveau;
	private String nom;
	
	public Map() {
		this.map = null;
		this.largeur = 0;
		this.longueur = 0;
		this.niveau = 0;
		this.nom = "";
	}
	
	public Map(List<List<Cellule>> m, int la, int lo, int ni, String no) {
		this.map = m;
		this.largeur = la;
		this.longueur = lo;
		this.niveau = ni;
		this.nom = no;
	}
	
	public List<List<Cellule>> getMap() {return this.map;}
	
	public int getLargeur() {return this.largeur;}
	
	public int getLongueur() {return this.longueur;}
	
	public int getNiveau() {return this.niveau;}
	
	public String getNom() {return this.nom;}
	
	public Cellule getCellule(int l, int c) {
		return this.map.get(l).get(c);
	}
	
	public boolean estFini() {
		boolean fini = true;
		for (int i = 0; i < this.longueur; i++) {
			for (int j = 0; j < this.largeur; j++) {
				if (this.getCellule(i, j).getCouleur() == Couleur.BLEU) {
					fini = false;
					break;
				}
			}
			if (!fini) break;
		}
		return fini;
	}
	
	public String toString() {
		return "nom = " + this.nom + "\n" +
			   "niveau = " + this.niveau + "\n" + 
			   "largeur = " + this.largeur + "\n" + 
			   "longueur = " + this.longueur + "\n";
	}
	
}
