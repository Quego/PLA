package game;



import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
//import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Accueil extends BasicGameState {
	   
		public static final int ID = 1;
		private Image background;
		private Image jouer;
		private StateBasedGame game;
		//protected static Music music;
	   
		public int getID() {
			return ID;
		}

	   public void init(GameContainer container, StateBasedGame game) throws SlickException {
		   	this.game = game;
		   	this.background = new Image("graphisme/Images/fond/FOND_ACCUEIL.png");
		   	this.jouer = new Image("graphisme/Images/fond/Jouer.png");
	   }

	   
	   public void enter(GameContainer container, StateBasedGame game) throws SlickException {
			
			this.game = game;
			container.setShowFPS(false);

			//PAUSE = new Image("src/graphisme/main/ressources/map/image/Pause.jpeg");

			
			
		}
	 
	   public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		   this.background.draw(0,0,container.getWidth(),container.getScreenHeight());
		   this.jouer.draw(200,400);
	   }

	   public void update(GameContainer container, StateBasedGame game, int delta) {
	   }
	   
	   public void mouseClicked(int button, int x, int y, int ClickCount){
		  if (x>200 && x<200+jouer.getWidth() && y>400 && y<400+jouer.getHeight()){
			   this.game.enterState(Choix.ID, new FadeOutTransition(Color.white), new FadeInTransition(Color.white));
		  }
	   }
	   
	   
	   
	}


