import javax.swing.*; 
import java.awt.*; 
import java.util.*;

//fenêtre qui s'affiche lorsque le joueur a appuyé sur credit dans le menu banque et qui lui permet de prendre un credit en focntion de son capital
public class MenuCredit extends JFrame{
	
	//éléments graphiques de la fenêtre 
	//bouton qui permet de valider la demande et qui verifie si celle-ci est acceptée 
	private JButton b1 = new JButton("Valider"); 
	//nouton qui permet de finir la transaction peut importe que celle-ci ait eu lieu ou non et de revenir à l apartie 
	private JButton b2 = new JButton("Finir transaction"); 
	private JTextField t1= new JTextField(10); 
	private JLabel l1= new JLabel("Montant du credit"); 
	private JLabel l2=new JLabel("affichage du resultat"); 
	private JPanel cadrePrincipal;
	private JPanel commande1; 
	private JPanel commande2;
	private JPanel commande3; 
	private Joueur jcourant; 
	private FenetreInterface fen; 
	
	public MenuCredit(int longueur, int largeur, Joueur jcourant, FenetreInterface f){
		
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
		
		//ajout des différents éléments de l'interface graphique aux panels 
		commande1.add(l1); 
		commande1.add(t1); 
		commande1.add(b1);
		commande2.add(l2);
		commande3.add(b2); 
		//ajout des écouteurs qui ont les méthodes de prise de crédit et de fin de la transaction aux boutons de l'interface graphique 
		b1.addActionListener(new EcouteurValiderCredit(this)); 
		b2.addActionListener(new EcouteurFinaliserTransaction(this)); 
		
		l2.setVisible(false); //message qui a permi de faire des tests 
		this.setVisible(true);
	}
	
	//getteurs 
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
