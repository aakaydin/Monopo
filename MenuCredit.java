import javax.swing.*; 
import java.awt.*; 
import java.util.*;
public class MenuCredit extends JFrame{
	
	
	private JButton b1 = new JButton("Valider"); 
	private JButton b2 = new JButton("Finir transaction"); 
	private JTextField t1= new JTextField(10); 
	private JLabel l1= new JLabel("Montant du credit"); 
	private JLabel l2=new JLabel("affichage du resultat"); ;
	private JPanel cadrePrincipal;
	private JPanel commande1; 
	private JPanel commande2;
	private JPanel commande3; 
	private Joueur jcourant; 
	private FenetreInterface fen; 
	
	  
	
	public MenuCredit(int longueur, int largeur,Joueur jcourant,FenetreInterface f){
		
		super("Menu Credit"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setSize(new Dimension(longueur,largeur));
		this.jcourant = jcourant; 
		fen = f;   
	
		
		cadrePrincipal = new JPanel(new GridLayout(4,1));
		this.setContentPane(cadrePrincipal);
		
		commande1 = new JPanel(new FlowLayout()); 
		commande2 = new JPanel(new FlowLayout());
		commande3= new JPanel(new BorderLayout()); 
		
		cadrePrincipal.add(commande1); 
		cadrePrincipal.add(commande2); 
		cadrePrincipal.add(commande3); 
			
		commande1.add(l1); 
		commande1.add(t1); 
		commande1.add(b1);
		b1.addActionListener(new EcouteurValiderCredit(this)); 
		commande2.add(l2);
		commande3.add(b2); 
		b2.addActionListener(new EcouteurFinaliserTransaction(this)); 
		
		 
		
		l2.setVisible(false); 
		this.setVisible(true);
	}
	
	public Joueur getJoueurCourant(){
		return jcourant; 
	}
	
	public JTextField getMontant(){ 
		return t1; 
	}
	public JLabel getL2(){ 
		return l2; 
	}
	public FenetreInterface getFenetre(){ 
		return fen; 
	}
	public JButton getValiderCredit(){ 
		return b1; 
	}
	
}
