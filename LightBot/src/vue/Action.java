package vue;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Action {
	  private Image logo;
	  private String nom;
	  private Image contourVert, contourRouge; 
	  private boolean estBloquee = false;
	  private boolean testVrai = false;
	  private boolean testFaux = false;
	  private float x,y,destX,destY;	  
	  

	  public Action() throws SlickException{ 
		  this.x = 1000;
		  this.y = 700;
		  this.destX = 1000;
		  this.destY = 700;
		  this.nom = "Allumer";
		  this.logo = new Image("graphisme/Images/actions/Allumer.png");
		  this.contourRouge = new Image("graphisme/Images/actions/contourRouge.png");
		  this.contourVert = new Image("graphisme/Images/actions/contourVert.png");
		  estBloquee = true;
		  testVrai = false;
		  testFaux = false;
	  }
	  
	  public Action(Action copie) {
		  this.x = copie.getX();
		  this.y = copie.getY();
		  this.destX = copie.getdestX();
		  this.destY = copie.getdestY();
		  estBloquee = copie.estBloquee();
		  testVrai = copie.getTestVrai();
		  testFaux = copie.getTestFaux();
		  try {
			this.logo = new Image(copie.getImage().getResourceReference());
			this.contourRouge = new Image("graphisme/Images/actions/contourRouge.png");
			this.contourVert = new Image("graphisme/Images/actions/contourVert.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	  }
	  
	  public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		  g.resetTransform();
		  this.logo.draw(this.x,this.y); 
		  if (testVrai) contourVert.draw(x, y,50,50);
		  if (testFaux) contourRouge.draw(x, y,50,50);
	  }
	  
	  public void update() {
			this.x = this.destX;
			this.y = this.destY;
		}
	  
	  public void draw(float f, float g){
		  logo.draw(f,g);
		  if (testVrai) contourVert.draw(f, g,50,50);
		  if (testFaux) contourRouge.draw(f, g,50,50);
	  }
	  
	  public void setTestVrai(boolean b){ testVrai = b; }
	  public void setTestFaux(boolean b){ testFaux = b; }
	  
	  public boolean getTestVrai(){ return testVrai; }
	  public boolean getTestFaux(){ return testFaux; }
	  
	  
	  public boolean estBloquee(){ return estBloquee; }
	  public void setEstBloquee(boolean b) { estBloquee = b; }
	  
	  public String getNom() {return this.nom;}
	  public void setNom(String n) {this.nom = n;}  
		
  
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
