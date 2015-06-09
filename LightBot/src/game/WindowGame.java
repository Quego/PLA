package game;


import org.newdawn.slick.Animation;
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
import org.newdawn.slick.tiled.TiledMap;


public class WindowGame extends BasicGameState {
	private GameContainer container;
	private Player player_1;
	private Player player_2;

	public static final int ID = 2;

	public static int time;
	private StateBasedGame game;
	private Map map = new Map();

	boolean pause = false;
	
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
	}
	
	public void enter(GameContainer container, StateBasedGame game) throws SlickException 
		{
		
		this.game = game;
		container.setShowFPS(false);

		//PAUSE = new Image("src/graphisme/main/ressources/map/image/Pause.jpeg");

		
		
		}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		if(pause)
		{
		     // PAUSE.draw(0,0);
		      g.setColor(Color.white);
		      g.drawString("Resume (P)", 250, 100);
		      g.drawString("Main Menu (SPACE)", 250, 150);
		      g.drawString("Quit Game (ESCAPE)", 250, 200);	
		}
		else
		{

		//g.translate(this.map.getSizeX()/4*map.getTilesWidth()+3*map.getTilesWidth()/2, 0);
			g.translate(container.getWidth()/3 -this.map.getTilesWidth()/2,
						(container.getHeight()/2-this.map.getHeight()*this.map.getTilesHeight()/2 -this.map.getTilesHeight()/2));	
			
		
		this.map.renderBackground(this.player_1.getLigne()/*14*/);
		
		this.player_1.render(g);
		this.player_2.render(g);
		this.map.renderForeground(this.player_1.getLigne());
		}
		


	}

	public void update(GameContainer container, StateBasedGame game, int delta)throws SlickException{
		this.player_1.update(delta);
		this.player_2.update(delta);
	}

	public void keyPressed(int key, char c) {
		if(!this.player_1.isRunning()){
			switch (key) {
			case Input.KEY_UP:    this.player_1.setDirection(0); this.player_1.start(); break;
			case Input.KEY_LEFT:  this.player_1.setDirection(1); this.player_1.start(); break;
			case Input.KEY_DOWN:  this.player_1.setDirection(2); this.player_1.start(); break;
			case Input.KEY_RIGHT: this.player_1.setDirection(3); this.player_1.start(); break;
			}
		}
		if(!this.player_2.isRunning()){
			switch (key) {
        case Input.KEY_Z:     this.player_2.setDirection(0); this.player_2.start(); break;
        case Input.KEY_Q:     this.player_2.setDirection(1); this.player_2.start(); break;
        case Input.KEY_S:     this.player_2.setDirection(2); this.player_2.start(); break;
        case Input.KEY_D:     this.player_2.setDirection(3); this.player_2.start(); break;
			}
	    }
		switch (key) {
		case Input.KEY_ESCAPE:this.container.exit(); break;
		case Input.KEY_M:this.player_1.incLigne(); break;
		case Input.KEY_L:this.player_1.dincLigne(); break;
		}
	}
	
	public void keyReleased(int key, char c) {
	//    this.player_1.setMoving(false);
	  //  this.player_2.setMoving(false);
	}
	
	

}