package structure.actions;
import java.util.List;


public class Procedure implements Action {

	private List<Action> actions;
	
	public int executer() {
		for (Action a : this.actions) {
			a.executer();
		}
		return 1;
	}
	
	public void setActions(List<Action> a) {this.actions = a;}
	
	public String toString() {
		return "";
	}
	
}
