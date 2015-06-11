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
import org.newdawn.slick.tiled.Layer;
import org.newdawn.slick.tiled.TiledMap;


public class WindowGame extends BasicGameState {
	private GameContainer container;
	private Player player_1;
	private Player player_2;
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
	}
	
	public void enter(GameContainer container, StateBasedGame game) throws SlickException 
		{
		
		this.game = game;
		container.setShowFPS(false);
		}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		

		g.translate(container.getWidth()/3 -this.map.getTilesWidth()/2,
					(container.getHeight()/2-this.map.getHeight()*this.map.getTilesHeight()/2 -this.map.getTilesHeight()/2));	
			
		
	this.map.renderBackground(this.player_1.getLigne(),this.player_1.getColonne());
	//this.map.renderTest();
	this.player_1.render(g);
//	this.player_2.render(g);
	
	this.map.renderForeground(this.player_1.getLigne(),this.player_1.getColonne());
//	this.interf.render(container, game, g);
	//this.map.renderTest();
	}

	public void update(GameContainer container, StateBasedGame game, int delta)throws SlickException{

		this.player_1.update(delta);
	//	this.player_2.update(delta);
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
