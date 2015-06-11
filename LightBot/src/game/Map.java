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
import org.newdawn.slick.tiled.TiledMap;

public class Map {
	
	private int TilesWidth ;
	private int TilesHeight;
	private TiledMap tiledMap;
	private int Height;
	private int Width;
	

	public void init() throws SlickException {
		this.tiledMap = new TiledMap("graphisme/map/test.tmx");
		Height = tiledMap.getHeight();
		Width = tiledMap.getWidth();
		TilesWidth = tiledMap.getTileWidth();	
		TilesHeight = tiledMap.getTileHeight();
	}
	
	public void renderBackground(int ligne, int colonne){
		for(int i=0;i<=ligne+colonne;i++){
			this.tiledMap.render(0, 0, i);
		}
	}
	
	public void renderForeground(int ligne, int colonne){
		for(int i=ligne+colonne+1;i<this.Height + this.Width-1;i++){
			this.tiledMap.render(0, 0, i);
			System.out.println(this.tiledMap.getLayerIndex("lampe1"));
			System.out.println(this.tiledMap.getLayerProperty(13, "tet", "reutgerg"));
			this.tiledMap.setTileId(0, 1, 1, 3);
			System.out.println(this.tiledMap.getTileId(0,1,1));
			System.out.println(this.tiledMap.getTileId(1,0,1));
			System.out.println(this.tiledMap.getTileId(2,0,2));
			System.out.println(this.tiledMap.getTileId(1,1,2));
		}
	}
	
	public void allume(int colonne, int ligne)
	{
		this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 4);
	}
		
	public void changeMap(String file) throws SlickException {
		this.tiledMap = new TiledMap(file);
	}	
	
	  public float getHeight(){
		  	return Height;
	  }
	  
	  public float getWidth(){
		  	return Width;
	  }
	  
	  public int getTilesWidth(){
		  	return TilesWidth;
	  }
	  
	  public int getTilesHeight(){
		  	return TilesHeight;
	  }
	  
}
