package game;



import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Accueil extends BasicGameState {
	   
		public static final int ID = 1;
		private Image background;
		private StateBasedGame game;
		//protected static Music music;
	   
		public int getID() {
			return ID;
		}

	   public void init(GameContainer container, StateBasedGame game) throws SlickException {
		   	this.game = game;
		   	this.background = new Image("graphisme/Images/fond/FOND_ACCUEIL.png");
	   }

	   
	   public void enter(GameContainer container, StateBasedGame game) throws SlickException {
			
			this.game = game;
			container.setShowFPS(false);

			//PAUSE = new Image("src/graphisme/main/ressources/map/image/Pause.jpeg");

			
			
		}
	 
	   public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		   this.background.draw(0,0,container.getWidth(),container.getScreenHeight());
		   g.setColor(Color.black);
		   g.drawString("Press 'ENTER'", Main.resolutionX/2-50, Main.resolutionY/2+220);
	   }

	   public void update(GameContainer container, StateBasedGame game, int delta) {
	   }
	   
	   public void mouseClicked(int button, int x, int y, int ClickCount){
		   this.game.enterState(Choix.ID, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
	   }
	   
	   public void keyReleased(int key, char c) {
	      switch (key) {
	    	  case Input.KEY_ENTER: 
	    	  {
	    		  this.game.enterState(Choix.ID, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));break;
	    	  }
	    	  case Input.KEY_ESCAPE:Menu.container.exit(); break;

	      }
	   }
	   
	}


