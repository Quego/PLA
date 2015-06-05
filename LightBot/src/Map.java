import java.util.ArrayList;
import java.util.List;

public class Map {

	private List<List<Cellule>> map;
	private int largeur, longueur, niveau, maxActionsMain, maxProcedures, maxActionsProcedures;
	private String nom;
	private List<Action> actionsAutorisees;
	
	public Map() {
		this.map = null;
		this.largeur = 0;
		this.longueur = 0;
		this.niveau = 0;
		this.nom = "";
		this.actionsAutorisees = null;
		this.maxActionsMain = 0;
		this.maxProcedures = 0;
		this.maxActionsProcedures = 0;
	}
	
	public Map(List<List<Cellule>> m, int la, int lo, int ni, String no, List<Action> a, int mam, int mp, int map) {
		this.map = m;
		this.largeur = la;
		this.longueur = lo;
		this.niveau = ni;
		this.nom = no;
		this.actionsAutorisees = a;
		this.maxActionsMain = mam;
		this.maxProcedures = mp;
		this.maxActionsProcedures = map;
	}
	
	public List<List<Cellule>> getMap() {return this.map;}
	public void initMap() {this.map = new ArrayList<List<Cellule>>();}
	
	public int getLargeur() {return this.largeur;}
	public void setLargeur(int l) {this.largeur = l;}
	
	public int getLongueur() {return this.longueur;}
	public void setLongueur(int l) {this.longueur = l;}
	
	public int getNiveau() {return this.niveau;}
	public void setNiveau(int n) {this.niveau = n;}
	
	public int getMaxActionsMain() {return this.maxActionsMain;}
	public void setMaxActionsMain(int m) {this.maxActionsMain = m;}
	
	public int getMaxProcedures() {return this.maxProcedures;}
	public void setMaxProcedures(int m) {this.maxProcedures = m;}
	
	public int getMaxActionsProcedures() {return this.maxActionsProcedures;}
	public void setMaxActionsProcedures(int m) {this.maxActionsProcedures = m;}
	
	public String getNom() {return this.nom;}
	public void setNom(String n) {this.nom = n;}
	
	public List<Action> getActionsAutorisees() {return this.actionsAutorisees;}
	public void initActionsAutorisees() {this.actionsAutorisees = new ArrayList<Action>();}
	
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
