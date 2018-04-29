import java.awt.event.* ;
import javax.swing.*; 
import java.awt.*; 
import java.util.* ; 

public class EcouteurCredit implements ActionListener{
	
	//le menu banque est la fenêtre dans laquelle se trouve le bouton associé à cet écouteur 
	private MenuBanque mb;
	private JTextField t1;
	private JTextField t2; 
	private String Nom; 
	private int MontantTransfere; 
	//joeur qui veut faire l'opération banquaire
	private Joueur jcourant;
	//liste des joueurs de la partie 
	private LinkedList<Joueur> ListJoueur; 
	private FenetreInterface fen; 
	
	public EcouteurCredit(MenuBanque m){
		//on récupère les différentes données depuis la fenêtre interface 
		mb = m; 
		jcourant = mb.getJoueurCourant(); 
		ListJoueur = m.getListJoueur(); 
		fen = mb.getFenetre(); 
		
	}
	
	public void actionPerformed(ActionEvent ae){
		//ouverture de la fenêtre qui permet de demander un crédit 
		MenuCredit mc = new MenuCredit(400,300,jcourant,fen); 
	 
	}
}
