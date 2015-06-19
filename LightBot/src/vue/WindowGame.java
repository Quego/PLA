package vue;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import enumere.Couleur;
import structure.Controleur;
import structure.Interrupteur;
import structure.Position;
import structure.actions.Allumer;
import structure.actions.Appuyer;
import structure.actions.Avancer;
import structure.actions.Break;
import structure.actions.Envoyer;
import structure.actions.Lacher;
import structure.actions.LockUnlock;
import structure.actions.Sauter;
import structure.actions.TestCaseDevant;
import structure.actions.TestCouleurCase;
import structure.actions.TestSauter;
import structure.actions.TournerD;
import structure.actions.TournerG;


public class WindowGame extends BasicGameState {
	private GameContainer container;
	public static int precedent;
	private Action copie;
	private Image background, menu, aide, finNiv;
	private Action e, e_lock;
	private boolean menu_ouvert = false;
	public static final int ID = 2;
	private Interface interf = new Interface();
	private StateBasedGame game;
	private Map map = new Map();
	private int X, Y, LG;
	private String S;
	
	private Player player_1;
	private Player player_2;
	private Player player;
	
	private List<Action> main = new ArrayList<Action>();
	private List<Action> p1 = new ArrayList<Action>();
	private List<Action> p2 = new ArrayList<Action>();
	private List<Action> tmp;
	private List<Integer> backcpt = new ArrayList<Integer>(), backwhere = new ArrayList<Integer>();
	private List<List<Action>> backup = new ArrayList<List<Action>>();
	private List<structure.actions.Action> actionAutorisees = new ArrayList<structure.actions.Action>();
	private List<Position> casesAleatoires;
	private int cptMain = 0, cptP1 = 0, cptP2 = 0, cpt = 0, where = -1, choix;
	private boolean iftrue, test;
	

	public WindowGame() {}

	public int getID() {
		return ID;
	}

