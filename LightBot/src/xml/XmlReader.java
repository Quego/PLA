package xml;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import enumere.Couleur;
import enumere.Etat;
import enumere.Objet;
import enumere.Orientation;
import structure.Bot;
import structure.Cellule;
import structure.Interrupteur;
import structure.Map;
import structure.Position;
import structure.actions.Action;


public class XmlReader {
	
	private List<Map> maps = new ArrayList<Map>();
	
	public List<Map> getMaps() {return this.maps;}
	
	public XmlReader() {
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {
				
			boolean nom, niveau, largeur, longueur, maxActionsMain, maxProcedures, maxActionsProcedures, action,
					ligneB, colonneB, etatB, orientation, objetB, hauteurC, couleurC, visibleC, aleatoire,
					hauteurI, couleurI, objetI, ligneI, colonneI, etatI;
			
			int nbL = 0, num = 0;
			
			Map mapCourrante;
			Cellule celluleCourante;
			Bot botCourrant;
			Position positionInitiale, positionCible;
				
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                	//System.out.println("Start Element : " + qName);
                	if (qName.equalsIgnoreCase("map")) {
                		mapCourrante = new Map();
                		mapCourrante.setCellules(new ArrayList<List<Cellule>>());
                		nbL = 0;
                		num = 0;
                	}
	                	if (qName.equalsIgnoreCase("nom")) nom = true;
	                	if (qName.equalsIgnoreCase("niveau")) niveau = true;
	                	if (qName.equalsIgnoreCase("largeur")) largeur = true;
	                	if (qName.equalsIgnoreCase("longueur")) longueur = true;
	                	if (qName.equalsIgnoreCase("maxActionsMain")) maxActionsMain = true;
	                	if (qName.equalsIgnoreCase("maxProcedures")) maxProcedures = true;
	                	if (qName.equalsIgnoreCase("maxActionsProcedures")) maxActionsProcedures = true;
	                	if (qName.equalsIgnoreCase("actions")) mapCourrante.setActionsAutorisees(new ArrayList<Action>());
	                		if (qName.equalsIgnoreCase("action")) action = true;
	                	if (qName.equalsIgnoreCase("bot")) botCourrant = new Bot();
	                		if (qName.equalsIgnoreCase("initiale")) positionInitiale = new Position();
	                			if (qName.equalsIgnoreCase("ligneB")) ligneB = true;
	                			if (qName.equalsIgnoreCase("colonneB")) colonneB = true;
	                		if (qName.equalsIgnoreCase("etatB")) etatB = true;
	                		if (qName.equalsIgnoreCase("orientation")) orientation = true;
	                		if (qName.equalsIgnoreCase("objets"));	// Déja initialisé avec le constructeur de Bot
	                			if (qName.equalsIgnoreCase("objetB")) objetB = true;
	                	if (qName.equalsIgnoreCase("cellule")) celluleCourante = new Cellule();
		                	if (qName.equalsIgnoreCase("hauteurC")) hauteurC = true;
		                	if (qName.equalsIgnoreCase("couleurC")) couleurC = true;
		                	if (qName.equalsIgnoreCase("visibleC")) visibleC = true;
		                	if (qName.equalsIgnoreCase("aleatoire")) aleatoire = true;
		                if (qName.equalsIgnoreCase("interrupteur")) celluleCourante = new Interrupteur();
		                	if (qName.equalsIgnoreCase("hauteurI")) hauteurI = true;
		                	if (qName.equalsIgnoreCase("couleurI")) couleurI = true;
		                	if (qName.equalsIgnoreCase("cible")) positionCible = new Position();
		                		if (qName.equalsIgnoreCase("ligneI")) ligneI = true;
		                		if (qName.equalsIgnoreCase("colonneI")) colonneI = true;
		                	if (qName.equalsIgnoreCase("etatI")) etatI = true;
                }
				
				public void endElement(String uri, String localName, String qName) throws SAXException {
					if (qName.equalsIgnoreCase("map")) maps.add(mapCourrante);
					if (qName.equalsIgnoreCase("bot")) {
						mapCourrante.setBot(num, botCourrant);
						num++;
					}
					if (qName.equalsIgnoreCase("initiale")) {
						botCourrant.setInitialeP(positionInitiale);
						botCourrant.setPosition(positionInitiale);
					}
					if (qName.equalsIgnoreCase("cellule")) {
						int i = nbL / (mapCourrante.getLargeur());
						mapCourrante.getCellules().get(i).add(celluleCourante);
						nbL++;
					}
					if (qName.equalsIgnoreCase("interrupteur")) {
						int i = nbL / (mapCourrante.getLargeur());
						mapCourrante.getCellules().get(i).add((Interrupteur)celluleCourante);
						nbL++;
					}
					if (qName.equalsIgnoreCase("cible")) ((Interrupteur)celluleCourante).setCible(positionCible);
					//System.out.println("End Element :" + qName);
				}
				 
				public void characters(char ch[], int start, int length) throws SAXException {
					String s = new String(ch, start, length);
					if (nom) {
						//System.out.println("Nom : " + s);
						mapCourrante.setNom(s);
						nom = false;
					}
					if (niveau) {
						//System.out.println("Niveau : " + s);
						mapCourrante.setNiveau(Integer.valueOf(s));
						niveau = false;
					}
					if (largeur) {
						//System.out.println("Largeur : " + s);
						mapCourrante.setLargeur(Integer.valueOf(s));
						largeur = false;
					}
					if (longueur) {
						//System.out.println("Longueur : " + s);
						mapCourrante.setLongueur(Integer.valueOf(s));
						for (int i = 0; i < mapCourrante.getLongueur(); i++) {
							mapCourrante.getCellules().add(i, new ArrayList<Cellule>());
						}
						longueur = false;
					}
					if(maxActionsMain) {
						//System.out.println("MaxActionsMain : " + s);
						mapCourrante.setMaxActionsMain(Integer.valueOf(s));
						maxActionsMain = false;								
					}
					if (maxProcedures) {
						//System.out.println("MaxProcedures : " + s);
						mapCourrante.setMaxProcedures(Integer.valueOf(s));
						maxProcedures = false;
					}
					if (maxActionsProcedures) {
						//System.out.println("MaxActionsProcedures : " + s);
						mapCourrante.setMaxActionsProcedures(Integer.valueOf(s));
						maxActionsProcedures = false;
					}
					if (action) {
						//System.out.println("Action : " + s);
						try {
							@SuppressWarnings("unchecked")
							Class<Action> classe = (Class<Action>) Class.forName(s);
							Action act = classe.newInstance();
							mapCourrante.getActionsAutorisees().add(act);
						} catch (Exception e) {
							e.printStackTrace();
						}
						action = false;
					}
					if (ligneB) {
						//System.out.println("Ligne Initiale : " + s);
						positionInitiale.setLigne(Integer.valueOf(s));
						ligneB = false;
					}
					if (colonneB) {
						//System.out.println("Colonne Initiale : " + s);
						positionInitiale.setColonne(Integer.valueOf(s));
						colonneB = false;
					}
					if (etatB) {
						//System.out.println("Etat Bot : " + s);
						botCourrant.setEtat(Etat.valueOf(s));
						etatB = false;
					}
					if (orientation) {
						//System.out.println("Orientation : " + s);
						botCourrant.setOrientation(Orientation.valueOf(s));
						botCourrant.setInitialeO(Orientation.valueOf(s));
						botCourrant.setDevant();
						orientation = false;
					}
					if (objetB) {
						//System.out.println("Objet Bot : " + s);
						botCourrant.getObjets().add(Objet.valueOf(s));
						botCourrant.getInitiauxO().add(Objet.valueOf(s));
						objetB = false;
					}
					if (hauteurC) {
						//System.out.println("Hauteur Cellule : " + s);
						celluleCourante.setHauteur(Integer.valueOf(s));
						hauteurC = false;
					}
					if (couleurC) {
						//System.out.println("Couleur : " + s);
						celluleCourante.setCouleur(Couleur.valueOf(s));
						couleurC = false;
					}
					if (visibleC) {
						//System.out.println("Visible Cellule : " + s);
						celluleCourante.setVisible(Boolean.valueOf(s));
						visibleC = false;
					}
					if (aleatoire) {
						//System.out.println("Aléatoire : " + s);
						celluleCourante.setAleatoire(Boolean.valueOf(s));
						aleatoire = false;
					}
					if (hauteurI) {
						//System.out.println("Hauteur Interrupteur : " + s);
						((Interrupteur)celluleCourante).setHauteur(Integer.valueOf(s));
						hauteurI = false;
					}
					if (couleurI) {
						//System.out.println("Couleur Interrupteur : " + s);
						((Interrupteur)celluleCourante).setCouleur(Couleur.valueOf(s));
						couleurI = false;
					}
					if (objetI) {
						//System.out.println("Objet Interrupteur : " + s);
						((Interrupteur)celluleCourante).setObjet(Objet.valueOf(s));
						objetI = false;
					}
					if (ligneI) {
						//System.out.println("Ligne Cible Interrupteur : " + s);
						positionCible.setLigne(Integer.valueOf(s));
						ligneI = false;
					}
					if (colonneI) {
						//System.out.println("Colonne Cible Interrupteur : " + s);
						positionCible.setColonne(Integer.valueOf(s));
						colonneI = false;
					}
					if (etatI) {
						//System.out.println("Etat Interrupteur : " + s);
						((Interrupteur)celluleCourante).setEtat(Etat.valueOf(s));
						etatI = false;
					}
				}
				
			};
			
			parser.parse("./src/map.xml", handler);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}  
	
}
