import java.awt.event.* ;
import java.util.* ; 

public class EcouteurPayerCredit implements ActionListener{
	
	private FenetreInterface fen; 
	private Joueur jcourant; 
	private int mensualite; 
	
	public EcouteurPayerCredit(FenetreInterface f){
		fen = f;
		jcourant = fen.getJoueur();
		mensualite = jcourant.getMensualite(); 
		
		
	}
	
	public void actionPerformed(ActionEvent ae){
		if(jcourant.getDette() !=0){
			System.out.println("mon joueur est : "+jcourant.getNom()); 
			System.out.println("ma dette avant : "+jcourant.getDette()); 
			System.out.println("mon argent : "+jcourant.getSomme());
			jcourant.setDette(-(mensualite)); 
			jcourant.setArgent(-(mensualite));
			System.out.println("mon argent"+jcourant.getSomme());
			System.out.println("ma mensualite"+jcourant.getMensualite());
			System.out.println("ma dette"+jcourant.getDette()); 
		}
		fen.getL1().setText("Somme : "+jcourant.getSomme());     //j'affiche la somme du joueur 
		
	}
}
