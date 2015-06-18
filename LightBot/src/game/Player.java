package game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

public class Player {
	
	private float x =0, y = 0;
	private int direction = 0;
	private Animation[] animations = new Animation[12]; //Modifié par elsa 16/6
	private int posLigne, posColonne;
	private Map map;
	  
	private float destinationX,destinationY;
	private int delta_a = 0;
	  
	private boolean running = false;
	private boolean lightning = false; //Ajout par elsa 16/6
	private boolean jumping = false;
	private boolean topJump = false;
	private boolean falling = false;
	private boolean topDown = false;
	private boolean mid = false;
	
	private Sound allumer;
	
	
	public Player() {
	  }

	public Player(Map map) {
	  this.map = map;
	 }
	  //Modif par elsa 16/6
	public void init() throws SlickException { 
		  
		SpriteSheet spriteSheet = new SpriteSheet("graphisme/sprite/character.png", 64, 96);
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
		this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
		this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
		this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
		this.animations[4] = loadAnimation(spriteSheet, 1, 4, 0);
		this.animations[5] = loadAnimation(spriteSheet, 1, 4, 1);
		this.animations[6] = loadAnimation(spriteSheet, 1, 4, 2);
		this.animations[7] = loadAnimation(spriteSheet, 1, 4, 3);
		this.animations[8] = loadAnimation(spriteSheet, 0, 4, 4);
		this.animations[9] = loadAnimation(spriteSheet, 0, 4, 5);
		this.animations[10] = loadAnimation(spriteSheet, 0, 4, 6);
		this.animations[11] = loadAnimation(spriteSheet, 0, 4, 7);
		
		allumer = new Sound("music/allumer.ogg");
	  }
	  
