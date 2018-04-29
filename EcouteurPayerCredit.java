import java.awt.event.* ;
import java.util.* ; 

public class EcouteurPayerCredit implements ActionListener{
	
	private FenetreInterface fen; 
	private Joueur jcourant; 
	private int mensualite; 
	
	public EcouteurPayerCredit(FenetreInterface f){
		fen = f;
		jcourant = fen.getJoueur();
	}
	
	
	//pour changer le joueur associé à ce bouton et donc prélever l'argent sur le bon joueur 
	public void changerJoueur(Joueur j){ 
		jcourant = j; 
	}
	
	public void actionPerformed(ActionEvent ae){
		if(jcourant.getDette() !=0){
			//changement de la somme et de la dette du joueur 
			jcourant.setDette(-jcourant.getMensualite()); 
			jcourant.setArgent(-jcourant.getMensualite());
			
		}
		
		fen.changerPanelJoueur(jcourant);
		fen.getPayerDette().setEnabled(false);  
		
	}
}
