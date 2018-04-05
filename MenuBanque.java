import java.util.*;
import javax.swing.*; 
import java.awt.*; 

public class MenuBanque extends JFrame{
	
	
	private JButton b1 = new JButton("Transfert"); 
	private JButton b2 = new JButton("Credit");
	//private JButton b3 = new JButton("hypotheque"); 
	private JButton b3 = new JButton("Retour");
	private JPanel cadrePrincipal; 
	private JPanel commande1;
	private JPanel commande2;  
	private Joueur jcourant; 
	private LinkedList<Joueur> ListJoueur; 
	
	public MenuBanque(int longueur, int largeur,Joueur j,LinkedList<Joueur> tab){
		
		super("Menu Banque"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setSize(new Dimension(longueur,largeur)); 
		jcourant = j; 
		ListJoueur = tab; 
		
		cadrePrincipal = new JPanel(new BorderLayout());
		commande1 = new JPanel(new FlowLayout());
		commande2 = new JPanel(new FlowLayout()); 
		this.setContentPane(cadrePrincipal);
		
		commande1.add(b1); 
		commande1.add(b2); 
		commande2.add(b3);
		b1.addActionListener(new EcouteurTransfert(this));
		b3.addActionListener(new EcouteurRetourBanque(this)); 
		cadrePrincipal.add(commande1,BorderLayout.NORTH); 
		cadrePrincipal.add(commande2,BorderLayout.SOUTH); 
		
		
		this.setVisible(true);
	}
	
	public Joueur getJoueurCourant(){ 
		return jcourant; 
	}
	public LinkedList<Joueur>  getListJoueur(){
			return ListJoueur;
		}
}
