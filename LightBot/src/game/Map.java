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
		this.tiledMap = new TiledMap("graphisme/map/coop_niv1.tmx");
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
		if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) ==1 )
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 2);
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 2)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 1);
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 3)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 4);
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 4)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 3);
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 5)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 6);
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 5)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 6);
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 7)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 8);
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 7)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 8);

	}
	
	public void interrup(int colonne, int ligne)
	{
		System.out.println(+this.tiledMap.getTileId(colonne,ligne, ligne + colonne));
		int ID = this.tiledMap.getTileId(colonne,ligne, ligne + colonne);
		if ((17 <= ID ) && (ID <= 24)){
			if ((ID%2 == 1))
				this.tiledMap.setTileId(colonne, ligne, ligne + colonne, ID + 1 );
			else 
				this.tiledMap.setTileId(colonne, ligne, ligne + colonne, ID - 1 );
			
			for (int i=0; i< this.tiledMap.getWidth(); i++){
				for (int j = 0; j < this.tiledMap.getHeight();j++ ){
						if ((this.tiledMap.getTileId(i, j, i+j) == ID + 8)) 
							if ((ID%2 == 1))
								this.tiledMap.setTileId(i, j, i+j, ID + 8 + 1 );
							else 
								this.tiledMap.setTileId(i, j, i+j, ID + 8 - 1 );
						else if (this.tiledMap.getTileId(i, j, i+j) == ID + 16){
							if ((ID%2 == 1))
							this.tiledMap.setTileId(i, j, i+j, ID + 16 + 1 );
						else 
							this.tiledMap.setTileId(i, j, i+j, ID + 16 - 1 );
							
					}
				}
			}
		}
		if ((33 <= ID ) && (ID <= 40)){
			if ((ID%2 == 1))
				this.tiledMap.setTileId(colonne, ligne, ligne + colonne, ID + 1 );
			else 
				this.tiledMap.setTileId(colonne, ligne, ligne + colonne, ID - 1 );
			
			for (int i=0; i< this.tiledMap.getWidth(); i++){
				for (int j = 0; j < this.tiledMap.getHeight();j++ ){
						if ((this.tiledMap.getTileId(i, j, i+j) == ID + 8)) 
							if ((ID%2 == 1))
								this.tiledMap.setTileId(i, j, i+j, ID + 8 + 1 );
							else 
								this.tiledMap.setTileId(i, j, i+j, ID + 8 - 1 );
						else if (this.tiledMap.getTileId(i, j, i+j) == ID - 8){
							if ((ID%2 == 1))
							this.tiledMap.setTileId(i, j, i+j, ID - 8 + 1 );
						else 
							this.tiledMap.setTileId(i, j, i+j, ID - 8 - 1 );
							
					}
				}
			}
		}
	}
		
	
	public void poseFruit(int colonne, int ligne){
		//IF GOTFRUIT TODO
		int ID = this.tiledMap.getTileId(colonne,ligne, ligne + colonne);
		if (ID == 27 || ID == 29 || ID == 31){
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, ID +24);
		}
		if (ID == 43 || ID == 45 || ID == 47){
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, ID +9);
		}
	
	}
	public void prendFruit(int colonne, int ligne){
		int ID = this.tiledMap.getTileId(colonne,ligne, ligne + colonne);
		if (ID == 51 || ID == 53 || ID == 55){
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, ID -24);
		}
			if (ID == 52 || ID == 54 || ID == 56){
				this.tiledMap.setTileId(colonne, ligne, ligne + colonne, ID -9);	
		}
		
		
	}
	
	public void changeMap(String file) throws SlickException {
		this.tiledMap = new TiledMap(file);
	}	
	
	  public float getHeight(){
		  	return Height;
	  }
	  
	  public void YOLOSWAG(){
			if (this.tiledMap.getTileId(2,4,6) == 1 )
				this.tiledMap.setTileId(2,4,6, 9);
			else if (this.tiledMap.getTileId(2,4,6) == 9 )
				this.tiledMap.setTileId(2,4,6, 1);
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