	public void placePlayer(int ligne, int colonne, int hauteur){
		this.x = map.getTilesWidth()/2*(1-ligne+colonne ); 
		this.y =  map.getTilesHeight()/2*(1+ligne+colonne) - hauteur*(map.getTilesHeight()/2);
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
	  //Modifié par Elsa 16/6
	public void render(Graphics g) throws SlickException {
	 //   g.setColor(new Color(0, 0, 0, .5f));
	  //  g.fillOval(x - 16, y - 8, 32, 16);
		if (lightning)	allumer.play(1,(float)0.05);
	    g.drawAnimation(animations[direction + (running ? 4 : (lightning? 8 : 0))], x-32, y-55);
	 }
	  
	  
	public void update(int delta) {
		
		updateRun(delta);
		updateJump(delta);
		updateDown(delta);
		updateLight(delta);
		}
	
	private void updateLight(int delta){
		if(lightning){
			delta_a += delta;
			if (delta_a > 20*delta){ 
			lightning = false;
			delta_a = 0;
			}
		}
	}

	
	private void updateRun(int delta){
		if (running) {
    		switch (this.direction) {
        	case 0:  this.x += .1f * delta;this.y -= 0.5* .1f * delta;
        	if ( mid && (this.x > destinationX - map.getTilesWidth()/4) && (this.y < destinationY + map.getTilesHeight()/4)) {
        		this.posLigne--; 
        		mid = false;
        	}
			if ((this.x > destinationX) && (this.y < destinationY)) {
				this.x = destinationX;
				this.y = destinationY;
				running = false;
			}
        	break;
        	case 1: this.x -= .1f * delta; this.y -= 0.5 * .1f * delta;
        	if ( mid && (this.x < destinationX + map.getTilesWidth()/4) && (this.y < destinationY + map.getTilesHeight()/4)) {
        		this.posColonne--;
        		mid = false;
        	}
			if ((this.x < destinationX) && (this.y < destinationY)) {
				this.x = destinationX;
				this.y = destinationY;
				running = false;
			}
        	break;
        	case 2: this.x -= .1f * delta;this.y += 0.5* .1f * delta;
        	if ( mid && (this.x < destinationX + map.getTilesWidth()/4) && (this.y > destinationY - map.getTilesHeight()/4)) {
    			this.posLigne++;
        		mid = false;
        	}
			if ((this.x < destinationX) && (this.y > destinationY)) {
				this.x = destinationX;
				this.y = destinationY;
				running = false;
			}            	
        	break;
        	case 3: this.x += .1f * delta; this.y += 0.5 * .1f * delta; 
        	if ( mid && (this.x > destinationX - map.getTilesWidth()/4) && (this.y > destinationY - map.getTilesHeight()/4)) {
    			this.posColonne++;
        		mid = false;
        	}
				if ((this.x > destinationX) && (this.y > destinationY)) {
					this.x = destinationX;
					this.y = destinationY;
					running = false;
				}
        	break;

			}
		}
		
	}
	
	private void updateJump(int delta){
		if (jumping) {
    		switch (this.direction) {
        	
    		case 0:  
        		if(this.y >= destinationY)
        			this.y -= .1f * delta;
        		if (this.y <= destinationY) {
        			this.x += .1f * delta;
        			if ( mid && (this.x > destinationX - map.getTilesWidth()/4)){
        				mid = false;
        				this.posLigne--;
        			}
					if (this.x > destinationX) {	
						this.x = destinationX;
						this.y = destinationY;
						jumping = false;
					}
        		}
        	break;
        	
    		case 1: 
        		if(this.y >= destinationY)	
        			this.y -= .1f * delta;
        		if (this.y <= destinationY) {
        			this.x -= .1f * delta;
        			if ( mid && (this.x < destinationX + map.getTilesWidth()/4)){
        				mid = false;
        				this.posColonne--;
        			}
        			if (this.x < destinationX){ 
        				this.x = destinationX;
        				this.y = destinationY;
        				jumping = false;
        			}
			}
        	break;
        	
    		case 2:
    			if(!topJump)
    			{
    				if(this.y >= destinationY - map.getTilesHeight()/2)	
    					this.y -= .1f * delta;
    				else
    					topJump = true;
    			}
    			if(topJump)
    			{
    				this.x -= .1f * delta;this.y += 0.5* .1f * delta;
    				if ( mid && (this.x < destinationX + map.getTilesWidth()/4) && (this.y > destinationY - map.getTilesHeight()/4)) {
    	    			this.posLigne++;
    	        		mid = false;
    	        	}
    				if ((this.x < destinationX) && (this.y > destinationY)) {
    					this.x = destinationX;
    					this.y = destinationY;
    					jumping = false;
    					topJump = false;
    				}
			}            	
        	break;
        	
        	case 3: 
       			if(!topJump)
    			{
    				if(this.y >= destinationY - map.getTilesHeight()/2)	
    					this.y -= .1f * delta;
    				else
    					topJump = true;
    			}
       			if(topJump){
       				this.x += .1f * delta; this.y += 0.5 * .1f * delta; 
       	        	if ( mid && (this.x > destinationX - map.getTilesWidth()/4) && (this.y > destinationY - map.getTilesHeight()/4)) {
       	    			this.posColonne++;
       	        		mid = false;
       	        	}
       				if ((this.x > destinationX) && (this.y > destinationY)) {
       					this.x = destinationX;
       					this.y = destinationY;
       					jumping = false;
       					topJump = false;
       				}
				}
        	break;

			}
		}
		
	
	}
	
	void updateDown(int delta){
		if (falling) {
    		switch (this.direction) {
        	
    		case 0:
    			if(!topDown){
	    			this.x += .1f * delta;
	    			this.y -= 0.5* .1f * delta;
	            	if ( mid && (this.x > destinationX - map.getTilesWidth()/4) && (this.y < destinationY + map.getTilesHeight()/4)) {
	            		this.posLigne--; 
	            		mid = false;
	            	}
	    			if ((this.x > destinationX) && (this.y < destinationY - map.getTilesHeight()/2)) {
	    				this.x = destinationX;
	    				topDown = true;
	    			}
    			}
    			if(topDown){
    				if(this.y <= destinationY)	
    					this.y += .1f * delta;
    				else{
    					this.y = destinationY;
    					topDown = false;
    					falling = false;
    				}
    			}
        	break;
        	
    		case 1: 
    			
    			if(!topDown){
    				this.x -= .1f * delta;
    				this.y -= 0.5 * .1f * delta;
    	        	if ( mid && (this.x < destinationX + map.getTilesWidth()/4) && (this.y < destinationY + map.getTilesHeight()/4)) {
    	        		this.posColonne--;
    	        		mid = false;
    	        	}
	    			if ((this.x < destinationX) && (this.y < destinationY - map.getTilesHeight()/2)) {
	    				this.x = destinationX;
	    				topDown = true;
	    			}
    			}
    			if(topDown){
    				if(this.y <= destinationY)	
    					this.y += .1f * delta;
    				else{
    					this.y = destinationY;
    					topDown = false;
    					falling = false;
    				}
    			}
    			

			
        	break;
        	
    		case 2: 
    			if (this.x >= destinationX)
    				this.x -= .1f * delta;
    			if ( mid && (this.x < destinationX + map.getTilesWidth()/4)){
    				mid = false;
    				this.posLigne++;
    			}
    			if (this.x <= destinationX ){
    				this.y += .1f * delta;

    				if (this.y > destinationY) {
    					this.x = destinationX;
    					this.y = destinationY;
    					falling = false;
    				}

			}            	
        	break;
        	
        	case 3: 
        		if (this.x <= destinationX)
       				this.x += .1f * delta;
    			if ( mid && (this.x > destinationX - map.getTilesWidth()/4)){
    				mid = false;
    				this.posColonne++;
    			}
        		if (this.x >= destinationX){
        			this.y += .1f * delta;
        			
       				if (this.y > destinationY) {
       					this.x = destinationX;
       					this.y = destinationY;
       					falling = false;
       				}
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
		mid = true;
	}
		
	public void jump() {
		switch (this.direction) {
		case 0: 
			this.destinationX = this.x + map.getTilesWidth()/2;
			this.destinationY = this.y - map.getTilesHeight()/2-map.getTilesHeight()/2; 
			break;
		case 1: 
			this.destinationX = this.x - map.getTilesWidth()/2;
			this.destinationY = this.y - map.getTilesHeight()/2-map.getTilesHeight()/2; 
			break;
		case 2: 
			this.destinationX = this.x - map.getTilesWidth()/2;
			this.destinationY = this.y;
			break;
		case 3:
			this.destinationX = this.x + map.getTilesWidth()/2;
			this.destinationY = this.y;
			break;
		}
		jumping = true;
		mid = true;
	}

	public void down(){
		switch (this.direction) {
		case 0: 
			this.destinationX = this.x + map.getTilesWidth()/2;
			this.destinationY = this.y;
			break;
		case 1: 
			this.destinationX = this.x - map.getTilesWidth()/2;
			this.destinationY = this.y;
			break;
		case 2: 
			this.destinationX = this.x - map.getTilesWidth()/2;
			this.destinationY = this.y + map.getTilesHeight()/2+map.getTilesHeight()/2;; 
			break;
		case 3:
			this.destinationX = this.x + map.getTilesWidth()/2;
			this.destinationY = this.y + map.getTilesHeight()/2+map.getTilesHeight()/2;; 
			break;
		}
		falling = true;
		mid = true;
		
	}
	  
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
	  
	  public boolean isJumping() { 
		  return jumping;
	  }
	  
	  public boolean isFalling() { 
		  return falling;
	  }
	  
	  public boolean isRunning() { 
		  return running;
	  }
	  
	  public void setRunning(boolean running) { 
		  this.running = running; 
	  }
	  
	  public boolean isLightning() { 
		  return lightning;
	  }
	  
	  public void setLightning(boolean lightning) { 
		  this.lightning = lightning; 
	  }
	  
	  public int getLigne(){
		  return this.posLigne;
	  }
	  
	  public int getColonne(){
		  return this.posColonne;
	  }
	  
	  public void setNewDirection(int x){
		this.direction = ((direction+x+4)%4);
	  }
	  
	  public void setMap(Map map){
		  this.map = map;
	  }

}
