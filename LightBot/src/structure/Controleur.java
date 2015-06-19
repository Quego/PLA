package structure;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import enumere.Couleur;
import enumere.Etat;
import vue.Menu;
import xml.XmlReader;


public class Controleur {

	/**
	 * Attributs de la classe Controleur
	 */
	
	public static int resolutionX = 1000;
	public static int resolutionY = 700;	
	
	private static List<Map> maps;
	private static Map mapCourrante;
	
	
	/**
	 * Getteurs - Setteurs
	 */
	
	public static List<Map> getMaps() {return maps;}
	public static void setMaps(List<Map> m) {maps = m;}
	
	public static Map getMapCourrante() {return mapCourrante;}
	public static void setMapCourrante(Map m) {mapCourrante = m;}
	
	
	/**
	 * Constructeur
	 */
	public Controleur() {
		Controleur.setMaps(new ArrayList<Map>());
		Controleur.setMapCourrante(null);
	}
	
	/**
	 * Restaure les maps du fichier XML
	 */
	public void restaure() {
		XmlReader reader = new XmlReader();
		Controleur.setMaps(reader.getMaps());
		Controleur.setMapCourrante(Controleur.maps.get(0));
	}
	
	/**
	 * Démarrage de l'application
	 */
	public void demarrage() {
		try {
			Menu.container = new AppGameContainer(new Menu());
			Menu.container.setDisplayMode(resolutionX,resolutionY,false);
			Menu.container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Change de map
	 * @param choix
	 */
	public static void changeMap(int choix) {
		Controleur.setMapCourrante(Controleur.maps.get(choix));
		Controleur.getMapCourrante().initBot();
		Controleur.getMapCourrante().initMap();
	}
	
	/**
	 * Retourne le nombre de bot pour une map
	 * @return
	 */
	public static int nombreBot() {
		int i = 0;
		if (Controleur.getMapCourrante().getBot1() != null) i++;
		if (Controleur.getMapCourrante().getBot2() != null) i++;
		return i;
	}
	
	/**
	 * Renvoie le numéro du bot actif
	 * @return
	 */
	public static int numeroBot() {
		return (Controleur.getMapCourrante().getBot1().getEtat() == Etat.UNLOCK) ? 0 : 1;
	}
	
	/**
	 * Retourne la position initiale du bot numéro num
	 * @param num
	 * @return
	 */
	public static Position positionInit(int num) {
		return Controleur.getMapCourrante().getBot(num).getInitialeP();
	}
	
	/**
	 * Retourne la hauteur initiale du bot numéro num
	 * @param num
	 * @return
	 */
	public static int hauteurInit(int num) {
		return Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(num).getPosition()).getHauteur();
	}
	
	public static int orientationInit(int num) {
		return Controleur.getMapCourrante().getBot(num).getInitialeO().orientationToInt();
	}
	
	/**
	 * Fonction de démonstration
	 * @param b
	 * @param num
	 */
	public static void orientation(boolean b, int num) {
		if (b) Controleur.getMapCourrante().getBot(num).setOrientationDroite();
		else Controleur.getMapCourrante().getBot(num).setOrientationGauche();
		Controleur.getMapCourrante().getBot(num).setDevant();
	}
	
	public static List<Position> casesBlancBleu() {
		List<Position> pos = new ArrayList<Position>();
		for (int i = 0; i < Controleur.getMapCourrante().getCellules().size(); i++) {
			for (int j = 0; j < Controleur.getMapCourrante().getCellules().get(i).size(); j++) {
				if (Controleur.getMapCourrante().getCellule(new Position(i, j)).getCouleur() == Couleur.BLANCBLEU)
					pos.add(new Position(i, j));
			}
		}
		return pos;
	}
	
}
