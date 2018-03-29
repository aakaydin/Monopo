import java.util.*;
public class Principal { 
	
	public static void main(String[] args){
		
		//MenuPrincipal m1 = new MenuPrincipal(400,300);
		//MenuPrincipal2 m2 = m1 ;
		LinkedList<Joueur> mesJoueurs = new LinkedList<Joueur>() ;
		Joueur j1 = new Joueur("A");
		Joueur j2 = new Joueur("L");
		mesJoueurs.add(j1);
		mesJoueurs.add(j2);
		
		int nbJoueurs = mesJoueurs.size() ; 
		
		Joueur jcourant;
		
		Plateau plateau = new Plateau() ; 
		FenetreInterface fen = new FenetreInterface(1200,600,plateau) ; 
		
		//on déninit le joueur courant
		
		int rangJoueur = 0;
		jcourant = mesJoueurs.get(rangJoueur);
		
		//on fait un while tant que joueurCourant est vivant
		while(jcourant.estVivant()){
			
			while(jcourant.getSonTour()){
				Jouer jouer = new Jouer(plateau, fen, jcourant);
				fen.changerPanelJoueur(jcourant);
				
				jouer.testerPrison();
			}
			
			rangJoueur = (rangJoueur + 1)%nbJoueurs ;
			jcourant = mesJoueurs.get(rangJoueur);
			fen.changerJoueur(jcourant);
			
		}	
		
	}

}
