package vue;

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


public class Choix extends BasicGameState { 
	public static final int ID = 3;
	
    private StateBasedGame game;
    
    protected static Music music;
    
    private Image boutonQuit,boutonBasic,boutonITE,boutonCoop,boutonFruit,boutonHardLevels,boutonRetour;
	private Image background;
    
    boolean quit = false;

  
    public int getID() 
    {
    	return ID;
    }
	   
    public void init(GameContainer container, StateBasedGame game) throws SlickException { 
    	this.game = game;
    	this.background = new Image("graphisme/Images/fond/fond_choix.png");
    	this.boutonQuit = new Image("graphisme/Images/Quit.png");
    	this.boutonBasic = new Image("graphisme/Images/choix/choixBasic.png");
    	this.boutonITE = new Image("graphisme/Images/choix/IF.png");
    	this.boutonFruit = new Image("graphisme/Images/choix/FRUITS.png");
    	this.boutonCoop = new Image("graphisme/Images/choix/COOP.png");
    	this.boutonHardLevels = new Image("graphisme/Images/choix/choix5.png");
    	this.boutonRetour = new Image("graphisme/Images/Retour.png");
    } 
 
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {	
    	float positionX,positionY,ecartLargeur,ecartHauteur;
    	
    	ecartLargeur = (container.getWidth()-(250+250+250))/4;
    	ecartHauteur = (container.getHeight()-(233+233))/3;
    	
    	this.background.draw(0,0,container.getWidth(),container.getScreenHeight());
    	this.boutonQuit.draw(0,0); boutonRetour.draw(boutonQuit.getWidth(),0);
    	
    	positionX = ecartLargeur; positionY = ecartHauteur;
    	this.boutonBasic.draw(positionX,positionY,250,233);
    	
    	positionX += 250 + ecartLargeur;
    	this.boutonITE.draw(positionX,positionY,250,233);
    	
    	positionX += 250 + ecartLargeur;
    	this.boutonFruit.draw(positionX,positionY,250,233);
    	
    	positionX = (container.getWidth()-(250+250+ecartLargeur))/2;
    	positionY += 233 + ecartHauteur;
    	this.boutonCoop.draw(positionX,positionY,250,233);
    	
    	positionX += 250 + ecartLargeur;
    	this.boutonHardLevels.draw(positionX,positionY,250,233); 
    } 
    
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {	
		this.game = game;
		container.setShowFPS(false);
	}
 
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    	
    }
 
    public void mouseClicked(int button, int x, int y, int clickCount){
    	if(this.quit) Menu.container.exit();
    	if(x>0 && x<this.boutonQuit.getWidth() && y>0 && y<this.boutonQuit.getHeight()){
    		Menu.container.exit();
    	}
    	if(x>this.boutonQuit.getWidth() && x<(this.boutonQuit.getWidth()+this.boutonRetour.getWidth()) && y>0 && y<this.boutonRetour.getHeight()){
    		this.game.enterState(Accueil.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    	} else {
	    	if(x>62 && x<312 && y>78 && y<311){
	    		this.game.enterState(ChoixBasic.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
	    	}
	    	if(x>374 && x<624 && y>78 && y<311){
	    		this.game.enterState(ChoixITE.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
	    	}
			if(x>686 && x<936 && y>78 && y<311){
				this.game.enterState(ChoixFruit.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));	
			}
			if(x>219 && x<469 && y>389 && y<622){
				this.game.enterState(ChoixCoop.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			}
			if(x>531 && x<781 && y>389 && y<622){
				this.game.enterState(ChoixHardLevels.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			}
    	}
    }
    
	public void keyReleased(int key, char c) {
	      switch (key) {
	    	  case Input.KEY_ESCAPE:Menu.container.exit(); break;
	    	  case Input.KEY_M: {
	    		  if (Accueil.music.playing())
	    			 Accueil.music.pause(); 
	    		  else	
	    			Accueil.music.resume();
	    	  }

	      }
	   }
    
}