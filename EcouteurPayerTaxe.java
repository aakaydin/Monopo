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
		fen.finTour.setEnabled(false);
		
	}
	
	public void setFenetreInterface(FenetreInterface f){
		fen = f ;
	}
	
	public void actionPerformed(ActionEvent ae){
		
		
		fen.finTour.setEnabled(true);
		but.setEnabled(false);
		
		//peut être que le code de cette méthode peut se touver comme c'est déjà fait dans le programme jouer 
		j.setArgent(somme);
		fen.changerPanelJoueur(j);
		//il faut que l'argent soit déverser dans la classe cagnotte, fait dans méthode tour 
		//il faudrait que ça change l'affichage de la somme du joueur dans la fenêtre
		
	}
}
