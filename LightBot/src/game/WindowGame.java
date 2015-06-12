package game;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
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
	private Player player_1;
	private Player player_2;
	private Action copie;
	private Image background;
	private boolean running = false;
	public static final int ID = 2;
	private Interface interf = new Interface();
	private StateBasedGame game;
	private Map map = new Map();

	public WindowGame() {
	}

	public int getID() {
		return ID;
	}

	public void init(GameContainer container, StateBasedGame game) throws SlickException{	
		this.container = container;
		this.map.init(); 
		player_1 = new Player(map); 
		player_2 = new Player(map);
		this.player_1.init();
		this.player_1.placePlayer(2,3);
		this.player_2.init();
		this.player_2.placePlayer(3,2);
		this.interf.init();
		copie = new Action();
		background = new Image("graphisme/Images/fond/fond_jeu.png");
		
	}
	
	public void enter(GameContainer container, StateBasedGame game) throws SlickException 
		{
		
		this.game = game;
		container.setShowFPS(false);
		}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		background.draw(0,0);
		g.translate(container.getWidth()/3 -this.map.getTilesWidth()/2,
					(container.getHeight()/2-this.map.getHeight()*this.map.getTilesHeight()/2 -this.map.getTilesHeight()/2));	
			
		
		
	
	this.map.renderBackground(this.player_1.getLigne(),this.player_1.getColonne());
	//this.map.renderTest();
	this.player_1.render(g);
