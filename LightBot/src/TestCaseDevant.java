package src;

public class TestCaseDevant extends IfThenElse {
	public TestCaseDevant(){
		super("La case devant est un trou", Controleur.getBotActif().getPositionDevant().estDansMap());
	}
	}
