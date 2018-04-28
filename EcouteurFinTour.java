import java.awt.event.*;
import java.util.*;
import java.awt.* ;
import javax.swing.*;


public class EcouteurFinTour implements ActionListener {
	
	private FenetreInterface fen; 
	//joueur qui appuie sur le bouton
	private Joueur jcourant; 
    private Plateau plateau ;
    private PanelPlateau panelPlateau ;
	
	//panel pour le panel de la fenêtre 
	private JPanel lancerLesDes = new JPanel();
	private JLabel lab = new JLabel("Vous pouvez lancer les des");
	
	//liste des joeurs de ma aprtie 
	private LinkedList<Joueur> ListJoueur = new LinkedList<Joueur>();
	
	//code util pour le traitement du crédit  mais qui est une partie que nous n'avons pas fini de développer et qui n'est pas opérationnelle 
	//private int[] detteTourAvant;
	//private int dette = 0; 
	
	//va prendre le rang du joueur courant dans la linkedlist
	int rangJoueur =0 ;
	int nbJoueur = 0;
	  

	
	public EcouteurFinTour(FenetreInterface f,Joueur jcourant, LinkedList<Joueur> lj){ 
		
		fen = f; 
        plateau = fen.getPlateau();
        panelPlateau = fen.getPanelPlateau() ; 
        
		this.jcourant = jcourant; 
		ListJoueur = lj ; 
		nbJoueur = ListJoueur.size();
		//detteTourAvant = new int[ListJoueur.size()]; 
		
		/*for(int i =0; i<detteTourAvant.length; i++){ 
			detteTourAvant[i] =0; 
		}*/ 
		 
		
		lancerLesDes.add(lab); 
		
		
	} 
	
	public void actionPerformed(ActionEvent e){ 
		
		//on efface le panel de la case sur laquelle on se trouve 
		fen.changerPanelTemp(new JPanel()); 
		
		//on change l'activation des boutons pour que le joueur ne fasse pas ce qu'il veut 
		fen.finTour.setEnabled( false );
		fen.lanceDe.setEnabled( true );
			
		//on met la méthode j.getSomme en début de tour car on autorise un tour d'endettement donc on peut être un tour en négatif 
		//test si le joeur est mort ou n'a plus d'argent 
		if(!jcourant.estVivant() || jcourant.getSomme() < 0){
			fen.dispose();
			//fin de la partie
			//creer une fenêtre fin de la partie
			FenetreFinPartie finpartie = new FenetreFinPartie(ListJoueur);
		}
	
		//partie qui permet de tester si le joueur a bien payer son crédit et sinon de le pénaliser en hypothéquent en conséquence, partie non fonctionnelle pour l'instant 
		//System.out.println("la dette du joueur avant est : "+detteTourAvant[rangJoueur]); 
		//System.out.println("la dette du joueur est : "+jcourant.getDette());
		
		
		/*dette = jcourant.getDette();
        System.out.println("dette "+dette);
		if(dette == detteTourAvant[rangJoueur] && dette!=0){ 
			
		 //en cas d'impayé il faut un indicateur pour actionner l'hypotheque
			
			if(jcourant.avoirHotel() == true && dette >0){ //il faut une liste d'hotel et savoir si le joeur en a encore
				while(jcourant.getMesHotels().size() > 0 && dette > 0){ 
				dette = dette - jcourant.getHotelPlusChere().getPrixHypotheque(); // j'enlève à la dette le prix de l'hypotheque d'un hotel
				jcourant.getMesHotels().remove(jcourant.getHotelPlusChere()); // j'enlève l'hotel de la liste
				//il faut effacer l'hotel du plateau 
				//il faut enlever un hotel à la CaseProp correspondante 
				}
				
			}else if(jcourant.avoirMaison()== true && dette >0){ 
				while(jcourant.getMesMaisons().size() > 0 && dette > 0){ 
				dette = dette - jcourant.getMaisonPlusChere().getPrixHypotheque(); // j'enlève à la dette le prix de l'hypotheque d'une maison
				jcourant.getMesMaisons().remove(jcourant.getMaisonPlusChere()); // j'enlève la maison de la liste
				//il faut effacer la maison du plateau 
				//il faut enlever une maison à la case prop correspondante 
				}
			}else if(jcourant.avoirPropriete()== true && dette >0){ 
                System.out.println("dans boucle propriete");
				while(jcourant.getMesProprietes().size() > 0 && dette > 0){ 
				dette = dette - jcourant.getProprietePlusChere().getPrixHypotheque(); 
				jcourant.getMesProprietes().remove(jcourant.getProprietePlusChere());
				//il faut retirer le propriétaire de la case, remettre la case dans son état initial
				}
			}else if(dette >0 && jcourant.avoirPropriete()!= true){ // si la dette n'est toujours pas nulle il faut prélever sur le compte
				jcourant.setArgent(jcourant.getSomme()-dette); 
				System.out.println(jcourant.getSomme());
				if(jcourant.getSomme()<0){ //s'il n'y a plus d'argent le joueur a perdu
					jcourant.tuer(); 
					System.out.println("joueur"+jcourant.getNom()+"a perdu"); 
				} //peut être à cause de cette ligne que le jeu s'arrête parfois 
			}
			
					 
		
		}*/ 
		//on remet à 0 la dette du joueur si celle-ci était négtive, oui il peut perdre de l'argent dans ce cas						  
		/*if(dette<0){ 
                	dette = 0; 
            	}
		//on règle la nouvelle dette du joueur 
           	jcourant.setDette2(dette); 	
		//on met à jour la dette tour avant du joueur 						   
		detteTourAvant[rangJoueur] = dette;*/ 
		
		
		//changement du joueur dont c'est le tour 
		if(rangJoueur + 1 >= nbJoueur ){
			rangJoueur = (rangJoueur + 1)%nbJoueur ;
		} else {
			rangJoueur = rangJoueur + 1 ;
		}
		
		//changement du joueur couant 
		jcourant = ListJoueur.get(rangJoueur);							//on change de joueur; 
		
		
		//changements liés à la fenêtre 
		fen.setJoueur(jcourant);
		fen.changerJoueurEcouteurDe(jcourant);
		//fen.panelEast.repaint();
		fen.changerPanelJoueur(jcourant);
	
		
		
		//changement du joueur pour le bouton payer credit qui doit être adapté au joueur courant 
		fen.getEcouteurPayerCredit().changerJoueur(jcourant);
		if(jcourant.getDette()!=0){ 
			fen.getPayerDette().setEnabled(true); 
		}else{ 
			fen.getPayerDette().setEnabled(false);
		}
		
		//si c'est le tour de l'intelligence artificielle est Bob alors le tour lancé est différent 
		if( jcourant.getNom() == "Bob"){
			
			IA bob = new IA( fen);
			bob.perform();
			
		} 
		//et si c'est son tour on laisse quand même ça Aydin ?? 
			//création d'un nouvel objet jouer qui va permettre d'effcetuer en cascade les méthodes d'un tour 
			Jouer jouer = new Jouer(fen.getPlateau(), fen, jcourant);
			//méthode à partir de laquelle vont s'effectuer en cascade les autres méthodes
			jouer.testerPrison();
	 
	}
}
