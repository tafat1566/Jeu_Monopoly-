package monopl2.Monopoly;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class De {
  
	public int val_de=0;
    
	public De(int val_dice) {
		super();
		this.val_de = val_dice;
	}
	
	
	
	public static void Roll( De d1 ,De d2) 
	  {
	  	d1.val_de =0; //( int )( Math.random() * 6 + 1 );
		d2.val_de =1; //( int )( Math.random() * 6 + 1 );
	  }  
	
	
	public void paintComponent(Graphics g) {
		//LES DICES
	   	g.setFont( new Font( "verdana", Font.BOLD, 20 ) );
	   	g.setColor(Color.black);
	   	g.drawString("Résultat des Dés",10,130);
	   	g.setColor( new Color( (230), (230), (230) ) );
		g.fillRoundRect( 120, 150, 33, 33 ,5,5);
		g.fillRoundRect( 161, 150, 33, 33,5,5);
		g.setColor( Color.black );
	
	
	}
}
