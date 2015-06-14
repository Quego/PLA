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

public class Action {
	  private Image logo;
	  private float x,y,destX,destY;	  
	  

	  public Action() throws SlickException{ 
		  this.x = 1000;
		  this.y = 700;
		  this.destX = 1000;
		  this.destY = 700;
		  this.logo = new Image("graphisme/Images/actions/Avancer.png");
	  }
	  
	  public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		  g.resetTransform();
		  this.logo.draw(this.x,this.y);  
	  }
	  
	  public void update() {
			this.x = this.destX;
			this.y = this.destY;
		}
	  
		
  
	  public Image getImage(){
		  return logo;
	  }
	  public void setImage(Image i){
		  logo = i;
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
	  
	  public float getdestX(){
		  	return this.destX;
	  }
	  
	  public void setdestX(float x){
		  	this.destX = x;
	  }
	  
	  public float getdestY() {
		  	return this.destY;
	  }
	  
	  public void setdestY(float y) {
		  this.destY = y;
	  }

	  
	   
	

}
