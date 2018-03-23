import java.awt.event.* ;
import java.util.* ; 

public class EcouteurAcheter implements ActionListener{
	
	Joueur j ; 
	CaseProp c ;
	
	public EcouteurAcheter(Joueur jj, CaseProp cas){
		j = jj ;
		c = cas ;
	}
	
	public void actionPerformed(ActionEvent ae){
		j.setArgent(-c.getPrix());
		j.addCase(c);
		c.setProprietaire(j);
	}
}
