package game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
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
//	this.map.renderBackground(this.player_1.getLigne(),this.player_1.getColonne());
//	this.player_1.render(g);
//	this.player_2.render(g);
//	this.map.renderForeground(this.player_1.getLigne(),this.player_1.getColonne());
	public void render(Player p1, Player p2, Graphics g) throws SlickException{
		if (p1.getLigne() +p1.getColonne() < p2.getLigne() +p2.getColonne()){
			renderBackground(p1.getLigne(),p1.getColonne());
			p1.render(g);
			renderMiddle(p1.getLigne(),p1.getColonne(), p2.getLigne(),p2.getColonne());
			p2.render(g);
			renderForeground(p2.getLigne(),p2.getColonne());
		}
		else if (p1.getLigne() +p1.getColonne() > p2.getLigne() +p2.getColonne()){
			renderBackground(p2.getLigne(),p2.getColonne());
			p2.render(g);
			renderMiddle(p2.getLigne(),p2.getColonne(), p1.getLigne(),p1.getColonne());
			p1.render(g);
			renderForeground(p1.getLigne(),p1.getColonne());
		}
		else {
			renderBackground(p1.getLigne(),p1.getColonne());
			p1.render(g);
			p2.render(g);
			renderForeground(p1.getLigne(),p1.getColonne());
		}
	}
	
	public void renderBackground(int ligne, int colonne){
		for(int i=0;i<=ligne+colonne;i++){
			this.tiledMap.render(0, 0, i);
		}
	}
	
	public void renderMiddle(int ligneS, int colonneS, int ligneE, int colonneE){
		for(int i=ligneS + colonneS+1;i<=ligneE+colonneE;i++){
			this.tiledMap.render(0, 0, i);
		}
	}
	
	
	public void renderForeground(int ligne, int colonne){
		for(int i=ligne+colonne+1;i<this.Width + this.Height-1;i++){
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
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 6)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 5);
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 7)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 8);
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 8)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 7);

	}
	
	public void interrup(int colonne, int ligne)
	{
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
	
	  public void randomCase(int colonne, int ligne){
		  int nombreAleatoire =  (int)(Math.random() * (50));
		  int ID = this.tiledMap.getTileId(colonne,ligne, ligne + colonne);
		  if (nombreAleatoire == 1){
			switch (ID) {
        	case 2: this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 9); break;
        	case 4: this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 10); break;
        	case 6: this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 11); break;
        	case 8: this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 12); break;
        	case 9: this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 2); break;
        	case 10:this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 4); break;
        	case 11:this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 6); break;
        	case 12:this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 8); break;
			}
		  }
	  }
	
	public void changeMap(String file) throws SlickException {
		this.tiledMap = new TiledMap(file);
		Height = tiledMap.getHeight();
		Width = tiledMap.getWidth();
		TilesWidth = tiledMap.getTileWidth();	
		TilesHeight = tiledMap.getTileHeight();
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
