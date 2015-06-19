package vue;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


public class Choix extends BasicGameState { 
	public static final int ID = 3;
	private Image background;
    private StateBasedGame game;
    protected static Music music;
    private Image boutonQuit,boutonBasic,boutonITE,boutonCoop,boutonFruit,boutonHardLevels,boutonRetour;
    boolean quit = false;

  
    public int getID() 
    {
    	return ID;
    }
	   
    public void init(GameContainer container, StateBasedGame game) throws SlickException { 
    	this.game = game;
    	background = new Image("graphisme/Images/fond/fond_choix.png");
    	boutonQuit = new Image("graphisme/Images/Quit.png");
    	boutonBasic = new Image("graphisme/Images/choix/choixBasic.png");
    	boutonITE = new Image("graphisme/Images/choix/IF.png");
    	boutonFruit = new Image("graphisme/Images/choix/FRUITS.png");
    	boutonCoop = new Image("graphisme/Images/choix/COOP.png");
    	boutonHardLevels = new Image("graphisme/Images/choix/choix5.png");
    	boutonRetour = new Image("graphisme/Images/Retour.png");
    } 
 
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {	
    	float positionX,positionY,ecartLargeur,ecartHauteur;
    	ecartLargeur = (container.getWidth()-(250+250+250))/4;
    	ecartHauteur = (container.getHeight()-(233+233))/3;
    	background.draw(0,0,container.getWidth(),container.getScreenHeight());
    	boutonQuit.draw(0,0); boutonRetour.draw(boutonQuit.getWidth(),0);
    	positionX = ecartLargeur; positionY = ecartHauteur;
    	boutonBasic.draw(positionX,positionY,250,233);
    	positionX += 250 + ecartLargeur;
    	boutonITE.draw(positionX,positionY,250,233);
    	positionX += 250 + ecartLargeur;
    	boutonFruit.draw(positionX,positionY,250,233);
    	positionX = (container.getWidth()-(250+250+ecartLargeur))/2; positionY += 233 + ecartHauteur;
    	boutonCoop.draw(positionX,positionY,250,233);
    	positionX += 250 + ecartLargeur;
    	boutonHardLevels.draw(positionX,positionY,250,233); 
    } 
    
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {	
		this.game = game;
		container.setShowFPS(false);
	}
 
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    	
    }
 
    public void mouseClicked(int button, int x, int y, int clickCount){
    	if(quit) Menu.container.exit();
    	if(x>0 && x<boutonQuit.getWidth() && y>0 && y<boutonQuit.getHeight()){
    		Menu.container.exit();
    	}
    	if(x>boutonQuit.getWidth() && x<(boutonQuit.getWidth()+boutonRetour.getWidth()) && y>0 && y<boutonRetour.getHeight()){
    		game.enterState(Accueil.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    	} else {
	    	if(x>62 && x<312 && y>78 && y<311){
	    		game.enterState(ChoixBasic.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
	    	}
	    	if(x>374 && x<624 && y>78 && y<311){
	    		game.enterState(ChoixITE.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
	    	}
			if(x>686 && x<936 && y>78 && y<311){
				game.enterState(ChoixFruit.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));	
			}
			if(x>219 && x<469 && y>389 && y<622){
				game.enterState(ChoixCoop.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			}
			if(x>531 && x<781 && y>389 && y<622){
				game.enterState(ChoixHardLevels.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
			}
    	}
    }
    
}