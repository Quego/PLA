
public class TournerD implements Action{
	public void executer(){
		Orientation o = Bot.getOrientation();
		switch (o){
			case SUD 	:	o = Orientation.OUEST; 	break;
			case EST 	: 	o = Orientation.NORD; 	break;
			case NORD 	: 	o = Orientation.EST; 	break;
			case OUEST 	: 	o = Orientation.SUD; 	break;
		}
	}
}
