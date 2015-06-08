
public class IfThenElse {

	/*-----------------------------ATTRIBUTS-----------------------------*/
	/**
	 * str_cond repr�sente la chaine de caract�re de la condition
	 * bool_cond repr�sente la valeur de la condition
	 * proc_then repr�sente les actions que le Bot doit ex�cuter si la condition est v�rifi�e
	 * proc_else repr�sente les actions que le Bot doit ex�cuter si la condition n'est pas v�rifi�e
	 */
	private String str_cond;
	private boolean bool_cond;
	private Procedure proc_then;
	private Procedure proc_else;
	
	
	
	/*-----------------------------CONSTRUCTEURS-----------------------------*/
	public IfThenElse(){
		this.str_cond = "vrai";
		this.bool_cond = true;
		this.proc_then.Procedure();
		this.proc_else.Procedure(p);
	}
	public IfThenElse(Procedure p){
		this.str_cond = "vrai";
		this.bool_cond = true;
		this.proc_then.Procedure(p);
		this.proc_else.Procedure();
	}
	public IfThenElse(Procedure p_then,Procedure p_else){
		this.str_cond = "vrai";
		this.bool_cond = true;
		this.proc_then.Procedure(p_then);
		this.proc_else.Procedure(p_then);
	}
	public IfThenElse(String str, boolean cond, Procedure p_then,Procedure p_else){
		this.str_cond = str;
		this.bool_cond = cond;
		this.proc_then.Procedure(p_then);
		this.proc_else.Procedure(p_then);
	}
	
	/*---------------------PROCEDURES-&-FONCTIONS-----------------------------*/
	/**
	 * Ex�cute une des 2 proc�dures en fonction de la condition
	 */	
	public void executer(){
		if (cond) 	{
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
			s+ = "Alors le Bot n'a rien � faire \n";
		}
		else {
			s += "Alors le Bot doit faire cette liste d'actions : " 
			s += this.proc_then.toString() + "\n";
		}
		if (this.proc_else.isEmpty()) {
			s += "Sinon il n'a rien � faire \n";
		}
		else {
			s += "Sinon il doit faire cette liste d'actions : " 
			s += this.proc_then.toString() + "\n";
		}
		return s;
	}
	
	/*-----------------------------GETTEURS-----------------------------*/
	public boolean getBoolCond(){ return this.bool_cond; }
	
	public String getStrCond (){ return this.str_cond;	}
	
	public Fonction getFonctThen(){ return this.proc_then;	}
	
	public Fonction getFonctElse(){ return this.proc_else; }
	
	
	/*-----------------------------SETTEURS-----------------------------*/
	public void setBoolCond(boolean cond){ this.bool_cond = cond; }
	
	public void setStrCond (String s){ this.str_cond = s;	}
	
	public void setFonctThen(Fonction f){ this.proc_then = f;	}
	
	public void setFonctElse(Fonction f){ this.proc_else = f; }
	
	
}
