package monopl2.Monopoly;
import java.awt.*;
import java.awt.event.*;

class Interface extends Frame
{
  Plateau MPPlateau = new Plateau();
  Image MPTable;
  De De1=new De(0);
  De De2=new De(0);

//INSTANCIATION DES DEUX JOUEURS
    Joueur MPJoueur1 = new Joueur(Control_actions.Joueur1.getText());
    Joueur MPJoueur2 = new Joueur(Control_actions.Joueur2.getText());
    Joueur MPEtat = new Joueur("Etat");
//FIN INSTANCIATION DES DEUX JOUEURS


    Interface()
  {
  	setTitle("Monopoly Ghiles Farid");
  	MPJoueur1.setTour(true);
    MPJoueur2.setTour(false);
   
   /* MPPlateau.getCasePlateau(6).setCaseProprietaire(MPJoueur1);
    MPPlateau.getCasePlateau(8).setCaseProprietaire(MPJoueur1);
    MPPlateau.getCasePlateau(9).setCaseProprietaire(MPJoueur1);
   */
    MPEtat.setTour(false);
    MPEtat.PayerArgent(150000);
    MPTable=getToolkit().getImage(getClass().getResource("table.gif"));
    addWindowListener(new WindowAdapter() 
    {
		public void windowClosing(WindowEvent e) 
		{
			dispose();
			System.exit(0);
		}
	});
  }
  
  
  public void Stat()
  {
   int i;
   for(i=1;i<=39;i++)
   if(MPPlateau.getCasePlateau(i).getCaseProprietaire()==MPJoueur1)
   System.out.println("" + MPPlateau.getCasePlateau(i).getCaseProprietaire().getNom());
  
  }
  
  
  public void paint(Graphics g)
  {
  	//AFFICHAGE PLEIN ECRAN DE LA TABLE MONOPOLY
  	int width = (int)Toolkit.getDefaultToolkit().getScreenSize().width;
	int heigh = (int)Toolkit.getDefaultToolkit().getScreenSize().height;
	setBounds(0,0,width, heigh);
    g.drawImage(MPTable, 210, 50, 600, 600, this);
    //AFFICHAGE PLEIN ECRAN DE LA TABLE MONOPOLY
   
   //AFFICHAGE DES PIONS BLEU
   g.setColor( Color.blue );
   g.fillOval( MPJoueur1.PlacementJoueur1[MPJoueur1.getJPosition()][0],MPJoueur1.PlacementJoueur1[MPJoueur1.getJPosition()][1],15, 15 );
   
   //AFFICHAGE DES PIONS ROUGE
   g.setColor( Color.red );
   g.fillOval( MPJoueur2.PlacementJoueur2[MPJoueur2.getJPosition()][0],MPJoueur2.PlacementJoueur2[MPJoueur2.getJPosition()][1],15, 15 );
   
   
	    //Dice 1
		if (De1.val_de==1){
			g.fill3DRect(130,165,6,6,true);
		}
		else if (De1.val_de == 2){
			g.fill3DRect(125,165,6,6,true);
			g.fill3DRect(145,165,6,6,true);
		}
		else if (De1.val_de == 3){
			g.fill3DRect(125,155,6,6,true);
			g.fill3DRect(135,165,6,6,true);
			g.fill3DRect(145,175,6,6,true);
		}
		else if (De1.val_de == 4){
			g.fill3DRect(125,155,6,6,true);
			g.fill3DRect(125,170,6,6,true);
			g.fill3DRect(140,155,6,6,true);
			g.fill3DRect(140,170,6,6,true);
		}
		else if (De1.val_de== 5){
			g.fill3DRect(125,155,6,6,true);
			g.fill3DRect(125,170,6,6,true);
			g.fill3DRect(140,155,6,6,true);
			g.fill3DRect(140,170,6,6,true);
			g.fill3DRect(132,165,6,6,true);
		}
		else if (De1.val_de== 6) {
			g.fill3DRect(125,155,6,6,true);
			g.fill3DRect(125,165,6,6,true);
			g.fill3DRect(125,175,6,6,true);
			g.fill3DRect(140,155,6,6,true);
			g.fill3DRect(140,165,6,6,true);
			g.fill3DRect(140,175,6,6,true);
		}
		//Dice 2
		g.setColor(Color.black);
		if (De2.val_de ==1){
			g.fill3DRect(172,165,6,6,true);
		}
		else if (De2.val_de== 2){
			g.fill3DRect(165,165,6,6,true);
			g.fill3DRect(185,165,6,6,true);
		}
		else if (De2.val_de == 3){
			g.fill3DRect(165,155,6,6,true);
			g.fill3DRect(175,165,6,6,true);
			g.fill3DRect(185,175,6,6,true);
		}
		else if (De2.val_de== 4){
			g.fill3DRect(165,155,6,6,true);
			g.fill3DRect(165,170,6,6,true);
			g.fill3DRect(175,155,6,6,true);
			g.fill3DRect(175,170,6,6,true);
		}
		else if (De2.val_de == 5){
			g.fill3DRect(165,155,6,6,true);
			g.fill3DRect(165,170,6,6,true);
			g.fill3DRect(180,155,6,6,true);
			g.fill3DRect(180,170,6,6,true);
			g.fill3DRect(172,165,6,6,true);
		}
		else if (De2.val_de== 6) {
			g.fill3DRect(165,155,6,6,true);
			g.fill3DRect(165,165,6,6,true);
			g.fill3DRect(165,175,6,6,true);
			g.fill3DRect(180,155,6,6,true);
			g.fill3DRect(180,165,6,6,true);
			g.fill3DRect(180,175,6,6,true);
		}
		   //LE TOTAL DES DES
   g.drawString("Total=" + (De1.val_de + De2.val_de),110,210);
		
boolean terr1=true;
boolean terr2=true;
g.setColor(Color.black);
g.drawRect(18,422,170,185);
g.setColor(Color.black);
g.drawRect(828,422,170,185);
		if((MPJoueur1.getJPosition()==0)||
		(MPJoueur1.getJPosition()==20)||
		(MPJoueur1.getJPosition()==4)||
    	(MPJoueur1.getJPosition()==38)||
    	(MPJoueur1.getJPosition()==2)||
    	(MPJoueur1.getJPosition()==17)||
    	(MPJoueur1.getJPosition()==33)||
    	(MPJoueur1.getJPosition()==7)||
    	(MPJoueur1.getJPosition()==22)||
    	(MPJoueur1.getJPosition()==36)||
    	(MPJoueur1.getJPosition()==10)||
    	(MPJoueur1.getJPosition()==30)) {terr1=false;g.setColor(Color.lightGray);}
    	
    	if((MPJoueur1.getJPosition()==5)||
    	(MPJoueur1.getJPosition()==25)||
    	(MPJoueur1.getJPosition()==15)||
    	(MPJoueur1.getJPosition()==35)) g.setColor(Color.gray);
    	
    	if((MPJoueur1.getJPosition()==12)||
    	(MPJoueur1.getJPosition()==28)) g.setColor(Color.gray);
    	//BRUN
    	if((MPJoueur1.getJPosition()==1)||
    	(MPJoueur1.getJPosition()==3)) g.setColor( new Color( (100), (30), (100) ) );
    	//BLEU CLAIR    	
    	if((MPJoueur1.getJPosition()==6)||
    	(MPJoueur1.getJPosition()==8)
    	||(MPJoueur1.getJPosition()==9)) g.setColor( new Color( (200), (200), (240) ) );
    	//VIOLET
    	if((MPJoueur1.getJPosition()==11)||
    	(MPJoueur1.getJPosition()==13)||
    	(MPJoueur1.getJPosition()==14)) g.setColor( new Color( (200), (30), (200) ) );
    	//ORANGE    	
    	if((MPJoueur1.getJPosition()==16)||
    	(MPJoueur1.getJPosition()==18)||
    	(MPJoueur1.getJPosition()==19)) g.setColor(Color.orange);
    	//ROUGE
    	if((MPJoueur1.getJPosition()==21)||
    	(MPJoueur1.getJPosition()==23)||
    	(MPJoueur1.getJPosition()==24)) g.setColor(Color.red);
    	//JAUNE    	
    	if((MPJoueur1.getJPosition()==26)||
    	(MPJoueur1.getJPosition()==27)||
    	(MPJoueur1.getJPosition()==29)) g.setColor(Color.yellow);
    	//VERT    	
    	if((MPJoueur1.getJPosition()==31)||
    	(MPJoueur1.getJPosition()==32)||
    	(MPJoueur1.getJPosition()==34)) g.setColor(Color.green);
    	//BLEU FONCE    	
    	if((MPJoueur1.getJPosition()==37)||
    	(MPJoueur1.getJPosition()==39))	g.setColor(Color.blue);
g.fillRect(19,423,169,50);
		
		
		if((MPJoueur2.getJPosition()==0)||
		(MPJoueur2.getJPosition()==20)||
		(MPJoueur2.getJPosition()==4)||
    	(MPJoueur2.getJPosition()==38)||
    	(MPJoueur2.getJPosition()==2)||
    	(MPJoueur2.getJPosition()==17)||
    	(MPJoueur2.getJPosition()==33)||
    	(MPJoueur2.getJPosition()==7)||
    	(MPJoueur2.getJPosition()==22)||
    	(MPJoueur2.getJPosition()==36)||
    	(MPJoueur2.getJPosition()==10)||
    	(MPJoueur2.getJPosition()==30)) {terr2=false;g.setColor(Color.lightGray);}
    	
    	
    	if((MPJoueur2.getJPosition()==5)||
    	(MPJoueur2.getJPosition()==25)||
    	(MPJoueur2.getJPosition()==15)||
    	(MPJoueur2.getJPosition()==35)) g.setColor(Color.gray);
    	
    	if((MPJoueur2.getJPosition()==12)||
    	(MPJoueur2.getJPosition()==28)) g.setColor(Color.gray);
    	//BRUN
    	if((MPJoueur2.getJPosition()==1)||
    	(MPJoueur2.getJPosition()==3)) g.setColor( new Color( (100), (30), (100) ) );
    	//BLEU CLAIR    	
    	if((MPJoueur2.getJPosition()==6)||
    	(MPJoueur2.getJPosition()==8)
    	||(MPJoueur2.getJPosition()==9)) g.setColor( new Color( (200), (200), (240) ) );
    	//VIOLET
    	if((MPJoueur2.getJPosition()==11)||
    	(MPJoueur2.getJPosition()==13)||
    	(MPJoueur2.getJPosition()==14)) g.setColor( new Color( (200), (30), (200) ) );
    	//ORANGE    	
    	if((MPJoueur2.getJPosition()==16)||
    	(MPJoueur2.getJPosition()==18)||
    	(MPJoueur2.getJPosition()==19)) g.setColor(Color.orange);
    	//ROUGE
    	if((MPJoueur2.getJPosition()==21)||
    	(MPJoueur2.getJPosition()==23)||
    	(MPJoueur2.getJPosition()==24)) g.setColor(Color.red);
    	//JAUNE    	
    	if((MPJoueur2.getJPosition()==26)||
    	(MPJoueur2.getJPosition()==27)||
    	(MPJoueur2.getJPosition()==29)) g.setColor(Color.yellow);
    	//VERT    	
    	if((MPJoueur2.getJPosition()==31)||
    	(MPJoueur2.getJPosition()==32)||
    	(MPJoueur2.getJPosition()==34)) g.setColor(Color.green);
    	//BLEU FONCE    	
    	if((MPJoueur2.getJPosition()==37)||
    	(MPJoueur2.getJPosition()==39))	g.setColor(Color.blue);
g.fillRect(829,423,169,50);


		g.setFont( new Font( "verdana", Font.BOLD, 20 ) );
   		//AFFICHAGE DES JOUEURS SUR LA TABLE DU MONOPOLY
   		g.setColor(Color.blue);
   		g.drawString("" + MPJoueur1.getNom(),20,350);
   		g.drawString("" + MPJoueur1.getArgent() + " F",20,380);
   		g.setColor(Color.red);
   		g.drawString("" + MPJoueur2.getNom(),830,350);
   		g.drawString("" + MPJoueur2.getArgent() + " F",830,380);


      
   g.setFont( new Font( "verdana", Font.BOLD, 15 ) );
   if(MPPlateau.getCasePlateau(MPJoueur1.getJPosition())!=null)
   {
   	g.setColor(Color.black);
    g.drawString("" + MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).getNomCase(),20,450);
    if(terr1==true)
    {
    g.drawString("Prix :"+MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).getCasePrix(),20,515);
    g.drawString("Loyer :"+MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).getCaseLoyer(),20,530);
    g.drawString("Prix Maison :"+MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).getPrixMaison(),20,545);
    g.drawString("Nbre Maison :"+MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).getNbreMaison(),20,560);
	
	g.drawString("Propriétaire :",20,575);
    if(MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).getCaseProprietaire()!=null)
    g.drawString("->" + MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).getCaseProprietaire().getNom(),20,590);
    else
 	g.drawString("-> A Vendre",20,590);
 	}
   }

   if(MPPlateau.getCasePlateau(MPJoueur2.getJPosition())!=null)
   {
    g.setColor(Color.black);
    g.drawString("" + MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).getNomCase(),830,450);
    if(terr2==true)
    {
    g.drawString("Prix :"+MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).getCasePrix(),830,515);
    g.drawString("Loyer :"+MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).getCaseLoyer(),830,530);
    g.drawString("Prix Maison :"+MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).getPrixMaison(),830,545);
    g.drawString("Nbre Maison :"+MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).getNbreMaison(),830,560);
	
	g.drawString("Propriétaire :",830,575);
    if(MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).getCaseProprietaire()!=null)
    g.drawString("->" + MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).getCaseProprietaire().getNom(),830,590);
    else
 	g.drawString("-> A Vendre",830,590);
    }
   }
   		
   		//AFFICHAGE DES NOM DES JOUEURS SUR LA TABLE DU MONOPOLY QUI DOIVENT JOUER
   		g.setFont( new Font( "verdana", Font.BOLD, 20 ) );
   		g.setColor(Color.black);
   		g.drawString("Celui qui a la main est :",220,700);
   		
		if(MPJoueur1.getTour()==true)
		{
			g.setColor(Color.blue);
			g.drawString(MPJoueur1.getNom(),500,700);
		}
		else
		{
			g.setColor(Color.red);
			g.drawString(MPJoueur2.getNom(),500,700);
		}
		
		
		
		
		
		

