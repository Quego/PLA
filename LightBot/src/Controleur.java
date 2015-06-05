import java.util.List;


public class Controleur {

	private List<Map> maps;
	private Bot bot1, bot2;
	private Map map;
	
	public Controleur() {
		this.maps = null;
		this.map = null;
		this.bot = null;
		this.suppleant = null;
	}
	
	public List<Map> getMaps() {return this.maps;}
	public Map getMap() {return this.map;}
	public void setMap(int i) {this.map = this.maps.get(i);}
	public void setMaps(List<Map> m) {this.maps = m;}
	public void addMaps(Map m) {this.maps.add(m);}
	
	public Bot getBot1() {return this.bot1;}
	public Bot getBot2() {return this.bot2;}
	public Bot getBotActif() { 
		if (this.bot1.getEtat() == Etat.ACTIF) return this.bot1;
		else return this.bot2;
	}
	public Bot getBotInactif() { 
		if (this.bot1.getEtat() == Etat.INACTIF) return this.bot1;
		else return this.bot2;
	}
	
}
