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


public class Choix extends BasicGameState { 
	public static final int ID = 3;
	private Image background;
    private StateBasedGame game;
    protected static Music music;
    private Image boutonQuit,boutonBasic,boutonITE,boutonCoop,boutonFruit,boutonHardLevels,boutonMouse,boutonRetour;
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
    	boutonBasic = new Image("graphisme/Images/choix/choix1.png");
    	boutonITE = new Image("graphisme/Images/choix/ChoixITE.jpg");
    	boutonFruit = new Image("graphisme/Images/choix/ChoixFruit.jpg");
    	boutonCoop = new Image("graphisme/Images/choix/ChoixCoop.jpg");
    	boutonHardLevels = new Image("graphisme/Images/choix/choix5.png");
    	boutonRetour = new Image("graphisme/Images/Retour.png");
    	//PG_X = (container.getWidth()-(boutonBasic.getWidth()+boutonITE.getWidth()+boutonFruit.getWidth()))/8-boutonMouse.getWidth()/2;
    	//PG_Y = (container.getHeight()-(boutonBasic.getHeight()+boutonCoop.getHeight()))/3+boutonBasic.getHeight()/2-boutonMouse.getWidth()/2;
	  // 	this.music = new Music("music/Choix_Music.ogg");
	   //	music.loop();
    	
    } 
 
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {	
    	float positionX,positionY,ecartLargeur,ecartHauteur;
    	ecartLargeur = (container.getWidth()-(boutonBasic.getWidth()+boutonITE.getWidth()+boutonFruit.getWidth()))/4;
    	ecartHauteur = (container.getHeight()-(boutonBasic.getHeight()+boutonCoop.getHeight()))/3;
    	background.draw();
    	boutonQuit.draw(0,0); boutonRetour.draw(boutonQuit.getWidth(),0);
    	//boutonSolo.draw(50, 350);
    	//boutonMulti.draw(300, 350);
    	positionX = ecartLargeur; positionY = ecartHauteur;
    	boutonBasic.draw(positionX,positionY);
    	positionX += boutonBasic.getWidth() + ecartLargeur;
    	boutonITE.draw(positionX,positionY);
    	positionX += boutonITE.getWidth() + ecartLargeur;
    	boutonFruit.draw(positionX,positionY);
    	positionX = (container.getWidth()-(boutonCoop.getWidth()+boutonHardLevels.getWidth()+ecartLargeur))/2; positionY += boutonBasic.getHeight() + ecartHauteur;
    	boutonCoop.draw(positionX,positionY);
    	positionX += boutonCoop.getWidth() + ecartLargeur;
    	boutonHardLevels.draw(positionX,positionY);  
    	//boutonMouse.draw(PG_X,PG_Y);
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
    	if(x>boutonQuit.getWidth() && x<(boutonQuit.getWidth()+boutonRetour.getWidth()) && y>0 && y<boutonRetour.getHeight()){
    		game.enterState(Accueil.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
    	}
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
    
    
    
    public void keyReleased(int key, char c) {  
    	switch (key) {
    	case Input.KEY_ENTER :
    		if (quit) Menu.container.exit(); 
    		else  {
    			game.enterState(ChoixBasic.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));break;
    		}    		
    	case Input.KEY_ESCAPE: Menu.container.exit(); break;
    	//case Input.KEY_M: if(Accueil.Music_Choix.playing()){ Accueil.Music_Choix.pause(); MusicManager.mute=true; }else {Accueil.Music_Choix.resume(); MusicManager.mute=false;}break;
    	}
    }	
    
}