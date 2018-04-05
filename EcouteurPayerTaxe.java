import java.awt.event.* ;
import java.util.* ; 

public class EcouteurPayerTaxe implements ActionListener{
	
	Joueur j ; 
	int somme ;
	
	
	public EcouteurPayerTaxe(Joueur jj, int somme){
		j = jj ;
		this.somme = somme ;
		
	}
	
	public void actionPerformed(ActionEvent ae){
		//peut être que le code de cette méthode peut se touver comme c'est déjà fait dans le programme jouer 
		j.setArgent(-somme);
		//il faut que l'argent soit déverser dans la classe cagnotte, fait dans méthode tour 
		//il faudrait que ça change l'affichage de la somme du joueur dans la fenêtre
		
	}
}
