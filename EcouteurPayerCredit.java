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
	
	public void changerJoueur(Joueur j){ 
		jcourant = j; 
	}
	
	public void actionPerformed(ActionEvent ae){
		if(jcourant.getDette() !=0){
			System.out.println("mon joueur est : "+jcourant.getNom()); 
			System.out.println("ma dette avant : "+jcourant.getDette()); 
			System.out.println("mon argent : "+jcourant.getSomme());
			System.out.println("mensualité "  + mensualite); 
			System.out.println("mesualite du joueur"+jcourant.getMensualite()); 
			jcourant.setDette(-jcourant.getMensualite()); 
			jcourant.setArgent(-jcourant.getMensualite());
			System.out.println("mon argent"+jcourant.getSomme());
			System.out.println("ma mensualite"+jcourant.getMensualite());
			System.out.println("ma dette"+jcourant.getDette()); 
		}
		//fen.getL1().setText("Somme : "+jcourant.getSomme());     //j'affiche la somme du joueur 
		//il faut plutôt utiliser la méthode changer panel joueur 
		fen.changerPanelJoueur(jcourant);
		fen.getPayerDette().setEnabled(false);  
		
	}
}
