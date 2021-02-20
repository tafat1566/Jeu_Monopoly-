package monopl2.Monopoly;
class Joueur 
{  
  	String Nom;
	int Argent;
	int JPosition;
	boolean Tour;
	boolean enPrison;
	int End_prison;
	
	public Joueur(String Nom)
	{
		this.Nom=Nom;
		Argent=150000;
		JPosition=0;
		Tour=false;
		enPrison=false;
		End_prison=0;
	}
	public boolean getEtatPrison()
	{
		return enPrison;
	}
	
	public void setEtatPrison(boolean EtatPrison)
	{
		enPrison=EtatPrison;
	}
	public int getEtatPrisonFini()
	{
		return End_prison;
	}
	public void setEtatPrisonFini(int TourPrison)
	{
		End_prison=TourPrison;
	}
	
	
	public String getNom()
	{
		return(Nom);
	}

	public int getJPosition()
	{
		return(JPosition);
	}

	public void setJPosition(int JPosition){
		this.JPosition=JPosition;
	}

	public int getArgent(){
		return (Argent);
	}
	
	public void PayerArgent(int Montant){
		Argent-=Montant;
	}

	public void RecevoirArgent(int Montant){
		Argent+=Montant;
	}
	
	public boolean getTour()
	{
		return(Tour);
	}
	public void setTour(boolean tour)
	{
		Tour=tour;
	}
	
  //POSITIONS DU JOUEUR 1 BLEU SUR LA TABLE DU MONOPOLY
  public int PlacementJoueur1[][] = 
  {		
	{ 760, 607 },//CASE DEPART
	{ 685, 567 },
	{ 635, 567 },
	{ 585, 567 },
	{ 545, 567 },
	{ 495, 567 },
	{ 445, 567 },
	{ 395, 567 },
	{ 345, 567 },
	{ 295, 567 },
	{ 250, 587 },//CASE PRISON
	{ 278, 550 },
	{ 278, 500 },
	{ 278, 450 },
	{ 278, 400 },
	{ 278, 350 },
	{ 278, 300 },
	{ 278, 255 },
	{ 278, 205 },
	{ 278, 155 },
	{ 240, 97  },//PARC GRATUIT
	{ 295, 117 },
	{ 345, 117 },
	{ 395, 117 },
	{ 445, 117 },
	{ 495, 117 },
	{ 545, 117 },
	{ 585, 117 },
	{ 635, 117 },
	{ 685, 117 },
	{ 750, 90  },//ALLEZ EN PRISON
	{ 728, 155 },
	{ 728, 205 },
	{ 728, 255 },
	{ 728, 300 },
	{ 728, 350 },
	{ 728, 400 },
	{ 728, 450 },
	{ 728, 500 },
	{ 728, 550 },
  };

 //POSITIONS DU JOUEUR 2 ROUGE SUR LA TABLE DU MONOPOLY
  public int PlacementJoueur2[][] = 
  {
	{ 780, 607 },//CASE DEPART
	{ 705, 567 },
	{ 655, 567 },
	{ 605, 567 },
	{ 565, 567 },
	{ 515, 567 },
	{ 465, 567 },
	{ 415, 567 },
	{ 365, 567 },
	{ 315, 567 },
	{ 270, 587 },//CASE PRISON
	{ 278, 530 },
	{ 278, 480 },
	{ 278, 430 },
	{ 278, 380 },
	{ 278, 330 },
	{ 278, 280 },
	{ 278, 235 },
	{ 278, 185 },
	{ 278, 135 },
	{ 260, 97  },//PARC GRATUIT
	{ 315, 117 },
	{ 365, 117 },
	{ 415, 117 },
	{ 465, 117 },
	{ 515, 117 },
	{ 565, 117 },
	{ 605, 117 },
	{ 655, 117 },
	{ 705, 117 },
	{ 770, 90  },//ALLEZ EN PRISON
	{ 728, 135 },
	{ 728, 185 },
	{ 728, 235 },
	{ 728, 280 },
	{ 728, 330 },
	{ 728, 380 },
	{ 728, 430 },
	{ 728, 480 },
	{ 728, 530 },
  };	
	
}