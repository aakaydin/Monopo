import java.awt.event.* ;
import javax.swing.*; 
import java.awt.*; 
import java.util.* ; 

public class EcouteurTransferer implements ActionListener{
	
	
	
	private MenuTransfert mt;
	//pour saisir le nom du destinataire et la somme du transfert 
	private JTextField t1;
	private JTextField t2; 
	
	//nom du destinataire 
	private String Nom; 
	
	private int MontantTransfere; 
	
	//joueur donataire 
	private Joueur jcourant;
	
	//listes des joueurs de la partie 
	private LinkedList<Joueur> ListJoueur;
	
	//fenêtre de la partie 
	private FenetreInterface fen; 
	
	
	public EcouteurTransferer(MenuTransfert m, FenetreInterface f){
		//récupération des données entrées dans la fenêtre transfert qui est un le menu transfert 
		mt = m; 
		t1 = mt.getNom(); 
		t2 = mt.getMontant();
		jcourant = m.getJoueurCourant(); 
		ListJoueur = m.getListJoueur(); 
		fen = f ; 
	}
	
	public void actionPerformed(ActionEvent ae){
		
		
		Nom = t1.getText(); 											//je prends le nom entré par le joueur
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
		
		//il faut changer la somme du joueur qui est affichée dans l'interface graphique 
		fen.changerPanelJoueur(mt.getJoueurCourant());
		mt.setVisible(false); 
 
	}
}
