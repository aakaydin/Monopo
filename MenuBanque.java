import java.util.*;
import javax.swing.*; 
import java.awt.*; 

//il s'agit d'une fenêtre qui permet au joueur de décider quelle opéartion banquaire il veut réaliser (credit ou transfert)
public class MenuBanque extends JFrame{
	
	
	private JButton b1 = new JButton("Transfert"); 
	private JButton b2 = new JButton("Credit");
	//la partie hypotheque du jeu a commencé à être réalisée mais n'a pas été terminée 
	//private JButton b3 = new JButton("hypotheque"); 
	
	//on utilise un bouton retour qui permet de revenir au jeu 
	private JButton b3 = new JButton("Retour");
	
	//différents éléments de l'affichage graphique 
	private JPanel cadrePrincipal; 
	private JPanel commande1;
	private JPanel commande2;  
	
	//joueur qui veut effectuer le transfert ou prendre le crédit 
	private Joueur jcourant; 
	
	//listes des joueurs de la partie 
	private LinkedList<Joueur> ListJoueur; 
	
	//fenêtre interface qui s'occupe de la partie affichage de la partie 
	private FenetreInterface fen;
	
	public MenuBanque(int longueur, int largeur, Joueur j, LinkedList<Joueur> tab, FenetreInterface f){
		
		super("Menu Banque"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setSize(new Dimension(longueur,largeur)); 
		
		//initilisation des attributs 
		jcourant = j; 
		ListJoueur = tab; 
		fen = f; 
		
		//réglage des éléments graphiques de la fenêtre 
		cadrePrincipal = new JPanel(new BorderLayout());
		commande1 = new JPanel(new FlowLayout());
		commande2 = new JPanel(new FlowLayout()); 
		this.setContentPane(cadrePrincipal);
		
		//ajout des boutons et des écouteurs associés aux boutons 
		commande1.add(b1); 
		commande1.add(b2); 
		commande2.add(b3);
		b1.addActionListener(new EcouteurTransfert(this, fen));
		b2.addActionListener(new EcouteurCredit(this));
		b3.addActionListener(new EcouteurRetourBanque(this)); 
		cadrePrincipal.add(commande1,BorderLayout.NORTH); 
		cadrePrincipal.add(commande2,BorderLayout.SOUTH); 
		
		this.setVisible(true);
	}
	
	public Joueur getJoueurCourant(){ 
		return jcourant; 
	}
	public LinkedList<Joueur> getListJoueur(){
			return ListJoueur;
		}
	public FenetreInterface getFenetre(){ 
		return fen; 
	}
}
