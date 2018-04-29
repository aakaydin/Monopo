import java.awt.event.* ;
import java.util.* ; 
import javax.swing.*;

public class EcouteurPayerTaxe implements ActionListener{
	
	Joueur j ; 
	int somme ;
	FenetreInterface fen ;
	JButton but;
	
	public EcouteurPayerTaxe(Joueur jj, int somme, FenetreInterface f, JButton button){
		j = jj ;
		this.somme = somme ;
		fen = f ;
		but = button;
		//on désactive le bouton de fin de tour pour que le joueur soit obligé de payer les taxes 
		fen.finTour.setEnabled(false);
		
	}
	
	public void setFenetreInterface(FenetreInterface f){
		fen = f ;
	}
	
	//méthode appelée lorsque le joueur appuie sur payer la taxe 
	public void actionPerformed(ActionEvent ae){
		
		//il peut à présent terminer son tour 
		fen.finTour.setEnabled(true);
		//le bouton de payer la taxe devient faux 
		but.setEnabled(false);
		
		//changement de la somme du joueur 
		j.setArgent(somme);
		//changement de l'affichage graphique 
		fen.changerPanelJoueur(j);
		
		
	}
}
