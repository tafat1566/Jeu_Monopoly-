package monopl2.Monopoly;

import java.util.ArrayList;

import monopl2.Monopoly.Joueur;

public class Case_chance extends Case{

	public Case_chance(String monopolyCaseNom, int monopolyCasePosition,
			int monopolyCaseType) {
		super(monopolyCaseNom, monopolyCasePosition, monopolyCaseType);
		// TODO Auto-generated constructor stub
	}

	public static String tirer_carte(Joueur  J) {
		ArrayList<String> cartes = new ArrayList<String>();
		cartes.add("Vous gagne gagner 10.000");
		cartes.add("vous gagnez 5.000");
		cartes.add("visite en prison");
		cartes.add(" on vous place case depart !");
		
		int a=(int)Math.random()*cartes.size();
		String carte_tire=cartes.get(a);
		switch(a) {
			case 0:
				J.RecevoirArgent(10000);
				break;
			case 1:
				J.RecevoirArgent(5000);
				break;
			case 2:
				J.setJPosition(10);
				break;
			case 3:
				J.setJPosition(0);
				break;
		}
		return carte_tire;

	}
	
	
	
	
}
