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
		protected static Music music;
	   
		public int getID() {
			return ID;
		}

	   public void init(GameContainer container, StateBasedGame game) throws SlickException {
		   	this.game = game;
		   	this.background = new Image("graphisme/image/FOND_ACCUEIL.png");
		   	this.music = new Music("music/Accueil_Music.ogg");
		   //	music.loop();

	   }

	   public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		   this.background.draw();
		   g.drawString("Press 'ENTER'", Main.resolutionX/2-50, Main.resolutionY/2+200);
	   }

	   public void update(GameContainer container, StateBasedGame game, int delta) {
	   }
	   
	   public void keyReleased(int key, char c) {
	      switch (key) {
	    	  case Input.KEY_ENTER: 
	    	  {
	    		/*  Music_Choix.loop(); if(MusicManager.mute) Music_Choix.pause(); */
	    		  this.game.enterState(Choix.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));break;
	    	  }
	    	  case Input.KEY_M: if(music.playing()){ music.pause(); }else {music.resume();}break;
	    	  case Input.KEY_ESCAPE:Menu.container.exit(); break;

	      }
	   }
	}

