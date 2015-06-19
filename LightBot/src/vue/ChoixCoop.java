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

import structure.Controleur;
	
public class ChoixCoop extends BasicGameState{

	public static final int ID = 6;
	private Image background;
    private StateBasedGame game;
    protected static Music music;
    private Image boutonQuit,boutonLvl1,boutonLvl2,boutonLvl3,boutonLvl4,boutonLvl5,boutonRetour;
    
     
    
    boolean quit = false;

  
    public int getID() 
    {
    	return ID;
    }
	   
    public void init(GameContainer container, StateBasedGame game) throws SlickException { 
    	this.game = game;
    	background = new Image("graphisme/Images/fond/fond_choix.png");
    	boutonQuit = new Image("graphisme/Images/Quit.png");
    	boutonLvl1 = new Image("graphisme/Images/choix/ChoixCoop/choix41.png");
    	boutonLvl2 = new Image("graphisme/Images/choix/ChoixCoop/choix42.png");
    	boutonLvl3 = new Image("graphisme/Images/choix/ChoixCoop/choix43.png");
    	boutonLvl4 = new Image("graphisme/Images/choix/ChoixCoop/choix44.png");
    	boutonLvl5 = new Image("graphisme/Images/choix/ChoixCoop/choix45.png");
    	boutonRetour = new Image("graphisme/Images/Retour.png");
    	
    } 
 
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {	
    	float positionX,positionY,ecartLargeur,ecartHauteur;
    	ecartLargeur = (container.getWidth()-(boutonLvl1.getWidth()+boutonLvl2.getWidth()+boutonLvl3.getWidth()))/4;
    	ecartHauteur = (container.getHeight()-(boutonLvl1.getHeight()+boutonLvl4.getHeight()))/3;
    	background.draw();
    	boutonQuit.draw(0,0);
    	boutonRetour.draw(boutonQuit.getWidth(),0);
    	positionX = ecartLargeur; positionY = ecartHauteur;
    	boutonLvl1.draw(positionX,positionY);
    	positionX += boutonLvl1.getWidth() + ecartLargeur;
    	boutonLvl2.draw(positionX,positionY);
    	positionX += boutonLvl2.getWidth() + ecartLargeur;
    	boutonLvl3.draw(positionX,positionY);
    	positionX = (container.getWidth()-(boutonLvl4.getWidth()+boutonLvl5.getWidth()+ecartLargeur))/2; positionY += boutonLvl1.getHeight() + ecartHauteur;
    	boutonLvl4.draw(positionX,positionY);
    	positionX += boutonLvl4.getWidth() + ecartLargeur;
    	boutonLvl5.draw(positionX,positionY);
    	g.setColor(Color.black);
    	g.drawString("Click on your choice", Controleur.resolutionX/2-80, Controleur.resolutionY/2-10);
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
    		game.enterState(Choix.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    	} else {
	    	if(x>62 && x<312 && y>78 && y<311){
	    		WindowGame.precedent = 41;
	    	}
	    	if(x>374 && x<624 && y>78 && y<311){
	    		WindowGame.precedent = 42;
	    	}
			if(x>686 && x<936 && y>78 && y<311){
				WindowGame.precedent = 43;
			}
			if(x>219 && x<469 && y>389 && y<622){
				WindowGame.precedent = 44;
			}	
			if(x>531 && x<781 && y>389 && y<622){
				WindowGame.precedent = 45;
			}
			game.enterState(WindowGame.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    	}
    }
    
}
