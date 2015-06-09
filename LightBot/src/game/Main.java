package game;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;


public class Main {

	public static int resolutionX = 1000;
	public static int resolutionY = 700;
	
	   public static void main(String[] argv) {
		      try {
		         Menu.container = new AppGameContainer(new Menu());
		         Menu.container.setDisplayMode(resolutionX,resolutionY,false);
		         Menu.container.start();
		      } catch (SlickException e) {
		         e.printStackTrace();
		      }
	   }
}	