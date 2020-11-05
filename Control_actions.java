package monopl2.Monopoly;
//Monopoly.java 1.0 04/01/2004


import java.awt.*;
import java.applet.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import monopl2.Monopoly.*;


public class Control_actions extends Applet implements ActionListener
{
	
	Interface interf = new Interface();
//DEBUT FRAME CHOIX DES JOUEURS
	static final Frame Joueur = new Frame();
	public static final TextField Joueur1 = new TextField("Le joueur 1", 13 );
	public static final TextField Joueur2 = new TextField("Le joueur 2", 13 );
	static final Button Play = new Button( "JOUER" );
	static final Button Exit = new Button ("QUITTER");

//FIN FRAME CHOIX DES JOUEURS

//DEBUT GESTION DE LA PARTIE
	static final Frame FrameGestionPartie = new Frame();
	static final Button Jouer = new Button( "Jouer" );
	static final Button Terminer = new Button( "Passer le tour" );
	static final Button Acheter = new Button( "Acheter " );
	static final Button Vendre = new Button( "Vendre" );
	static final Button AjoutMaison = new Button( "Acheter une Maison" );
	static final Button Hypothequer = new Button( "Hypothéquer" );
	static final Button Reprendre = new Button( "Reprendre" );
	//static final Button Statistiques = new Button( "Statistiques" );
	static final Button Quitter = new Button( "Sortir du jeu" );
//FIN GESTION DE LA PARTIE

//VENDRE UNE PROPRIETE
static final Frame FrameVendre = new Frame();
public static final TextField VendreCombien = new TextField();
static final Button VendreP = new Button( "Confirmer" );
static final Button AnnulerP = new Button( "Annuler" );

//AJOUTER MAISON
static final Frame FrameAjouterMaison = new Frame();
public static final TextField AjouterCombienM = new TextField();
static final Button AjouterM = new Button( "Confirmer" );
static final Button AnnulerM = new Button( "Annuler" );

boolean PayerPourSortir;
public void init() 
	{ 
	  	
	
//DEBUT FRAME CHOIX DES JOUEURS
		Joueur.setSize( 380, 390 );
		Joueur.setTitle("Bienvenue au monopoly !");
		Joueur.setBackground(new Color( (90), (200), (60) )); /// modifier la couleur debut 
		Joueur.setLayout(new FlowLayout(FlowLayout.CENTER));
		Joueur.setResizable(false);
		Panel PanelJoueur = new Panel(new GridLayout(0,1));
		Joueur.add(PanelJoueur);
		PanelJoueur.add(new Label("Joueur 1"));
		PanelJoueur.add(Joueur1);
		PanelJoueur.add(new Label("Joueur 2"));
		PanelJoueur.add(Joueur2);
		PanelJoueur.add(new Label(""));
		PanelJoueur.add(Play);
		PanelJoueur.add(Exit);
		Joueur.setVisible(true );
		Exit.addActionListener(this);
		Play.addActionListener(this);
//FIN FRAME CHOIX DES JOUEURS
	}
	
public void Jouer(Joueur MPJoueur)
	{
		if(MPJoueur.getJPosition()+interf.De1.val_de+interf.De2.val_de>=40)
		{
			MPJoueur.setJPosition(MPJoueur.getJPosition()+interf.De1.val_de+interf.De2.val_de-40);
			Message.affMsg(FrameGestionPartie,"Vous etes a la case depart, Vous reçevez 20000 EURO");
			MPJoueur.RecevoirArgent(20000);
		}
		else
		if(MPJoueur.getJPosition()+interf.De1.val_de+interf.De2.val_de<40)
		{
			MPJoueur.setJPosition(MPJoueur.getJPosition()+interf.De1.val_de+interf.De2.val_de);
		}

		if(MPJoueur.getJPosition()==30)
		{
		PayerPourSortir=Message.affQuest(FrameGestionPartie,"Voulez vous payer 5000 EUROS pour sortir de prison");
		if(PayerPourSortir==true)
			{
			MPJoueur.PayerArgent(5000);
			MPJoueur.setEtatPrison(true);
			MPJoueur.setEtatPrisonFini(1);
			}
		else
			{
			MPJoueur.setEtatPrison(true);
			MPJoueur.setEtatPrisonFini(3);
			}
		MPJoueur.setJPosition(10);
		}

		if(MPJoueur.getJPosition()==20)
		{
		Message.affMsg(FrameGestionPartie,"La Banque vous rembourse la somme de  " + interf.MPEtat.getArgent() + " EUROS");
		MPJoueur.RecevoirArgent(interf.MPEtat.getArgent());
		interf.MPEtat.PayerArgent(interf.MPEtat.getArgent());
		} 
		
		if(MPJoueur.getJPosition()==7||MPJoueur.getJPosition()==22||MPJoueur.getJPosition()==37){
			String a=Case_chance.tirer_carte(MPJoueur);
			Message.affMsg(FrameGestionPartie,"vous avez tirer une carte chance !!  "+a);
		}
		
	
		interf.repaint();
	}
public void Terminer()
{
	if((interf.MPJoueur1.getTour()==true)&&(interf.De1.val_de != interf.De2.val_de))
	{
		interf.MPJoueur1.setTour(false);
		interf.MPJoueur2.setTour(true);
	}
	else
	if((interf.MPJoueur2.getTour()==true)&&(interf.De1.val_de != interf.De2.val_de))
	{
	interf.MPJoueur2.setTour(false);
	interf.MPJoueur1.setTour(true);
	}
}
public void Acheter()
{
	if(interf.MPJoueur1.getTour()==true)
{
if(interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).aVendre()==true)
	{
		if(interf.MPJoueur1.getArgent()>=interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getCasePrix())
		{
		interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).setCaseProprietaire(interf.MPJoueur1);
		Message.affMsg(FrameGestionPartie,"Vous avez acheté " + interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getNomCase() + " pour " + Integer.toString(interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getCasePrix())+ "EUROS");
		interf.MPJoueur1.PayerArgent(interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getCasePrix());
		}
		else
		Message.affMsg(FrameGestionPartie,"Vous n'avez pas assez d'argent !!") ;
	}
}
else
if(interf.MPJoueur2.getTour()==true)
{
	if(interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).aVendre()==true)
	{
		if(interf.MPJoueur2.getArgent()>=interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getCasePrix())
		{
		interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).setCaseProprietaire(interf.MPJoueur2);
		Message.affMsg(FrameGestionPartie,"Vous avez acheté " + interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getNomCase() + " pour " + Integer.toString(interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getCasePrix())+ "EUROS");
		interf.MPJoueur2.PayerArgent(interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getCasePrix());
		}
		else
		Message.affMsg(FrameGestionPartie,"Vous n'avez pas assez d'argent !!") ;
	}
}
interf.repaint();
Acheter.setEnabled(false);
}

