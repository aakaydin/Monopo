import java.awt.event.* ;
import java.util.* ; 

public class EcouteurPayerJoueur implements ActionListener{
	
	Joueur j ; 
	Joueur proprietaire ;
	CaseProp c ;
	
	public EcouteurPayerJoueur(Joueur prop, Joueur jj, CaseProp cas){
		j = jj ;
		proprietaire = prop ; 
		c = cas ;
	}
	
	public void actionPerformed(ActionEvent ae){
		int prix = c.getPrix() ;
		j.setArgent(-prix);
		j.setArgent(prix) ;
		
	}
}
