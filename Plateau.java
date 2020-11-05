package monopl2.Monopoly;/*
 TYPES DE TERRAINS
 0:Terrain normal
 1:Gare
 2:Compagnie
 3:Caisse de Communauté
 4:Chance
 5:Prison
 6:Allez en prison
 7:Case de départ
 8:Impôt
 9:Parc Gratuit
 */
 
class Plateau
{   
	
	//INSTANCIATION DES TERRAINS DU MONOPOLY
	Propriete CD=new Propriete(0,0,0,null,"Case de départ",0,7,0);
//BRUN
	Propriete T1=new Propriete(6000,200,200,null,"Belleville",1,0,1);
    Propriete CC1=new Propriete(0,0,0,null,"Caisse de Communauté",2,3,0);
    Propriete T2=new Propriete(6000,400,200,null,"Lecourbe",3,0,1);
    Propriete IGR=new Propriete(0,20000,0,null,"Impôt sur le Revenu",4,8,0);
    Propriete GM=new Propriete(20000,2500,0,null,"Montparnasse",5,1,9);
//BLEU CLAIR
	Propriete T3=new Propriete(10000,600,300,null,"Vaugirard",6,0,2);
	Propriete CH1=new Propriete(0,0,0,null,"Chance",7,4,0);
	Propriete T4=new Propriete(10000,600,300,null,"Courcelles",8,0,2);
	Propriete T5=new Propriete(12000,800,300,null,"Republique",9,0,2);
	Propriete PR=new Propriete(0,0,0,null,"Prison",10,5,0);
//VIOLET
	Propriete T6=new Propriete(14000,1000,400,null,"La Villette",11,0,3);
	Propriete CE=new Propriete(15000,1000,0,null,"Compagnie Electricité",12,2,10);
	Propriete T7=new Propriete(14000,1000,400,null,"Neuilly",13,0,3);
	Propriete T8=new Propriete(16000,1200,400,null,"Paradis",14,0,3);
	Propriete GL=new Propriete(20000,2500,0,null,"Lyon",15,1,9);
//ORANGE
	Propriete T9=new Propriete(18000,1400,500,null,"Mozart",16,0,4);
	Propriete CC2=new Propriete(0,0,0,null,"Caisse de Communauté",17,3,0);
	Propriete T10=new Propriete(18000,1400,500,null,"St-Michel",18,0,4);
	Propriete T11=new Propriete(20000,1600,500,null,"Pigalle",19,0,4);
	Propriete PG=new Propriete(0,0,0,null,"Parc Gratuit",20,9,0);	
//ROUGE
	Propriete T12=new Propriete(22000,1800,600,null,"Matignon",21,0,5);
	Propriete CH2=new Propriete(0,0,0,null,"Chance",22,4,0);
	Propriete T13=new Propriete(22000,1800,600,null,"Malesherbes",23,0,5);
	Propriete T14=new Propriete(24000,2000,600,null,"Henri-Martin",24,0,5);
	Propriete GN=new Propriete(20000,2500,0,null,"Nord",25,1,9);
//JAUNE
	Propriete T15=new Propriete(26000,2200,700,null,"St-Honore",26,0,6);
	Propriete T16=new Propriete(26000,2200,700,null,"La Bourse",27,0,6);
	Propriete CDE=new Propriete(15000,1000,0,null,"Compagnie des Eaux",28,2,10);
	Propriete T17=new Propriete(28000,2400,700,null,"La Fayette",29,0,6);
	Propriete AEP=new Propriete(0,0,0,null,"Allez en Prison",30,6,0);	
//VERT
	Propriete T18=new Propriete(30000,2600,1500,null,"Breteuil",31,0,7);
	Propriete T19=new Propriete(30000,2600,1500,null,"Foch",32,0,7);
	Propriete CC3=new Propriete(0,0,0,null,"Caisse de Communauté",33,3,0);
	Propriete T20=new Propriete(32000,2800,1500,null,"Capucines",34,0,7);
	Propriete GSL=new Propriete(20000,2500,0,null,"Saint Lazare",35,1,9);
    Propriete CH3=new Propriete(0,0,0,null,"Chance",36,4,0);
//BLEU FONCE
	Propriete T21=new Propriete(35000,3500,2000,null,"Champs-Elysees",37,0,8);
	Propriete TL=new Propriete(0,10000,0,null,"Taxe De luxe",38,8,0);
	Propriete T22=new Propriete(40000,5000,2000,null,"La Paix",39,0,8);
//FIN INSTANCIATION DES TERRAINS DU MONOPOLY
	public Propriete getCasePlateau(int Pos)
    {
    	if(Pos==0) return (CD);
    	//BRUN
    	if(Pos==1) return (T1);
    	if(Pos==2) return (CC1);
    	if(Pos==3) return (T2);
    	if(Pos==4) return (IGR);
    	if(Pos==5) return (GM);
		//BLEU CLAIR    	
    	if(Pos==6) return (T3);
    	if(Pos==7) return (CH1);
    	if(Pos==8) return (T4);
    	if(Pos==9) return (T5);
    	if(Pos==10) return (PR);
    	//VIOLET
    	if(Pos==11) return (T6);
    	if(Pos==12) return (CE);
    	if(Pos==13) return (T7);
    	if(Pos==14) return (T8);
    	if(Pos==15) return (GL);
		//ORANGE    	
    	if(Pos==16) return (T9);
    	if(Pos==17) return (CC2);
    	if(Pos==18) return (T10);
    	if(Pos==19) return (T11);
    	if(Pos==20) return (PG);
		//ROUGE
    	if(Pos==21) return (T12);
    	if(Pos==22) return (CH2);
    	if(Pos==23) return (T13);
    	if(Pos==24) return (T14);
    	if(Pos==25) return (GN);
		//JAUNE    	
    	if(Pos==26) return (T15);
    	if(Pos==27) return (T16);
    	if(Pos==28) return (CDE);
    	if(Pos==29) return (T17);
    	if(Pos==30) return (AEP);
		//VERT    	
    	if(Pos==31) return (T18);
    	if(Pos==32) return (T19);
    	if(Pos==33) return (CC3);
    	if(Pos==34) return (T20);
    	if(Pos==35) return (GSL);
    	if(Pos==36) return (CH3);
		//BLEU FONCE    	
    	if(Pos==37) return (T21);
    	if(Pos==38) return (TL);
    	if(Pos==39) return (T22);
    	return null;
    }
	
}