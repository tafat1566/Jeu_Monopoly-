package monopl2.Monopoly;

import monopl2.Monopoly.*;

public class Hotel  extends Propriete{
           static int nb_hotel=0;
	public Hotel(int prix, int loyer, int prixMaison,
			Joueur proprietaire, String monopolyCaseNom,
			int monopolyCasePosition, int monopolyCaseType,
			int monopolyCaseGroupe) {
		super(prix, loyer, prixMaison, proprietaire, monopolyCaseNom,
				monopolyCasePosition, monopolyCaseType, monopolyCaseGroupe);
		// TODO Auto-generated constructor stub
	}

	public void ajouterMaison() {
		  
		   NbreMaison++;

	  }
	  
	  public static void ajouterHotel() {
		  
		  nb_hotel++;
		  NbreMaison=NbreMaison-4;
		  System.out.println("vous avez construit un hotel");
	  }
	  
	  public int nbHotel() {
		  return nb_hotel;
	  }

	
	
	
	
}
