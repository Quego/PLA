package structure;


public class Start {

	/**
	 * Constructeur de l'application. 
	 * Instancie le controleur
	 * Affiche la fenêtre de démarrage
	 */
	public Start() {
		Controleur controleur = new Controleur();
		controleur.restaure();
		controleur.demarrage();
	}
	
	public static void main(String args[]) {
		new Start();
	}

}