//GESTION DE L'ACHAT (BOUTON)
if(MPJoueur1.getTour()==true)
{
	Control_actions.Acheter.setEnabled(false);
if((
(MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).CaseType==0)||
(MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).CaseType==1)||
(MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).CaseType==2)
)
&&(MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).aVendre()==true))
	Control_actions.Acheter.setEnabled(true);
}
else
{
	Control_actions.Acheter.setEnabled(false);
if((
(MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).CaseType==0)||
(MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).CaseType==1)||
(MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).CaseType==2)
)
&&(MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).aVendre()==true))
	Control_actions.Acheter.setEnabled(true);
}

//GESTION DE LA VENTE (BOUTON)
if(MPJoueur1.getTour()==true)
{
	Control_actions.Vendre.setEnabled(false);
if((
(MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).CaseType==0)||
(MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).CaseType==1)||
(MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).CaseType==2)
)
&&(MPPlateau.getCasePlateau(MPJoueur1.getJPosition()).getCaseProprietaire()==MPJoueur1))
	Control_actions.Vendre.setEnabled(true);
}
else
{
	Control_actions.Vendre.setEnabled(false);
if((
(MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).CaseType==0)||
(MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).CaseType==1)||
(MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).CaseType==2)
)
&&(MPPlateau.getCasePlateau(MPJoueur2.getJPosition()).getCaseProprietaire()==MPJoueur2))
	Control_actions.Vendre.setEnabled(true);
}

  }
}