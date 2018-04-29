import java.awt.event.* ;
import java.util.* ; 

public class EcouteurPayerJoueur implements ActionListener{
	
	Joueur j; 
	Joueur proprietaire;
	CaseProp c;
	FenetreInterface fen;
	
	
	public EcouteurPayerJoueur(Joueur prop, Joueur jj, CaseProp cas){
		j = jj;
		proprietaire = prop; 
		c = cas;
	}
	
	
	public void setJoueur(Joueur jj){
		j = jj;
	}
		
	public void setFenetreInterface(FenetreInterface f){
		fen = f;
	}
	
	
	public void disableButton(){  
		fen.finTour.setEnabled(false);
	}
	
	
	public void actionPerformed(ActionEvent ae){
		c.payer.setEnabled(false);
		fen.finTour.setEnabled(true); //On ne peut finir son tour seulement si on a payé le joueur
		//le peix à payer par le joueur qui tombe sur une propriété est 10% du prix de la propriété
		int prix = c.getPrix()/ 10;
		j.setArgent(-prix); //On déduit de la somme du joueur la valeur à payer 
		
		proprietaire.setArgent(prix); //On augmente la somme du propriétaire
		fen.changerPanelJoueur(j);
	}
		
		
		
}
