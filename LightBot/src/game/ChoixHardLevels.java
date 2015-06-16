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
	
public class ChoixHardLevels extends BasicGameState{

		public static final int ID = 8;
		private Image background;
	    private StateBasedGame game;
	    protected static Music music;
	    private Image boutonQuit,boutonLvl1,boutonLvl2,boutonLvl3,boutonLvl4,boutonLvl5,boutonMouse,boutonRetour;
	    private int PG_X,PG_Y;
	    
	     
	    
	    boolean quit = false;

	  
	    public int getID() 
	    {
	    	return ID;
	    }
		   
	    public void init(GameContainer container, StateBasedGame game) throws SlickException { 
	    	this.game = game;
	    	background = new Image("graphisme/Images/fond/FOND_CHOIX.png");
	    	boutonQuit = new Image("graphisme/Images/Quit.png");
	    	//boutonSolo = new Image("graphisme/image/Solo.png");
	    	//boutonMulti = new Image("graphisme/image/Multi.png");
	    	boutonMouse  = new Image("graphisme/Images/Mouse.png");
	    	boutonLvl1 = new Image("graphisme/Images/choix/ChoixHardLevels/choix51.png");
	    	boutonLvl2 = new Image("graphisme/Images/choix/ChoixHardLevels/choix52.png");
	    	boutonLvl3 = new Image("graphisme/Images/choix/ChoixHardLevels/choix53.png");
	    	boutonLvl4 = new Image("graphisme/Images/choix/ChoixHardLevels/choix54.png");
	    	boutonLvl5 = new Image("graphisme/Images/choix/ChoixHardLevels/choix55.png");
	    	boutonRetour = new Image("graphisme/Images/Retour.png");
	    	//PG_X = (container.getWidth()-(boutonBasic.getWidth()+boutonITE.getWidth()+boutonFruit.getWidth()))/8-boutonMouse.getWidth()/2;
	    	//PG_Y = (container.getHeight()-(boutonBasic.getHeight()+boutonCoop.getHeight()))/3+boutonBasic.getHeight()/2-boutonMouse.getWidth()/2;
		  // 	this.music = new Music("music/Choix_Music.ogg");
		   //	music.loop();
	    	
	    } 
	 
	    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
	    {	
	    	float positionX,positionY,ecartLargeur,ecartHauteur;
	    	ecartLargeur = (container.getWidth()-(boutonLvl1.getWidth()+boutonLvl2.getWidth()+boutonLvl3.getWidth()))/4;
	    	ecartHauteur = (container.getHeight()-(boutonLvl1.getHeight()+boutonLvl4.getHeight()))/3;
	    	background.draw();
	    	boutonQuit.draw(0,0);
	    	boutonRetour.draw(boutonQuit.getWidth(),0);
	    	//boutonSolo.draw(50, 350);
	    	//boutonMulti.draw(300, 350);
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
	    	//boutonMouse.draw(PG_X,PG_Y);
	    	g.setColor(Color.black);
	    	g.drawString("Click on your choice", Main.resolutionX/2-80, Main.resolutionY/2-10);
	    } 
	    
	    public void enter(GameContainer container, StateBasedGame game) throws SlickException {		
			this.game = game;
			container.setShowFPS(false);

			//PAUSE = new Image("src/graphisme/main/ressources/map/image/Pause.jpeg");

			
			
		}
	 
	    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	    	
	    }
	 
	    public void mouseClicked(int button, int x, int y, int clickCount){
	    	if(quit) Menu.container.exit();
	    	if(x>0 && x<boutonQuit.getWidth() && y>0 && y<boutonQuit.getHeight()){
	    		Menu.container.exit();
	    	}
	    	else {
		    	if(x>boutonQuit.getWidth() && x<(boutonQuit.getWidth()+boutonRetour.getWidth()) && y>0 && y<boutonRetour.getHeight()){
		    		game.enterState(Choix.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
		    	}
		    	if(x>62 && x<312 && y>78 && y<311){
		    		WindowGame.precedent = 51;
		    	}
		    	if(x>374 && x<624 && y>78 && y<311){
		    		WindowGame.precedent = 52;
		    	}
				if(x>686 && x<936 && y>78 && y<311){
					WindowGame.precedent = 53;
				}
				if(x>219 && x<469 && y>389 && y<622){
					WindowGame.precedent = 54;
				}	
				if(x>531 && x<781 && y>389 && y<622){
					WindowGame.precedent = 55;
				}
				game.enterState(WindowGame.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
	    	}
	    }
	
	    
}
