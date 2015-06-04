
public class Avancer implements Action {
	public void executer(){
		int x,y;
		x = Bot.getX();
		y = Bot.getY(); 
		Orientation o = Bot.getOrientation();
		switch (o){
			case SUD 	:	Bot.setX(x+1); 	break;
			case OUEST 	: 	Bot.setY(y-1); 	break;
			case NORD 	: 	Bot.setX(x-1); 	break;
			case EST	: 	Bot.setY(y+1); 	break;
		}	
		
	}
		
}
