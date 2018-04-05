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
	
	
	public EcouteurTransferer(MenuTransfert m){
		mt = m; 
		t1 = mt.getNom(); 
		t2 = mt.getMontant();
		jcourant = m.getJoueurCourant(); 
		ListJoueur = m.getListJoueur(); 
		
	}
	
	public void actionPerformed(ActionEvent ae){
		
		
		Nom = t1.getText(); 											//je prends le nom entrée par le joueur
		MontantTransfere = Integer.parseInt(t2.getText()); 				// je convertis la somme entrée par le joueur
		
		 
		for(Joueur j:ListJoueur){ 
			if(j.getNom()==Nom){ 
				jcourant.transfere(j); 						//je réalise un transfert à la bonne personne; 
			} 
		} 
		mt.setVisible(false); 
		
		
		
		 
	}
}
