import java.util.List;


public class Controleur {

	private List<Map> maps;
	private Bot bot, suppleant;
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
	
	public Bot getBot() {return this.bot;}
	public Bot getSuppleant() {return this.suppleant;}
	
}