public void PayerLoyerAJoueur2()
{
int x;
x=0;
if(interf.MPJoueur1.getTour()==true)
{
if(TestAjoutMaisonMPJoueur2(interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).MonopolyCaseGroupe)==true)
{
x=3*interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getCaseLoyer();
x=x+(interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getNbreMaison()*interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getPrixMaison());
Message.affMsg(FrameGestionPartie,"Vous payé un Loyer pour " + interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getNomCase() + " de " + x + "EUROS");
interf.MPJoueur1.PayerArgent(x);
interf.MPJoueur2.RecevoirArgent(x);
interf.repaint();
}
else
if(interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getCaseProprietaire()==interf.MPJoueur2)
{
x=interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getCaseLoyer();
Message.affMsg(FrameGestionPartie,"Vous payé un Loyer pour " + interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getNomCase() + " de " + x + " EUROS");
interf.MPJoueur1.PayerArgent(x);
interf.MPJoueur2.RecevoirArgent(x);
interf.repaint();
}
}
}

public void PayerLoyerAJoueur1()
{
int x;
x=0;
if(interf.MPJoueur2.getTour()==true)
{
if(TestAjoutMaisonMPJoueur1(interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).MonopolyCaseGroupe)==true)
{
x=3*interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getCaseLoyer();
x=x+(interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getNbreMaison()*interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getPrixMaison());
Message.affMsg(FrameGestionPartie,"Vous payé un Loyer pour " + interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getNomCase() + " de " + x + " EUROS");
interf.MPJoueur2.PayerArgent(x);
interf.MPJoueur1.RecevoirArgent(x);
interf.repaint();
}
else
if(interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getCaseProprietaire()==interf.MPJoueur1)
{
x=interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getCaseLoyer();
Message.affMsg(FrameGestionPartie,"Vous payé un Loyer pour " + interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getNomCase() + " de " + x + "EUROS");
interf.MPJoueur2.PayerArgent(x);
interf.MPJoueur1.RecevoirArgent(x);
interf.repaint();
}
}
}

