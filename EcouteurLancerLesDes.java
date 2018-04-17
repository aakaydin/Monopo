import java.awt.event.* ;
import java.util.* ; 

public class EcouteurLancerLesDes implements ActionListener{
	
	Joueur j ; 
	//il faudra récupérer jouer pour passer d'un tour à l'autre mais ne pourra être fait que quand partie aura pu être fait 
	Jouer jouer ;
	FenetreInterface fen ;
	boolean enPrison;
	
	public EcouteurLancerLesDes(Joueur jj, FenetreInterface f, Plateau p){
		j = jj ;
		jouer = new Jouer(p, f, j);
		//jouer = f.getPartie().getJouer() ; 
		fen = f;
		enPrison = j.enPrison;
	}
	
	public void setJoueur(Joueur jj){
		j = jj;
	}
	
	public void actionPerformed(ActionEvent ae){
		//il faut enlever le panel qui dit qu'on peut lancer les dés 
		
		System.out.println("des");
		
		fen.setTextInfo(""); 
		j.lancerLesDes() ; 
		
		if( j.de1 != j.de2){	
		
		fen.finTour.setEnabled(true);
		fen.lanceDe.setEnabled(false);
		
		}else if( j.de1 == j.de2 && enPrison == false ){
			fen.setTextInfo("Rejouez");
			fen.finTour.setEnabled(false);
			fen.lanceDe.setEnabled(true);
			
			}else if ( enPrison == true ){
				
				if(j.de1 == j.de2){
					
					fen.finTour.setEnabled(true);
					fen.lanceDe.setEnabled(false);
					
					
					}	
				}
		
		//if(this.estActif() == true){
		//dans le cas où le joueur n'est pas en prison il faut l'enlever de sa position précédente 
		//if(!j.getEnPrison()){
			fen.getPanelCase(j.getPos()).retirerJoueur(j);
			fen.getPanelPlateau().repaint();
		//}
		
			
			fen.aff.setDes(j.de1 , j.de2);
			fen.aff.repaint();
			if(!j.getEnPrison()){
				int numCaseAAvancer = j.getSommeDes() ;
				
				j.avancer(numCaseAAvancer) ; 
				if(j.getPassCaseDep() == true){
					fen.setTextInfo("Vous passez par la case depart, recevez 10000");
					j.setPassCaseDep(false);
					fen.changerPanelJoueur(j);
				}
				//il faut redessiner la position du joueur sur le plateau 
				
				fen.getPanelCase(j.getPos()).dessinerJoueur(j);
				//fen.getPanelPlateau().repaint();
				System.out.println(j.getSommeDes());
				//appeler méthode traitement case dans le cas où je ne suis pas en prison 
				jouer.Tour() ; 
				
				//dans la cas où le joueur atteri en prison il faut le redessiner : fait dans méthode  
			}else{
				//appeler méthode traitement quand je suis en prison
				jouer.traitementEstEnPrison();
			}
			fen.repaint(); 
			fen.pack();
			//fen.getPanelPlateau().repaint();
			//this.setActif(false); 
		//}
		
		
	}
	
}
