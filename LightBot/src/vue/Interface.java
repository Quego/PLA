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
	
	private Image main,proc1,proc2,menu,actions,music,musicOn,musicOff,play,stop,poubelle,fraise,pasteque,myrtille, couleurs;
	
	private Action emplacement1,emplacement2,emplacement3,emplacement4,emplacement5,emplacement6,emplacement7,emplacement8,emplacement9,emplacement10,emplacement11,emplacement12,emplacement13,emplacement14,emplacement15,emplacement16,emplacement17,emplacement18,emplacement19,emplacement20,emplacement21,emplacement22,emplacement23,emplacement24,emplacement25,emplacement26,emplacement27,emplacement28;
	
	private Action allumer,avancer,tournerG,tournerD,sauter,appuyer,prendre,lacher,lockUnlock,myBreak,testCaseBleue,testAvancer,testSauter,p1,p2;
	
	private boolean running;
	private boolean cleaning;
	
	private String e = "graphisme/Images/actions/emplacement.bmp";
	private String e_lock  = "graphisme/Images/actions/emplacement_lock.bmp";
	
	public void init() throws SlickException {
		
		this.main = new Image("graphisme/Images/fond/fond_actions.png");
		this.proc1 = new Image("graphisme/Images/fond/fond_actions.png");
		this.proc2 = new Image("graphisme/Images/fond/fond_actions.png");
		this.menu = new Image("graphisme/Images/fond/fond_actions.png");
		this.actions = new Image("graphisme/Images/fond/fond_actions.png");
		this.fraise = new Image("graphisme/Images/fruits/panier_fraise.png");
		this.pasteque = new Image("graphisme/Images/fruits/panier_pasteque.png");
		this.myrtille = new Image("graphisme/Images/fruits/panier_myrtille.png");
		this.couleurs = new Image("graphisme/Images/actions/rouge_ou_vert.png");
		this.musicOn = new Image("graphisme/Images/musiqueON.png");
		this.musicOff = new Image("graphisme/Images/musiqueOFF.png");
		this.music = this.musicOn;
		this.play = new Image("graphisme/Images/play.png");
		this.stop = new Image("graphisme/Images/stop.png");
		this.poubelle = new Image("graphisme/Images/trash.png");
		
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
		
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 1) this.emplacement1.setImage(new Image(e));else  this.emplacement1.setImage(new Image(e_lock));
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
		
		this.allumer = new Action();
		this.avancer = new Action();
		this.tournerG = new Action();
		this.tournerD = new Action();
		this.sauter = new Action();
		this.appuyer = new Action();
		this.prendre = new Action();
		this.lacher = new Action();
		this.lockUnlock = new Action();
		this.myBreak = new Action();
		this.testCaseBleue = new Action();
		this.testAvancer = new Action();
		this.testSauter = new Action();
		this.p1 = new Action();
		this.p2 = new Action();
		this.allumer.setImage(new Image("graphisme/Images/actions/Allumer.png"));
		this.avancer.setImage(new Image("graphisme/Images/actions/Avancer.png"));
		this.tournerG.setImage(new Image("graphisme/Images/actions/TournerGauche.png"));
		this.tournerD.setImage(new Image("graphisme/Images/actions/TournerDroite.png"));
		this.sauter.setImage(new Image("graphisme/Images/actions/Sauter.png"));
		this.appuyer.setImage(new Image("graphisme/Images/actions/Appuie.png"));
		this.prendre.setImage(new Image("graphisme/Images/actions/Prendre.png"));
		this.lacher.setImage(new Image("graphisme/Images/actions/Poser.png"));
		this.lockUnlock.setImage(new Image("graphisme/Images/actions/LockUnlock.png"));
		this.myBreak.setImage(new Image("graphisme/Images/actions/Break.png"));
		this.testCaseBleue.setImage(new Image("graphisme/Images/actions/test_bleu.png"));
		this.testAvancer.setImage(new Image("graphisme/Images/actions/test_avancer.png"));
		this.testSauter.setImage(new Image("graphisme/Images/actions/test_sauter.png"));
		this.p1.setImage(new Image("graphisme/Images/actions/P1.png"));
		this.p2.setImage(new Image("graphisme/Images/actions/P2.png"));
		this.running = false;
		this.cleaning = false;
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.resetTransform();
		float decalage = container.getHeight()/100;
		float decalage2 = 28;
		g.setColor(Color.black);
		
		this.main.draw(2*container.getWidth()/3, 
						container.getHeight()/20+decalage,
						container.getWidth()/3-decalage,
						6*container.getHeight()/20);
		
		this.proc1.draw(2*container.getWidth()/3, 
						7*container.getHeight()/20+2*decalage,
						container.getWidth()/3-decalage,
						4*container.getHeight()/20);
		
		this.proc2.draw(2*container.getWidth()/3, 
						11*container.getHeight()/20+3*decalage,
						container.getWidth()/3-decalage,
						4*container.getHeight()/20);
		
		this.menu.draw(0, 
					   0,
					   container.getWidth(),
					   container.getHeight()/20);
		
		panier(Controleur.getMapCourrante().getBot1().getObjets(), container);
		if (Controleur.getMapCourrante().getBot2() != null) panier2(Controleur.getMapCourrante().getBot2().getObjets(), container);
		
		this.actions.draw(decalage, 
						16*container.getHeight()/20-decalage,
						2*container.getWidth()/3-2*decalage,
						4*container.getHeight()/20);
		
		g.drawString("M",container.getWidth()-this.music.getWidth()-decalage2-5,5);
		
		this.music.draw(container.getWidth()-this.music.getWidth()-decalage2,
					0,container.getHeight()/20,container.getHeight()/20);
		
		this.poubelle.draw(2*container.getWidth()/3+20+2*this.emplacement1.getImage().getWidth()+2*decalage2,16*container.getHeight()/20-decalage,4*container.getHeight()/20,4*container.getHeight()/20);
		
		if (!running) {
			this.play.draw(2*container.getWidth()/3+20,16*container.getHeight()/20-decalage,4*container.getHeight()/20,4*container.getHeight()/20);
		}
		else {
			this.stop.draw(2*container.getWidth()/3+20,16*container.getHeight()/20-decalage,4*container.getHeight()/20,4*container.getHeight()/20);
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
		
		if(!avancer.estBloquee()) 
			this.avancer.draw(decalage+20, 16*container.getHeight()/20-decalage+20);
		else 
			lock.draw(decalage+20, 16*container.getHeight()/20-decalage+20);
		
		if(!allumer.estBloquee())
			this.allumer.draw(decalage+20+lg+decalage2, 16*container.getHeight()/20-decalage+20);
		else 
			lock.draw(decalage+20+lg+decalage2, 16*container.getHeight()/20-decalage+20);
		
		if(!tournerG.estBloquee())
			this.tournerG.draw(decalage+20+2*lg+2*decalage2, 16*container.getHeight()/20-decalage+20);
		else 
			lock.draw(decalage+20+2*lg+2*decalage2, 16*container.getHeight()/20-decalage+20);
		
		if(!tournerD.estBloquee())
			this.tournerD.draw(decalage+20+3*lg+3*decalage2, 16*container.getHeight()/20-decalage+20);
		else 
			lock.draw(decalage+20+3*lg+3*decalage2, 16*container.getHeight()/20-decalage+20);
		
		if(!sauter.estBloquee())
			this.sauter.draw(decalage+20+4*lg+4*decalage2, 16*container.getHeight()/20-decalage+20);
		else 
			lock.draw(decalage+20+4*lg+4*decalage2, 16*container.getHeight()/20-decalage+20);
		
		if(!appuyer.estBloquee())
			this.appuyer.draw(decalage+20+5*lg+5*decalage2, 16*container.getHeight()/20-decalage+20);
		else 
			lock.draw(decalage+20+5*lg+5*decalage2, 16*container.getHeight()/20-decalage+20);
		
		if(!p1.estBloquee())
			this.p1.getImage().draw(decalage+20+6*lg+6*decalage2, 16*container.getHeight()/20-decalage+20);
		else 
			lock.draw(decalage+20+6*lg+6*decalage2, 16*container.getHeight()/20-decalage+20);
		
		if(!(testCaseBleue.estBloquee() && testAvancer.estBloquee() && testSauter.estBloquee())) 
			this.couleurs.draw(decalage+20+7*lg+7*decalage2, 16*container.getHeight()/20-decalage+20,50,50);
		else 
			lock.draw(decalage+20+7*lg+7*decalage2, 16*container.getHeight()/20-decalage+20);
		
		if(!prendre.estBloquee())
			this.prendre.draw(decalage+20, 16*container.getHeight()/20-decalage+20+lar);
		else 
			lock.draw(decalage+20, 16*container.getHeight()/20-decalage+20+lar);
		
		if(!lacher.estBloquee())
			this.lacher.draw(decalage+20+lg+decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else 
			lock.draw(decalage+20+lg+decalage2, 16*container.getHeight()/20-decalage+20+lar);
		
		if(!myBreak.estBloquee())
			this.myBreak.draw(decalage+20+2*lg+2*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else 
			lock.draw(decalage+20+2*lg+2*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		
		if(!testAvancer.estBloquee())
			this.testAvancer.draw(decalage+20+3*lg+3*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else 
			lock.draw(decalage+20+3*lg+3*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		
		if(!testCaseBleue.estBloquee())
			this.testCaseBleue.draw(decalage+20+4*lg+4*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else lock.draw(decalage+20+4*lg+4*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		
		if(!lockUnlock.estBloquee())
			this.lockUnlock.draw(decalage+20+5*lg+5*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else 
			lock.draw(decalage+20+5*lg+5*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		
		if(!p2.estBloquee())
			this.p2.draw(decalage+20+6*lg+6*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else 
			lock.draw(decalage+20+6*lg+6*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		
		if(!testSauter.estBloquee())
			this.testSauter.draw(decalage+20+7*lg+7*decalage2, 16*container.getHeight()/20-decalage+20+lar);
		else lock.draw(decalage+20+7*lg+7*decalage2, 16*container.getHeight()/20-decalage+20+lar);	
	}
	
	public void panier(List<Objet> fruit, GameContainer container ){
		int tailleFruit = 50;
		float decalage = container.getHeight()/100;
		for (int i = 0; i < fruit.size(); i ++){
			switch (fruit.get(i)){
				case FRAISE : this.fraise.draw(0, 
				container.getHeight()/20+decalage + i*tailleFruit,
				tailleFruit,
				tailleFruit);
					break;
				case PASTEQUE : this.pasteque.draw(0, 
				container.getHeight()/20+decalage + i*tailleFruit,
				tailleFruit,
				tailleFruit);
					break;
				case MYRTILLE : this.myrtille.draw(0, 
				container.getHeight()/20+decalage + i*tailleFruit,
				tailleFruit,
				tailleFruit);
					break;
				default :
					break;
			}
		}
	}
	
	public void panier2(List<Objet> fruit, GameContainer container ){
		int tailleFruit = 50;
		float decalage = container.getHeight()/100;
		for (int i = 0; i < fruit.size(); i ++){
			switch (fruit.get(i)){
				case FRAISE : this.fraise.draw(	2*container.getWidth()/3-tailleFruit, 
				container.getHeight()/20+decalage + i*tailleFruit,
				tailleFruit,
				tailleFruit);
					break;
				case PASTEQUE : this.pasteque.draw(	2*container.getWidth()/3-tailleFruit, 
				container.getHeight()/20+decalage + i*tailleFruit,
				tailleFruit,
				tailleFruit);
					break;
				case MYRTILLE : this.myrtille.draw(2*container.getWidth()/3-tailleFruit, 
				container.getHeight()/20+decalage + i*tailleFruit,
				tailleFruit,
				tailleFruit);
					break;
				default :
					break;
			}
		}
	}
	

	
	public Action getAllumer(){ return this.allumer; }
	public Action getAvancer() { return this.avancer; }
	public Action getTournerG() { return this.tournerG; }
	public Action getTournerD() { return this.tournerD; }
	public Action getSauter() { return this.sauter; }
	public Action getAppuyer(){ return this.appuyer; }
	public Action getPrendre(){ return this.prendre; }
	public Action getLacher(){ return this.lacher; }
	public Action getLockUnlock(){ return this.lockUnlock; }
	public Action getMyBreak(){ return this.myBreak; }
	public Action getTestCaseBleue(){ return this.testCaseBleue; }
	public Action getTestAvancer(){ return this.testAvancer; }
	public Action getTestSauter(){ return this.testSauter; }
	public Action getP1() { return this.p1; }
	public Action getP2() { return this.p2; }
	
	public void setEmplacement1 (Action a){ this.emplacement1 =  a; }
	public void setEmplacement2 (Action a){ this.emplacement2 =  a; }
	public void setEmplacement3 (Action a){ this.emplacement3 =  a; }
	public void setEmplacement4 (Action a){ this.emplacement4 =  a; }
	public void setEmplacement5 (Action a){ this.emplacement5 =  a; }
	public void setEmplacement6 (Action a){ this.emplacement6 =  a; }
	public void setEmplacement7 (Action a){ this.emplacement7 =  a; }
	public void setEmplacement8 (Action a){ this.emplacement8 =  a; }
	public void setEmplacement9 (Action a){ this.emplacement9 =  a; }
	public void setEmplacement10(Action a){ this.emplacement10 = a; }
	public void setEmplacement11(Action a){ this.emplacement11 = a; }
	public void setEmplacement12(Action a){ this.emplacement12 = a; }
	public void setEmplacement13(Action a){ this.emplacement13 = a; }
	public void setEmplacement14(Action a){ this.emplacement14 = a; }
	public void setEmplacement15(Action a){ this.emplacement15 = a; }
	public void setEmplacement16(Action a){ this.emplacement16 = a; }
	public void setEmplacement17(Action a){ this.emplacement17 = a; }
	public void setEmplacement18(Action a){ this.emplacement18 = a; }
	public void setEmplacement19(Action a){ this.emplacement19 = a; }
	public void setEmplacement20(Action a){ this.emplacement20 = a; }
	public void setEmplacement21(Action a){ this.emplacement21 = a; }
	public void setEmplacement22(Action a){ this.emplacement22 = a; }
	public void setEmplacement23(Action a){ this.emplacement23 = a; }
	public void setEmplacement24(Action a){ this.emplacement24 = a; }
	public void setEmplacement25(Action a){ this.emplacement25 = a; }
	public void setEmplacement26(Action a){ this.emplacement26 = a; }
	public void setEmplacement27(Action a){ this.emplacement27 = a; }
	public void setEmplacement28(Action a){ this.emplacement28 = a; }
	
	public Action getEmplacement1(){ return this.emplacement1; }
	public Action getEmplacement2(){ return this.emplacement2; }
	public Action getEmplacement3(){ return this.emplacement3; }
	public Action getEmplacement4(){ return this.emplacement4; }
	public Action getEmplacement5(){ return this.emplacement5; }
	public Action getEmplacement6(){ return this.emplacement6; }
	public Action getEmplacement7(){ return this.emplacement7; }
	public Action getEmplacement8(){ return this.emplacement8; }
	public Action getEmplacement9(){ return this.emplacement9; }
	public Action getEmplacement10(){ return this.emplacement10; }
	public Action getEmplacement11(){ return this.emplacement11; }
	public Action getEmplacement12(){ return this.emplacement12; }
	public Action getEmplacement13(){ return this.emplacement13; }
	public Action getEmplacement14(){ return this.emplacement14; }
	public Action getEmplacement15(){ return this.emplacement15; }
	public Action getEmplacement16(){ return this.emplacement16; }
	public Action getEmplacement17(){ return this.emplacement17; }
	public Action getEmplacement18(){ return this.emplacement18; }
	public Action getEmplacement19(){ return this.emplacement19; }
	public Action getEmplacement20(){ return this.emplacement20; }
	public Action getEmplacement21(){ return this.emplacement21; }
	public Action getEmplacement22(){ return this.emplacement22; }
	public Action getEmplacement23(){ return this.emplacement23; }
	public Action getEmplacement24(){ return this.emplacement24; }
	public Action getEmplacement25(){ return this.emplacement25; }
	public Action getEmplacement26(){ return this.emplacement26; }
	public Action getEmplacement27(){ return this.emplacement27; }
	public Action getEmplacement28(){ return this.emplacement28; }
	
	public Image getMusic() { return this.music; }
	public void setMusic() { if (this.music.equals(musicOn)) this.music = musicOff; else this.music = musicOn; }
	
	public boolean getRunning() {return this.running;}
	public void setRunning() { this.running = !this.running; }
	
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
if (Controleur.getMapCourrante().getMaxActionsMain() >= 1)  this.emplacement1. setImage(new Image(e)); else  this.emplacement1 .setImage(new Image(e_lock)); this.emplacement1.setNom(null);		 		this.emplacement1.setTestFaux(false); this.emplacement1.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 2)  this.emplacement2. setImage(new Image(e)); else  this.emplacement2 .setImage(new Image(e_lock)); this.emplacement2.setNom(null);        this.emplacement2.setTestFaux(false); this.emplacement2.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 3)  this.emplacement3. setImage(new Image(e)); else  this.emplacement3 .setImage(new Image(e_lock)); this.emplacement3.setNom(null);        this.emplacement3.setTestFaux(false); this.emplacement3.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 4)  this.emplacement4. setImage(new Image(e)); else  this.emplacement4 .setImage(new Image(e_lock)); this.emplacement4.setNom(null);        this.emplacement4.setTestFaux(false); this.emplacement4.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 5)  this.emplacement5. setImage(new Image(e)); else  this.emplacement5 .setImage(new Image(e_lock)); this.emplacement5.setNom(null);        this.emplacement5.setTestFaux(false); this.emplacement5.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 6)  this.emplacement6. setImage(new Image(e)); else  this.emplacement6 .setImage(new Image(e_lock)); this.emplacement6.setNom(null);        this.emplacement6.setTestFaux(false); this.emplacement6.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 7)  this.emplacement7. setImage(new Image(e)); else  this.emplacement7 .setImage(new Image(e_lock)); this.emplacement7.setNom(null);        this.emplacement7.setTestFaux(false); this.emplacement7.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 8)  this.emplacement8. setImage(new Image(e)); else  this.emplacement8 .setImage(new Image(e_lock)); this.emplacement8.setNom(null);        this.emplacement8.setTestFaux(false); this.emplacement8.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 9)  this.emplacement9. setImage(new Image(e)); else  this.emplacement9 .setImage(new Image(e_lock)); this.emplacement9.setNom(null);        this.emplacement9.setTestFaux(false); this.emplacement9.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 10) this.emplacement10.setImage(new Image(e)); else  this.emplacement10.setImage(new Image(e_lock)); this.emplacement10.setNom(null);       this.emplacement10.setTestFaux(false); this.emplacement10.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 11) this.emplacement11.setImage(new Image(e)); else  this.emplacement11.setImage(new Image(e_lock)); this.emplacement11.setNom(null);       this.emplacement11.setTestFaux(false); this.emplacement11.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsMain() >= 12) this.emplacement12.setImage(new Image(e)); else  this.emplacement12.setImage(new Image(e_lock)); this.emplacement12.setNom(null);       this.emplacement12.setTestFaux(false); this.emplacement12.setTestVrai(false);

		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 1) this.emplacement13.setImage(new Image(e)); else  this.emplacement13.setImage(new Image(e_lock)); this.emplacement13.setNom(null);  this.emplacement13.setTestFaux(false); this.emplacement13.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 2) this.emplacement14.setImage(new Image(e)); else  this.emplacement14.setImage(new Image(e_lock)); this.emplacement14.setNom(null);  this.emplacement14.setTestFaux(false); this.emplacement14.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 3) this.emplacement15.setImage(new Image(e)); else  this.emplacement15.setImage(new Image(e_lock)); this.emplacement15.setNom(null);  this.emplacement15.setTestFaux(false); this.emplacement15.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 4) this.emplacement16.setImage(new Image(e)); else  this.emplacement16.setImage(new Image(e_lock)); this.emplacement16.setNom(null);  this.emplacement16.setTestFaux(false); this.emplacement16.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 5) this.emplacement17.setImage(new Image(e)); else  this.emplacement17.setImage(new Image(e_lock)); this.emplacement17.setNom(null);  this.emplacement17.setTestFaux(false); this.emplacement17.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 6) this.emplacement18.setImage(new Image(e)); else  this.emplacement18.setImage(new Image(e_lock)); this.emplacement18.setNom(null);  this.emplacement18.setTestFaux(false); this.emplacement18.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 7) this.emplacement19.setImage(new Image(e)); else  this.emplacement19.setImage(new Image(e_lock)); this.emplacement19.setNom(null);  this.emplacement19.setTestFaux(false); this.emplacement19.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 8) this.emplacement20.setImage(new Image(e)); else  this.emplacement20.setImage(new Image(e_lock)); this.emplacement20.setNom(null);  this.emplacement20.setTestFaux(false); this.emplacement20.setTestVrai(false);
		                    
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 1) this.emplacement21.setImage(new Image(e)); else  this.emplacement21.setImage(new Image(e_lock)); this.emplacement21.setNom(null);  this.emplacement21.setTestFaux(false); this.emplacement21.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 2) this.emplacement22.setImage(new Image(e)); else  this.emplacement22.setImage(new Image(e_lock)); this.emplacement22.setNom(null);  this.emplacement22.setTestFaux(false); this.emplacement22.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 3) this.emplacement23.setImage(new Image(e)); else  this.emplacement23.setImage(new Image(e_lock)); this.emplacement23.setNom(null);  this.emplacement23.setTestFaux(false); this.emplacement23.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 4) this.emplacement24.setImage(new Image(e)); else  this.emplacement24.setImage(new Image(e_lock)); this.emplacement24.setNom(null);  this.emplacement24.setTestFaux(false); this.emplacement24.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 5) this.emplacement25.setImage(new Image(e)); else  this.emplacement25.setImage(new Image(e_lock)); this.emplacement25.setNom(null);  this.emplacement25.setTestFaux(false); this.emplacement25.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 6) this.emplacement26.setImage(new Image(e)); else  this.emplacement26.setImage(new Image(e_lock)); this.emplacement26.setNom(null);  this.emplacement26.setTestFaux(false); this.emplacement26.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 7) this.emplacement27.setImage(new Image(e)); else  this.emplacement27.setImage(new Image(e_lock)); this.emplacement27.setNom(null);  this.emplacement27.setTestFaux(false); this.emplacement27.setTestVrai(false);
		if (Controleur.getMapCourrante().getMaxActionsProcedures() >= 8) this.emplacement28.setImage(new Image(e)); else  this.emplacement28.setImage(new Image(e_lock)); this.emplacement28.setNom(null);  this.emplacement28.setTestFaux(false); this.emplacement28.setTestVrai(false);
		this.cleaning = true;
		this.running = false;
	}
	
	public boolean getCleaning() {return this.cleaning;}
	public void setCleaning(boolean c) {this.cleaning = c;}
	
}