public void PayerTaxeJoueur1()
{
	if(interf.MPJoueur1.getJPosition()==4) 
	{
	Message.affMsg(FrameGestionPartie,"Vous Payer l'IGR de 20000 EUROS");
	interf.MPJoueur1.PayerArgent(20000);
	interf.MPEtat.RecevoirArgent(20000);
	interf.repaint();
	}
	else
	if(interf.MPJoueur1.getJPosition()==38)
	{
		Message.affMsg(FrameGestionPartie,"Vous Payer une taxe de luxe de 10000 EUROS");
		interf.MPJoueur1.PayerArgent(10000);
		interf.MPEtat.RecevoirArgent(10000);
		interf.repaint();
	}
	
}
public void PayerTaxeJoueur2()
{
	if(interf.MPJoueur2.getJPosition()==4) 
	{
	Message.affMsg(FrameGestionPartie,"Vous Payer l'IGR de 20000 EUROS");
	interf.MPJoueur2.PayerArgent(20000);
	interf.MPEtat.RecevoirArgent(20000);
	interf.repaint();
	}
	else
	if(interf.MPJoueur2.getJPosition()==38)
	{
		Message.affMsg(FrameGestionPartie,"Vous Payer une taxe de luxe de 10000 F");
		interf.MPJoueur2.PayerArgent(10000);
		interf.MPEtat.RecevoirArgent(10000);
		interf.repaint();
	}
}


public boolean TestAjoutMaisonMPJoueur1(int i)
{
if(i==1)
		{
			if((interf.MPPlateau.getCasePlateau(1).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(3).getCaseProprietaire()==interf.MPJoueur1))
			return true;
		}
if(i==2)
		{
			if((interf.MPPlateau.getCasePlateau(6).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(8).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(9).getCaseProprietaire()==interf.MPJoueur1))
			return true;
		}

if(i==3)
		{
			if((interf.MPPlateau.getCasePlateau(11).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(13).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(14).getCaseProprietaire()==interf.MPJoueur1))
			return true;
		}
if(i==4)
		{
			if((interf.MPPlateau.getCasePlateau(16).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(18).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(19).getCaseProprietaire()==interf.MPJoueur1))
			return true;
		}
if(i==5)
		{
			if((interf.MPPlateau.getCasePlateau(21).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(23).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(24).getCaseProprietaire()==interf.MPJoueur1))
			return true;
		}
if(i==6)
		{
			if((interf.MPPlateau.getCasePlateau(26).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(27).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(29).getCaseProprietaire()==interf.MPJoueur1))
			return true;
		}		
if(i==7)
		{
			if((interf.MPPlateau.getCasePlateau(31).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(32).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(34).getCaseProprietaire()==interf.MPJoueur1))
			return true;
		}
if(i==8)
		{
			if((interf.MPPlateau.getCasePlateau(37).getCaseProprietaire()==interf.MPJoueur1)&&
			(interf.MPPlateau.getCasePlateau(39).getCaseProprietaire()==interf.MPJoueur1))
			return true;
		}
		
return false;
}



