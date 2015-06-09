package game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

public class Player {
	
	  private float x =0, y = 0;
	  private int direction = 0;
	  private Animation[] animations = new Animation[8];
	  private int posLigne, posColonne;
	  private Map map;
	  
	  private float destinationX,destinationY;
	  
	  //private int time;
	  private boolean running = false;
	  
	  public Player() {
		  }

	  public Player(Map map) {
	    this.map = map;
	  }
	  
	  public void init() throws SlickException { 
		  
		    SpriteSheet spriteSheet = new SpriteSheet("graphisme/sprite/character.png", 64, 64);
		    this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
		    this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		    this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
		    this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
		    this.animations[4] = loadAnimation(spriteSheet, 1, 7, 0);
		    this.animations[5] = loadAnimation(spriteSheet, 1, 7, 1);
		    this.animations[6] = loadAnimation(spriteSheet, 1, 7, 2);
		    this.animations[7] = loadAnimation(spriteSheet, 1, 7, 3);

	  }
	  
	  public void placePlayer(int ligne, int colonne){
		  this.x = map.getTilesWidth()/2*(1-ligne+colonne ); 
		  this.y =  map.getTilesHeight()/2*(1+ligne+colonne);
		  this.posLigne = ligne;
		  this.posColonne = colonne;
				  
		  
	  }
	  
	  private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
		  Animation animation = new Animation();
		  for (int x = startX; x < endX; x++) {
			  animation.addFrame(spriteSheet.getSprite(x, y), 100);
		  }
		  return animation;
	  }
	  
	  public void render(Graphics g) throws SlickException {
		    g.setColor(new Color(0, 0, 0, .5f));
		    g.fillOval(x - 16, y - 8, 32, 16);
		    g.drawAnimation(animations[direction + (running ? 4 : 0)], x-32, y-60);
	  }
	  
	/*  public void update(int delta)
			  throws SlickException {
		    	if (this.moving) {
		    		switch (this.direction) {
		            	case 0: this.y -= 0.5* .1f * delta; this.x += .1f * delta; break;
		            	case 1: this.x -= .1f * delta; this.y -= 0.5 * .1f * delta; break;
		            	case 2: this.y += 0.5* .1f * delta; this.x -= .1f * delta; break;
		            	case 3: this.x += .1f * delta; this.y += 0.5 * .1f * delta; break;
		    		}
		    	}		  
	  }*/
	  
	public void update(int delta) {
			if (running) {
	    		switch (this.direction) {
            	case 0:  this.x += .1f * delta;this.y -= 0.5* .1f * delta;
				if ((this.x > destinationX) && (this.y < destinationY)) {
					this.x = destinationX;
					this.y = destinationY;
					running = false;
				}
            	break;
            	case 1: this.x -= .1f * delta; this.y -= 0.5 * .1f * delta;
				if ((this.x < destinationX) && (this.y < destinationY)) {
					this.x = destinationX;
					this.y = destinationY;
					running = false;
				}
            	break;
            	case 2: this.x -= .1f * delta;this.y += 0.5* .1f * delta; 
				if ((this.x < destinationX) && (this.y > destinationY)) {
					this.x = destinationX;
					this.y = destinationY;
					running = false;
				}            	
            	break;
            	case 3: this.x += .1f * delta; this.y += 0.5 * .1f * delta; 
					if ((this.x > destinationX) && (this.y > destinationY)) {
						this.x = destinationX;
						this.y = destinationY;
						running = false;
					}
            	break;
	
				}
			}
		}


		public void start() {
			switch (this.direction) {
			case 0: 
				this.destinationX = this.x + map.getTilesWidth()/2;
				this.destinationY = this.y - map.getTilesHeight()/2; 
				break;
			case 1: 
				this.destinationX = this.x - map.getTilesWidth()/2;
				this.destinationY = this.y - map.getTilesHeight()/2; 
				break;
			case 2: 
				this.destinationX = this.x - map.getTilesWidth()/2;
				this.destinationY = this.y + map.getTilesHeight()/2; 
				break;
			case 3:
				this.destinationX = this.x + map.getTilesWidth()/2;
				this.destinationY = this.y + map.getTilesHeight()/2; 
				break;
			}
			running = true;
		}

	  
	  public void avancerDevant(){};
	  
	  public void avancerDerriere(){};
	  
	  public void avancerDroite(){};
	  
	  public void avancerGauche(){};
	  
	  
	  public float getX(){
		  	return x;
	  }
	  
	  public void setX(float x){
		  	this.x = x;
	  }
	  
	  public float getY() {
		  	return y;
	  }
	  
	  public void setY(float y) {
		  this.y = y;
	  }
	  
	  public int getDirection(){ 
		  return direction;
	  }
	  
	  public void setDirection(int direction) {
		  this.direction = direction;
	  }
	  
	  public boolean isRunning() { 
		  return running;
	  }
	  
	  public void setRunning(boolean running) { 
		  this.running = running; 
	  }
	  
	  public void incLigne(){
		  this.posLigne++;
	  }
	  
	  public void dincLigne(){
		  this.posLigne--;
	  }
	  
	  public int getLigne(){
		  return this.posLigne;
	  }
	  
	  public int getColonne(){
		  return this.posColonne;
	  }


}
