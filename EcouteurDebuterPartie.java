import java.awt.event.*;
import java.util.*;
import javax.swing.*; 
import java.awt.*; 

public class EcouteurDebuterPartie implements ActionListener {
	
	private MenuPrincipal2 m2; 
	private LinkedList<String> Nom = new LinkedList<String>();  
	private LinkedList<JTextField> text;// = new LinkedList<JTextField>();  
	private int nbJoueur; 
	private LinkedList<Joueur> ListJoueur= new LinkedList<Joueur>();
	private Joueur jcourant; 
	 

	
	public EcouteurDebuterPartie(MenuPrincipal2 f){ 
		m2=f; 
		nbJoueur = m2.getNbJoueur(); 
		
	} 
	
	public void actionPerformed(ActionEvent e){ 
		//créaton de l'interface à compléter : 
		text = m2.getTextField(); 
		for(JTextField t : text){							//je complète le tableau des noms des joueurs
			Nom.add(t.getText()); 
		}
		
		for(String nom : Nom){ 
			ListJoueur.add(new Joueur(nom,100000,0));
			System.out.println(nom); 
		}
		
		
		
		Plateau plateau = new Plateau() ; 
		FenetreInterface fen = new FenetreInterface(1200,600,plateau) ; 
		
		
		//on déninit le joueur courant
		
		int rangJoueur = 0;
		jcourant = ListJoueur.get(rangJoueur);
		
		//on fait un while tant que joueurCourant est vivant
		while(jcourant.estVivant()){
			
			while(jcourant.getSonTour()){
				Jouer jouer = new Jouer(plateau, fen, jcourant);
				fen.changerPanelJoueur(jcourant);
				
				jouer.testerPrison();
				//c'est l'écouteur fin de tour qui rend le tour du joueur false 
			}
			
			rangJoueur = (rangJoueur + 1)%nbJoueur ;
			jcourant = ListJoueur.get(rangJoueur);
			fen.changerJoueur(jcourant);
		}
	
	
		
		
	}
	
	
}
