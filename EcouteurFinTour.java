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
	private int[] detteTourAvant;
	private int dette = 0; 
	
	
	
	int rangJoueur =0 ;
	int nbJoueur = 0;
	  

	
	public EcouteurFinTour(FenetreInterface f,Joueur jcourant, LinkedList<Joueur> lj){ 
		
		fen = f; 
		this.jcourant = jcourant; 
		ListJoueur = lj ; 
		nbJoueur = ListJoueur.size();
		detteTourAvant = new int[ListJoueur.size()]; 
		
		for(int i =0; i<detteTourAvant.length; i++){ 
			detteTourAvant[i] =0; 
		}
		 
		
		lancerLesDes.add(lab); 
		
		
	} 
	
	public void actionPerformed(ActionEvent e){ 
		
		//on efface le panel de la case sur laquelle on se trouve 
		fen.changerPanelTemp(new JPanel()); 
		
		fen.finTour.setEnabled( false );
		fen.lanceDe.setEnabled( true );
		
		
		System.out.println("taille tableau"+detteTourAvant.length); 
			
		//on met la méthode j.getSomme en début de tour car on autorise un tour d'endettement 
		if(!jcourant.estVivant() || jcourant.getSomme() < 0){
			fen.dispose();
			//fin de la partie
			//creer une fenêtre fin de la partie
			FenetreFinPartie finpartie = new FenetreFinPartie(ListJoueur);
		}
	
		
		System.out.println("la dette du joueur avant est : "+detteTourAvant[rangJoueur]); 
		System.out.println("la dette du joueur est : "+jcourant.getDette());
		
		dette = jcourant.getDette();
		
		if(dette == detteTourAvant[rangJoueur] && dette!=0){ 
			
		 //en cas d'impayé il faut un indicateur pour actionner l'hypotheque
			
			if(jcourant.avoirHotel() == true && dette >0){ //il faut une liste d'hotel et savoir si le joeur en a encore
				while(jcourant.getMesHotels() != null){ 
				dette = dette - jcourant.getHotelPlusChere().getPrixHypotheque(); // j'enlève à la dette le prix de l'hypotheque d'un hotel
				jcourant.getMesHotels().remove(jcourant.getMesHotels().indexOf(jcourant.getHotelPlusChere())); // j'enlève l'hotel de la liste
				}
				
			}else if(jcourant.avoirMaison()== true && dette >0){ 
				while(jcourant.getMesMaisons()!= null){ 
				dette = dette - jcourant.getMaisonPlusChere().getPrixHypotheque(); // j'enlève à la dette le prix de l'hypotheque d'une maison
				jcourant.getMesMaisons().remove(jcourant.getMesMaisons().indexOf(jcourant.getMaisonPlusChere())); // j'enlève la maison de la liste
				}
			}else if(jcourant.avoirPropriete()== true && dette >0){ 
				while(jcourant.getMesProprietes()!= null){ 
				dette = dette - jcourant.getProprietePlusChere().getPrixHypotheque(); 
				jcourant.getMesProprietes().remove(jcourant.getMesProprietes().indexOf(jcourant.getProprietePlusChere()));
				}
			}else if(dette >0){ // si la dette n'est toujours pas nulle il faut prélever sur le compte
				jcourant.setArgent(jcourant.getSomme()-dette); 
				if(jcourant.getSomme()<0){ //s'il n'y a plus d'argent le joueur a perdu
					jcourant.setAbandon(); 
					System.out.println("joueur"+jcourant.getNom()+"a perdu"); 
				} 
			}
			
					 
		
		}
		detteTourAvant[rangJoueur] = dette;
		
		System.out.println(""+rangJoueur); 
		if(rangJoueur + 1 >= nbJoueur ){
			rangJoueur = (rangJoueur + 1)%nbJoueur ;
		} else {
			rangJoueur = rangJoueur + 1 ;
		}
		System.out.println("Rang Joueur :"+rangJoueur); 
		jcourant = ListJoueur.get(rangJoueur);							//on change de joueur; 
		System.out.println(" Fin tour ");
		Jouer jouer = new Jouer(fen.getPlateau(), fen, jcourant);
		fen.setJoueur(jcourant);
		fen.changerJoueurEcouteurDe(jcourant);
		//fen.panelEast.repaint();
		fen.changerPanelJoueur(jcourant);
		jouer.testerPrison();
		
		
		// je rend disponible de bouton PayerCredit
		
		fen.getEcouteurPayerCredit().changerJoueur(jcourant);
		if(jcourant.getDette()!=0){ 
			fen.getPayerDette().setEnabled(true); 
		}else{ 
			fen.getPayerDette().setEnabled(false);
		}
		
		if( jcourant.getNom() == "Bob"){
			
			IA bob = new IA( fen);
			bob.perform();
			
		}
		
		
		 
	
	 
	}
}
