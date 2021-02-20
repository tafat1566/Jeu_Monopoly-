package monopl2.Monopoly;

class Propriete extends Case
{
	protected int Prix;
	protected int Loyer;
	protected Joueur Proprietaire;
	public int MonopolyCaseGroupe;
	protected int PrixMaison;
	protected static int NbreMaison;
	



	public Propriete(int prix,int loyer,int prixMaison,Joueur proprietaire,String monopolyCaseNom, int monopolyCasePosition,
			int monopolyCaseType,
			 int monopolyCaseGroupe
			) {
		super(monopolyCaseNom, monopolyCasePosition, monopolyCaseType);
		Prix = prix;
		Loyer = loyer;
		Proprietaire = proprietaire;
		MonopolyCaseGroupe = monopolyCaseGroupe;
		PrixMaison = prixMaison;
		NbreMaison = 0;
	}

	
	
	public int getCasePrix()
	{
		return (Prix);
	}

	public int getCaseLoyer()
	{
		return (Loyer);
	}

	public Joueur getCaseProprietaire()
	{
		return (Proprietaire);
	}

	public void setCaseProprietaire(Joueur CaseProprio)
	{
		Proprietaire=CaseProprio;
	}

	public boolean aVendre()
	{
		return (Proprietaire==null);
	}


	
	public int getPrixMaison()
	{
		return (PrixMaison);
	}
	
	public void setNbreMaison(int NbreM)
	{
		NbreMaison=NbreM;
	}
	
	public int getNbreMaison()
	{
		return (NbreMaison);
	}
}
