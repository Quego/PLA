package vue;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import structure.Controleur;
import enumere.Objet;

public class Interface {
	
	private Image MAIN,P1,P2,MENU,ACTIONS,MUSIC,MUSIC_ON,MUSIC_OFF,PLAY,STOP,POUBELLE,fraise,pasteque,myrtille, couleurs;
	
	private Action emplacement1,emplacement2,emplacement3,emplacement4,emplacement5,emplacement6,emplacement7,emplacement8,emplacement9,emplacement10,emplacement11,emplacement12,emplacement13,emplacement14,emplacement15,emplacement16,emplacement17,emplacement18,emplacement19,emplacement20,emplacement21,emplacement22,emplacement23,emplacement24,emplacement25,emplacement26,emplacement27,emplacement28;
	
	private Action allumer,avancer,tournerG,tournerD,sauter,appuyer,prendre,lacher,lockUnlock,myBreak,testCaseBleue,testAvancer,testSauter,p1,p2;
	
	private boolean running;
	private boolean cleaning;
	
	private String e = "graphisme/Images/actions/emplacement.bmp";
	private String e_lock  = "graphisme/Images/actions/emplacement_lock.bmp";
	
	public void init() throws SlickException {
		
		this.MAIN = new Image("graphisme/Images/fond/fond_actions.png");
		this.P1 = new Image("graphisme/Images/fond/fond_actions.png");
		this.P2 = new Image("graphisme/Images/fond/fond_actions.png");
		this.MENU = new Image("graphisme/Images/fond/fond_actions.png");
		this.ACTIONS = new Image("graphisme/Images/fond/fond_actions.png");
		this.fraise = new Image("graphisme/Images/fruits/panier_fraise.png");
		this.pasteque = new Image("graphisme/Images/fruits/panier_pasteque.png");
		this.myrtille = new Image("graphisme/Images/fruits/panier_myrtille.png");
		this.couleurs = new Image("graphisme/Images/actions/rouge_ou_vert.png");
		this.MUSIC_ON = new Image("graphisme/Images/musiqueON.png");
		this.MUSIC_OFF = new Image("graphisme/Images/musiqueOFF.png");
		this.MUSIC = this.MUSIC_ON;
		this.PLAY = new Image("graphisme/Images/play.png");
		this.STOP = new Image("graphisme/Images/stop.png");
		this.POUBELLE = new Image("graphisme/Images/trash.png");
		
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
		
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 1) this.emplacement1.setImage(new Image(e)); else  this.emplacement1.setImage(new Image(e_lock));
		this.emplacement1.setNom(null);                                            
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 2) this.emplacement2.setImage(new Image(e)); else  this.emplacement2.setImage(new Image(e_lock));
		this.emplacement2.setNom(null);                                              
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 3) this.emplacement3.setImage(new Image(e)); else  this.emplacement3.setImage(new Image(e_lock));
		this.emplacement3.setNom(null);                                              
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 4) this.emplacement4.setImage(new Image(e)); else  this.emplacement4.setImage(new Image(e_lock));
		this.emplacement4.setNom(null);                                              
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 5) this.emplacement5.setImage(new Image(e)); else  this.emplacement5.setImage(new Image(e_lock));
		this.emplacement5.setNom(null);                                              
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 6) this.emplacement6.setImage(new Image(e)); else  this.emplacement6.setImage(new Image(e_lock));
		this.emplacement6.setNom(null);                                              
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 7) this.emplacement7.setImage(new Image(e)); else  this.emplacement7.setImage(new Image(e_lock));
		this.emplacement7.setNom(null);                                              
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 8) this.emplacement8.setImage(new Image(e)); else  this.emplacement8.setImage(new Image(e_lock));
		this.emplacement8.setNom(null);                                              
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 9) this.emplacement9.setImage(new Image(e)); else  this.emplacement9.setImage(new Image(e_lock));
		this.emplacement9.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 10) this.emplacement10.setImage(new Image(e)); else  this.emplacement10.setImage(new Image(e_lock));
		this.emplacement10.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 11) this.emplacement11.setImage(new Image(e)); else  this.emplacement11.setImage(new Image(e_lock));
		this.emplacement11.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 12) this.emplacement12.setImage(new Image(e)); else  this.emplacement12.setImage(new Image(e_lock));
		this.emplacement12.setNom(null);
		
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 1) this.emplacement13.setImage(new Image(e)); else  this.emplacement13.setImage(new Image(e_lock));
		this.emplacement13.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 2) this.emplacement14.setImage(new Image(e)); else  this.emplacement14.setImage(new Image(e_lock));
		this.emplacement14.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 3) this.emplacement15.setImage(new Image(e)); else  this.emplacement15.setImage(new Image(e_lock));
		this.emplacement15.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 4) this.emplacement16.setImage(new Image(e)); else  this.emplacement16.setImage(new Image(e_lock));
		this.emplacement16.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 5) this.emplacement17.setImage(new Image(e)); else  this.emplacement17.setImage(new Image(e_lock));
		this.emplacement17.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 6) this.emplacement18.setImage(new Image(e)); else  this.emplacement18.setImage(new Image(e_lock));
		this.emplacement18.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 7) this.emplacement19.setImage(new Image(e)); else  this.emplacement19.setImage(new Image(e_lock));
		this.emplacement19.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 8) this.emplacement20.setImage(new Image(e)); else  this.emplacement20.setImage(new Image(e_lock));
		this.emplacement20.setNom(null);
		
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 1) this.emplacement21.setImage(new Image(e)); else  this.emplacement21.setImage(new Image(e_lock));
		this.emplacement21.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 2) this.emplacement22.setImage(new Image(e)); else  this.emplacement22.setImage(new Image(e_lock));
		this.emplacement22.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 3) this.emplacement23.setImage(new Image(e)); else  this.emplacement23.setImage(new Image(e_lock));
		this.emplacement23.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 4) this.emplacement24.setImage(new Image(e)); else  this.emplacement24.setImage(new Image(e_lock));
		this.emplacement24.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 5) this.emplacement25.setImage(new Image(e)); else  this.emplacement25.setImage(new Image(e_lock));
		this.emplacement25.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 6) this.emplacement26.setImage(new Image(e)); else  this.emplacement26.setImage(new Image(e_lock));
		this.emplacement26.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 7) this.emplacement27.setImage(new Image(e)); else  this.emplacement27.setImage(new Image(e_lock));
		this.emplacement27.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 8) this.emplacement28.setImage(new Image(e)); else  this.emplacement28.setImage(new Image(e_lock));
		this.emplacement28.setNom(null);
		
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
		lockUnlock.setImage(new Image("graphisme/Images/actions/LockUnlock.png"));
		myBreak.setImage(new Image("graphisme/Images/actions/Break.png"));
		testCaseBleue.setImage(new Image("graphisme/Images/actions/test_bleu.png"));
		testAvancer.setImage(new Image("graphisme/Images/actions/test_avancer.png"));
		testSauter.setImage(new Image("graphisme/Images/actions/test_sauter.png"));
		p1.setImage(new Image("graphisme/Images/actions/P1.png"));
		p2.setImage(new Image("graphisme/Images/actions/P2.png"));
		running = false;
		cleaning = false;
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
		
		panier(Controleur.getMapCourrante().getBot1().getObjets(), container);
		if (Controleur.getMapCourrante().getBot2() != null) panier2(Controleur.getMapCourrante().getBot2().getObjets(), container);
		
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
	
	public void panier(List<Objet> fruit, GameContainer container ){
		float decalage = container.getHeight()/100;
		for (int i = 0; i < fruit.size(); i ++){
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
	}
	
	public void panier2(List<Objet> fruit, GameContainer container ){
		float decalage = container.getHeight()/100;
		for (int i = 0; i < fruit.size(); i ++){
			switch (fruit.get(i)){
				case FRAISE : this.fraise.draw(	2*container.getWidth()/3-50, 
				container.getHeight()/20+decalage + i*50,
				50,
				50);
					break;
				case PASTEQUE : this.pasteque.draw(	2*container.getWidth()/3-50, 
				container.getHeight()/20+decalage + i*50,
				50,
				50);
					break;
				case MYRTILLE : this.myrtille.draw(2*container.getWidth()/3-50, 
				container.getHeight()/20+decalage + i*50,
				50,
				50);
					break;
				default :
					break;
			}
		}
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
	
	public void setEmplacement1 (Action a){ emplacement1 =  a; }
	public void setEmplacement2 (Action a){ emplacement2 =  a; }
	public void setEmplacement3 (Action a){ emplacement3 =  a; }
	public void setEmplacement4 (Action a){ emplacement4 =  a; }
	public void setEmplacement5 (Action a){ emplacement5 =  a; }
	public void setEmplacement6 (Action a){ emplacement6 =  a; }
	public void setEmplacement7 (Action a){ emplacement7 =  a; }
	public void setEmplacement8 (Action a){ emplacement8 =  a; }
	public void setEmplacement9 (Action a){ emplacement9 =  a; }
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
	
	public Action getEmplacement1(){ return emplacement1; }
	public Action getEmplacement2(){ return emplacement2; }
	public Action getEmplacement3(){ return emplacement3; }
	public Action getEmplacement4(){ return emplacement4; }
	public Action getEmplacement5(){ return emplacement5; }
	public Action getEmplacement6(){ return emplacement6; }
	public Action getEmplacement7(){ return emplacement7; }
	public Action getEmplacement8(){ return emplacement8; }
	public Action getEmplacement9(){ return emplacement9; }
	public Action getEmplacement10(){ return emplacement10; }
	public Action getEmplacement11(){ return emplacement11; }
	public Action getEmplacement12(){ return emplacement12; }
	public Action getEmplacement13(){ return emplacement13; }
	public Action getEmplacement14(){ return emplacement14; }
	public Action getEmplacement15(){ return emplacement15; }
	public Action getEmplacement16(){ return emplacement16; }
	public Action getEmplacement17(){ return emplacement17; }
	public Action getEmplacement18(){ return emplacement18; }
	public Action getEmplacement19(){ return emplacement19; }
	public Action getEmplacement20(){ return emplacement20; }
	public Action getEmplacement21(){ return emplacement21; }
	public Action getEmplacement22(){ return emplacement22; }
	public Action getEmplacement23(){ return emplacement23; }
	public Action getEmplacement24(){ return emplacement24; }
	public Action getEmplacement25(){ return emplacement25; }
	public Action getEmplacement26(){ return emplacement26; }
	public Action getEmplacement27(){ return emplacement27; }
	public Action getEmplacement28(){ return emplacement28; }
	
	public Image getMusic() { return this.MUSIC; }
	public void setMusic() { if (this.MUSIC.equals(MUSIC_ON)) this.MUSIC = MUSIC_OFF; else this.MUSIC = MUSIC_ON; }
	
	public boolean getRunning() {return this.running;}
	public void setRunning() { running = !running; }
	
	public List<Action> recupereMain() {
		List<Action> actions = new ArrayList<Action>();
		if (getEmplacement1(). getNom() != null) actions.add(getEmplacement1());
		if (getEmplacement2(). getNom() != null) actions.add(getEmplacement2());
		if (getEmplacement3(). getNom() != null) actions.add(getEmplacement3());
		if (getEmplacement4(). getNom() != null) actions.add(getEmplacement4());
		if (getEmplacement5(). getNom() != null) actions.add(getEmplacement5());
		if (getEmplacement6(). getNom() != null) actions.add(getEmplacement6());
		if (getEmplacement7(). getNom() != null) actions.add(getEmplacement7());
		if (getEmplacement8(). getNom() != null) actions.add(getEmplacement8());
		if (getEmplacement9(). getNom() != null) actions.add(getEmplacement9());
		if (getEmplacement10().getNom() != null) actions.add(getEmplacement10());
		if (getEmplacement11().getNom() != null) actions.add(getEmplacement11());
		if (getEmplacement12().getNom() != null) actions.add(getEmplacement12());
		return actions;
	}
	
	public List<Action> recupereP1() {
		List<Action> actions = new ArrayList<Action>();
		if (getEmplacement13().getNom() != null) actions.add(getEmplacement13());
		if (getEmplacement14().getNom() != null) actions.add(getEmplacement14());
		if (getEmplacement15().getNom() != null) actions.add(getEmplacement15());
		if (getEmplacement16().getNom() != null) actions.add(getEmplacement16());
		if (getEmplacement17().getNom() != null) actions.add(getEmplacement17());
		if (getEmplacement18().getNom() != null) actions.add(getEmplacement18());
		if (getEmplacement19().getNom() != null) actions.add(getEmplacement19());
		if (getEmplacement20().getNom() != null) actions.add(getEmplacement20());
		return actions;
	}
	
	public List<Action> recupereP2() {
		List<Action> actions = new ArrayList<Action>();
		if (getEmplacement21().getNom() != null) actions.add(getEmplacement21());
		if (getEmplacement22().getNom() != null) actions.add(getEmplacement22());
		if (getEmplacement23().getNom() != null) actions.add(getEmplacement23());
		if (getEmplacement24().getNom() != null) actions.add(getEmplacement24());
		if (getEmplacement25().getNom() != null) actions.add(getEmplacement25());
		if (getEmplacement26().getNom() != null) actions.add(getEmplacement26());
		if (getEmplacement27().getNom() != null) actions.add(getEmplacement27());
		if (getEmplacement28().getNom() != null) actions.add(getEmplacement28());
		return actions;
	}
	
	public void effacer() throws SlickException{
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 1)  this.emplacement1. setImage(new Image(e)); else  this.emplacement1 .setImage(new Image(e_lock)); this.emplacement1.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 2)  this.emplacement2. setImage(new Image(e)); else  this.emplacement2 .setImage(new Image(e_lock)); this.emplacement2.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 3)  this.emplacement3. setImage(new Image(e)); else  this.emplacement3 .setImage(new Image(e_lock)); this.emplacement3.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 4)  this.emplacement4. setImage(new Image(e)); else  this.emplacement4 .setImage(new Image(e_lock)); this.emplacement4.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 5)  this.emplacement5. setImage(new Image(e)); else  this.emplacement5 .setImage(new Image(e_lock)); this.emplacement5.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 6)  this.emplacement6. setImage(new Image(e)); else  this.emplacement6 .setImage(new Image(e_lock)); this.emplacement6.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 7)  this.emplacement7. setImage(new Image(e)); else  this.emplacement7 .setImage(new Image(e_lock)); this.emplacement7.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 8)  this.emplacement8. setImage(new Image(e)); else  this.emplacement8 .setImage(new Image(e_lock)); this.emplacement8.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 9)  this.emplacement9. setImage(new Image(e)); else  this.emplacement9 .setImage(new Image(e_lock)); this.emplacement9.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 10) this.emplacement10.setImage(new Image(e)); else  this.emplacement10.setImage(new Image(e_lock)); this.emplacement10.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 11) this.emplacement11.setImage(new Image(e)); else  this.emplacement11.setImage(new Image(e_lock)); this.emplacement11.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 12) this.emplacement12.setImage(new Image(e)); else  this.emplacement12.setImage(new Image(e_lock)); this.emplacement12.setNom(null);
		
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 1) this.emplacement13.setImage(new Image(e)); else  this.emplacement13.setImage(new Image(e_lock)); this.emplacement13.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 2) this.emplacement14.setImage(new Image(e)); else  this.emplacement14.setImage(new Image(e_lock)); this.emplacement14.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 3) this.emplacement15.setImage(new Image(e)); else  this.emplacement15.setImage(new Image(e_lock)); this.emplacement15.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 4) this.emplacement16.setImage(new Image(e)); else  this.emplacement16.setImage(new Image(e_lock)); this.emplacement16.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 5) this.emplacement17.setImage(new Image(e)); else  this.emplacement17.setImage(new Image(e_lock)); this.emplacement17.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 6) this.emplacement18.setImage(new Image(e)); else  this.emplacement18.setImage(new Image(e_lock)); this.emplacement18.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 7) this.emplacement19.setImage(new Image(e)); else  this.emplacement19.setImage(new Image(e_lock)); this.emplacement19.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 8) this.emplacement20.setImage(new Image(e)); else  this.emplacement20.setImage(new Image(e_lock)); this.emplacement20.setNom(null);
		
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 1) this.emplacement21.setImage(new Image(e)); else  this.emplacement21.setImage(new Image(e_lock)); this.emplacement21.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 2) this.emplacement22.setImage(new Image(e)); else  this.emplacement22.setImage(new Image(e_lock)); this.emplacement22.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 3) this.emplacement23.setImage(new Image(e)); else  this.emplacement23.setImage(new Image(e_lock)); this.emplacement23.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 4) this.emplacement24.setImage(new Image(e)); else  this.emplacement24.setImage(new Image(e_lock)); this.emplacement24.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 5) this.emplacement25.setImage(new Image(e)); else  this.emplacement25.setImage(new Image(e_lock)); this.emplacement25.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 6) this.emplacement26.setImage(new Image(e)); else  this.emplacement26.setImage(new Image(e_lock)); this.emplacement26.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 7) this.emplacement27.setImage(new Image(e)); else  this.emplacement27.setImage(new Image(e_lock)); this.emplacement27.setNom(null);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 8) this.emplacement28.setImage(new Image(e)); else  this.emplacement28.setImage(new Image(e_lock)); this.emplacement28.setNom(null);
		cleaning = true;
		running = false;
	}
	
	public boolean getCleaning() {return this.cleaning;}
	public void setCleaning(boolean c) {this.cleaning = c;}
	
}
