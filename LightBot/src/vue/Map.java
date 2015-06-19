package vue;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Map {
	
	private int TilesWidth ;
	private int TilesHeight;
	private TiledMap tiledMap;
	private int Height;
	private int Width;	
	private String path;

	public void init() throws SlickException {
		this.tiledMap = new TiledMap("graphisme/map/base_niv1.tmx");
		this.Height = tiledMap.getHeight();
		this.Width = tiledMap.getWidth();
		this.TilesWidth = tiledMap.getTileWidth();	
		this.TilesHeight = tiledMap.getTileHeight();
	}
	
	public void render(Player p1, Player p2, org.newdawn.slick.Graphics g) throws SlickException{
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
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 6)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 5);
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 7)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 8);
		else if (this.tiledMap.getTileId(colonne,ligne, ligne + colonne) == 8)
			this.tiledMap.setTileId(colonne, ligne, ligne + colonne, 7);
	}
	
	public void interrup(int colonne, int ligne, int colonneC, int ligneC)
	{
		int ID = this.tiledMap.getTileId(colonne,ligne, ligne + colonne);
		if ((17 <= ID ) && (ID <= 24)){
			if ((ID%2 == 1))
				this.tiledMap.setTileId(colonne, ligne, ligne + colonne, ID + 1 );
			else 
				this.tiledMap.setTileId(colonne, ligne, ligne + colonne, ID - 1 );
			
			if ((this.tiledMap.getTileId(colonneC, ligneC, colonneC + ligneC) == ID + 8)) 
				if ((ID%2 == 1))
					this.tiledMap.setTileId(colonneC, ligneC, colonneC + ligneC, ID + 8 + 1 );
				else 
					this.tiledMap.setTileId(colonneC, ligneC, colonneC + ligneC, ID + 8 - 1 );
			else if (this.tiledMap.getTileId(colonneC,ligneC, colonneC + ligneC) == ID + 16){
				if ((ID%2 == 1))
					this.tiledMap.setTileId(colonneC, ligneC, colonneC + ligneC, ID + 16 + 1 );
				else 
					this.tiledMap.setTileId(colonneC, ligneC, colonneC + ligneC, ID + 16 - 1 );
				
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
	
	  public int randomCase(int colonne, int ligne){
		  int nombreAleatoire =  (int)(Math.random() * (80));
		  int ID = this.tiledMap.getTileId(colonne,ligne, ligne + colonne);
		  if (nombreAleatoire == 1){
			switch (ID) {
        	case 2: this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 9);  return -1;
        	case 4: this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 10); return -1;
        	case 6: this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 11); return -1;
        	case 8: this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 12); return -1;
        	case 9: this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 2); return 1;
        	case 10:this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 4); return 1;
        	case 11:this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 6); return 1;
        	case 12:this.tiledMap.setTileId(colonne,ligne,ligne + colonne, 8); return 1;
			}
		  }
		  return 0;
	  }
	
	public void changeMap(String file) throws SlickException {
		this.path = file;
		this.tiledMap = new TiledMap(file);
		this.Height = tiledMap.getHeight();
		this.Width = tiledMap.getWidth();
		this.TilesWidth = tiledMap.getTileWidth();	
		this.TilesHeight = tiledMap.getTileHeight();
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
	  
	  public String getPath() {return this.path;}
}
