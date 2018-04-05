import java.awt.event.* ;
import javax.swing.*; 
import java.awt.*; 
import java.util.* ; 

public class EcouteurCredit implements ActionListener{
	
	
	
	private MenuBanque mb;
	private JTextField t1;
	private JTextField t2; 
	private String Nom; 
	private int MontantTransfere; 
	private Joueur jcourant;
	private LinkedList<Joueur> ListJoueur; 
	
	
	public EcouteurCredit(MenuBanque m){
		mb = m; 
		jcourant = mb.getJoueurCourant(); 
		ListJoueur = m.getListJoueur(); 
		
	}
	
	public void actionPerformed(ActionEvent ae){
		
		
		MenuCredit mc = new MenuCredit(400,300,jcourant); 
		
		
		
		 
	}
}
