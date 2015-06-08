package src;
import java.util.List;

public class Fonction extends IfThenElse {
	/*-----------------------------CONSTRUCTEURS-----------------------------*/
	public Fonction() {
		super();
	}
	public Fonction(List<Action> p){
		super(p);
	}

	/*---------------------PROCEDURES-&-FONCTIONS-----------------------------*/
	public void executer() {
		super.executer();
	}
	
	public String toString() {
		String s ="";
		if (super.proc_then.isEmpty()) {
			s += "Alors le Bot n'a rien à faire \n";
		}
		else {
			s += "Alors le Bot doit faire cette liste d'actions : " ;
			s += super.proc_then.toString() + "\n";
		}
		return s;
	}
	
	
	/*-----------------------------GETTEUR-----------------------------*/
	public Procedure getFonct(){ return super.proc_then;	}
	
	/*-----------------------------SETTEUR-----------------------------*/
	public void setFonctThen(Procedure f){ super.proc_then = f;	}
	
	
	

}