//	this.player_2.render(g);
	
	this.map.renderForeground(this.player_1.getLigne(),this.player_1.getColonne());
	this.interf.render(container, game, g);
	//this.map.renderTest();
	copie.render(container,game,g);

	}

	public void update(GameContainer container, StateBasedGame game, int delta)throws SlickException{

		this.player_1.update(delta);
//		this.player_2.update(delta);
		this.copie.update();
		this.interf.getAllumer().update();
		this.interf.getAvancer().update();
		this.interf.getTournerG().update();
		this.interf.getTournerD().update();
		this.interf.getSauter().update();
		this.interf.getAppuyer().update();
		this.interf.getPrendre().update();
		this.interf.getLacher().update();
		this.interf.getLockUnlock().update();
		this.interf.getMyBreak().update();
		this.interf.getTestCouleurCase().update();
		this.interf.getTestCaseDevant().update();
	}
	
	public void mouseClicked(int button, int x, int y, int clickCount){
		int decalage = 7;
    	int decalage2 = 28;
    	int lg,h;
		lg = this.interf.getAvancer().getImage().getWidth();
		h = this.interf.getAvancer().getImage().getHeight()+10;
		running = true;
		if (button == Input.MOUSE_LEFT_BUTTON){
		if (x>(container.getWidth()-this.interf.getSon().getWidth())  && y<this.interf.getSon().getHeight()){
			this.interf.setSon();
		}
		if(x>(decalage+20) && x < (decalage+20 + lg) && y>(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20 + h)){
			copie.setImage(this.interf.getAllumer().getImage().copy());
			copie.setX(x-this.interf.getAllumer().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getAllumer().getImage().getHeight()/2);
		}
		if(x>(decalage+20+lg+decalage2) && x<(decalage+20+lg+decalage2+lg) && y>(16*container.getHeight()/20-decalage+20) && y<(16*container.getHeight()/20-decalage+20+h)){
			copie.setImage(this.interf.getAvancer().getImage().copy());
			copie.setX(x-this.interf.getAvancer().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getAvancer().getImage().getHeight()/2);
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
			copie.setImage(this.interf.getTestCaseDevant().getImage().copy());
			copie.setX(x-this.interf.getTestCaseDevant().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getTestCaseDevant().getImage().getHeight()/2);
		}
		if(x>(decalage+20+4*lg+4*decalage2) && x < (decalage+20+4*lg+4*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			copie.setImage(this.interf.getTestCouleurCase().getImage().copy());
			copie.setX(x-this.interf.getTestCouleurCase().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getTestCouleurCase().getImage().getHeight()/2);
		}
		if(x>(decalage+20+5*lg+5*decalage2) && x < (decalage+20+5*lg+5*decalage2 + h) && y >(16*container.getHeight()/20-decalage+20+h) && y<(16*container.getHeight()/20-decalage+20+h + lg)){
			copie.setImage(this.interf.getLockUnlock().getImage().copy());
			copie.setX(x-this.interf.getLockUnlock().getImage().getWidth()/2);
	    	copie.setY(y-this.interf.getLockUnlock().getImage().getHeight()/2);
		}
		}
		
	}
	
    public void mouseDragged(int oldx, int oldy, int newx, int newy){
    	if (running){
    		this.copie.setdestX(newx-this.copie.getImage().getWidth()/2);
    		this.copie.setdestY(newy-this.copie.getImage().getHeight()/2);
    	}
			copie.setdestX(newx-this.copie.getImage().getWidth()/2);
			copie.setdestY(newy-this.copie.getImage().getHeight()/2);
			copie.getImage().draw(newx-this.copie.getImage().getWidth()/2,newy-this.copie.getImage().getHeight()/2);
	
    }
    	
    
    public void mouseReleased(int button, int x, int y){
    	int decalage = 7;
    	int decalage2 = 28;
    	int lg,h;
    	running = false;
    	this.copie.setdestX(1000);
		this.copie.setdestY(700);
		lg = this.interf.getAvancer().getImage().getWidth();
		h = this.interf.getAvancer().getImage().getHeight()+10;
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

    	
    	/*
		//emplacement P1//
		g.drawString("P1", 2*container.getWidth()/3+5, 7*container.getHeight()/20+2*decalage+5);
		
		this.emplacement13.draw(2*container.getWidth()/3+20, 7*container.getHeight()/20+2*decalage+30);
		this.emplacement17.draw(2*container.getWidth()/3+20, 7*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
	
		this.emplacement14.draw(2*container.getWidth()/3+20+this.emplacement1.getWidth()+decalage2 ,7*container.getHeight()/20+2*decalage+30);
		this.emplacement18.draw(2*container.getWidth()/3+20+this.emplacement1.getWidth()+decalage2 ,7*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
		
		this.emplacement15.draw(2*container.getWidth()/3+20+2*this.emplacement1.getWidth()+2*decalage2,7*container.getHeight()/20+2*decalage+30);
		this.emplacement19.draw(2*container.getWidth()/3+20+2*this.emplacement1.getWidth()+2*decalage2,7*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
		
		this.emplacement16.draw(2*container.getWidth()/3+20+3*this.emplacement1.getWidth()+3*decalage2,7*container.getHeight()/20+2*decalage+30);
		this.emplacement20.draw(2*container.getWidth()/3+20+3*this.emplacement1.getWidth()+3*decalage2,7*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
		
		//emplacement P2//
		g.drawString("P2", 2*container.getWidth()/3+5, 11*container.getHeight()/20+2*decalage+5);
		
		this.emplacement21.draw(2*container.getWidth()/3+20, 11*container.getHeight()/20+2*decalage+30);
		this.emplacement25.draw(2*container.getWidth()/3+20, 11*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
	
		this.emplacement22.draw(2*container.getWidth()/3+20+this.emplacement1.getWidth()+decalage2 ,11*container.getHeight()/20+2*decalage+30);
		this.emplacement26.draw(2*container.getWidth()/3+20+this.emplacement1.getWidth()+decalage2 ,11*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
		
		this.emplacement23.draw(2*container.getWidth()/3+20+2*this.emplacement1.getWidth()+2*decalage2,11*container.getHeight()/20+2*decalage+30);
		this.emplacement27.draw(2*container.getWidth()/3+20+2*this.emplacement1.getWidth()+2*decalage2,11*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
		
		this.emplacement24.draw(2*container.getWidth()/3+20+3*this.emplacement1.getWidth()+3*decalage2,11*container.getHeight()/20+2*decalage+30);
		this.emplacement28.draw(2*container.getWidth()/3+20+3*this.emplacement1.getWidth()+3*decalage2,11*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
		*/
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
		case Input.KEY_ESCAPE:this.container.exit(); break;
		}
	}
	
}
