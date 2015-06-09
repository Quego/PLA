package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;


public class Menu extends StateBasedGame {

	public static AppGameContainer container;
	
   public Menu() {
      super("LightBot");
   }
   
   public void initStatesList(GameContainer container) {
	  addState(new Accueil());
      addState(new Choix());
    /*  addState(new SelectionPerso());*/
      addState(new WindowGame());
     /* addState(new Win ());
      addState(new Dead());
      addState(new Difficulte());
      addState(new Free());
      addState(new SelectionMapSolo());
      addState(new HighscoreTable());
      addState(new HighscoreEnter());*/

   }
   
  
}