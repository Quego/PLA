import java.util.List;


public class Controleur {

	private List<Map> maps;
	private Bot bot, suppleant;
	
	public Controleur() {
		this.maps = null;
		this.bot = null;
		this.suppleant = null;
	}
	
	public List<Map> getMaps() {return this.maps;}
	public void setMaps(List<Map> m) {this.maps = m;}
	public void addMaps(Map m) {this.maps.add(m);}
	
	public Bot getBot() {return this.bot;}
	public Bot getSuppleant() {return this.suppleant;}
	
}
