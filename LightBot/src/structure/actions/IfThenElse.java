package structure.actions;
import java.util.List;


public abstract class IfThenElse implements Action {

	/**
	 * Attributs de la classe IfThenElse
	 */
	private List<Action> ifActions;
	private List<Action> elseActions;
	
	
	/**
	 * Getteurs - Setteurs
	 */
	
	public List<Action> getIfActions() {return this.ifActions;}
	public void setIfActions(List<Action> a) {this.ifActions = a;}
	
	public List<Action> getElseActions() {return this.elseActions;}
	public void setElseActions(List<Action> a) {this.elseActions = a;}
	
	public String toString() {
		return "";
	}
	
}
