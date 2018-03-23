import java.awt.event.* ;
import java.util.* ; 

public class EcouteurPasAcheter implements ActionListener{
	
	Joueur j ; 
	CaseProp c ;
	
	public EcouteurPasAcheter(Joueur jj, CaseProp cas){
		j = jj ;
		c = cas ;
	}
	
	public void actionPerformed(ActionEvent ae){
		//passer au joueur suivant 
	}
}
