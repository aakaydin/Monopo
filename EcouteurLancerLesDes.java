import java.awt.event.* ;
import java.util.* ; 

public class EcouteurLancerLesDes implements ActionListener{
	
	Joueur j ; 
	
	
	public EcouteurLancerLesDes(Joueur jj){
		j = jj ;
	}
	
	public void actionPerformed(ActionEvent ae){
		j.lancerLesDes() ;
		int numCaseAAvancer = j.getSommeDees() ;
		//je concidère que 30 est le nombre de cases du plateau 
		int numNewPosition = j.getPos() + j.getSommeDees() ;
		if(numNewPosition > 30){
			numNewPosition = numNewPosition - 30 ;
		}
		
		j.deplacer(j.getPos() + j.getSommeDees()) ; 
	}
}
