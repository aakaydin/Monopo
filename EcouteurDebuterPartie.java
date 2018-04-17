import java.awt.event.*;
import java.util.*;
import javax.swing.*; 
import java.awt.*; 

public class EcouteurDebuterPartie implements ActionListener {
	
	private MenuPrincipal2 m2; 
	private LinkedList<String> Nom = new LinkedList<String>();  
	private LinkedList<JTextField> text;// = new LinkedList<JTextField>();  
	private int nbJoueur; 
	private int nbIA; 
	private LinkedList<Joueur> ListJoueur= new LinkedList<Joueur>();
	private Joueur jcourant; 
	 

	
	public EcouteurDebuterPartie(MenuPrincipal2 f){ 
		m2=f; 
		//nbJoueur = m2.getNbJoueur();
		//nbIA = m2.getNbIA();
		
		//System.out.println(nbIA+ " LOL");
		//System.out.println(nbJoueur+ " LOL");
	} 
	
	public LinkedList<Joueur> getListJoueur(){return ListJoueur;}
	
	public void actionPerformed(ActionEvent e){ 
		
		nbJoueur = m2.getNbJoueur();
		nbIA = m2.getNbIA();
		//System.out.println(nbIA+ " LOL");
		//System.out.println(nbJoueur+ " LOL");
		
		//créaton de l'interface à compléter : 
		text = m2.getTextField(); 
		for(JTextField t : text){							//je complète le tableau des noms des joueurs
			Nom.add(t.getText());
				 
		}
		
		for( int i =0 ; i < nbIA ; i++){
			Nom.add("Bob");	
		}
		
		for(String nom : Nom){ 
			ListJoueur.add(new Joueur(nom,100000,0));
			System.out.println(nom); 
		}
		
		
		
		
		
		
		//on déninit le joueur courant
		
		int rangJoueur = 0;
		jcourant = ListJoueur.get(rangJoueur);
		jcourant.setSonTour(true); 
		
		//afficage du jeu
		Plateau plateau = new Plateau() ; 
		FenetreInterface fen = new FenetreInterface(1200,600,plateau,jcourant, ListJoueur) ; 
			
		
		//on fait un while tant que joueurCourant est vivant
		
			
			System.out.println("etat tour du joueur"+jcourant.getSonTour()); 
			//while(jcourant.getSonTour()==true){
			
				
				
				
				
				Jouer jouer = new Jouer(plateau, fen, jcourant);
				fen.changerPanelJoueur(jcourant);
				for(Joueur jj : ListJoueur){
					fen.getPanelCase(jj.getPos()).dessinerJoueur(jj);
					fen.getPanelPlateau().repaint();
				}
				
				
				jouer.testerPrison();
				System.out.println("etat tour du joueur"+jcourant.getSonTour()); 
				//c'est l'écouteur fin de tour qui rend le tour du joueur false 
				
			//}
			
		
	
	
		m2.setVisible(false); 
		
	}
	
	
}
