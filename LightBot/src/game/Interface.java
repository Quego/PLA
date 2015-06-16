package game;

import java.util.ArrayList;
import java.util.List;

import model.Objet;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Interface {
	
	private Image MAIN,P1,P2,MENU,ACTIONS,MUSIC,MUSIC_ON,MUSIC_OFF,PLAY,STOP,POUBELLE,fraise,pasteque,myrtille;
	
	private Image emplacement1,emplacement2,emplacement3,emplacement4,emplacement5,emplacement6,emplacement7,emplacement8,emplacement9,emplacement10,emplacement11,emplacement12,emplacement13,emplacement14,emplacement15,emplacement16,emplacement17,emplacement18,emplacement19,emplacement20,emplacement21,emplacement22,emplacement23,emplacement24,emplacement25,emplacement26,emplacement27,emplacement28;
	
	private Action allumer,avancer,tournerG,tournerD,sauter,appuyer,prendre,lacher,lockUnlock,myBreak,testCaseBleue,testAvancer,testSauter,p1,p2;
	
	private boolean running;
	
	public void init() throws SlickException {
		
		this.MAIN = new Image("graphisme/Images/fond/fond_actions.png");
		this.P1 = new Image("graphisme/Images/fond/fond_actions.png");
		this.P2 = new Image("graphisme/Images/fond/fond_actions.png");
		this.MENU = new Image("graphisme/Images/fond/fond_actions.png");
		this.ACTIONS = new Image("graphisme/Images/fond/fond_actions.png");
		this.fraise = new Image("graphisme/Images/fruits/panier_fraise.png");
		this.pasteque = new Image("graphisme/Images/fruits/panier_pasteque.png");
		this.myrtille = new Image("graphisme/Images/fruits/panier_myrtille.png");
		MUSIC_ON = new Image("graphisme/Images/musiqueON.png");
		MUSIC_OFF = new Image("graphisme/Images/musiqueOFF.png");
		MUSIC = MUSIC_ON;
		PLAY = new Image("graphisme/Images/play.png");
		STOP = new Image("graphisme/Images/stop.png");
		POUBELLE = new Image("graphisme/Images/trash.png");
		this.emplacement1 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement2 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement3 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement4 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement5 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement6 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement7 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement8 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement9 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement10 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement11 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement12 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement13 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement14 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement15 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement16 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement17 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement18 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement19 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement20 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement21 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement22 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement23 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement24 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement25 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement26 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement27 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement28 = new Image("graphisme/Images/actions/emplacement.bmp");
		allumer = new Action();
		avancer = new Action();
		tournerG = new Action();
		tournerD = new Action();
		sauter = new Action();
		appuyer = new Action();
		prendre = new Action();
		lacher = new Action();
		lockUnlock = new Action();
		myBreak = new Action();
		testCaseBleue = new Action();
		testAvancer = new Action();
		testSauter = new Action();
		p1 = new Action();
		p2 = new Action();
		allumer.setImage(new Image("graphisme/Images/actions/Allumer.png"));
		avancer.setImage(new Image("graphisme/Images/actions/Avancer.png"));
		tournerG.setImage(new Image("graphisme/Images/actions/TournerGauche.png"));
		tournerD.setImage(new Image("graphisme/Images/actions/TournerDroite.png"));
		sauter.setImage(new Image("graphisme/Images/actions/Sauter.png"));
		appuyer.setImage(new Image("graphisme/Images/actions/Appuie.png"));
		prendre.setImage(new Image("graphisme/Images/actions/Prendre.png"));
		lacher.setImage(new Image("graphisme/Images/actions/Poser.png"));
		lockUnlock.setImage(new Image("graphisme/Images/actions/Allumer.png"));///////////////
		myBreak.setImage(new Image("graphisme/Images/actions/Break.png"));
		testCaseBleue.setImage(new Image("graphisme/Images/actions/Allumer.png"));//////////
		testAvancer.setImage(new Image("graphisme/Images/actions/Allumer.png"));////////
		testSauter.setImage(new Image("graphisme/Images/actions/Allumer.png"));/////////
		p1.setImage(new Image("graphisme/Images/actions/P1.png"));
		p2.setImage(new Image("graphisme/Images/actions/P2.png"));
		running = false;
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.resetTransform();
		float decalage = container.getHeight()/100;
		float decalage2 = 28;
		g.setColor(Color.black);
		
		
		this.MAIN.draw(2*container.getWidth()/3, 
						container.getHeight()/20+decalage,
						container.getWidth()/3-decalage,
						6*container.getHeight()/20);
		
		this.P1.draw(2*container.getWidth()/3, 
						7*container.getHeight()/20+2*decalage,
						container.getWidth()/3-decalage,
						4*container.getHeight()/20);
		
		this.P2.draw(2*container.getWidth()/3, 
						11*container.getHeight()/20+3*decalage,
						container.getWidth()/3-decalage,
						4*container.getHeight()/20);
		
		this.MENU.draw(0, 
						0,
						container.getWidth(),
						container.getHeight()/20);
		
		panier(/*List<Objet> fruit,*/ container);
		
		this.ACTIONS.draw(decalage, 
						16*container.getHeight()/20-decalage,
						2*container.getWidth()/3-2*decalage,
						4*container.getHeight()/20);
		g.drawString("M",container.getWidth()-this.MUSIC.getWidth()-decalage2-5,5);
		this.MUSIC.draw(container.getWidth()-this.MUSIC.getWidth()-decalage2, 0,container.getHeight()/20,container.getHeight()/20);
		this.POUBELLE.draw(2*container.getWidth()/3+20+2*this.emplacement1.getWidth()+2*decalage2,16*container.getHeight()/20-decalage,4*container.getHeight()/20,4*container.getHeight()/20);
		if (!running) {
			this.PLAY.draw(2*container.getWidth()/3+20,16*container.getHeight()/20-decalage,4*container.getHeight()/20,4*container.getHeight()/20);
		}
		else {
			this.STOP.draw(2*container.getWidth()/3+20,16*container.getHeight()/20-decalage,4*container.getHeight()/20,4*container.getHeight()/20);
		}
		g.drawString("Menu",5,5);
		
		//emplacement MAIN//
    	g.drawString("Main", 2*container.getWidth()/3+5,container.getHeight()/20+ decalage + 5);

		this.emplacement1.draw(2*container.getWidth()/3+20,container.getHeight()/20+decalage + 30);
		this.emplacement5.draw(2*container.getWidth()/3+20,container.getHeight()/20+decalage + 30 + this.emplacement1.getHeight() + 10);
		this.emplacement9.draw(2*container.getWidth()/3+20,container.getHeight()/20+decalage + 30 + 2*this.emplacement1.getHeight() + 2*10);
		
		this.emplacement2.draw(2*container.getWidth()/3+20+this.emplacement1.getWidth()+decalage2 ,container.getHeight()/20+decalage + 30);
		this.emplacement6.draw(2*container.getWidth()/3+20+this.emplacement1.getWidth()+decalage2 ,container.getHeight()/20+decalage + 30 + this.emplacement1.getHeight() + 10);
		this.emplacement10.draw(2*container.getWidth()/3+20+this.emplacement1.getWidth()+decalage2 ,container.getHeight()/20+decalage + 30 + 2*this.emplacement1.getHeight() + 2*10);
		
		this.emplacement3.draw(2*container.getWidth()/3+20+2*this.emplacement1.getWidth()+2*decalage2,container.getHeight()/20+decalage + 30);
		this.emplacement7.draw(2*container.getWidth()/3+20+2*this.emplacement1.getWidth()+2*decalage2,container.getHeight()/20+decalage + 30 + this.emplacement1.getHeight() + 10);
		this.emplacement11.draw(2*container.getWidth()/3+20+2*this.emplacement1.getWidth()+2*decalage2,container.getHeight()/20+decalage + 30 + 2*this.emplacement1.getHeight() + 2*10);
		
		this.emplacement4.draw(2*container.getWidth()/3+20+3*this.emplacement1.getWidth()+3*decalage2,container.getHeight()/20+decalage + 30);
		this.emplacement8.draw(2*container.getWidth()/3+20+3*this.emplacement1.getWidth()+3*decalage2,container.getHeight()/20+decalage + 30 + this.emplacement1.getHeight() + 10);
		this.emplacement12.draw(2*container.getWidth()/3+20+3*this.emplacement1.getWidth()+3*decalage2,container.getHeight()/20+decalage + 30 + 2*this.emplacement1.getHeight() + 2*10);
		
		
		//emplacement P1//
		g.drawString("P1", 2*container.getWidth()/3+5, 7*container.getHeight()/20+2*decalage+5);
		
		this.emplacement13.draw(2*container.getWidth()/3+20, 7*container.getHeight()/20+2*decalage+30);
		this.emplacement17.draw(2*container.getWidth()/3+20, 7*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
	
		this.emplacement14.draw(2*container.getWidth()/3+20+this.emplacement1.getWidth()+decalage2 ,7*container.getHeight()/20+2*decalage+30);
		this.emplacement18.draw(2*container.getWidth()/3+20+this.emplacement1.getWidth()+decalage2 ,7*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
		
		this.emplacement15.draw(2*container.getWidth()/3+20+2*this.emplacement1.getWidth()+2*decalage2,7*container.getHeight()/20+2*decalage+30);
		this.emplacement19.draw(2*container.getWidth()/3+20+2*this.emplacement1.getWidth()+2*decalage2,7*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
		
		this.emplacement16.draw(2*container.getWidth()/3+20+3*this.emplacement1.getWidth()+3*decalage2,7*container.getHeight()/20+2*decalage+30);
		this.emplacement20.draw(2*container.getWidth()/3+20+3*this.emplacement1.getWidth()+3*decalage2,7*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
		
		
		//emplacement P2//
		g.drawString("P2", 2*container.getWidth()/3+5, 11*container.getHeight()/20+2*decalage+5);
		
		this.emplacement21.draw(2*container.getWidth()/3+20, 11*container.getHeight()/20+2*decalage+30);
		this.emplacement25.draw(2*container.getWidth()/3+20, 11*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
	
		this.emplacement22.draw(2*container.getWidth()/3+20+this.emplacement1.getWidth()+decalage2 ,11*container.getHeight()/20+2*decalage+30);
		this.emplacement26.draw(2*container.getWidth()/3+20+this.emplacement1.getWidth()+decalage2 ,11*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
		
		this.emplacement23.draw(2*container.getWidth()/3+20+2*this.emplacement1.getWidth()+2*decalage2,11*container.getHeight()/20+2*decalage+30);
		this.emplacement27.draw(2*container.getWidth()/3+20+2*this.emplacement1.getWidth()+2*decalage2,11*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
		
		this.emplacement24.draw(2*container.getWidth()/3+20+3*this.emplacement1.getWidth()+3*decalage2,11*container.getHeight()/20+2*decalage+30);
		this.emplacement28.draw(2*container.getWidth()/3+20+3*this.emplacement1.getWidth()+3*decalage2,11*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getHeight() + 5);
		
		
		//ACTIONS//
		int lg,lar;
		lg = this.avancer.getImage().getWidth();
		lar = this.avancer.getImage().getHeight()+10;
		g.drawString("Actions", decalage+5, 16*container.getHeight()/20-decalage);
		this.avancer.getImage().draw(decalage+20, 16*container.getHeight()/20-decalage+20);
		this.allumer.getImage().draw(decalage+20+lg+decalage2, 16*container.getHeight()/20-decalage+20);
		this.tournerG.getImage().draw(decalage+20+2*lg+2*decalage2, 16*container.getHeight()/20-decalage+20);
		this.tournerD.getImage().draw(decalage+20+3*lg+3*decalage2, 16*container.getHeight()/20-decalage+20);
		this.sauter.getImage().draw(decalage+20+4*lg+4*decalage2, 16*container.getHeight()/20-decalage+20);
		this.appuyer.getImage().draw(decalage+20+5*lg+5*decalage2, 16*container.getHeight()/20-decalage+20);
		this.p1.getImage().draw(decalage+20+6*lg+6*decalage2, 16*container.getHeight()/20-decalage+20);
		this.prendre.getImage().draw(decalage+20, 16*container.getHeight()/20-decalage+20+lar);
		this.lacher.getImage().draw(decalage+20+lg+decalage2, 16*container.getHeight()/20-decalage+20+lar);
		this.myBreak.getImage().draw(decalage+20+2*lg+2*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		this.testAvancer.getImage().draw(decalage+20+3*lg+3*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		this.testCaseBleue.getImage().draw(decalage+20+4*lg+4*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		this.lockUnlock.getImage().draw(decalage+20+5*lg+5*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		this.p2.getImage().draw(decalage+20+6*lg+6*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		this.testSauter.getImage().draw(decalage+20+7*lg+7*decalage2, 16*container.getHeight()/20-decalage+20+lar);
	}
	
	
	public void panier(/*List<Objet> fruit,*/ GameContainer container ){
		float decalage = container.getHeight()/100;
		for (int i = 0; i < 4; i ++){
		this.fraise.draw(0, 
				container.getHeight()/20+decalage + i*50,
				50,
				50);}
	/*	for (int i = 0; i < fruit.size(); i ++){
			switch (fruit.get(i)){
				case FRAISE : this.fraise.draw(0, 
				container.getHeight()/20+decalage + i*50,
				50,
				50);
					break;
				case PASTEQUE : this.pasteque.draw(0, 
				container.getHeight()/20+decalage + i*50,
				50,
				50);
					break;
				case MYRTILLE : this.myrtille.draw(0, 
				container.getHeight()/20+decalage + i*50,
				50,
				50);
					break;
				default :
					break;
			}
		}
		
		
		*/
	}
	
	
	public Action getAllumer(){ return allumer; }
	public Action getAvancer() { return avancer; }
	public Action getTournerG() { return tournerG; }
	public Action getTournerD() { return tournerD; }
	public Action getSauter() { return sauter; }
	public Action getAppuyer(){ return appuyer; }
	public Action getPrendre(){ return prendre; }
	public Action getLacher(){ return lacher; }
	public Action getLockUnlock(){ return lockUnlock; }
	public Action getMyBreak(){ return myBreak; }
	public Action getTestCaseBleue(){ return testCaseBleue; }
	public Action getTestAvancer(){ return testAvancer; }
	public Action getTestSauter(){ return testSauter; }
	public Action getP1() { return p1; }
	public Action getP2() { return p2; }
	
	public void setEmplacement1(Image i){ emplacement1 = i; }
	public void setEmplacement2(Image i){ emplacement2 = i; }
	public void setEmplacement3(Image i){ emplacement3 = i; }
	public void setEmplacement4(Image i){ emplacement4 = i; }
	public void setEmplacement5(Image i){ emplacement5 = i; }
	public void setEmplacement6(Image i){ emplacement6 = i; }
	public void setEmplacement7(Image i){ emplacement7 = i; }
	public void setEmplacement8(Image i){ emplacement8 = i; }
	public void setEmplacement9(Image i){ emplacement9 = i; }
	public void setEmplacement10(Image i){ emplacement10 = i; }
	public void setEmplacement11(Image i){ emplacement11 = i; }
	public void setEmplacement12(Image i){ emplacement12 = i; }
	public void setEmplacement13(Image i){ emplacement13 = i; }
	public void setEmplacement14(Image i){ emplacement14 = i; }
	public void setEmplacement15(Image i){ emplacement15 = i; }
	public void setEmplacement16(Image i){ emplacement16 = i; }
	public void setEmplacement17(Image i){ emplacement17= i; }
	public void setEmplacement18(Image i){ emplacement18 = i; }
	public void setEmplacement19(Image i){ emplacement19 = i; }
	public void setEmplacement20(Image i){ emplacement20 = i; }
	public void setEmplacement21(Image i){ emplacement21 = i; }
	public void setEmplacement22(Image i){ emplacement22 = i; }
	public void setEmplacement23(Image i){ emplacement23 = i; }
	public void setEmplacement24(Image i){ emplacement24= i; }
	public void setEmplacement25(Image i){ emplacement25 = i; }
	public void setEmplacement26(Image i){ emplacement26 = i; }
	public void setEmplacement27(Image i){ emplacement27 = i; }
	public void setEmplacement28(Image i){ emplacement28 = i; }
	
	public Image getMusic() { return this.MUSIC; }
	public void setMusic() { if (this.MUSIC.equals(MUSIC_ON)) this.MUSIC = MUSIC_OFF; else this.MUSIC = MUSIC_ON; }
	
	public void setRunning() { running = !running; }
	
	public void effacer() throws SlickException{
		this.emplacement1 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement2 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement3 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement4 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement5 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement6 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement7 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement8 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement9 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement10 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement11 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement12 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement13 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement14 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement15 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement16 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement17 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement18 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement19 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement20 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement21 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement22 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement23 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement24 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement25 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement26 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement27 = new Image("graphisme/Images/actions/emplacement.bmp");
		this.emplacement28 = new Image("graphisme/Images/actions/emplacement.bmp");
	}
	
}
