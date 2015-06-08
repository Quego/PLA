package src;
import java.util.*;

public class IfThenElse {

	/*-----------------------------ATTRIBUTS-----------------------------*/
	/**
	 * str_cond repr�sente la chaine de caract�re de la condition
	 * bool_cond repr�sente la valeur de la condition
	 * proc_then repr�sente les actions que le Bot doit ex�cuter si la condition est v�rifi�e
	 * proc_else repr�sente les actions que le Bot doit ex�cuter si la condition n'est pas v�rifi�e
	 */
	protected String str_cond;
	protected boolean bool_cond;
	protected Procedure proc_then;
	protected Procedure proc_else;
	
	
	
	/*-----------------------------CONSTRUCTEURS-----------------------------*/
	public IfThenElse(){
		this.str_cond = "vrai";
		this.bool_cond = true;
		this.proc_then = new Procedure();
		this.proc_else = new Procedure();
	}
	public IfThenElse(List<Action> p){
		this.str_cond = "vrai";
		this.bool_cond = true;
		this.proc_then = new Procedure(p);
		this.proc_else = new Procedure();
	}
	public IfThenElse(List<Action> p_then,List<Action> p_else){
		this.str_cond = "vrai";
		this.bool_cond = true;
		this.proc_then = new Procedure(p_then);
		this.proc_else = new Procedure(p_then);
	}
	public IfThenElse(String str, boolean cond, List<Action> p_then,List<Action> p_else){
		this.str_cond = str;
		this.bool_cond = cond;
		this.proc_then = new Procedure(p_then);
		this.proc_else = new Procedure(p_then);
	}
	
	/*---------------------PROCEDURES-&-FONCTIONS-----------------------------*/
	/**
	 * Ex�cute une des 2 proc�dures en fonction de la condition
	 */	
	public void executer(){
		if (bool_cond) 	{
			Controleur.getBotActif().setCouleur(Couleur.VERT);
			proc_then.executer();
		}
		else	{
			Controleur.getBotActif().setCouleur(Couleur.ROUGE);	
			proc_else.executer();
		}
	}
	
	public String toString() {
		String s = "";
		s += "Si " + str_cond + "\n";
		if (this.proc_then.isEmpty()) {
			s += "Alors le Bot n'a rien � faire \n";
		}
		else {
			s += "Alors le Bot doit faire cette liste d'actions : ";
			s += this.proc_then.toString() + "\n";
		}
		if (this.proc_else.isEmpty()) {
			s += "Sinon il n'a rien � faire \n";
		}
		else {
			s += "Sinon il doit faire cette liste d'actions : "; 
			s += this.proc_then.toString() + "\n";
		}
		return s;
	}
	
	/*-----------------------------GETTEURS-----------------------------*/
	public boolean getBoolCond(){ return this.bool_cond; }
	
	public String getStrCond (){ return this.str_cond;	}
	
	public Procedure getFonctThen(){ return this.proc_then;	}
	
	public Procedure getFonctElse(){ return this.proc_else; }
	
	
	/*-----------------------------SETTEURS-----------------------------*/
	public void setBoolCond(boolean cond){ this.bool_cond = cond; }
	
	public void setStrCond (String s){ this.str_cond = s;	}
	
	public void setFonctThen(Procedure f){ this.proc_then = f;	}
	
	public void setFonctElse(Procedure f){ this.proc_else = f; }
	
	
}
