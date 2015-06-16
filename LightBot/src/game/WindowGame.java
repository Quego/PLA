package game;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.Layer;
import org.newdawn.slick.tiled.TiledMap;


public class WindowGame extends BasicGameState {
	private GameContainer container;
	public static int precedent;
	private Player player_1;
	private Player player_2;
	private Action copie;
	private Image aide; //Matthieu 
	private Image background,menu;
	private boolean running = false, menu_ouvert = false;
	public static final int ID = 2;
	private Interface interf = new Interface();
	private StateBasedGame game;
	private Map map = new Map();
	private int X, Y, LG;//Matthieu : ajout LG
	private String S;
	public WindowGame() {
	}

	public int getID() {
		return ID;
	}
	
	//Matthieu : ajout des init necessaire
	public void init(GameContainer container, StateBasedGame game) throws SlickException{	
		this.container = container;
		map.init();
		player_1 = new Player(map); 
		player_2 = new Player(map);
		this.player_1.init();
		this.player_1.placePlayer(0,0,1);
		this.player_2.init();
		this.player_2.placePlayer(0,0,1);
		this.interf.init();
		copie = new Action();
		background = new Image("graphisme/Images/fond/niv1.png");
		menu = new Image("graphisme/Images/menu.png");
		aide = new Image("graphisme/Images/actions/aide.gif");
		X = 1000;
		Y = 700;
		S = "";
		
	}
	
	public void enter(GameContainer container, StateBasedGame game) throws SlickException 
		{
		this.game = game;
		container.setShowFPS(false);
		switch (precedent) {
			case 11 : this.map.changeMap("graphisme/map/base_niv1.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv1.png"); break;
			case 12 : this.map.changeMap("graphisme/map/base_niv2.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv2.png"); break;
			case 13 : this.map.changeMap("graphisme/map/base_niv3.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv3.png"); break;
			case 14 : this.map.changeMap("graphisme/map/base_niv4.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv4.png"); break;
			case 15 : this.map.changeMap("graphisme/map/base_niv5.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv5.png"); break;
			case 21 : this.map.changeMap("graphisme/map/if_niv1.tmx");  this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv1.png"); break;
			case 22 : this.map.changeMap("graphisme/map/if_niv2.tmx");  this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv2.png"); break;
			case 23 : this.map.changeMap("graphisme/map/if_niv3.tmx");  this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv3.png"); break;
			case 24 : this.map.changeMap("graphisme/map/base_niv4.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv4.png"); break;
			case 25 : this.map.changeMap("graphisme/map/base_niv5.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv5.png"); break;
			case 31 : this.map.changeMap("graphisme/map/fruit_niv1.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv1.png"); break;
			case 32 : this.map.changeMap("graphisme/map/fruit_niv2.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv2.png"); break;
			case 33 : this.map.changeMap("graphisme/map/fruit_niv3.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv3.png"); break;
			case 34 : this.map.changeMap("graphisme/map/fruit_niv4.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv4.png"); break;
			case 35 : this.map.changeMap("graphisme/map/base_niv5.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv5.png"); break;
			case 41 : this.map.changeMap("graphisme/map/coop_niv1.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv1.png"); break;
			case 42 : this.map.changeMap("graphisme/map/coop_niv2.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv2.png"); break;
			case 43 : this.map.changeMap("graphisme/map/coop_niv3.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv3.png"); break;
			case 44 : this.map.changeMap("graphisme/map/coop_niv4.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv4.png"); break;
			case 45 : this.map.changeMap("graphisme/map/base_niv5.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv5.png"); break;
			case 51 : this.map.changeMap("graphisme/map/base_niv1.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv1.png"); break;
			case 52 : this.map.changeMap("graphisme/map/base_niv2.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv2.png"); break;
			case 53 : this.map.changeMap("graphisme/map/base_niv3.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv3.png"); break;
			case 54 : this.map.changeMap("graphisme/map/base_niv4.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv4.png"); break;
			case 55 : this.map.changeMap("graphisme/map/base_niv5.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv5.png"); break;
			default : this.map.changeMap("graphisme/map/base_niv1.tmx");this.player_1.setMap(map); background = new Image("graphisme/Images/fond/niv1.png"); break;
		}
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		background.draw(0,0);
		g.translate(container.getWidth()/3 -this.map.getTilesWidth()/2,
					(container.getHeight()/2-this.map.getHeight()*this.map.getTilesHeight()/2 -this.map.getTilesHeight()/2));	
			
		
		
	
	this.map.renderBackground(this.player_1.getLigne(),this.player_1.getColonne());
	this.player_1.render(g);
//	this.player_2.render(g);
	this.map.renderForeground(this.player_1.getLigne(),this.player_1.getColonne());
	this.interf.render(container, game, g);
	copie.render(container,game,g);
	if(menu_ouvert) menu.draw(1, container.getHeight()/20+1);
	g.resetTransform();
	g.setColor(Color.red);
	aide.draw(X-4, Y-3, LG, 25);
	g.drawString(S,X,Y);
	}