public boolean TestAjoutMaisonMPJoueur2(int i)
{
if(i==1)
		{
			if((interf.MPPlateau.getCasePlateau(1).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(3).getCaseProprietaire()==interf.MPJoueur2))
			return true;
		}
if(i==2)
		{
			if((interf.MPPlateau.getCasePlateau(6).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(8).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(9).getCaseProprietaire()==interf.MPJoueur2))
			return true;
		}

if(i==3)
		{
			if((interf.MPPlateau.getCasePlateau(11).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(13).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(14).getCaseProprietaire()==interf.MPJoueur2))
			return true;
		}
if(i==4)
		{
			if((interf.MPPlateau.getCasePlateau(16).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(18).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(19).getCaseProprietaire()==interf.MPJoueur2))
			return true;
		}
if(i==5)
		{
			if((interf.MPPlateau.getCasePlateau(21).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(23).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(24).getCaseProprietaire()==interf.MPJoueur2))
			return true;
		}
if(i==6)
		{
			if((interf.MPPlateau.getCasePlateau(26).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(27).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(29).getCaseProprietaire()==interf.MPJoueur2))
			return true;
		}		
if(i==7)
		{
			if((interf.MPPlateau.getCasePlateau(31).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(32).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(34).getCaseProprietaire()==interf.MPJoueur2))
			return true;
		}
if(i==8)
		{
			if((interf.MPPlateau.getCasePlateau(37).getCaseProprietaire()==interf.MPJoueur2)&&
			(interf.MPPlateau.getCasePlateau(39).getCaseProprietaire()==interf.MPJoueur2))
			return true;
		}
		
return false;
}



public static void main(String argv[])
    {
     	new Control_actions();
    }

