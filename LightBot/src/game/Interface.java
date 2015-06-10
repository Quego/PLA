package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Interface {
	
	private Image MAIN,P1,P2,MENU,ACTIONS;
	
	public void init() throws SlickException {
		
		this.MAIN = new Image("graphisme/image/FOND_MAIN.png");
		this.P1 = new Image("graphisme/image/FOND_MAIN.png");
		this.P2 = new Image("graphisme/image/FOND_MAIN.png");
		this.MENU = new Image("graphisme/image/FOND_MAIN.png");
		this.ACTIONS = new Image("graphisme/image/FOND_MAIN.png");
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.resetTransform();
		float decalage = container.getHeight()/100;
		
		this.MAIN.draw(2*container.getWidth()/3, 
						container.getHeight()/20+decalage,
						container.getWidth()/3-decalage,
						6*container.getHeight()/20);
		
		this.P1.draw(2*container.getWidth()/3, 
						7*container.getHeight()/20+2*decalage,
						container.getWidth()/3-decalage,
						4*container.getHeight()/20);
		
		this.P2.draw(2*container.getWidth()/3, 
						11*container.getHeight()/20+3*decalage,
						container.getWidth()/3-decalage,
						4*container.getHeight()/20);
		
		this.MENU.draw(0, 
						0,
						container.getWidth(),
						container.getHeight()/20);
		
		this.ACTIONS.draw(decalage, 
						16*container.getHeight()/20-decalage,
						2*container.getWidth()/3-2*decalage,
						4*container.getHeight()/20);
	}
}
