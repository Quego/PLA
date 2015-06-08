
public class Sauter implements Action {
	public void executer(){
		int xprime,yprime;
		int h, h_prime;
		Position p = new Position (xprime, yprime);
		pinit = Controleur.getBotActif().getPosition();
		dest = Controleur.getBotActif().getPositionDevant();
		
		h = Map.getCellule(pinit).getHauteur();
		h_prime = Map.getCellule(dest).getHauteur();
		if (h > h_prime || h = (h_prime -1)) {
			Map.getCellule(Controleur.getBotActif().getPositionDevant().setOccupee(false));
			p_prime= new Position (xprime, yprime);
			Controleur.getBotActif().setPosition(p_prime);
			Map.getCellule(Controleur.getBotActif().getPositionDevant().setOccupee(true));
		}
		else throw new Ensure("Le Bot ne peut pas sauter !");
	}
}