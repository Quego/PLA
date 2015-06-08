package src;
import java.util.List;


public class Controleur {

	private static List<Map> maps;
	private static Bot bot1, bot2;
	private static Map map;
	
	public Controleur() {
		maps = null;
		map = null;
		bot1 = new Bot();
		bot2 = new Bot(Etat.INACTIF);
	}
	
	public static List<Map> getMaps() {return maps;}
	public static Map getMap() {return map;}
	public static void setMap(int i) {map = maps.get(i);}
	public static void setMaps(List<Map> m) {maps = m;}
	public static void addMaps(Map m) { maps.add(m);}
	
	public static Bot getBot1() {return bot1;}
	public static Bot getBot2() {return bot2;}
	public static Bot getBotActif() { 
		if (bot1.getEtat() == Etat.ACTIF) return bot1;
		else return bot2;
	}
	public static Bot getBotInactif() { 
		if (bot1.getEtat() == Etat.INACTIF) return bot1;
		else return bot2;
	}
	
}
