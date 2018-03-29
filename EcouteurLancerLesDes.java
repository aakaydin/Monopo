import java.awt.event.* ;
import java.util.* ; 

public class EcouteurLancerLesDes implements ActionListener{
	
	Joueur j ; 
	//il faudra récupérer jouer pour passer d'un tour à l'autre mais ne pourra être fait que quand partie aura pu être fait 
	Jouer jouer ;
	FenetreInterface fen ;
	
	
	public EcouteurLancerLesDes(Joueur jj, FenetreInterface f, Plateau p){
		j = jj ;
		jouer = new Jouer(p, f, j);
		//jouer = f.getPartie().getJouer() ; 
		fen = f;
	}
	
	public void actionPerformed(ActionEvent ae){
		//if(this.estActif() == true){
			j.lancerLesDes() ;
			fen.aff.setDes(j.de1 , j.de2);
			fen.aff.repaint();
			
			if(!j.getEnPrison()){
				int numCaseAAvancer = j.getSommeDes() ;
				//je considère que 30 est le nombre de cases du plateau 
			
				j.avancer(numCaseAAvancer) ; 
				//appeler méthode traitement case dans le cas où je ne suis pas en prison 
				jouer.Tour() ; 
			}else{
				//appeler méthode traitement quand je suis en prison
				//jouer.traitementEstEnPriosn();
			}
			//this.setActif(false); 
		//}
	}
	
}
