
public class SwitchBot implements Action {
	public void executer(){
		Bot bot1, bot2;
		bot1 = Controleur.getBotActif();
		bot2 = Controleur.getBotInactif();
		bot1.setEtat(ETAT.Inactif);
		bot2.setEtat(ETAT.Actif);
	}
}