public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == Exit)
						        {
									Joueur.setVisible(false);
								}
		if(e.getSource() == Play) 
								{
									Joueur.setVisible(false);
									//DEBUT OUVERTURE DE LA TABLE MONOPOLY
									interf.setSize(300, 220);
    								interf.setVisible(true);
    								//FIN OUVERTURE DE LA TABLE MONOPOLY
    								//OUVERTURE DE LA FRAME DE GESTION DE LA PARTIE
    								FrameGestionPartie.setLocation(1040,310);
    								FrameGestionPartie.setResizable(false);
	    							FrameGestionPartie.setSize(230,230 );
									FrameGestionPartie.setTitle("Actions");
									FrameGestionPartie.setBackground(Color.white);
									FrameGestionPartie.setLayout(new FlowLayout(FlowLayout.CENTER));
									Panel PanelPartie = new Panel(new GridLayout(0,1));
									FrameGestionPartie.add(PanelPartie);
									PanelPartie.add(Jouer);
									PanelPartie.add(Terminer);
									PanelPartie.add(Acheter);
									PanelPartie.add(Vendre);
									PanelPartie.add(AjoutMaison);
									PanelPartie.add(Hypothequer);
									PanelPartie.add(Reprendre);
									//PanelPartie.add(Statistiques);
									PanelPartie.add(Quitter);
									FrameGestionPartie.setVisible(true );
									Jouer.setEnabled(true);
									Terminer.setEnabled(false);
									Acheter.setEnabled(false);
									Vendre.setEnabled(false);
									AjoutMaison.setEnabled(false);
									Hypothequer.setEnabled(false);
									Reprendre.setEnabled(false);
									
									
									
									Jouer.addActionListener(this);
									Terminer.addActionListener(this);
									Acheter.addActionListener(this);
									Vendre.addActionListener(this);
									AjoutMaison.addActionListener(this);								
									//Statistiques.addActionListener(this);
									Quitter.addActionListener(this);
									//FIN OUVERTURE DE LA FRAME DE GESTION DE LA PARTIE
    							}//Play
		
		if(e.getSource() == Quitter)
						        {
						        	interf.setVisible(false);
						        	FrameGestionPartie.setVisible(false);
								}
		
		
								
		if(e.getSource() == Jouer)
								 if(interf.MPJoueur1.getTour()==true)
								 {
									De.Roll(interf.De1,interf.De2);
								 	Jouer(interf.MPJoueur1);
								 	PayerLoyerAJoueur2();
								 	PayerTaxeJoueur1();
//GESTION DES MAISONS (BOUTON)
AjoutMaison.setEnabled(false);
if(TestAjoutMaisonMPJoueur1(interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).MonopolyCaseGroupe)==true)
AjoutMaison.setEnabled(true);

								 	if((interf.De1.val_de == interf.De2.val_de)
	||((interf.MPJoueur2.getEtatPrison()==true)&&(interf.MPJoueur2.getEtatPrisonFini()!=0)))
								 	{
								 	Jouer.setEnabled(true);
						        	Terminer.setEnabled(false);
						        	if(interf.MPJoueur1.getEtatPrison()==true)
								 	{
								 	Jouer.setEnabled(false);
						        	Terminer.setEnabled(true);
						        	}
	if(interf.MPJoueur2.getEtatPrison()==true)
	if(interf.MPJoueur2.getEtatPrisonFini()!=0)
	interf.MPJoueur2.setEtatPrisonFini(interf.MPJoueur2.getEtatPrisonFini()-1);
	if(interf.MPJoueur2.getEtatPrisonFini()==0) interf.MPJoueur2.setEtatPrison(false);
						        	}
						        	else
						        	{
						        	Jouer.setEnabled(false);
						        	Terminer.setEnabled(true);
						        	}
								 }
								else
								if(interf.MPJoueur2.getTour()==true)
								 {  
								 	De.Roll(interf.De1,interf.De2);
								 	Jouer(interf.MPJoueur2);
								 	PayerLoyerAJoueur1();
								 	PayerTaxeJoueur2();
//GESTION DES MAISONS (BOUTON)

AjoutMaison.setEnabled(false);
if(TestAjoutMaisonMPJoueur2(interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).MonopolyCaseGroupe)==true)
AjoutMaison.setEnabled(true);
								 	if((interf.De1.val_de == interf.De2.val_de)
	||((interf.MPJoueur1.getEtatPrison()==true)&&(interf.MPJoueur1.getEtatPrisonFini()!=0)))
								 	{
								 	Jouer.setEnabled(true);
						        	Terminer.setEnabled(false);
						        	if(interf.MPJoueur2.getEtatPrison()==true)
								 	{
								 	Jouer.setEnabled(false);
						        	Terminer.setEnabled(true);
						        	}
	if(interf.MPJoueur1.getEtatPrison()==true)
	if(interf.MPJoueur1.getEtatPrisonFini()!=0)
	interf.MPJoueur1.setEtatPrisonFini(interf.MPJoueur1.getEtatPrisonFini()-1);
	if(interf.MPJoueur1.getEtatPrisonFini()==0) interf.MPJoueur1.setEtatPrison(false);
						        	}
						        	else
						        	{
						        	Jouer.setEnabled(false);
						        	Terminer.setEnabled(true);
						        	}
								 }
		if(e.getSource() == Terminer)
								{
									Terminer();
									Jouer.setEnabled(true);
						        	Terminer.setEnabled(false);
						        	interf.repaint();
if(interf.MPJoueur1.getTour()==true)
{
AjoutMaison.setEnabled(false);
if(TestAjoutMaisonMPJoueur1(interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).MonopolyCaseGroupe)==true)
AjoutMaison.setEnabled(true);
}
else
{
AjoutMaison.setEnabled(false);
if(TestAjoutMaisonMPJoueur2(interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).MonopolyCaseGroupe)==true)
AjoutMaison.setEnabled(true);
}
								}
		
		if(e.getSource() == Acheter)
								{
									Acheter();
								}
		if(e.getSource() == Vendre)
								{
    								FrameVendre.setResizable(false);
	    							FrameVendre.setSize( 305, 150 );
									FrameVendre.setTitle("Vente de La Propriétée");
									FrameVendre.setBackground(Color.white);
									FrameVendre.setLayout(new FlowLayout(FlowLayout.CENTER));
									Panel PanelVendre = new Panel(new GridLayout(0,1));
									FrameVendre.add(PanelVendre);
									if(interf.MPJoueur1.getTour()==true)
									PanelVendre.add(new Label("Combien Voulez vous Vendre "+interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getNomCase()+" ?"));
									else
									PanelVendre.add(new Label("Combien Voulez vous Vendre "+interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getNomCase()+" ?"));
									PanelVendre.add(VendreCombien);
									FrameVendre.add(VendreP);
									FrameVendre.add(AnnulerP);
									FrameVendre.setVisible(true );
									VendreP.addActionListener(this);
									AnnulerP.addActionListener(this);
							    }
	
		if(e.getSource() == VendreP)
								{
									if(interf.MPJoueur1.getTour()==true)
									{
									interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).setCaseProprietaire(interf.MPJoueur2);
									interf.MPJoueur1.RecevoirArgent(Integer.parseInt(VendreCombien.getText()));
									interf.MPJoueur2.PayerArgent(Integer.parseInt(VendreCombien.getText()));
									}
									
									if(interf.MPJoueur2.getTour()==true)
									{
									interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).setCaseProprietaire(interf.MPJoueur1);
									interf.MPJoueur2.RecevoirArgent(Integer.parseInt(VendreCombien.getText()));
									interf.MPJoueur1.PayerArgent(Integer.parseInt(VendreCombien.getText()));
								    }
								    FrameVendre.setVisible(false);
									FrameVendre.removeAll();
									AjoutMaison.setEnabled(false);
								    interf.repaint();
								}
		
		if(e.getSource() == AnnulerP)
										{
										FrameVendre.setVisible(false);
									    FrameVendre.removeAll();
										}
										
		
		if(e.getSource() == AjoutMaison)
										{
									FrameAjouterMaison.setResizable(false);
	    							FrameAjouterMaison.setSize( 380, 150 );
									FrameAjouterMaison.setTitle("Ajouter Maisons à La Propriétée");
									FrameAjouterMaison.setBackground(Color.white);
									FrameAjouterMaison.setLayout(new FlowLayout(FlowLayout.CENTER));
									Panel PanelAjouter = new Panel(new GridLayout(0,1));
									FrameAjouterMaison.add(PanelAjouter);
									if(interf.MPJoueur1.getTour()==true)
									PanelAjouter.add(new Label("Combien Voulez vous ajouter de Maisons sur "+interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getNomCase()+" ?"));
									else
									PanelAjouter.add(new Label("Combien Voulez vous ajouter de Maisons sur "+interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getNomCase()+" ?"));
									PanelAjouter.add(AjouterCombienM);
									FrameAjouterMaison.add(AjouterM);
									FrameAjouterMaison.add(AnnulerM);
									FrameAjouterMaison.setVisible(true );
									AjouterM.addActionListener(this);
									AnnulerM.addActionListener(this);
										}
		if(e.getSource() == AjouterM)
					{
								if(interf.MPJoueur1.getTour()==true)
								{ 
								    JFrame Fr = new JFrame();
								    Fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
									Fr.setResizable(false);
									Fr.setSize( 380, 150 );
									Fr.setTitle("hotel");
									Fr.setBackground(Color.white);
									
									interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).setNbreMaison(Integer.parseInt(AjouterCombienM.getText()));
									interf.MPJoueur1.PayerArgent(Integer.parseInt(AjouterCombienM.getText()) * interf.MPPlateau.getCasePlateau(interf.MPJoueur1.getJPosition()).getPrixMaison());
								   if((Integer.parseInt(AjouterCombienM.getText()))>=4)
								   {
									   Hotel.ajouterHotel();
									   Panel p=new Panel(new GridLayout(0,1));
									   Fr.add(p);
									   p.add(new Label("          Vous avez ajouter un hotel !!"));
									   Fr.setVisible(true );
									   
									   
								   }
								}
								if(interf.MPJoueur2.getTour()==true)
								{
									interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).setNbreMaison(Integer.parseInt(AjouterCombienM.getText()));
									interf.MPJoueur2.PayerArgent(Integer.parseInt(AjouterCombienM.getText()) * interf.MPPlateau.getCasePlateau(interf.MPJoueur2.getJPosition()).getPrixMaison());
							    }
							FrameAjouterMaison.setVisible(false);
							FrameAjouterMaison.removeAll();
							interf.repaint();
					}
					
		if(e.getSource() == AnnulerM)
										{
									FrameAjouterMaison.setVisible(false);
									FrameAjouterMaison.removeAll();
										}
		

		
								}

	}

