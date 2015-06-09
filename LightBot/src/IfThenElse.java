package src;
import java.util.*;

public class IfThenElse implements Action {

	/*-----------------------------ATTRIBUTS-----------------------------*/
	/**
	 * str_cond représente la chaine de caractère de la condition
	 * bool_cond représente la valeur de la condition
	 * proc_then représente les actions que le Bot doit exécuter si la condition est vérifiée
	 * proc_else représente les actions que le Bot doit exécuter si la condition n'est pas vérifiée
	 */
	protected String str_cond;
	protected boolean bool_cond;
	protected List<Action> actions_if;
	protected List<Action> actions_else;
	
	
	
	/*-----------------------------CONSTRUCTEURS-----------------------------*/
	public IfThenElse(){
		this.str_cond = "vrai";
		this.bool_cond = true;
		this.actions_if = null;
		this.actions_else = null;
	}
	
	public IfThenElse(String str, boolean cond){
		this.str_cond = str;
		this.bool_cond = cond;
		this.actions_if = null;
		this.actions_else = null;
	}
	
	/*---------------------PROCEDURES-&-FONCTIONS-----------------------------*/
	/**
	 * Exécute une des 2 procédures en fonction de la condition
	 */	
	public void executer(){
		if (bool_cond) 	{
			Controleur.getBotActif().setCouleur(Couleur.VERT);
			for (int i=0; i< this.actions_if.size();i++) {
				if (actions_if.get(i).toString().equals("Break")){
					break;
				}
				actions_if.get(i).executer();
			}
		}
		else	{
			Controleur.getBotActif().setCouleur(Couleur.ROUGE);	
			for (int i=0; i< this.actions_else.size();i++) {
				if (actions_else.get(i).toString().equals("Break")){
					break;
				}
				actions_else.get(i).executer();
			}
		}
	}
	
	public String toString() {
		String s = "";
		s += "Si " + str_cond + "\n";
		if (this.actions_if.isEmpty()) {
			s += "Alors le Bot n'a rien à faire \n";
		}
		else {
			s += "Alors le Bot doit faire cette liste d'actions : ";
			s += this.actions_if.toString() + "\n";
		}
		if (this.actions_else.isEmpty()) {
			s += "Sinon il n'a rien à faire \n";
		}
		else {
			s += "Sinon il doit faire cette liste d'actions : "; 
			s += this.actions_else.toString() + "\n";
		}
		return s;
	}
	
	/*-----------------------------GETTEURS-----------------------------*/
	public boolean getBoolCond(){ return this.bool_cond; }
	
	public String getStrCond (){ return this.str_cond;	}
	
	public List<Action> getActionsIf(){ return this.actions_if;	}
	
	public List<Action> getActionsElse(){ return this.actions_else; }
	
	
	/*-----------------------------SETTEURS-----------------------------*/
	public void setBoolCond(boolean cond){ this.bool_cond = cond; }
	
	public void setStrCond (String s){ this.str_cond = s;	}
	
	public void setActionsIf(List<Action> l){ this.actions_if = l;	}
	
	public void setActionsElse(List<Action> l){ this.actions_else = l; }
	
	
}
