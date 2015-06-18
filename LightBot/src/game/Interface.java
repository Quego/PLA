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
	
	private Image couleurs;
	private Action emplacement1,emplacement2,emplacement3,emplacement4,emplacement5,emplacement6,emplacement7,emplacement8,emplacement9,emplacement10,emplacement11,emplacement12,emplacement13,emplacement14,emplacement15,emplacement16,emplacement17,emplacement18,emplacement19,emplacement20,emplacement21,emplacement22,emplacement23,emplacement24,emplacement25,emplacement26,emplacement27,emplacement28;
	
	private Action allumer,avancer,tournerG,tournerD,sauter,appuyer,prendre,lacher,lockUnlock,myBreak,testCaseBleue,testAvancer,testSauter,p1,p2;
	
	private boolean running;
	

	String e = "graphisme/Images/actions/emplacement.bmp";
	String e_lock  = "graphisme/Images/actions/emplacement_lock.bmp";
	
	public void init() throws SlickException {
		this.MAIN = new Image("graphisme/Images/fond/fond_actions.png");
		this.P1 = new Image("graphisme/Images/fond/fond_actions.png");
		this.P2 = new Image("graphisme/Images/fond/fond_actions.png");
		this.MENU = new Image("graphisme/Images/fond/fond_menu.jpg");
		this.ACTIONS = new Image("graphisme/Images/fond/fond_actions.png");
		this.fraise = new Image("graphisme/Images/fruits/panier_fraise.png");
		this.pasteque = new Image("graphisme/Images/fruits/panier_pasteque.png");
		this.myrtille = new Image("graphisme/Images/fruits/panier_myrtille.png");
		this.couleurs = new Image("graphisme/Images/actions/rouge_ou_vert.png");
		MUSIC_ON = new Image("graphisme/Images/musiqueON.png");
		MUSIC_OFF = new Image("graphisme/Images/musiqueOFF.png");
		MUSIC = MUSIC_ON;
		PLAY = new Image("graphisme/Images/play.png");
		STOP = new Image("graphisme/Images/stop.png");
		POUBELLE = new Image("graphisme/Images/trash.png");
		this.emplacement1  = new Action();
		this.emplacement2  = new Action();
		this.emplacement3  = new Action();
		this.emplacement4  = new Action();
		this.emplacement5  = new Action();
		this.emplacement6  = new Action();
		this.emplacement7  = new Action();
		this.emplacement8  = new Action();
		this.emplacement9  = new Action();
		this.emplacement10 = new Action();
		this.emplacement11 = new Action();
		this.emplacement12 = new Action();
		this.emplacement13 = new Action();
		this.emplacement14 = new Action();
		this.emplacement15 = new Action();
		this.emplacement16 = new Action();
		this.emplacement17 = new Action();
		this.emplacement18 = new Action();
		this.emplacement19 = new Action();
		this.emplacement20 = new Action();
		this.emplacement21 = new Action();
		this.emplacement22 = new Action();
		this.emplacement23 = new Action();
		this.emplacement24 = new Action();
		this.emplacement25 = new Action();
		this.emplacement26 = new Action();
		this.emplacement27 = new Action();
		this.emplacement28 = new Action();
		if (WindowGame.getNbActionsMain() >= 1) this.emplacement1.setImage(new Image(e)); else  this.emplacement1.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 2) this.emplacement2.setImage(new Image(e)); else  this.emplacement2.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 3) this.emplacement3.setImage(new Image(e)); else  this.emplacement3.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 4) this.emplacement4.setImage(new Image(e)); else  this.emplacement4.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 5) this.emplacement5.setImage(new Image(e)); else  this.emplacement5.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 6) this.emplacement6.setImage(new Image(e)); else  this.emplacement6.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 7) this.emplacement7.setImage(new Image(e)); else  this.emplacement7.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 8) this.emplacement8.setImage(new Image(e)); else  this.emplacement8.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 9) this.emplacement9.setImage(new Image(e)); else  this.emplacement9.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 10) this.emplacement10.setImage(new Image(e)); else  this.emplacement10.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 11) this.emplacement11.setImage(new Image(e)); else  this.emplacement11.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 12) this.emplacement12.setImage(new Image(e)); else  this.emplacement12.setImage(new Image(e_lock));
		
		if (WindowGame.getNbActionsP1() >= 1) this.emplacement13.setImage(new Image(e)); else  this.emplacement13.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 2) this.emplacement14.setImage(new Image(e)); else  this.emplacement14.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 3) this.emplacement15.setImage(new Image(e)); else  this.emplacement15.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 4) this.emplacement16.setImage(new Image(e)); else  this.emplacement16.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 5) this.emplacement17.setImage(new Image(e)); else  this.emplacement17.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 6) this.emplacement18.setImage(new Image(e)); else  this.emplacement18.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 7) this.emplacement19.setImage(new Image(e)); else  this.emplacement19.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 8) this.emplacement20.setImage(new Image(e)); else  this.emplacement20.setImage(new Image(e_lock));
		
		if (WindowGame.getNbActionsP2() >= 1) this.emplacement21.setImage(new Image(e)); else  this.emplacement21.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 2) this.emplacement22.setImage(new Image(e)); else  this.emplacement22.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 3) this.emplacement23.setImage(new Image(e)); else  this.emplacement23.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 4) this.emplacement24.setImage(new Image(e)); else  this.emplacement24.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 5) this.emplacement25.setImage(new Image(e)); else  this.emplacement25.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 6) this.emplacement26.setImage(new Image(e)); else  this.emplacement26.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 7) this.emplacement27.setImage(new Image(e)); else  this.emplacement27.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 8) this.emplacement28.setImage(new Image(e)); else  this.emplacement28.setImage(new Image(e_lock));
		
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
		this.POUBELLE.draw(2*container.getWidth()/3+20+2*this.emplacement1.getImage().getWidth()+2*decalage2,16*container.getHeight()/20-decalage,4*container.getHeight()/20,4*container.getHeight()/20);
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
		this.emplacement5.draw(2*container.getWidth()/3+20,container.getHeight()/20+decalage + 30 + this.emplacement1.getImage().getHeight() + 10);
		this.emplacement9.draw(2*container.getWidth()/3+20,container.getHeight()/20+decalage + 30 + 2*this.emplacement1.getImage().getHeight() + 2*10);
		
		this.emplacement2.draw(2*container.getWidth()/3+20+this.emplacement1.getImage().getWidth()+decalage2 ,container.getHeight()/20+decalage + 30);
		this.emplacement6.draw(2*container.getWidth()/3+20+this.emplacement1.getImage().getWidth()+decalage2 ,container.getHeight()/20+decalage + 30 + this.emplacement1.getImage().getHeight() + 10);
		this.emplacement10.draw(2*container.getWidth()/3+20+this.emplacement1.getImage().getWidth()+decalage2 ,container.getHeight()/20+decalage + 30 + 2*this.emplacement1.getImage().getHeight() + 2*10);
		
		this.emplacement3.draw(2*container.getWidth()/3+20+2*this.emplacement1.getImage().getWidth()+2*decalage2,container.getHeight()/20+decalage + 30);
		this.emplacement7.draw(2*container.getWidth()/3+20+2*this.emplacement1.getImage().getWidth()+2*decalage2,container.getHeight()/20+decalage + 30 + this.emplacement1.getImage().getHeight() + 10);
		this.emplacement11.draw(2*container.getWidth()/3+20+2*this.emplacement1.getImage().getWidth()+2*decalage2,container.getHeight()/20+decalage + 30 + 2*this.emplacement1.getImage().getHeight() + 2*10);
		
		this.emplacement4.draw(2*container.getWidth()/3+20+3*this.emplacement1.getImage().getWidth()+3*decalage2,container.getHeight()/20+decalage + 30);
		this.emplacement8.draw(2*container.getWidth()/3+20+3*this.emplacement1.getImage().getWidth()+3*decalage2,container.getHeight()/20+decalage + 30 + this.emplacement1.getImage().getHeight() + 10);
		this.emplacement12.draw(2*container.getWidth()/3+20+3*this.emplacement1.getImage().getWidth()+3*decalage2,container.getHeight()/20+decalage + 30 + 2*this.emplacement1.getImage().getHeight() + 2*10);
		
		
		//emplacement P1//
		g.drawString("P1", 2*container.getWidth()/3+5, 7*container.getHeight()/20+2*decalage+5);
		
		this.emplacement13.draw(2*container.getWidth()/3+20, 7*container.getHeight()/20+2*decalage+30);
		this.emplacement17.draw(2*container.getWidth()/3+20, 7*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getImage().getHeight() + 5);
	
		this.emplacement14.draw(2*container.getWidth()/3+20+this.emplacement1.getImage().getWidth()+decalage2 ,7*container.getHeight()/20+2*decalage+30);
		this.emplacement18.draw(2*container.getWidth()/3+20+this.emplacement1.getImage().getWidth()+decalage2 ,7*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getImage().getHeight() + 5);
		
		this.emplacement15.draw(2*container.getWidth()/3+20+2*this.emplacement1.getImage().getWidth()+2*decalage2,7*container.getHeight()/20+2*decalage+30);
		this.emplacement19.draw(2*container.getWidth()/3+20+2*this.emplacement1.getImage().getWidth()+2*decalage2,7*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getImage().getHeight() + 5);
		
		this.emplacement16.draw(2*container.getWidth()/3+20+3*this.emplacement1.getImage().getWidth()+3*decalage2,7*container.getHeight()/20+2*decalage+30);
		this.emplacement20.draw(2*container.getWidth()/3+20+3*this.emplacement1.getImage().getWidth()+3*decalage2,7*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getImage().getHeight() + 5);
		
		
		//emplacement P2//
		g.drawString("P2", 2*container.getWidth()/3+5, 11*container.getHeight()/20+2*decalage+5);
		
		this.emplacement21.draw(2*container.getWidth()/3+20, 11*container.getHeight()/20+2*decalage+30);
		this.emplacement25.draw(2*container.getWidth()/3+20, 11*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getImage().getHeight() + 5);
	
		this.emplacement22.draw(2*container.getWidth()/3+20+this.emplacement1.getImage().getWidth()+decalage2 ,11*container.getHeight()/20+2*decalage+30);
		this.emplacement26.draw(2*container.getWidth()/3+20+this.emplacement1.getImage().getWidth()+decalage2 ,11*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getImage().getHeight() + 5);
		
		this.emplacement23.draw(2*container.getWidth()/3+20+2*this.emplacement1.getImage().getWidth()+2*decalage2,11*container.getHeight()/20+2*decalage+30);
		this.emplacement27.draw(2*container.getWidth()/3+20+2*this.emplacement1.getImage().getWidth()+2*decalage2,11*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getImage().getHeight() + 5);
		
		this.emplacement24.draw(2*container.getWidth()/3+20+3*this.emplacement1.getImage().getWidth()+3*decalage2,11*container.getHeight()/20+2*decalage+30);
		this.emplacement28.draw(2*container.getWidth()/3+20+3*this.emplacement1.getImage().getWidth()+3*decalage2,11*container.getHeight()/20+2*decalage+ 30 + this.emplacement1.getImage().getHeight() + 5);
		
		
		//ACTIONS//
		int lg,lar;
		Image lock = new Image(e_lock);
		lg = this.avancer.getImage().getWidth();
		lar = this.avancer.getImage().getHeight()+10;
		g.drawString("Actions", decalage+5, 16*container.getHeight()/20-decalage);
		if(!avancer.estBloquee()) this.avancer.draw(decalage+20, 16*container.getHeight()/20-decalage+20);
		else lock.draw(decalage+20, 16*container.getHeight()/20-decalage+20);
		if(!allumer.estBloquee())this.allumer.draw(decalage+20+lg+decalage2, 16*container.getHeight()/20-decalage+20);
		else lock.draw(decalage+20+lg+decalage2, 16*container.getHeight()/20-decalage+20);
		if(!tournerG.estBloquee())this.tournerG.draw(decalage+20+2*lg+2*decalage2, 16*container.getHeight()/20-decalage+20);
		else lock.draw(decalage+20+2*lg+2*decalage2, 16*container.getHeight()/20-decalage+20);
		if(!tournerD.estBloquee())this.tournerD.draw(decalage+20+3*lg+3*decalage2, 16*container.getHeight()/20-decalage+20);
		else lock.draw(decalage+20+3*lg+3*decalage2, 16*container.getHeight()/20-decalage+20);
		if(!sauter.estBloquee())this.sauter.draw(decalage+20+4*lg+4*decalage2, 16*container.getHeight()/20-decalage+20);
		else lock.draw(decalage+20+4*lg+4*decalage2, 16*container.getHeight()/20-decalage+20);
		if(!appuyer.estBloquee())this.appuyer.draw(decalage+20+5*lg+5*decalage2, 16*container.getHeight()/20-decalage+20);
		else lock.draw(decalage+20+5*lg+5*decalage2, 16*container.getHeight()/20-decalage+20);
		if(!p1.estBloquee())this.p1.getImage().draw(decalage+20+6*lg+6*decalage2, 16*container.getHeight()/20-decalage+20);
		else lock.draw(decalage+20+6*lg+6*decalage2, 16*container.getHeight()/20-decalage+20);
		if(!(testCaseBleue.estBloquee() && testAvancer.estBloquee() && testSauter.estBloquee())) this.couleurs.draw(decalage+20+7*lg+7*decalage2, 16*container.getHeight()/20-decalage+20,50,50);
		else lock.draw(decalage+20+7*lg+7*decalage2, 16*container.getHeight()/20-decalage+20);
		if(!prendre.estBloquee())this.prendre.draw(decalage+20, 16*container.getHeight()/20-decalage+20+lar);
		else lock.draw(decalage+20, 16*container.getHeight()/20-decalage+20+lar);
		if(!lacher.estBloquee())this.lacher.draw(decalage+20+lg+decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else lock.draw(decalage+20+lg+decalage2, 16*container.getHeight()/20-decalage+20+lar);
		if(!myBreak.estBloquee())this.myBreak.draw(decalage+20+2*lg+2*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else lock.draw(decalage+20+2*lg+2*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		if(!testAvancer.estBloquee())this.testAvancer.draw(decalage+20+3*lg+3*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else lock.draw(decalage+20+3*lg+3*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		if(!testCaseBleue.estBloquee())this.testCaseBleue.draw(decalage+20+4*lg+4*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else lock.draw(decalage+20+4*lg+4*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		if(!lockUnlock.estBloquee())this.lockUnlock.draw(decalage+20+5*lg+5*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else lock.draw(decalage+20+5*lg+5*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		if(!p2.estBloquee())this.p2.draw(decalage+20+6*lg+6*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else lock.draw(decalage+20+6*lg+6*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		if(!testSauter.estBloquee())this.testSauter.draw(decalage+20+7*lg+7*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else lock.draw(decalage+20+7*lg+7*decalage2, 16*container.getHeight()/20-decalage+20+lar);
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
	
	public void setEmplacement1(Action a){ emplacement1   = a;  }
	public void setEmplacement2(Action a){ emplacement2   = a; }
	public void setEmplacement3(Action a){ emplacement3   = a; }
	public void setEmplacement4(Action a){ emplacement4   = a; }
	public void setEmplacement5(Action a){ emplacement5   = a; }
	public void setEmplacement6(Action a){ emplacement6   = a; }
	public void setEmplacement7(Action a){ emplacement7   = a; }
	public void setEmplacement8(Action a){ emplacement8   = a; }
	public void setEmplacement9(Action a){ emplacement9   = a; }
	public void setEmplacement10(Action a){ emplacement10 = a; }
	public void setEmplacement11(Action a){ emplacement11 = a; }
	public void setEmplacement12(Action a){ emplacement12 = a; }
	public void setEmplacement13(Action a){ emplacement13 = a; }
	public void setEmplacement14(Action a){ emplacement14 = a; }
	public void setEmplacement15(Action a){ emplacement15 = a; }
	public void setEmplacement16(Action a){ emplacement16 = a; }
	public void setEmplacement17(Action a){ emplacement17 = a; }
	public void setEmplacement18(Action a){ emplacement18 = a; }
	public void setEmplacement19(Action a){ emplacement19 = a; }
	public void setEmplacement20(Action a){ emplacement20 = a; }
	public void setEmplacement21(Action a){ emplacement21 = a; }
	public void setEmplacement22(Action a){ emplacement22 = a; }
	public void setEmplacement23(Action a){ emplacement23 = a; }
	public void setEmplacement24(Action a){ emplacement24 = a; }
	public void setEmplacement25(Action a){ emplacement25 = a; }
	public void setEmplacement26(Action a){ emplacement26 = a; }
	public void setEmplacement27(Action a){ emplacement27 = a; }
	public void setEmplacement28(Action a){ emplacement28 = a; }
	
	public Image getMusic() { return this.MUSIC; }
	public void setMusic() { if (this.MUSIC.equals(MUSIC_ON)) this.MUSIC = MUSIC_OFF; else this.MUSIC = MUSIC_ON; }
	
	public void setRunning() { running = !running; }
	
	public void effacer() throws SlickException{
		if (WindowGame.getNbActionsMain() >= 1) this.emplacement1.setImage(new Image(e)); else  this.emplacement1.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 2) this.emplacement2.setImage(new Image(e)); else  this.emplacement2.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 3) this.emplacement3.setImage(new Image(e)); else  this.emplacement3.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 4) this.emplacement4.setImage(new Image(e)); else  this.emplacement4.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 5) this.emplacement5.setImage(new Image(e)); else  this.emplacement5.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 6) this.emplacement6.setImage(new Image(e)); else  this.emplacement6.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 7) this.emplacement7.setImage(new Image(e)); else  this.emplacement7.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 8) this.emplacement8.setImage(new Image(e)); else  this.emplacement8.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 9) this.emplacement9.setImage(new Image(e)); else  this.emplacement9.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 10) this.emplacement10.setImage(new Image(e)); else  this.emplacement10.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 11) this.emplacement11.setImage(new Image(e)); else  this.emplacement11.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsMain() >= 12) this.emplacement12.setImage(new Image(e)); else  this.emplacement12.setImage(new Image(e_lock));
		
		if (WindowGame.getNbActionsP1() >= 1) this.emplacement13.setImage(new Image(e)); else  this.emplacement13.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 2) this.emplacement14.setImage(new Image(e)); else  this.emplacement14.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 3) this.emplacement15.setImage(new Image(e)); else  this.emplacement15.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 4) this.emplacement16.setImage(new Image(e)); else  this.emplacement16.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 5) this.emplacement17.setImage(new Image(e)); else  this.emplacement17.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 6) this.emplacement18.setImage(new Image(e)); else  this.emplacement18.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 7) this.emplacement19.setImage(new Image(e)); else  this.emplacement19.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP1() >= 8) this.emplacement20.setImage(new Image(e)); else  this.emplacement20.setImage(new Image(e_lock));
		                                                                                                        
		if (WindowGame.getNbActionsP2() >= 1) this.emplacement21.setImage(new Image(e)); else  this.emplacement21.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 2) this.emplacement22.setImage(new Image(e)); else  this.emplacement22.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 3) this.emplacement23.setImage(new Image(e)); else  this.emplacement23.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 4) this.emplacement24.setImage(new Image(e)); else  this.emplacement24.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 5) this.emplacement25.setImage(new Image(e)); else  this.emplacement25.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 6) this.emplacement26.setImage(new Image(e)); else  this.emplacement26.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 7) this.emplacement27.setImage(new Image(e)); else  this.emplacement27.setImage(new Image(e_lock));
		if (WindowGame.getNbActionsP2() >= 8) this.emplacement28.setImage(new Image(e)); else  this.emplacement28.setImage(new Image(e_lock));
		
	}
	
}
