import java.awt.event.* ;
import java.util.* ; 

public class EcouteurLancerLesDes implements ActionListener{
	
	Joueur j ; 
	FenetreInterface fen;
	
	public EcouteurLancerLesDes(Joueur jj , FenetreInterface f ){
		
		j = jj ;
		fen = f;
	}
	
	public void actionPerformed(ActionEvent ae){
		j.lancerLesDes() ;
		fen.aff.setDes(j.de1 , j.de2);
		fen.aff.repaint();
		if(!j.getEnPrison()){
			int numCaseAAvancer = j.getSommeDes() ;
			//je considère que 30 est le nombre de cases du plateau 
			
			j.avancer(numCaseAAvancer) ; 
		}
		
		System.out.println( j.de1 );
		System.out.println( j.de2 );
		
	}
	
}
