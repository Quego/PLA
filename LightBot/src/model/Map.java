package model;
import java.util.ArrayList;
import java.util.List;

public class Map {

	private List<List<Cellule>> map;
	private int largeur, longueur, niveau, maxActionMain, maxProcedures, maxActionsProcedures;
	private String nom;
	private Position positionInit;
	private List<Action> actionsAutorisees;
	
	public Map() {
		this.map = null;
		this.largeur = 0;
		this.longueur = 0;
		this.niveau = 0;
		this.nom = "";
		this.positionInit = new Position(0, 0);
		this.maxActionMain = 0;
		this.maxProcedures = 0;
		this.maxActionsProcedures = 0;
		this.actionsAutorisees = null;
	}
	
	public Map(List<List<Cellule>> m, int la, int lo, int ni, String no, Position p, int ma, int mp, int map, List<Action> a) {
		this.map = m;
		this.largeur = la;
		this.longueur = lo;
		this.niveau = ni;
		this.nom = no;
		this.positionInit = p;
		this.maxActionMain = ma;
		this.maxProcedures = mp;
		this.maxActionsProcedures = map;
		this.actionsAutorisees = a;
	}
	

	public List<List<Cellule>> getMap() {return this.map;}
	public void initMap() {this.map = new ArrayList<List<Cellule>>();}

	public int getLargeur() {return this.largeur;}
	public void setLargeur(int l) {this.largeur = l;}	

	public int getLongueur() {return this.longueur;}
	public void setLongueur(int l) {this.longueur = l;}

	public int getNiveau() {return this.niveau;}
	public void setNiveau(int n) {this.niveau = n;}

	public int getMaxActionsMain() {return this.maxActionMain;}
	public void setMaxActionsMain(int m) {this.maxActionMain = m;}

	public int getMaxProcedures() {return this.maxProcedures;}
	public void setMaxProcedures(int m) {this.maxProcedures = m;}	

	public int getMaxActionsProcedures() {return this.maxActionsProcedures;}
	public void setMaxActionsProcedures(int m) {this.maxActionsProcedures = m;}

	public String getNom() {return this.nom;}
	public void setNom(String n) {this.nom = n;}
	
	public List<Action> getActionsAutorisees() {return this.actionsAutorisees;}
	public void initActionsAutorisees() {this.actionsAutorisees = new ArrayList<Action>();}
	
	// A garder pour le moment (XML)
	public Cellule getCellule(int l, int c) {
		return this.map.get(l).get(c);
	}
	
	public Cellule getCellule(Position p) {return map.get(p.getL()).get(p.getC());}	
	
	public boolean estFini() {
		boolean fini = true;
		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {
				if (getCellule(i, j).getCouleur() == Couleur.BLEU) {
					fini = false;
					break;
				}
			}
			if (!fini) break;
		}
		return fini;
	}
	
	public Position getPositionInit() {
		return this.positionInit;
	}
	
	public String toString() {
		return "Nom = " + nom + "\n" +
			   "Niveau = " + niveau + "\n" + 
			   "Largeur = " + largeur + "\n" + 
			   "Longueur = " + longueur + "\n" +
			   "Position Initiale = " + positionInit + "\n";
	}
	
}
