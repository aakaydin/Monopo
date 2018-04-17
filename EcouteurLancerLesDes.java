import java.awt.event.* ;
import java.util.* ;
import java.awt.*;

import javax.swing.*;


public class EcouteurLancerLesDes implements ActionListener{
	
	Joueur j ; 
	//il faudra récupérer jouer pour passer d'un tour à l'autre mais ne pourra être fait que quand partie aura pu être fait 
	Jouer jouer ;
	FenetreInterface fen ;
	boolean enPrison;
	
	JPanel panelInfo = new JPanel();
	
	
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
		 
		j.lancerLesDes() ; 
		
		if( j.de1 != j.de2){	
		
		fen.finTour.setEnabled(true);
		fen.lanceDe.setEnabled(false);
		
		}else if( j.de1 == j.de2 && enPrison == false ){
			
			
			panelInfo.removeAll();
			JLabel lab = new JLabel("Rejouez");
			panelInfo.add(lab);
			fen.changerPanelInfo(panelInfo);
			fen.repaint(); 
			fen.pack();
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
				//si il passe par la case départ il faut lui indiquer qu'il reçoit de l'argent 
				if(j.getPassCaseDep() == true){
					fen.changerPanelInfo(panelInfo);
					fen.pack();
					j.setPassCaseDep(false);
				} else {
					fen.changerPanelInfo(new JPanel()); 
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
			//fen.getPanelPlateau().repaint();
			//this.setActif(false); 
		//}
		
		
	}
	
}
