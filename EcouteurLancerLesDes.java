import java.awt.event.* ;
import java.util.* ; 

public class EcouteurLancerLesDes implements ActionListener{
	
	Joueur j ; 
	
	
	public EcouteurLancerLesDes(Joueur jj){
		j = jj ;
	}
	
	public void actionPerformed(ActionEvent ae){
		j.lancerLesDes() ;
		if(!j.getEnPrison()){
			int numCaseAAvancer = j.getSommeDes() ;
			//je considère que 30 est le nombre de cases du plateau 
			
			j.avancer(numCaseAAvancer) ; 
		}
	}
	
}
