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


public class Choix extends BasicGameState 
{ 
	public static final int ID = 3;
	private Image background;
    private StateBasedGame game;
    protected static Music music;
    private Image boutonQuit,boutonSolo,boutonMulti,boutonMouse;
    private int PG_X,PG_Y;
    
     
    
    boolean quit = false;

  
    public int getID() 
    {
    	return ID;
    }
	   
    public void init(GameContainer container, StateBasedGame game) throws SlickException { 
    	this.game = game;
    	background = new Image("graphisme/image/FOND_CHOIX.png");
    	boutonQuit = new Image("graphisme/image/Quit.png");
    	boutonSolo = new Image("graphisme/image/Solo.png");
    	boutonMulti = new Image("graphisme/image/Multi.png");
    	boutonMouse  = new Image("graphisme/image/Mouse.png");
    	PG_X = 9;
    	PG_Y = 359 ;
	   	this.music = new Music("music/Choix_Music.ogg");
	   //	music.loop();
    	
    } 
 
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {
    	background.draw();
    	boutonQuit.draw(550, 350);
    	boutonSolo.draw(50, 350);
    	boutonMulti.draw(300, 350);
    	boutonMouse.draw(PG_X,PG_Y);
    } 
    
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
	}
 
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    	
    }
 
    
    public void keyReleased(int key, char c) {  
    	switch (key) {
    	case Input.KEY_ENTER :
    		if (quit)Menu.container.exit(); 
    		else  
    		{
    				game.enterState(WindowGame.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));break;
    		}
    		
    		
    	case Input.KEY_ESCAPE:Menu.container.exit(); break;
    	//case Input.KEY_M: if(Accueil.Music_Choix.playing()){ Accueil.Music_Choix.pause(); MusicManager.mute=true; }else {Accueil.Music_Choix.resume(); MusicManager.mute=false;}break;
    	
    	case Input.KEY_RIGHT:
    		if(this.PG_X < 250)
    		{
    			this.PG_X = 259;
    			this.quit = false;
    		}
    		else 
    		{
    			this.PG_X = 509;
    			this.quit = true;
    		}
    		
    		break;
    	case Input.KEY_LEFT:
    		if(this.PG_X > 300)
    		{
    			this.PG_X = 259;
    			this.quit = false;
    		}
    		else 
    		{
    			this.PG_X = 9;
    			this.quit = false;
    		}
    		break;
    	}
	   }	
    
}