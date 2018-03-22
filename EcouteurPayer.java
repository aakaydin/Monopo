import java.awt.event.* ;
import java.util.* ; 

public class EcouteurPayer implements ActionListener{
	
	Joueur j ; 
	int somme ;
	
	public EcouteurPayer(Joueur jj, int somme){
		j = jj ;
		this.somme = somme ;
	}
	
	public void actionPerformed(ActionEvent ae){
		j.setArgent(-somme);
	}
}
