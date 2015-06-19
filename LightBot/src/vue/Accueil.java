package vue;

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


public class Accueil extends BasicGameState {
	   
	public static final int ID = 1;
	private StateBasedGame game;
	
	private Image background, jouer;
	
	private int boutonX = 200;
	private int boutonY = 400;
   
	public int getID() {
		return ID;
	}

   public void init(GameContainer container, StateBasedGame game) throws SlickException {
	   	this.game = game;
		this.background = new Image("graphisme/Images/fond/FOND_ACCUEIL.png");
	   	this.jouer = new Image("graphisme/Images/fond/jouer.png");
   }

   
   public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		this.game = game;
		container.setShowFPS(false);
	}
 
   public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
	   this.background.draw(0,0,container.getWidth(),container.getScreenHeight());
	   this.jouer.draw(this.boutonX,this.boutonY);
   }

   public void update(GameContainer container, StateBasedGame game, int delta) {
   }
   
   public void mouseClicked(int button, int x, int y, int ClickCount){
	   if (x>this.boutonX && x<this.boutonX+this.jouer.getWidth() && y>this.boutonY && y<this.boutonY+this.jouer.getHeight()){
		   this.game.enterState(Choix.ID, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
	  }
   }
   
   public void keyReleased(int key, char c) {
      switch (key) {
    	  case Input.KEY_ENTER: {
    		  this.game.enterState(Choix.ID, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));break;
    	  }
    	  case Input.KEY_ESCAPE:Menu.container.exit(); break;

      }
   }
}


