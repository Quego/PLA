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
		this.tiledMap = new TiledMap("graphisme/map/base_niv1.tmx");
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
		}
	}
	
	public void allume(int colonne, int ligne)
	{
		System.out.println(+this.tiledMap.getTileId(colonne,ligne, ligne + colonne));
		if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) ==8 )
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 9);
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 9)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 8);
		if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 10 )
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 11);
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) ==11)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 10);
	}
	
	public void interrup(int colonne, int ligne)
	{
		System.out.println(+this.tiledMap.getTileId(colonne,ligne, ligne + colonne));
		int ID = this.tiledMap.getTileId(colonne,ligne, ligne + colonne);
		if ( (ID > 11) && (ID < 20)){
			if ((ID%2 == 1))
				this.tiledMap.setTileId(colonne, ligne, ligne + colonne, ID - 1 );
			else 
				this.tiledMap.setTileId(colonne, ligne, ligne + colonne, ID + 1 );
			
			for (int i=0; i< this.tiledMap.getHeight(); i++){
				for (int j = 0; j < this.tiledMap.getWidth();j++ ){
					if ((ID%2 == 1)){
						if (this.tiledMap.getTileId(i, j, i+j) == ID + 7)
								this.tiledMap.setTileId(i, j, i+j, ID + 8 );
					}
					else {
						if (this.tiledMap.getTileId(i, j, i+j) == ID + 9)
								this.tiledMap.setTileId(i, j, i+j, ID +8 );
					}
				}
			}
			
		}
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 37){
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 38);
			for (int i=0; i< this.tiledMap.getHeight(); i++){
				for (int j = 0; j < this.tiledMap.getWidth();j++ ){
					if (this.tiledMap.getTileId(i, j, i+j) == 36){
						this.tiledMap.setTileId(i, j, i+j, 35	);
					}
				}
			}
			
		}
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
