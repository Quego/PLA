
public class LockUnlock implements Action {

	public void executer(){
		Bot bot1, bot2;
		bot1 = Controleur.getBotNonBloque();
		bot2 = Controleur.getBotBloquer();
		bot1.setEtat(Etat.BLOQUE);
		bot2.setEtat(Etat.NONBLOQUE);
	}

	public String toString(){
		return "Lock Unlock";
	}
}
