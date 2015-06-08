package src;

public class LockUnlock implements Action {

	public void executer(){
		Bot bot1, bot2;
		bot1 = Controleur.getBotActif();
		bot2 = Controleur.getBotInactif();
		bot2.setEtat(Etat.INACTIF);
		bot1.setEtat(Etat.ACTIF);
	}

	public String toString(){
		return "Lock Unlock";
	}
}
