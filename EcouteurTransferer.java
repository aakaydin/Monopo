import java.awt.event.* ;
import javax.swing.*; 
import java.awt.*; 
import java.util.* ; 

public class EcouteurTransferer implements ActionListener{
	
	
	
	private MenuTransfert mt;
	private JTextField t1;
	private JTextField t2; 
	private String Nom; 
	private int MontantTransfere; 
	private Joueur jcourant;
	private LinkedList<Joueur> ListJoueur; 
	private FenetreInterface fen; 
	
	
	public EcouteurTransferer(MenuTransfert m){
		mt = m; 
		t1 = mt.getNom(); 
		t2 = mt.getMontant();
		jcourant = m.getJoueurCourant(); 
		ListJoueur = m.getListJoueur(); 
		fen = mt.getFenetre(); 
	}
	
	public void actionPerformed(ActionEvent ae){
		
		
		Nom = t1.getText(); 											//je prends le nom entrée par le joueur
		MontantTransfere = Integer.parseInt(t2.getText()); 				// je convertis la somme entrée par le joueur
		jcourant.setSommeTransfert(MontantTransfere); 
				 
		for(Joueur j:ListJoueur){ 
						
			if(j.getNom().compareTo(Nom)==0){ 
				System.out.println("Joueur : "+j.getNom());
				jcourant.transfere(j); 						//je réalise un transfert à la bonne personne; 
				 
			}else{ 
				System.out.println("le if ne marche pas");  
			}
		} 
		mt.setVisible(false); 
		fen.getL1().setText("Somme : " +mt.getJoueurCourant().getSomme());
		
		
		 
	}
}
