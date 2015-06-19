package structure;

import java.util.ArrayList;
import java.util.List;

import structure.actions.Action;
import enumere.Couleur;
import enumere.Etat;
import enumere.Objet;


public class Map {

	/**
	 * Attributs de la classe Map
	 */
	
	private List<List<Cellule>> cellules;
	private int largeur, longueur, niveau, maxActionsMain, maxProcedures, maxActionsProcedures, nbBleu;
	private String nom;
	private List<Action> actionsAutorisees;
	
	private Bot bot1, bot2;
	
	
	/**
	 * Getteurs - Setteurs
	 */
	
	public List<List<Cellule>> getCellules() {return this.cellules;}
	public void setCellules(List<List<Cellule>> c) {this.cellules = c;}
	
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
	
	public int getNbBleu() {return this.nbBleu;}
	public void setNbBleu(int n) {this.nbBleu = n;}
	
	public String getNom() {return this.nom;}
	public void setNom(String n) {this.nom = n;}
	
	public List<Action> getActionsAutorisees() {return this.actionsAutorisees;}
	public void setActionsAutorisees(List<Action> a) {this.actionsAutorisees = a;}
	
	public Bot getBot1() {return this.bot1;}
	private void setBot1(Bot b) {this.bot1 = b;}
	
	public Bot getBot2() {return this.bot2;}
	private void setBot2(Bot b) {this.bot2 = b;}
	
	public Bot getBot(int num) {
		if (num == 0) return this.bot1;
		else if (num == 1) return this.bot2;
		else return null;
	}
	public void setBot(int num, Bot b) {
		if (num == 0) this.setBot1(b);
		else this.setBot2(b);
	}
	
	
	/**
	 * Constructeur
	 */
	public Map() {
		this.setCellules(null);
		this.setLargeur(0);
		this.setLongueur(0);
		this.setNiveau(0);
		this.setMaxActionsMain(0);
		this.setMaxProcedures(0);
		this.setMaxActionsProcedures(0);
		this.setNbBleu(0);
		this.setActionsAutorisees(null);
		this.setBot1(null);
		this.setBot2(null);
	}
	
	public Map(Map m) {
		this.setCellules(new ArrayList<List<Cellule>>(m.getCellules()));
		this.setLargeur(m.getLargeur());
		this.setLongueur(m.getLongueur());
		this.setNiveau(m.getNiveau());
		this.setMaxActionsMain(m.getMaxActionsMain());
		this.setMaxProcedures(m.getMaxProcedures());
		this.setMaxActionsProcedures(m.getMaxActionsProcedures());
		this.setNbBleu(m.getNbBleu());
		this.setActionsAutorisees(m.getActionsAutorisees());
		this.setBot1(m.getBot1());
		this.setBot2(m.getBot2());
	}
	
	/**
	 * Réinitialisation des bots
	 */
	public void initBot() {
		if (bot1 != null) {
			this.bot1.setPosition(bot1.getInitialeP());
			this.bot1.setOrientation(bot1.getInitialeO());
			this.bot1.setDevant();
			this.bot1.setEtat(Etat.UNLOCK);
			List<Objet> backUp = new ArrayList<Objet>();
			for (Objet o : this.bot1.getInitiauxO())
				backUp.add(o);
			this.bot1.setObjets(backUp);
		}
		if (bot2 != null) {
			this.bot2.setPosition(bot2.getInitialeP());
			this.bot2.setOrientation(bot2.getInitialeO());
			this.bot2.setDevant();
			this.bot2.setEtat(Etat.LOCK);
			List<Objet> backUp = new ArrayList<Objet>();
			for (Objet o : this.bot2.getInitiauxO())
				backUp.add(o);
			this.bot2.setObjets(backUp);
		}
	}
	
	/**
	 * Réinitialisation des couleurs des cases _ROUGE, _VERT, _VIOLET, et des interrupteurs
	 * TODO peut mieux faire
	 */
	public void initMap() {
		this.setNbBleu(0);
		for (List<Cellule> l : this.cellules) {
			for (Cellule c : l) {
				if (c.getCouleur() == Couleur.JAUNE && !c.getAleatoire()) {
					c.setCouleur(Couleur.BLEU);
					this.setNbBleu(this.getNbBleu() + 1);
				}
				if (c.getAleatoire()) c.setCouleur(Couleur.BLANCBLEU);
				if (c.getCouleur() == Couleur.BLANCBLEU) this.setNbBleu(this.getNbBleu() + 1);
				if (c.getCouleur() == Couleur._ROUGE) c.setCouleur(Couleur.ROUGE);
				if (c.getCouleur() == Couleur._VERT) c.setCouleur(Couleur.VERT);
				if (c.getCouleur() == Couleur._VIOLET) c.setCouleur(Couleur.VIOLET);
				if (c instanceof Interrupteur) {
					if (((Interrupteur)c).getEtat() == Etat.UNLOCK) {
						Controleur.getMapCourrante().getCellule(((Interrupteur)c).getCible()).setHauteur(
								Controleur.getMapCourrante().getCellule(((Interrupteur)c).getCible()).getHauteur() + 3);
						((Interrupteur)c).setEtat(Etat.LOCK);
					}
				}
			}
		}
	}
	
	/**
	 * Récupère la cellule associée à la position p
	 * @param p
	 * @return
	 */
	public Cellule getCellule(Position p) {
		return this.getCellules().get(p.getLigne()).get(p.getColonne());
	}
	
	/**
	 * Vérification si la case devant est dans la map
	 * @return
	 */
	public boolean estDansMap(int num) {
		int x = getBot(num).getDevant().getLigne();
		int y = getBot(num).getDevant().getColonne();
		return (0 <= x && x < longueur && 0 <= y && y < largeur);
	}
	
	/**
	 * Vérifie si la map est considérée comme finie
	 * @return un booléen associé au prédicat
	 */
	public boolean estFini() {
		boolean fini = true;
		for (List<Cellule> l : this.getCellules()) {
			for (Cellule c : l) {
				if (c.getCouleur() == Couleur.BLEU ||
					c.getCouleur() == Couleur.ROUGE ||
					c.getCouleur() == Couleur.VERT ||
					c.getCouleur() == Couleur.VIOLET ||
					this.getNbBleu() > 0) {
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
			   "Longueur = " + longueur + "\n";
	}
	
}
