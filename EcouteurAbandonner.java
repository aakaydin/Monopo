import java.awt.event.*;
import java.util.*;

public class EcouteurAbandonner implements ActionListener {
	
	//Attributs 
	private FenetreInterface fen; 
	private Joueur jcourant; 
	
	int rangJoueur =0 ;
	int nbJoueur = 0;
	 

	
	public EcouteurAbandonner(FenetreInterface f){ 
		
		fen = f; 
		
		
		
	} 
	
	//cet ecouteur devrait se faire afficher une fenetre fin de la partie
	public void actionPerformed(ActionEvent e){ 
		
		fen.dispose();
		
		fen.jcourant.tuer();
		
		
		FenetreFinPartie finpartie = new FenetreFinPartie(fen.getLesJoueurs());
		
		
		
	 
	}
}
