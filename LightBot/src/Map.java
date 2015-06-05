import java.util.List;

public class Map {

	private static List<List<Cellule>> map;
	private static int largeur, longueur, niveau;
	private static String nom;
	private static Position positionInit;
	
	public Map() {
		map = null;
		largeur = 0;
		longueur = 0;
		niveau = 0;
		nom = "";
		positionInit = new Position(0, 0);
	}
	
	public Map(List<List<Cellule>> m, int la, int lo, int ni, String no, Position p) {
		map = m;
		largeur = la;
		longueur = lo;
		niveau = ni;
		nom = no;
		positionInit = p;
	}
	
	public static List<List<Cellule>> getMap() {return map;}
	
	public static int getLargeur() {return largeur;}
	
	public static int getLongueur() {return longueur;}
	
	public static int getNiveau() {return niveau;}
	
	public static String getNom() {return nom;}
	
	public static Position getPositionInit() {return positionInit;}
	
	public static Cellule getCellule(Position p) {
		return map.get(p.getL()).get(p.getC());
	}
	
	public static Cellule getCellule(int l, int c) {
		return map.get(l).get(c);
	}
	
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
	
	public String toString() {
		return "Nom = " + nom + "\n" +
			   "Niveau = " + niveau + "\n" + 
			   "Largeur = " + largeur + "\n" + 
			   "Longueur = " + longueur + "\n" +
			   "Position Initiale = " + positionInit + "\n";
	}
	
}
