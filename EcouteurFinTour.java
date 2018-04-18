import java.awt.event.*;
import java.util.*;
import java.awt.* ;
import javax.swing.*;


public class EcouteurFinTour implements ActionListener {
	
	private FenetreInterface fen; 
	private Joueur jcourant; 
	
	JPanel lancerLesDes = new JPanel();
	
	JLabel lab = new JLabel("Vous pouvez lancer les des");
	
	private LinkedList<Joueur> ListJoueur = new LinkedList<Joueur>();
	
	int rangJoueur =0 ;
	int nbJoueur = 0;
	 

	
	public EcouteurFinTour(FenetreInterface f,Joueur jcourant, LinkedList<Joueur> lj){ 
		
		fen = f; 
		this.jcourant = jcourant; 
		ListJoueur = lj ; 
		nbJoueur = ListJoueur.size();
		
		lancerLesDes.add(lab); 
		
		
	} 
	
	public void actionPerformed(ActionEvent e){ 
		
		//on efface le panel de la case sur laquelle on se trouve 
		fen.changerPanelTemp(new JPanel()); 
		
		fen.finTour.setEnabled( false );
		fen.lanceDe.setEnabled( true );
		
		//on met la méthode j.getSomme en début de tour car on autorise un tour d'endettement 
		if(!jcourant.estVivant() || jcourant.getSomme() < 0){
			fen.dispose();
			//fin de la partie
			//creer une fenêtre fin de la partie
			FenetreFinPartie finpartie = new FenetreFinPartie(ListJoueur);
		}
		System.out.println(""+rangJoueur); 
		if(rangJoueur + 1 >= nbJoueur ){
			rangJoueur = (rangJoueur + 1)%nbJoueur ;
		} else {
			rangJoueur = rangJoueur + 1 ;
		}
		
		System.out.println("Rang Joueur :"+rangJoueur); 
		jcourant = ListJoueur.get(rangJoueur);
		System.out.println(" Fin tour ");
		Jouer jouer = new Jouer(fen.getPlateau(), fen, jcourant);
		fen.setJoueur(jcourant);
		fen.changerJoueurEcouteurDe(jcourant);
		
		if( jcourant.getNom() == "Bob"){
			
			IA bob = new IA( fen);
			bob.perform();
			
			}
		//fen.panelEast.repaint();
		
		if( jcourant.getNom() != "Bob")  fen.changerPanelJoueur(jcourant);
		jouer.testerPrison();
		
		
			
		
	
	 
	}
}
