import java.awt.event.*;
import java.util.*;

public class EcouteurFinTour implements ActionListener {
	
	private FenetreInterface fen; 
	private Joueur jcourant; 
	
	private LinkedList<Joueur> ListJoueur = new LinkedList<Joueur>();
	
	int rangJoueur =0 ;
	int nbJoueur = 0;
	 

	
	public EcouteurFinTour(FenetreInterface f,Joueur jcourant, LinkedList<Joueur> lj){ 
		
		fen = f; 
		this.jcourant = jcourant; 
		ListJoueur = lj ; 
		nbJoueur = ListJoueur.size();
		
		
	} 
	
	public void actionPerformed(ActionEvent e){ 
		
		if(!jcourant.estVivant()){
			//fin de la partie
		}
		System.out.println(""+rangJoueur); 
		if(rangJoueur + 1 >= nbJoueur ){
			rangJoueur = (rangJoueur + 1)%nbJoueur ;
		} else {
			rangJoueur = rangJoueur + 1 ;
		}
		System.out.println(""+rangJoueur); 
		jcourant = ListJoueur.get(rangJoueur);
		Jouer jouer = new Jouer(fen.getPlateau(), fen, jcourant);
		fen.setJoueur(jcourant);
		fen.changerJoueurEcouteurDe(jcourant);
		fen.changerPanelJoueur(jcourant);
		jouer.testerPrison();
		
			
	
			
		
	 
	}
}
