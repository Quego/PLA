
public class TournerG implements Action {
	public void executer(){
		Orientation o = Bot.getOrientation();
		switch (o){
			case SUD 	:	o = Orientation.EST; 	break;
			case EST 	: 	o = Orientation.SUD; 	break;
			case NORD 	: 	o = Orientation.OUEST; 	break;
			case OUEST 	: 	o = Orientation.NORD; 	break;
		}
		Bot.setOrientation(o);
	}
}
