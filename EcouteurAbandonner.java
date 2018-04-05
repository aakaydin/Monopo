import java.awt.event.*;
import java.util.*;

public class EcouteurAbandonner implements ActionListener {
	
	private FenetreInterface fen; 
	private Joueur jcourant; 
	
	private LinkedList<Joueur> ListJoueur = new LinkedList<Joueur>();
	
	int rangJoueur =0 ;
	int nbJoueur = 0;
	 

	
	public EcouteurAbandonner(FenetreInterface f){ 
		
		fen = f; 
		
		
		
	} 
	
	public void actionPerformed(ActionEvent e){ 
		
		fen.dispose();
		
		fen.jcourant.tuer();
		
		System.out.println("  Your ded 2 me " );
		FenetreFinPartie finpartie = new FenetreFinPartie(fen.getLesJoueurs());
		//cet ecouteur devrait se faire afficher une fenetre fin de la partie
		
		
	 
	}
}