	public void update(GameContainer container, StateBasedGame game, int delta)throws SlickException{

		this.player_1.update(delta);
//		this.player_2.update(delta);
		this.copie.update();
	//	this.map.randomCase(/*colonne*/ 0, /*ligne*/ 0);

	}
	
	public void mousePressed(int button, int x, int y){
		int decalage = 7;
    	int decalage2 = 28;
    	int lg,h;
		lg = this.interf.getAvancer().getImage().getWidth();
		h = this.interf.getAvancer().getImage().getHeight()+10;
		if (button == Input.MOUSE_LEFT_BUTTON){
		//menu//
		if (menu_ouvert){
			if(x>0 && x<this.menu.getWidth() && y>(container.getHeight()/20)+1 && y<(container.getHeight()/20+1+this.menu.getHeight()/3)){
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
			else if (x>0 && x<this.menu.getWidth() && y>(container.getHeight()/20+1+this.menu.getHeight()/3-1) && y<(container.getHeight()/20+1+this.menu.getHeight()*2/3)){
				game.enterState(Choix.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			}
			else if(x>0 && x<this.menu.getWidth() && y>(container.getHeight()/20+1+this.menu.getHeight()*2/3-1) && y<(container.getHeight()/20+1+this.menu.getHeight())){
				container.exit();
			}
			else {
				this.menu_ouvert = !this.menu_ouvert;
			}
		}
		if (x>0 && y>0 && x<50 && y<(container.getHeight()/20)) {
			this.menu_ouvert = !this.menu_ouvert;
		}
		//bouton play stop//
		if (x > 2*container.getWidth()/3+20 && y>16*container.getHeight()/20-decalage && x< 2*container.getWidth()/3+20 + 4*container.getHeight()/20 && y < 16*container.getHeight()/20-decalage + 4*container.getHeight()/20){
			this.interf.setRunning();
		}
		//Musique//
		if (x>container.getWidth()-this.interf.getMusic().getWidth()-decalage2 && y> 0 && x< container.getWidth()-decalage2-this.interf.getMusic().getWidth() +container.getHeight()/20 && y < container.getHeight()/20){
			this.interf.setMusic(); 
			//if(m.playing()) m.pause(); else m.resume();
		}
		//choix de l'action//
		if(x>(decalage+20) && x < (decalage+20 + lg) && y>(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + h)){
			copie.setImage(this.interf.getAvancer().getImage().copy());
			copie.setX(x-this.interf.getAvancer().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getAvancer().getImage().getHeight()/2);
		}
		if(x>(decalage+20+lg+decalage2) && x<(decalage+20+lg+decalage2+lg) && y>(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20+h)){
			copie.setImage(this.interf.getAllumer().getImage().copy());
			copie.setX(x-this.interf.getAllumer().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getAllumer().getImage().getHeight()/2);
		}
		if(x>(decalage+20+2*lg+2*decalage2) && x < (decalage+20+2*lg+2*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
			copie.setImage(this.interf.getTournerG().getImage().copy());
			copie.setX(x-this.interf.getTournerG().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getTournerG().getImage().getHeight()/2);
		}
		if(x>(decalage+20+3*lg+3*decalage2) && x < (decalage+20+3*lg+3*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
			copie.setImage(this.interf.getTournerD().getImage().copy());
			copie.setX(x-this.interf.getTournerD().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getTournerD().getImage().getHeight()/2);
		}
		if(x>(decalage+20+4*lg+4*decalage2) && x < (decalage+20+4*lg+4*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
			copie.setImage(this.interf.getSauter().getImage().copy());
			copie.setX(x-this.interf.getSauter().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getSauter().getImage().getHeight()/2);
		}
		if(x>(decalage+20+5*lg+5*decalage2) && x < (decalage+20+5*lg+5*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
			copie.setImage(this.interf.getAppuyer().getImage().copy());
			copie.setX(x-this.interf.getAppuyer().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getAppuyer().getImage().getHeight()/2);
		}
		if(x>(decalage+20+6*lg+6*decalage2) && x < (decalage+20+6*lg+6*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + lg)){
			copie.setImage(this.interf.getP1().getImage().copy());
			copie.setX(x-this.interf.getP1().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getP1().getImage().getHeight()/2);
		}
		if(x>(decalage+20) && x < (decalage+20+ h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			copie.setImage(this.interf.getPrendre().getImage().copy());
			copie.setX(x-this.interf.getPrendre().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getPrendre().getImage().getHeight()/2);
		}
		if(x>(decalage+20+lg+decalage2) && x < (decalage+20+lg+decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20 +h+ lg)){
			copie.setImage(this.interf.getLacher().getImage().copy());
			copie.setX(x-this.interf.getLacher().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getLacher().getImage().getHeight()/2);
		}
		if(x>(decalage+20+2*lg+2*decalage2) && x < (decalage+20+3*lg+3*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			copie.setImage(this.interf.getMyBreak().getImage().copy());
			copie.setX(x-this.interf.getMyBreak().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getMyBreak().getImage().getHeight()/2);
		}
		if(x>(decalage+20+3*lg+3*decalage2) && x < (decalage+20+4*lg+4*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			copie.setImage(this.interf.getTestAvancer().getImage().copy());
			copie.setX(x-this.interf.getTestAvancer().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getTestAvancer().getImage().getHeight()/2);
		}
		if(x>(decalage+20+4*lg+4*decalage2) && x < (decalage+20+4*lg+4*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			copie.setImage(this.interf.getTestCaseBleue().getImage().copy());
			copie.setX(x-this.interf.getTestCaseBleue().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getTestCaseBleue().getImage().getHeight()/2);
		}
		if(x>(decalage+20+5*lg+5*decalage2) && x < (decalage+20+5*lg+5*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			copie.setImage(this.interf.getLockUnlock().getImage().copy());
			copie.setX(x-this.interf.getLockUnlock().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getLockUnlock().getImage().getHeight()/2);
		}
		if(x>(decalage+20+6*lg+6*decalage2) && x < (decalage+20+6*lg+6*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			copie.setImage(this.interf.getP2().getImage().copy());
			copie.setX(x-this.interf.getP2().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getP2().getImage().getHeight()/2);
		}
		if(x>(decalage+20+7*lg+7*decalage2) && x < (decalage+20+7*lg+7*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			copie.setImage(this.interf.getTestSauter().getImage().copy());
			copie.setX(x-this.interf.getTestSauter().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getTestSauter().getImage().getHeight()/2);
		}
		if(x>2*container.getWidth()/3+20+2*lg+2*decalage2 && y > 16*container.getHeight()/20-decalage && x< 2*container.getWidth()/3+20+2*lg+2*decalage2 + 4*container.getHeight()/20 && y<  16*container.getHeight()/20-decalage + 4*container.getHeight()/20){
			try {
				this.interf.effacer();
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
    	this.copie.setdestX(1000);
		this.copie.setdestY(700);
		lg = this.interf.getAvancer().getImage().getWidth();
		h = this.interf.getAvancer().getImage().getHeight()+10;
		//main//
    	if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>(container.getHeight()/20+decalage + 30) && y<(container.getHeight()/20+decalage + 30 + h)){
			switch (button){
				case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement1(copie.getImage()); break;
				case Input.MOUSE_RIGHT_BUTTON  : try {
					this.interf.setEmplacement1(new Image("graphisme/Images/actions/emplacement.bmp"));
				} catch (SlickException e) {
					e.printStackTrace();
				} break;
			}
    		
		}
    	if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>(container.getHeight()/20+decalage + 30 + h + 10) && y<(container.getHeight()/20+decalage + 30 + h + 10 + h)){
    		switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement5(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement5(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
    	if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>(container.getHeight()/20+decalage + 30 + 2*h + 2*10) && y<(container.getHeight()/20+decalage + 30 + 2*h + 10 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement9(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement9(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
    	if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+lg+decalage2) && y>(container.getHeight()/20+decalage + 30) && y<(container.getHeight()/20+decalage + 30 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement2(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement2(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
    	if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+lg+decalage2) && y>(container.getHeight()/20+decalage + 30 + h + 10) && y<(container.getHeight()/20+decalage + 30 + h + 10 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement6(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement6(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
    	if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+lg+decalage2) && y>(container.getHeight()/20+decalage + 30 + 2*h + 2*10) && y<(container.getHeight()/20+decalage + 30 + 2*h + 10 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement10(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement10(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
    	if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+lg+2*lg+2*decalage2) && y>(container.getHeight()/20+decalage + 30) && y<(container.getHeight()/20+decalage + 30 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement3(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement3(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
    	if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+lg+2*lg+2*decalage2) && y>(container.getHeight()/20+decalage + 30 + h + 10) && y<(container.getHeight()/20+decalage + 30 + h + 10 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement7(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement7(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
    	if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+lg+2*lg+2*decalage2) && y>(container.getHeight()/20+decalage + 30 + 2*h + 2*10) && y<(container.getHeight()/20+decalage + 30 + 2*h + 10 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement11(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement11(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
    	if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+lg+3*lg+3*decalage2) && y>(container.getHeight()/20+decalage + 30) && y<(container.getHeight()/20+decalage + 30 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement4(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement4(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
    	if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+lg+3*lg+3*decalage2) && y>(container.getHeight()/20+decalage + 30 + h + 10) && y<(container.getHeight()/20+decalage + 30 + h + 10 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement8(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement8(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
    	if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+lg+3*lg+3*decalage2) && y>(container.getHeight()/20+decalage + 30 + 2*h + 2*10) && y<(container.getHeight()/20+decalage + 30 + 2*h + 10 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement12(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement12(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
    	}
    	//P1//
		if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>(7*container.getHeight()/20+2*decalage+5) && y<(7*container.getHeight()/20+2*decalage+5+ h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement13(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement13(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>( 7*container.getHeight()/20+2*decalage+ 30 + h + 5) && y<( 7*container.getHeight()/20+2*decalage+ 30 + h + 5+ h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement17(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement17(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+decalage2+lg) && y>(7*container.getHeight()/20+2*decalage+30) && y<(7*container.getHeight()/20+2*decalage+30+ h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement14(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement14(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+decalage2+lg) && y>(7*container.getHeight()/20+2*decalage+ 30 + h + 5) && y<(7*container.getHeight()/20+2*decalage+ 30 + h + 5 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement18(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement18(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+2*lg+2*decalage2+lg) && y>(7*container.getHeight()/20+2*decalage+ 30) && y<(7*container.getHeight()/20+2*decalage+ 30 + h )){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement15(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement15(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+2*lg+2*decalage2+lg) && y>(7*container.getHeight()/20+2*decalage+ 30+ h + 5) && y<(7*container.getHeight()/20+2*decalage+ 30 + h + h +5)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement19(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement19(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+3*lg+3*decalage2+lg) && y>(7*container.getHeight()/20+2*decalage+30) && y<(7*container.getHeight()/20+2*decalage+30 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement16(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement16(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+3*lg+3*decalage2+lg) && y>(7*container.getHeight()/20+2*decalage+ 30 + h + 5) && y<(7*container.getHeight()/20+2*decalage+ 30 + h + 5 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement20(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement20(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		//P2//
		if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>(11*container.getHeight()/20+2*decalage+5) && y<(11*container.getHeight()/20+2*decalage+5+ h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement21(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement21(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20) && x<(2*container.getWidth()/3+20+lg) && y>(11*container.getHeight()/20+2*decalage+ 30 + h + 5) && y<(11*container.getHeight()/20+2*decalage+ 30 + h + 5+ h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement25(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement25(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+decalage2+lg) && y>(11*container.getHeight()/20+2*decalage+30) && y<(11*container.getHeight()/20+2*decalage+30+ h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement22(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement22(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20+lg+decalage2) && x<(2*container.getWidth()/3+20+lg+decalage2+lg) && y>(11*container.getHeight()/20+2*decalage+ 30 + h + 5) && y<(11*container.getHeight()/20+2*decalage+ 30 + h + 5 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement26(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement26(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+2*lg+2*decalage2+lg) && y>(11*container.getHeight()/20+2*decalage+ 30) && y<(11*container.getHeight()/20+2*decalage+ 30 + h )){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement23(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement23(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20+2*lg+2*decalage2) && x<(2*container.getWidth()/3+20+2*lg+2*decalage2+lg) && y>(11*container.getHeight()/20+2*decalage+ 30+ h + 5) && y<(11*container.getHeight()/20+2*decalage+ 30 + h + h +5)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement27(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement27(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+3*lg+3*decalage2+lg) && y>(11*container.getHeight()/20+2*decalage+30) && y<(11*container.getHeight()/20+2*decalage+30 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement24(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement24(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		if(x>(2*container.getWidth()/3+20+3*lg+3*decalage2) && x<(2*container.getWidth()/3+20+3*lg+3*decalage2+lg) && y>(11*container.getHeight()/20+2*decalage+ 30 + h + 5) && y<(11*container.getHeight()/20+2*decalage+ 30 + h + 5 + h)){
			switch (button){
			case Input.MOUSE_LEFT_BUTTON : this.interf.setEmplacement28(copie.getImage()); break;
			case Input.MOUSE_RIGHT_BUTTON  : try {
				this.interf.setEmplacement28(new Image("graphisme/Images/actions/emplacement.bmp"));
			} catch (SlickException e) {
				e.printStackTrace();
			} break;
		}
		}
		
		
    }

	public void keyPressed(int key, char c) {
		if(!this.player_1.isRunning() && !this.player_1.isJumping() && !this.player_1.isFalling() ){
			switch (key) {
			case Input.KEY_UP:    this.player_1.start(); break;
			case Input.KEY_LEFT:  this.player_1.setNewDirection(1); break;
			case Input.KEY_RIGHT: this.player_1.setNewDirection(-1); break;
			case Input.KEY_J:     this.player_1.jump(); break;
			case Input.KEY_K:     this.player_1.down(); break;
			case Input.KEY_A:     this.map.allume(this.player_1.getColonne(),this.player_1.getLigne()); break;
			case Input.KEY_I:     this.map.interrup(this.player_1.getColonne(),this.player_1.getLigne()); break;
			case Input.KEY_P:     this.map.poseFruit(this.player_1.getColonne(),this.player_1.getLigne()); break;
			case Input.KEY_R:     this.map.prendFruit(this.player_1.getColonne(),this.player_1.getLigne()); break;
			}
		}
		/*if(!this.player_2.isRunning() && !this.player_2.isJumping() && !this.player_2.isFalling() ){
			switch (key) {
        case Input.KEY_Z:     this.player_2.setDirection(0); this.player_2.start(); break;
        case Input.KEY_Q:     this.player_2.setDirection(1); this.player_2.setNewDirection(1); break;
        case Input.KEY_D:     this.player_2.setDirection(2); this.player_2.setNewDirection(-1); break;
			}
	    }*/
		switch (key) {
		case Input.KEY_M:		/*this.interf.setMusic(); if(m.playing()) m.pause(); else m.resume();*/ break;
		case Input.KEY_ESCAPE: 	this.menu_ouvert = !this.menu_ouvert; break;
		}
		
		
		
		
	}
	
	
	//Matthieu : modif
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
