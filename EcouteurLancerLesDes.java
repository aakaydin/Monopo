import java.awt.event.* ;
import java.util.* ; 

public class EcouteurLancerLesDes implements ActionListener{
	
	Joueur j ;  
	Jouer jouer ;
	FenetreInterface fen ;
	boolean enPrison;
	
	public EcouteurLancerLesDes(Joueur jj, FenetreInterface f, Plateau p){
		j = jj ;
		jouer = new Jouer(p, f, j);
		fen = f;
		enPrison = j.enPrison;
	}
	
	public void setJoueur(Joueur jj){
		j = jj;
	}
	
	public void actionPerformed(ActionEvent ae){
		
		//System.out.println("des");
		
		fen.setTextInfo(""); 
		j.lancerLesDes(); 
		
		if( j.de1 != j.de2){	
		
		fen.finTour.setEnabled(true); //Si le joueur n'a pas fait de double, il peut finir son tour 
		fen.lanceDe.setEnabled(false); //et il ne peut pas rejouer 
		
		}else if( j.de1 == j.de2 && enPrison == false ){
			
			fen.setTextInfo("Rejouez");
			fen.finTour.setEnabled(false); //s'il a fait un double il est obligé de relancer les dés 
			fen.lanceDe.setEnabled(true);
			
		}else if ( enPrison == true ){

			if(j.de1 == j.de2){ 

				fen.finTour.setEnabled(true);
				fen.lanceDe.setEnabled(false);
		
			}	
		}
		
		
		fen.getPanelCase(j.getPos()).retirerJoueur(j); //On efface le joueur de la position qu'il avait avant de lancer les dés
		fen.getPanelPlateau().repaint();


		fen.aff.setDes(j.de1 , j.de2); //On modifie l'affichage des dés dans la FenetreInterface
		fen.aff.repaint();
		
		
		if(!j.getEnPrison()){ //s'il n'est pas en prison, le joueur va avancer du nombre de cases donné par les dés 
			
			int numCaseAAvancer = j.getSommeDes() ;

			j.avancer(numCaseAAvancer) ; 

			if(fen.p.getCases().get(j.getPos()) instanceof CaseProp){
				CaseProp cp = (CaseProp) fen.p.getCases().get(j.getPos());
				if(cp.getAchete() && cp.getPropri() != j) fen.finTour.setEnabled(false); //si le joueur est sur une case propriété d'un adversaire, il ne pourra pas finir son tour sans payer
			}

			if(j.getPassCaseDep() == true){
				fen.setTextInfo("Vous passez par la case depart, recevez 10000");
				j.setPassCaseDep(false); 
				fen.changerPanelJoueur(j);
			}
			
			
			//il faut redessiner la position du joueur sur le plateau 
			fen.getPanelCase(j.getPos()).dessinerJoueur(j);
			
			//System.out.println(j.getSommeDes());
			
			jouer.Tour(); //si le joueur n'est pas en prison, il faut appeler la méthode associée à la case sur laquelle il se trouve

		}else{ //appeler méthode traitement quand je suis en prison
			jouer.traitementEstEnPrison();
		}
		
		fen.repaint(); //on redessine la fenêtre
		fen.pack(); //on redimensionne la fenêtre
			
	}
	
}