	public void init(GameContainer container, StateBasedGame game) throws SlickException{	
		this.container = container;
		map.init();
		interf.init();
		copie = new Action();
		background = new Image("graphisme/Images/fond/fond_jeu.jpg");
		menu = new Image("graphisme/Images/menu.png");
		aide = new Image("graphisme/Images/actions/aide.gif");
		finNiv = new Image("graphisme/Images/win1.png");
	   	e = new Action();
		e.setImage(new Image("graphisme/Images/actions/emplacement.bmp"));
	   	e_lock = new Action();
		e_lock.setImage(new Image("graphisme/Images/actions/emplacement_lock.bmp"));
		X = 1000;
		Y = 700;
		S = "";
	}
	
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		this.game = game;
		container.setShowFPS(false);
		interf.effacer();
		interf.setCleaning(false);
		switch (precedent) {
		case 11 : background = new Image("graphisme/Images/fond/niv1.png"); map.changeMap("graphisme/map/base_niv1.tmx");  choix = 0;  Controleur.changeMap(choix); break;
		case 12 : background = new Image("graphisme/Images/fond/niv2.png"); map.changeMap("graphisme/map/base_niv2.tmx");  choix = 1;  Controleur.changeMap(choix); break; 
		case 13 : background = new Image("graphisme/Images/fond/niv3.png"); map.changeMap("graphisme/map/base_niv3.tmx");  choix = 2;  Controleur.changeMap(choix); break; 
		case 14 : background = new Image("graphisme/Images/fond/niv4.png"); map.changeMap("graphisme/map/base_niv4.tmx");  choix = 3;  Controleur.changeMap(choix); break; 
		case 15 : background = new Image("graphisme/Images/fond/niv5.png"); map.changeMap("graphisme/map/base_niv5.tmx");  choix = 4;  Controleur.changeMap(choix); break; 
		case 21 : background = new Image("graphisme/Images/fond/niv1.png"); map.changeMap("graphisme/map/if_niv1.tmx");    choix = 5;  Controleur.changeMap(choix); break; 
		case 22 : background = new Image("graphisme/Images/fond/niv2.png"); map.changeMap("graphisme/map/if_niv2.tmx");    choix = 6;  Controleur.changeMap(choix); break; 
		case 23 : background = new Image("graphisme/Images/fond/niv3.png"); map.changeMap("graphisme/map/if_niv3.tmx");    choix = 7;  Controleur.changeMap(choix); break; 
		case 24 : background = new Image("graphisme/Images/fond/niv4.png"); map.changeMap("graphisme/map/if_niv4.tmx");    choix = 8;  Controleur.changeMap(choix); break; 
		case 25 : background = new Image("graphisme/Images/fond/niv5.png"); map.changeMap("graphisme/map/if_niv5.tmx");    choix = 9;  Controleur.changeMap(choix); break; 
		case 31 : background = new Image("graphisme/Images/fond/niv1.png"); map.changeMap("graphisme/map/fruit_niv1.tmx"); choix = 10; Controleur.changeMap(choix); break;
		case 32 : background = new Image("graphisme/Images/fond/niv2.png"); map.changeMap("graphisme/map/fruit_niv2.tmx"); choix = 11; Controleur.changeMap(choix); break;
		case 33 : background = new Image("graphisme/Images/fond/niv3.png"); map.changeMap("graphisme/map/fruit_niv3.tmx"); choix = 12; Controleur.changeMap(choix); break;
		case 34 : background = new Image("graphisme/Images/fond/niv4.png"); map.changeMap("graphisme/map/fruit_niv4.tmx"); choix = 13; Controleur.changeMap(choix); break;
		case 35 : background = new Image("graphisme/Images/fond/niv5.png"); map.changeMap("graphisme/map/fruit_niv5.tmx"); choix = 14; Controleur.changeMap(choix); break;
		case 41 : background = new Image("graphisme/Images/fond/niv1.png"); map.changeMap("graphisme/map/coop_niv1.tmx");  choix = 15; Controleur.changeMap(choix); break;
		case 42 : background = new Image("graphisme/Images/fond/niv2.png"); map.changeMap("graphisme/map/coop_niv2.tmx");  choix = 16; Controleur.changeMap(choix); break;
		case 43 : background = new Image("graphisme/Images/fond/niv3.png"); map.changeMap("graphisme/map/coop_niv3.tmx");  choix = 17; Controleur.changeMap(choix); break;
		case 44 : background = new Image("graphisme/Images/fond/niv4.png"); map.changeMap("graphisme/map/coop_niv4.tmx");  choix = 18; Controleur.changeMap(choix); break;
		case 45 : background = new Image("graphisme/Images/fond/niv5.png"); map.changeMap("graphisme/map/coop_niv5.tmx");  choix = 19; Controleur.changeMap(choix); break;
		case 51 : background = new Image("graphisme/Images/fond/niv1.png"); map.changeMap("graphisme/map/hard_niv1.tmx");  choix = 20; Controleur.changeMap(choix); break;
		case 52 : background = new Image("graphisme/Images/fond/niv2.png"); map.changeMap("graphisme/map/hard_niv2.tmx");  choix = 21; Controleur.changeMap(choix); break;
		case 53 : background = new Image("graphisme/Images/fond/niv3.png"); map.changeMap("graphisme/map/hard_niv3.tmx");  choix = 22; Controleur.changeMap(choix); break;
		case 54 : background = new Image("graphisme/Images/fond/niv4.png"); map.changeMap("graphisme/map/hard_niv4.tmx");  choix = 23; Controleur.changeMap(choix); break;
		case 55 : background = new Image("graphisme/Images/fond/niv5.png"); map.changeMap("graphisme/map/hard_niv5.tmx");  choix = 24; Controleur.changeMap(choix); break;
		default : background = new Image("graphisme/Images/fond/niv1.png"); map.changeMap("graphisme/map/base_niv1.tmx");  choix = 0;  Controleur.changeMap(choix); break; 
		}
		interf.init();
		casesAleatoires = Controleur.casesBlancBleu();
		int nbBot = Controleur.nombreBot();
		player_1 = new Player(map);
		player_1.init();
		player_1.placePlayer(Controleur.positionInit(0).getLigne(), Controleur.positionInit(0).getColonne(), Controleur.hauteurInit(0));
		player_1.setDirection(Controleur.orientationInit(0));
		player_2 = null;
		if (nbBot == 2) {
			player_2 = new Player(map);
			player_2.init();
			player_2.placePlayer(Controleur.positionInit(1).getLigne(), Controleur.positionInit(1).getColonne(), Controleur.hauteurInit(1));
			player_2.setDirection(Controleur.orientationInit(1));
		}
		actionAutorisees = Controleur.getMapCourrante().getActionsAutorisees();
		for (structure.actions.Action act : actionAutorisees) {
			if (act instanceof Allumer)
				interf.getAllumer().setEstBloquee(false);
			if (act instanceof Appuyer)
				interf.getAppuyer().setEstBloquee(false);
			if (act instanceof Avancer)
				interf.getAvancer().setEstBloquee(false);
			if (act instanceof Break)
				interf.getMyBreak().setEstBloquee(false);
			if (act instanceof Envoyer)
				interf.getPrendre().setEstBloquee(false);
			if (act instanceof Lacher)
				interf.getLacher().setEstBloquee(false);
			if (act instanceof LockUnlock)
				interf.getLockUnlock().setEstBloquee(false);
			if (act instanceof Sauter)
				interf.getSauter().setEstBloquee(false);
			if (act instanceof TestCaseDevant)
				interf.getTestAvancer().setEstBloquee(false);
			if (act instanceof TestCouleurCase)
				interf.getTestCaseBleue().setEstBloquee(false);
			if (act instanceof TestSauter)
				interf.getSauter().setEstBloquee(false);
			if (act instanceof TournerD)
				interf.getTournerD().setEstBloquee(false);
			if (act instanceof TournerG)
				interf.getTournerG().setEstBloquee(false);
		}
		if (Controleur.getMapCourrante().getMaxProcedures() == 1) interf.getP1().setEstBloquee(false);
		if (Controleur.getMapCourrante().getMaxProcedures() == 2) {
			interf.getP1().setEstBloquee(false);
			interf.getP2().setEstBloquee(false);
		}
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {	
		background.draw(0,0);
		g.translate(container.getWidth()/3 -map.getTilesWidth()/2,
					(container.getHeight()/2-map.getHeight()*map.getTilesHeight()/2 -map.getTilesHeight()/2));	
		if (player_2 == null) {
			map.renderBackground(player_1.getLigne(),player_1.getColonne());
			player_1.render(g);
			map.renderForeground(player_1.getLigne(),player_1.getColonne());
		} else map.render(player_1,player_2,g);
		interf.render(container, game, g);
		copie.render(container,game,g);
		if(menu_ouvert) menu.draw(1, container.getHeight()/20+1);
		g.resetTransform();
		g.setColor(Color.red);
		aide.draw(X-4, Y-3, LG, 25);
		g.drawString(S,X,Y);
		if (Controleur.getMapCourrante().estFini() && interf.getRunning()) finNiv.draw(0,0);
	}
                                                     
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		player_1.update(delta);
		if (player_2 != null) player_2.update(delta);
		if (Controleur.numeroBot() == 0) player = player_1;
		else player = player_2;
		copie.update();
		int c;
		for (Position p : casesAleatoires) {
			c = map.randomCase(p.getColonne(), p.getLigne());
			if (c == -1) Controleur.getMapCourrante().getCellule(p).setCouleur(Couleur.BLANC);
			if (c == 1) Controleur.getMapCourrante().getCellule(p).setCouleur(Couleur.BLEU);
		}
		if (interf.getRunning()) {
			int res;
			String s = null;
			if(!Controleur.getMapCourrante().estFini() && !player.isRunning() && !player.isJumping() 
			   && !player.isFalling() && !player.isLeft()    && !player.isRight()   && !player.isLightning()) {
				if (cpt < tmp.size()) {
					s = tmp.get(cpt).getNom();
					if (where == 0) {
						cptMain++;
						cpt = cptMain;
					}
					if (where == 1) {
						cptP1++;
						cpt = cptP1;
					}
					if (where == 2) {
						cptP2++;
						cpt = cptP2;
					}
					if (s != null) {
						switch (s) {
						case "Allumer":
							res = new Allumer().executer();
							if (res == 1) {
								map.allume(player.getColonne(),player.getLigne());
								player.setLightning(true);
							}
							break;
						case "Appuyer":
							res = new Appuyer().executer();
							if (res == 1) map.interrup(player.getColonne(),player.getLigne(), 
									((Interrupteur)Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(Controleur.numeroBot()).getPosition())).getCible().getColonne(),
									((Interrupteur)Controleur.getMapCourrante().getCellule(Controleur.getMapCourrante().getBot(Controleur.numeroBot()).getPosition())).getCible().getLigne());
							break;
						case "Avancer":
							res = new Avancer().executer();
							if (res == 1) player.start();
							break;
						case "Break":
							//res = new Break().executer();
							//if (res == 1) 
							break;
						case "Envoyer":
							res = new Envoyer().executer();
						case "Lacher":
							res = new Lacher().executer();
							if (res == 1) map.poseFruit(player.getColonne(),player.getLigne());
							break;
						case "LockUnlock":
							res = new LockUnlock().executer();
							if (res == 1) player = player_1;
							if (res == 2) player = player_2;
							break;
						case "Sauter":
							res = new Sauter().executer();
							if (res == 1)  player.jump();
							if (res == -1) player.down();
							break;
						case "TestCaseDevant":
							res = new TestCaseDevant().executer();
							if (res == 0) iftrue = true;
							if (res == 1) iftrue = false;
							test = true;
							break;
						case "TestCouleurCase":
							res = new TestCouleurCase().executer();
							if (res == 0) iftrue = true; 
							if (res == 1) iftrue = false;
							test = true;
							break;
						case "TestSauter":
							res = new TestSauter().executer();
							if (res == 0) iftrue = true; 
							if (res == 1) iftrue = false;
							test = true;
							break;
						case "TournerD":
							res = new TournerD().executer();
							if (res == 1) player.setDroite();
							break;
						case "TournerG":
							res = new TournerG().executer();
							if (res == 1) player.setGauche();
							break;
						case "P1":
							if (where == 0) {
								backup.add(new ArrayList<Action>(main));
								backcpt.add(Integer.valueOf(cptMain));
								backwhere.add(Integer.valueOf(where));
							}
							if (where == 2) {
								backup.add(new ArrayList<Action>(p2));
								backcpt.add(Integer.valueOf(cptP2));
								backwhere.add(Integer.valueOf(where));
							}
							if (where == 1) {
								cptP1 = 0;
								cpt = 0;
								tmp = new ArrayList<Action>(p1);
							} else {
								where = 1;
								cpt = cptP1;
								tmp = new ArrayList<Action>(p1);
							}
							break;
						case "P2":
							if (where == 0) {
								backup.add(new ArrayList<Action>(main));
								backcpt.add(Integer.valueOf(cptMain));
								backwhere.add(Integer.valueOf(where));
							}
							if (where == 1) {
								backup.add(new ArrayList<Action>(p1));
								backcpt.add(Integer.valueOf(cptP1));
								backwhere.add(Integer.valueOf(where));
							}
							if (where == 2) {
								cptP2 = 0;
								cpt = 0;
								tmp = new ArrayList<Action>(p2);
							} else {
								where = 2;
								cpt = cptP2;
								tmp = new ArrayList<Action>(p2);
							}
							break;
						}
						if (test) {
							if (iftrue) {
								if (cpt < tmp.size() && tmp.get(cpt).getTestFaux() && !tmp.get(cpt).getTestVrai()) {
									while (cpt < tmp.size() && tmp.get(cpt).getTestFaux() && !tmp.get(cpt).getTestVrai()) {
										if (where == 0) {
											cptMain++;
											cpt = cptMain;
										}
										if (where == 1) {
											cptP1++;
											cpt = cptP1;
										}
										if (where == 2) {
											cptP2++;
											cpt = cptP2;
										}
									}
									test = false;
								}
							} else {
								if ((cpt < tmp.size()) && (!tmp.get(cpt).getTestFaux() && tmp.get(cpt).getTestVrai())) {
									while ((cpt < tmp.size()) && (!tmp.get(cpt).getTestFaux() && tmp.get(cpt).getTestVrai())) {
										if (where == 0) {
											cptMain++;
											cpt = cptMain;
										}
										if (where == 1) {
											cptP1++;
											cpt = cptP1;
										}
										if (where == 2) {
											cptP2++;
											cpt = cptP2;
										}
									}
								}
								if (cpt < tmp.size() && !tmp.get(cpt).getTestFaux() && !tmp.get(cpt).getTestVrai()) test = false;
							}
						}
					}
				} else {
					if (cptMain < main.size()) {
						tmp = new ArrayList<Action>(backup.get(backup.size()-1));
						backup.remove(backup.size()-1);
						cpt = backcpt.get(backcpt.size()-1);
						backcpt.remove(backcpt.size()-1);
						if (where == 1) cptP1 = 0;
						if (where == 2) cptP2 = 0;
						where = backwhere.get(backwhere.size()-1);
						backwhere.remove(backwhere.size()-1);
					}
				}
			}
		}
	}
	
	public void mousePressed(int button, int x, int y){
		int decalage = 7;
    	int decalage2 = 28;
    	int lg,h;
		lg = interf.getAvancer().getImage().getWidth();
		h = interf.getAvancer().getImage().getHeight()+10;
		if (button == Input.MOUSE_LEFT_BUTTON){
			// Ecran de fin
			if (Controleur.getMapCourrante().estFini() && interf.getRunning()) {
				switch (precedent) {
					case 11 : 
					case 12 : 
					case 13 : 
					case 14 : 
					case 15 : game.enterState(ChoixBasic.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black)); break;
					case 21 : 
					case 22 : 
					case 23 : 
					case 24 : 
					case 25 : game.enterState(ChoixITE.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black)); break;
					case 31 : 
					case 32 : 
					case 33 : 
					case 34 : 
					case 35 : game.enterState(ChoixFruit.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black)); break;
					case 41 : 
					case 42 : 
					case 43 : 
					case 44 : 
					case 45 : game.enterState(ChoixCoop.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black)); break;
					case 51 : 
					case 52 : 
					case 53 : 
					case 54 : 
					case 55 : game.enterState(ChoixHardLevels.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black)); break;
				}
				interf.setRunning();
				main = new ArrayList<Action>();
				p1 = new ArrayList<Action>();  
				p2 = new ArrayList<Action>();
				Controleur.changeMap(choix);
				try {map.changeMap(map.getPath());} 
				catch (SlickException e) {e.printStackTrace();}
			}
			//menu//
			if (menu_ouvert){
				if(x>0 && x<menu.getWidth() && y>(container.getHeight()/20)+1 && y<(container.getHeight()/20+1+menu.getHeight()/3)){
					switch (precedent) {
						case 11 : 
						case 12 : 
						case 13 : 
						case 14 : 
						case 15 : game.enterState(ChoixBasic.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black)); break;
						case 21 : 
						case 22 : 
						case 23 : 
						case 24 : 
						case 25 : game.enterState(ChoixITE.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black)); break;
						case 31 : 
						case 32 : 
						case 33 : 
						case 34 : 
						case 35 : game.enterState(ChoixFruit.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black)); break;
						case 41 : 
						case 42 : 
						case 43 : 
						case 44 : 
						case 45 : game.enterState(ChoixCoop.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black)); break;
						case 51 : 
						case 52 : 
						case 53 : 
						case 54 : 
						case 55 : game.enterState(ChoixHardLevels.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black)); break;
					}
				}
				else if (x>0 && x<menu.getWidth() && y>(container.getHeight()/20+1+menu.getHeight()/3-1) && y<(container.getHeight()/20+1+menu.getHeight()*2/3)){
					game.enterState(Accueil.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
				}
				else if(x>0 && x<menu.getWidth() && y>(container.getHeight()/20+1+menu.getHeight()*2/3-1) && y<(container.getHeight()/20+1+menu.getHeight())){
					container.exit();
				}
				else {
					menu_ouvert = !menu_ouvert;
				}
			}
			if (x>0 && y>0 && x<50 && y<(container.getHeight()/20)) {
				menu_ouvert = !menu_ouvert;
			}
			//bouton play stop//
			if (x > 2*container.getWidth()/3+20 && y>16*container.getHeight()/20-decalage && x< 2*container.getWidth()/3+20 + 4*container.getHeight()/20 && y < 16*container.getHeight()/20-decalage + 4*container.getHeight()/20){
				interf.setRunning();
				if (interf.getRunning()) {
					main = interf.recupereMain();
					tmp = new ArrayList<Action>(main);
					p1 = interf.recupereP1();
					p2 = interf.recupereP2();
					backcpt = new ArrayList<Integer>();
					backup = new ArrayList<List<Action>>();
					backwhere = new ArrayList<Integer>();
					cptMain = 0;
					cptP1 = 0;
					cptP2 = 0;
					where = 0;
					cpt = cptMain;
				} else {
					player_1.setFin();
					if (player_2 != null) player_2.setFin();
					main = new ArrayList<Action>();
					p1 = new ArrayList<Action>();
					p2 = new ArrayList<Action>();
					tmp = new ArrayList<Action>();
					backcpt = new ArrayList<Integer>();
					backwhere = new ArrayList<Integer>();
					backup = new ArrayList<List<Action>>();
					Controleur.changeMap(choix);
					casesAleatoires = Controleur.casesBlancBleu();
					try {map.changeMap(map.getPath());} 
					catch (SlickException e) {e.printStackTrace();}
					player_1.placePlayer(Controleur.positionInit(0).getLigne(), Controleur.positionInit(0).getColonne(), Controleur.hauteurInit(0));
					player_1.setDirection(Controleur.orientationInit(0));
					player_1.setDestinationX(Controleur.positionInit(0).getLigne());
					player_1.setDestinationY(Controleur.positionInit(0).getColonne());
					if (player_2 != null) {
						player_2.placePlayer(Controleur.positionInit(1).getLigne(), Controleur.positionInit(1).getColonne(), Controleur.hauteurInit(1));
						player_2.setDirection(Controleur.orientationInit(1));
						player_2.setDestinationX(Controleur.positionInit(1).getLigne());
						player_2.setDestinationY(Controleur.positionInit(1).getColonne());
					}
					player = player_1;
				}
			}
			//Musique//
			if (x>container.getWidth()-interf.getMusic().getWidth()-decalage2 && y> 0 && x< container.getWidth()-decalage2-interf.getMusic().getWidth() +container.getHeight()/20 && y < container.getHeight()/20){
				interf.setMusic();
			}
			//choix de l'action//
			if(x>(decalage+20) && x < (decalage+20 + lg) && y>(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + h)){
				if (!this.interf.getAvancer().estBloquee()){
					copie.setImage(interf.getAvancer().getImage().copy());
					copie.setNom("Avancer");
					copie.setX(x-interf.getAvancer().getImage().getWidth()/2);
			    	copie.setY(y-interf.getAvancer().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20+lg+decalage2) && x<(decalage+20+lg+decalage2+lg) && y>(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20+h)){
				if (!this.interf.getAllumer().estBloquee()){
					copie.setImage(interf.getAllumer().getImage().copy());
					copie.setNom("Allumer");
					copie.setX(x-interf.getAllumer().getImage().getWidth()/2);
			    	copie.setY(y-interf.getAllumer().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20+2*lg+2*decalage2) && x < (decalage+20+2*lg+2*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
				if (!this.interf.getTournerG().estBloquee()){
					copie.setImage(interf.getTournerG().getImage().copy());
					copie.setNom("TournerG");
					copie.setX(x-interf.getTournerG().getImage().getWidth()/2);
			    	copie.setY(y-interf.getTournerG().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20+3*lg+3*decalage2) && x < (decalage+20+3*lg+3*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
				if (!this.interf.getTournerD().estBloquee()){
					copie.setImage(interf.getTournerD().getImage().copy());
					copie.setNom("TournerD");
					copie.setX(x-interf.getTournerD().getImage().getWidth()/2);
			    	copie.setY(y-interf.getTournerD().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20+4*lg+4*decalage2) && x < (decalage+20+4*lg+4*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
				if (!this.interf.getSauter().estBloquee()){
					copie.setImage(interf.getSauter().getImage().copy());
					copie.setNom("Sauter");
					copie.setX(x-interf.getSauter().getImage().getWidth()/2);
			    	copie.setY(y-interf.getSauter().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20+5*lg+5*decalage2) && x < (decalage+20+5*lg+5*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
				if (!this.interf.getAppuyer().estBloquee()){
					copie.setImage(interf.getAppuyer().getImage().copy());
					copie.setNom("Appuyer");
					copie.setX(x-interf.getAppuyer().getImage().getWidth()/2);
			    	copie.setY(y-interf.getAppuyer().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20) && x < (decalage+20+ h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
				copie.setImage(interf.getPrendre().getImage().copy());
				copie.setNom("Envoyer");
				copie.setX(x-interf.getPrendre().getImage().getWidth()/2);
		    	copie.setY(y-interf.getPrendre().getImage().getHeight()/2);
			}
			if(x>(decalage+20+lg+decalage2) && x < (decalage+20+lg+decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20 +h+ lg)){
				if (!this.interf.getLacher().estBloquee()){
					copie.setImage(interf.getLacher().getImage().copy());
					copie.setNom("Lacher");
					copie.setX(x-interf.getLacher().getImage().getWidth()/2);
			    	copie.setY(y-interf.getLacher().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20+2*lg+2*decalage2) && x < (decalage+20+3*lg+3*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
				if (!this.interf.getMyBreak().estBloquee()){
					copie.setImage(interf.getMyBreak().getImage().copy());
					copie.setNom("Break");
					copie.setX(x-interf.getMyBreak().getImage().getWidth()/2);
			    	copie.setY(y-interf.getMyBreak().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20+3*lg+3*decalage2) && x < (decalage+20+4*lg+4*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
				if (!this.interf.getTestAvancer().estBloquee()){
					copie.setImage(interf.getTestAvancer().getImage().copy());
					copie.setNom("TestCaseDevant");
					copie.setX(x-interf.getTestAvancer().getImage().getWidth()/2);
			    	copie.setY(y-interf.getTestAvancer().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20+4*lg+4*decalage2) && x < (decalage+20+4*lg+4*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
				if (!this.interf.getTestCaseBleue().estBloquee()){
					copie.setImage(interf.getTestCaseBleue().getImage().copy());
					copie.setNom("TestCouleurCase");
					copie.setX(x-interf.getTestCaseBleue().getImage().getWidth()/2);
			    	copie.setY(y-interf.getTestCaseBleue().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20+7*lg+7*decalage2) && x < (decalage+20+7*lg+7*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
				if (!this.interf.getTestSauter().estBloquee()){
					copie.setImage(interf.getTestSauter().getImage().copy());
					copie.setNom("TestSauter");
					copie.setX(x-interf.getTestSauter().getImage().getWidth()/2);
			    	copie.setY(y-interf.getTestSauter().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20+5*lg+5*decalage2) && x < (decalage+20+5*lg+5*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
				if (!this.interf.getLockUnlock().estBloquee()){
					copie.setImage(interf.getLockUnlock().getImage().copy());
					copie.setNom("LockUnlock");
					copie.setX(x-interf.getLockUnlock().getImage().getWidth()/2);
			    	copie.setY(y-interf.getLockUnlock().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20+6*lg+6*decalage2) && x < (decalage+20+6*lg+6*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
				if (!this.interf.getP1().estBloquee()){
					copie.setImage(interf.getP1().getImage().copy());
					copie.setNom("P1");
					copie.setX(x-interf.getP1().getImage().getWidth()/2);
			    	copie.setY(y-interf.getP1().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20+6*lg+6*decalage2) && x < (decalage+20+6*lg+6*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
				if (!this.interf.getP2().estBloquee()){
					copie.setImage(interf.getP2().getImage().copy());
					copie.setNom("P2");
					copie.setX(x-interf.getP2().getImage().getWidth()/2);
			    	copie.setY(y-interf.getP2().getImage().getHeight()/2);
				}
			}
			if(x>(decalage+20+7*lg+7*decalage2) && x < (decalage+20+7*lg+7*decalage2 + h/3) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
				if(!(this.interf.getTestCaseBleue().estBloquee() && this.interf.getTestAvancer().estBloquee() && this.interf.getTestSauter().estBloquee())){
					copie.setTestFaux(true);
					copie.setTestVrai(false);
				}
			}
			if(x>(decalage+20+7*lg+7*decalage2+h/3) && x < (decalage+20+7*lg+7*decalage2 + h*2/3) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
				if(!(this.interf.getTestCaseBleue().estBloquee() && this.interf.getTestAvancer().estBloquee() && this.interf.getTestSauter().estBloquee())){
					copie.setTestFaux(false);
					copie.setTestVrai(false);
				}
			}
			if(x>(decalage+20+7*lg+7*decalage2+h*2/3) && x < (decalage+20+7*lg+7*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
				if(!(this.interf.getTestCaseBleue().estBloquee() && this.interf.getTestAvancer().estBloquee() && this.interf.getTestSauter().estBloquee())){
					copie.setTestFaux(false);
					copie.setTestVrai(true);
				}
			}
			if(x>2*container.getWidth()/3+20+2*lg+2*decalage2 && y > 16*container.getHeight()/20-decalage && x< 2*container.getWidth()/3+20+2*lg+2*decalage2 + 4*container.getHeight()/20 && y<  16*container.getHeight()/20-decalage + 4*container.getHeight()/20){
				try {
					interf.effacer();
					tmp = new ArrayList<Action>(main);
					backcpt = new ArrayList<Integer>();
					backup = new ArrayList<List<Action>>();
					backwhere = new ArrayList<Integer>();
					Controleur.changeMap(choix);
					casesAleatoires = Controleur.casesBlancBleu();
					try {map.changeMap(map.getPath());} 
					catch (SlickException e) {e.printStackTrace();}
					player_1.placePlayer(Controleur.positionInit(0).getLigne(), Controleur.positionInit(0).getColonne(), Controleur.hauteurInit(0));
					player_1.setDirection(Controleur.orientationInit(0));
					player_1.setDestinationX(Controleur.positionInit(0).getLigne());
					player_1.setDestinationY(Controleur.positionInit(0).getColonne());
					if (player_2 != null) {
						player_2.placePlayer(Controleur.positionInit(1).getLigne(), Controleur.positionInit(1).getColonne(), Controleur.hauteurInit(1));
						player_2.setDirection(Controleur.orientationInit(1));
						player_2.setDestinationX(Controleur.positionInit(1).getLigne());
						player_2.setDestinationY(Controleur.positionInit(1).getColonne());
					}
					player = player_1;
				} catch (SlickException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void mouseDragged(int oldx, int oldy, int newx, int newy){
		S = "";
		X = 1000;
		Y = 700;
		//se souvenir de l action selectionn�e//
		this.copie.setdestX(newx-this.copie.getImage().getWidth()/2);
		this.copie.setdestY(newy-this.copie.getImage().getHeight()/2);
		copie.setdestX(newx-this.copie.getImage().getWidth()/2);
		copie.setdestY(newy-this.copie.getImage().getHeight()/2);
		copie.getImage().draw(newx-this.copie.getImage().getWidth()/2,newy-this.copie.getImage().getHeight()/2);
    }
	
	public void mouseReleased(int button, int x, int y){
    	int decalage = 7;
    	int decalage2 = 28;
    	int lg,h;
    	copie.setdestX(1000);
		copie.setdestY(700);
		lg = interf.getAvancer().getImage().getWidth();
		h = interf.getAvancer().getImage().getHeight()+10;
		//main//
		if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>(container.getHeight()/20+decalage + 30) && y<(container.getHeight()/20+decalage + 30 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement1(new Action(copie)); this.interf.getEmplacement1().setNom(copie.getNom()); break;
				case Input.MOUSE_RIGHT_BUTTON  : this.interf.setEmplacement1(e); break;
			}
    		
		}
    	if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>(container.getHeight()/20+decalage + 30 + h + 10) && y<(container.getHeight()/20+decalage + 30 + h + 10 + h)){
    		switch (button){
	    		case Input.MOUSE_LEFT_BUTTON :  
	    			if (Controleur.getMapCourrante().getMaxActionsMain()>=5) {
		    			this.interf.setEmplacement5(new Action(copie)); 
		    			this.interf.getEmplacement5().setNom(copie.getNom()); 
	    			} else this.interf.setEmplacement5(e_lock); 
	    			break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsMain()>=5) this.interf.setEmplacement5(e);
				else this.interf.setEmplacement5(e_lock); break;
    		}
		}
    	if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>(container.getHeight()/20+decalage + 30 + 2*h + 2*10) && y<(container.getHeight()/20+decalage + 30 + 2*h + 10 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsMain()>=9) {
						this.interf.setEmplacement9(new Action(copie)); 
						this.interf.getEmplacement9().setNom(copie.getNom()); 
					} else this.interf.setEmplacement9(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsMain()>=9) this.interf.setEmplacement9(e);
				else this.interf.setEmplacement9(e_lock); break;
			}
		}
    	if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+lg+decalage2) && y>(container.getHeight()/20+decalage + 30) && y<(container.getHeight()/20+decalage + 30 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsMain()>=2) {
						this.interf.setEmplacement2(new Action(copie)); 
						this.interf.getEmplacement2().setNom(copie.getNom()); 
					} else this.interf.setEmplacement2(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsMain()>=2) this.interf.setEmplacement2(e);
				else this.interf.setEmplacement2(e_lock); break;
		}
		}
    	if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+lg+decalage2) && y>(container.getHeight()/20+decalage + 30 + h + 10) && y<(container.getHeight()/20+decalage + 30 + h + 10 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsMain()>=6) {
						this.interf.setEmplacement6(new Action(copie)); 
						this.interf.getEmplacement6().setNom(copie.getNom()); 
					} else this.interf.setEmplacement6(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsMain()>=6) this.interf.setEmplacement6(e);
				else this.interf.setEmplacement6(e_lock); break;
			}
		}
    	if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+lg+decalage2) && y>(container.getHeight()/20+decalage + 30 + 2*h + 2*10) && y<(container.getHeight()/20+decalage + 30 + 2*h + 10 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsMain()>=10) {
						this.interf.setEmplacement10(new Action(copie)); 
						this.interf.getEmplacement10().setNom(copie.getNom()); 
					} else this.interf.setEmplacement10(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsMain()>=10) this.interf.setEmplacement10(e);
				else this.interf.setEmplacement10(e_lock); break;
			}
		}
    	if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+lg+2*lg+2*decalage2) && y>(container.getHeight()/20+decalage + 30) && y<(container.getHeight()/20+decalage + 30 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsMain()>=3) {
						this.interf.setEmplacement3(new Action(copie)); 
						this.interf.getEmplacement3().setNom(copie.getNom()); 
					} else this.interf.setEmplacement3(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsMain()>=3) this.interf.setEmplacement3(e);
				else this.interf.setEmplacement3(e_lock); break;
			}
		}
    	if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+lg+2*lg+2*decalage2) && y>(container.getHeight()/20+decalage + 30 + h + 10) && y<(container.getHeight()/20+decalage + 30 + h + 10 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsMain()>=7) {
						this.interf.setEmplacement7(new Action(copie)); 
						this.interf.getEmplacement7().setNom(copie.getNom()); 
					} else this.interf.setEmplacement7(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsMain()>=7) this.interf.setEmplacement7(e);
				else this.interf.setEmplacement7(e_lock); break;
			}
		}
    	if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+lg+2*lg+2*decalage2) && y>(container.getHeight()/20+decalage + 30 + 2*h + 2*10) && y<(container.getHeight()/20+decalage + 30 + 2*h + 10 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsMain()>=11) {
						this.interf.setEmplacement11(new Action(copie)); 
						this.interf.getEmplacement11().setNom(copie.getNom()); 
					} else this.interf.setEmplacement11(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsMain()>=11) this.interf.setEmplacement11(e);
				else this.interf.setEmplacement11(e_lock); break;
			}
		}
    	if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+lg+3*lg+3*decalage2) && y>(container.getHeight()/20+decalage + 30) && y<(container.getHeight()/20+decalage + 30 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsMain()>=4) {
						this.interf.setEmplacement4(new Action(copie));
						this.interf.getEmplacement4().setNom(copie.getNom()); 
					} else this.interf.setEmplacement4(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsMain()>=4) this.interf.setEmplacement4(e);
				else this.interf.setEmplacement4(e_lock); break;
			}
		}
    	if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+lg+3*lg+3*decalage2) && y>(container.getHeight()/20+decalage + 30 + h + 10) && y<(container.getHeight()/20+decalage + 30 + h + 10 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsMain()>=8) {
						this.interf.setEmplacement8(new Action(copie)); 
						this.interf.getEmplacement8().setNom(copie.getNom()); 
					} else this.interf.setEmplacement8(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsMain()>=8) this.interf.setEmplacement8(e);
				else this.interf.setEmplacement8(e_lock); break;
			}
		}
    	if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+lg+3*lg+3*decalage2) && y>(container.getHeight()/20+decalage + 30 + 2*h + 2*10) && y<(container.getHeight()/20+decalage + 30 + 2*h + 10 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON :  
				if (Controleur.getMapCourrante().getMaxActionsMain()>=12) {
					this.interf.setEmplacement12(new Action(copie)); 
					this.interf.getEmplacement12().setNom(copie.getNom()); 
				} else this.interf.setEmplacement12(e_lock); 
				break;
			case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsMain()>=12) this.interf.setEmplacement12(e);
				else this.interf.setEmplacement12(e_lock); break;
			}
    	}
    	//P1//
		if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>(7*container.getHeight()/20+2*decalage+5) && y<(7*container.getHeight()/20+2*decalage+5+ h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=1) {
						this.interf.setEmplacement13(new Action(copie)); 
						this.interf.getEmplacement13().setNom(copie.getNom()); 
					} else this.interf.setEmplacement13(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=1) this.interf.setEmplacement13(e);
				else this.interf.setEmplacement13(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>( 7*container.getHeight()/20+2*decalage+ 30 + h + 5) && y<( 7*container.getHeight()/20+2*decalage+ 30 + h + 5+ h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=5) {
						this.interf.setEmplacement17(new Action(copie)); 
						this.interf.getEmplacement17().setNom(copie.getNom()); 
					} else this.interf.setEmplacement17(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=5) this.interf.setEmplacement17(e);
				else this.interf.setEmplacement17(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+decalage2+lg) && y>(7*container.getHeight()/20+2*decalage+30) && y<(7*container.getHeight()/20+2*decalage+30+ h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=2) {
						this.interf.setEmplacement14(new Action(copie)); 
						this.interf.getEmplacement14().setNom(copie.getNom()); 
					} else this.interf.setEmplacement14(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=2) this.interf.setEmplacement14(e);
				else this.interf.setEmplacement14(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+decalage2+lg) && y>(7*container.getHeight()/20+2*decalage+ 30 + h + 5) && y<(7*container.getHeight()/20+2*decalage+ 30 + h + 5 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=6) {
						this.interf.setEmplacement18(new Action(copie)); 
						this.interf.getEmplacement18().setNom(copie.getNom()); 
					} else this.interf.setEmplacement18(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=6) this.interf.setEmplacement18(e);
				else this.interf.setEmplacement18(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+2*lg+2*decalage2+lg) && y>(7*container.getHeight()/20+2*decalage+ 30) && y<(7*container.getHeight()/20+2*decalage+ 30 + h )){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=3) {
						this.interf.setEmplacement15(new Action(copie)); 
						this.interf.getEmplacement15().setNom(copie.getNom()); 
					} else this.interf.setEmplacement15(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=3) this.interf.setEmplacement15(e);
				else this.interf.setEmplacement15(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+2*lg+2*decalage2+lg) && y>(7*container.getHeight()/20+2*decalage+ 30+ h + 5) && y<(7*container.getHeight()/20+2*decalage+ 30 + h + h +5)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=7) {
						this.interf.setEmplacement19(new Action(copie)); 
						this.interf.getEmplacement19().setNom(copie.getNom()); 
					} else this.interf.setEmplacement19(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=7) this.interf.setEmplacement19(e);
				else this.interf.setEmplacement19(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+3*lg+3*decalage2+lg) && y>(7*container.getHeight()/20+2*decalage+30) && y<(7*container.getHeight()/20+2*decalage+30 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=4) {
						this.interf.setEmplacement16(new Action(copie)); 
						this.interf.getEmplacement16().setNom(copie.getNom()); 
					} else this.interf.setEmplacement16(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=4) this.interf.setEmplacement16(e);
				else this.interf.setEmplacement16(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+3*lg+3*decalage2+lg) && y>(7*container.getHeight()/20+2*decalage+ 30 + h + 5) && y<(7*container.getHeight()/20+2*decalage+ 30 + h + 5 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=8) {
						this.interf.setEmplacement20(new Action(copie)); 
						this.interf.getEmplacement20().setNom(copie.getNom()); 
					} else this.interf.setEmplacement20(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=8) this.interf.setEmplacement20(e);
				else this.interf.setEmplacement20(e_lock); break;
			}
		}
		//P2//
		if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>(11*container.getHeight()/20+2*decalage+5) && y<(11*container.getHeight()/20+2*decalage+5+ h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=1) {
						this.interf.setEmplacement21(new Action(copie)); 
						this.interf.getEmplacement21().setNom(copie.getNom()); 
					} else this.interf.setEmplacement21(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=1) this.interf.setEmplacement21(e);
				else this.interf.setEmplacement21(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>( 11*container.getHeight()/20+2*decalage+ 30 + h + 5) && y<( 11*container.getHeight()/20+2*decalage+ 30 + h + 5+ h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=5) {
						this.interf.setEmplacement25(new Action(copie));
						this.interf.getEmplacement25().setNom(copie.getNom()); 
					} else this.interf.setEmplacement25(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=5) this.interf.setEmplacement25(e);
				else this.interf.setEmplacement25(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+decalage2+lg) && y>(11*container.getHeight()/20+2*decalage+30) && y<(11*container.getHeight()/20+2*decalage+30+ h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=2) {
						this.interf.setEmplacement22(new Action(copie)); 
						this.interf.getEmplacement22().setNom(copie.getNom()); 
					} else this.interf.setEmplacement22(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=2) this.interf.setEmplacement22(e);
				else this.interf.setEmplacement22(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+decalage2+lg) && y>(11*container.getHeight()/20+2*decalage+ 30 + h + 5) && y<(11*container.getHeight()/20+2*decalage+ 30 + h + 5 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=6) {
						this.interf.setEmplacement26(new Action(copie)); 
						this.interf.getEmplacement26().setNom(copie.getNom()); 
					} else this.interf.setEmplacement26(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=6) this.interf.setEmplacement26(e);
				else this.interf.setEmplacement26(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+2*lg+2*decalage2+lg) && y>(11*container.getHeight()/20+2*decalage+ 30) && y<(11*container.getHeight()/20+2*decalage+ 30 + h )){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=3) {
						this.interf.setEmplacement23(new Action(copie)); 
						this.interf.getEmplacement23().setNom(copie.getNom()); 
					} else this.interf.setEmplacement23(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=3) this.interf.setEmplacement23(e);
				else this.interf.setEmplacement23(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+2*lg+2*decalage2+lg) && y>(11*container.getHeight()/20+2*decalage+ 30+ h + 5) && y<(11*container.getHeight()/20+2*decalage+ 30 + h + h +5)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=7) {
						this.interf.setEmplacement27(new Action(copie)); 
						this.interf.getEmplacement27().setNom(copie.getNom()); 
					} else this.interf.setEmplacement27(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=7) this.interf.setEmplacement27(e);
				else this.interf.setEmplacement27(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+3*lg+3*decalage2+lg) && y>(11*container.getHeight()/20+2*decalage+30) && y<(11*container.getHeight()/20+2*decalage+30 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=4) {
						this.interf.setEmplacement24(new Action(copie)); 
						this.interf.getEmplacement24().setNom(copie.getNom()); 
					} else this.interf.setEmplacement24(e_lock); 
					break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=4) this.interf.setEmplacement24(e);
				else this.interf.setEmplacement24(e_lock); break;
			}
		}
		if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+3*lg+3*decalage2+lg) && y>(11*container.getHeight()/20+2*decalage+ 30 + h + 5) && y<(11*container.getHeight()/20+2*decalage+ 30 + h + 5 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON :  
					if (Controleur.getMapCourrante().getMaxActionsProcedures()>=8) {
						this.interf.setEmplacement28(new Action(copie)); 
						this.interf.getEmplacement28().setNom(copie.getNom()); 
					}
				else this.interf.setEmplacement28(e_lock); break;
				case Input.MOUSE_RIGHT_BUTTON  : if (Controleur.getMapCourrante().getMaxActionsProcedures()>=8) this.interf.setEmplacement28(e);
				else this.interf.setEmplacement28(e_lock); break;
			}
		}
	}
	
	public void keyPressed(int key, char c) {
		if(!player_1.isRunning() && !player_1.isJumping() && !player_1.isFalling() && !player_1.isLeft() && !player_1.isRight()) {
			this.player_1.setLightning(false);
			switch (key) {
				case Input.KEY_UP:    player_1.start(); break;
				case Input.KEY_LEFT:  player_1.setGauche(); Controleur.orientation(false, 0); break;
				case Input.KEY_RIGHT: player_1.setDroite(); Controleur.orientation(true, 0); break;
				case Input.KEY_J:     player_1.jump(); break;
				case Input.KEY_K:     player_1.down(); break;
				case Input.KEY_A:     this.map.allume(this.player_1.getColonne(),this.player_1.getLigne());this.player_1.setLightning(true); break;
				//case Input.KEY_I:     this.map.interrup(this.player_1.getColonne(),this.player_1.getLigne()); break;
				case Input.KEY_P:     this.map.poseFruit(this.player_1.getColonne(),this.player_1.getLigne()); break;
				case Input.KEY_R:     this.map.prendFruit(this.player_1.getColonne(),this.player_1.getLigne()); break;
			}
		}
		/*if(!player_2.isRunning() && !player_2.isJumping() && !player_2.isFalling() ){
			switch (key) {
		        case Input.KEY_Z:     this.player_2.start(); break;
		        case Input.KEY_Q:     player_2.setGauche(); Controleur.orientation(false, 0); break;
		        case Input.KEY_D:     player_2.setDroite(); Controleur.orientation(true, 0); break;
			}
	    }*/
		switch (key) {
			case Input.KEY_M:		interf.setMusic();break;
			case Input.KEY_ESCAPE: 	menu_ouvert = !menu_ouvert; break;
		}
	}
	
	public void mouseMoved(int oldx, int oldy, int x, int y){
		int decalage = 7;
		int decalage2 = 28;
		int lg = this.interf.getAvancer().getImage().getWidth();
		int h = this.interf.getAvancer().getImage().getHeight();
		S = "";
		X = 1000;
		Y = 700;
		if(x>(decalage+20) && x < (decalage+20 + lg) && y>(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + h)){
			S = "Avancer";
			LG = 72;
			X = x;
			Y = y;
		}
		if(x>(decalage+20+lg+decalage2) && x<(decalage+20+lg+decalage2+lg) && y>(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20+h)){
			S = "Allumer";
			LG = 72;
			X = x;
			Y = y;
		}
		if(x>(decalage+20+2*lg+2*decalage2) && x < (decalage+20+2*lg+2*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
			S = "Tourner a gauche";
			LG = 155;
			X = x;
			Y = y;
		}
		if(x>(decalage+20+3*lg+3*decalage2) && x < (decalage+20+3*lg+3*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
			S = "Tourner a droite";
			LG = 155;
			X = x;
			Y = y;
		}
		if(x>(decalage+20+4*lg+4*decalage2) && x < (decalage+20+4*lg+4*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
			S = "Sauter";
			LG = 65;
			X = x;
			Y = y;
		}
		if(x>(decalage+20+5*lg+5*decalage2) && x < (decalage+20+5*lg+5*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
			S = "Appuyer sur l'interrupteur";
			LG = 250;
			X = x;
			Y = y;
		}
		if(x>(decalage+20+6*lg+6*decalage2) && x < (decalage+20+6*lg+6*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
			S = "Lancer P1";
			LG = 100;
			X = x;
			Y = y;
		}
		if(x>(decalage+20) && x < (decalage+20+ h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			S = "Prendre l'objet";
			LG = 145;
			X = x;
			Y = y;
		}
		if(x>(decalage+20+lg+decalage2) && x < (decalage+20+lg+decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20 +h+ lg)){
			S = "Lacher l'objet";
			LG = 140;
			X = x;
			Y = y;
		}
		if(x>(decalage+20+2*lg+2*decalage2) && x < (decalage+20+3*lg+3*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			S = "Arreter la boucle programmee";
			LG = 265;
			X = x;
			Y = y;
		}
		if(x>(decalage+20+3*lg+3*decalage2) && x < (decalage+20+4*lg+4*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			S = "Avancer ???";
			LG = 110;
			X = x;
			Y = y;
		}
		if(x>(decalage+20+4*lg+4*decalage2) && x < (decalage+20+4*lg+4*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			S = "Case bleue ???";
			LG = 135;
			X = x;
			Y = y;
		}
		if(x>(decalage+20+5*lg+5*decalage2) && x < (decalage+20+5*lg+5*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			S = "Changement de Bot";
			LG = 165;
			X = x;
			Y = y;
		}
		if(x>(decalage+20+6*lg+6*decalage2) && x < (decalage+20+6*lg+6*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			S = "Lancer P2";
			LG = 100;
			X = x;
			Y = y;
		}
		if(x>(decalage+20+7*lg+7*decalage2) && x < (decalage+20+7*lg+7*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			S = "Sauter ???";
			LG = 100;
			X = x;
			Y = y;
		}
		if(x>2*container.getWidth()/3+20+2*lg+2*decalage2 && y > 16*container.getHeight()/20-decalage && x< 2*container.getWidth()/3+20+2*lg+2*decalage2 + 4*container.getHeight()/20 && y<  16*container.getHeight()/20-decalage + 4*container.getHeight()/20){
			S = "Effacer les actions donnees";
			LG = 255;
			X = 750;
			Y = y;
		}
		Y -= 17; 
	}
	
}
