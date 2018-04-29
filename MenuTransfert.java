import javax.swing.*; 
import java.awt.*; 
import java.util.*;

//fenêtre qui permet de rentrer les valeurs (nom du joueur destinataire et somme) lorsque le joueur dont c'est le tour de jouer veut effectuer un transfert 
public class MenuTransfert extends JFrame{
	
	//différents éléments qui seront affichés dans la fenêtre 
	private JButton b1 = new JButton("Transferer"); 
	//champs où doivent être entrés le nom du bénéficiaire et le montant du transfert 
	private JTextField t1= new JTextField(10);
	private JTextField t2= new JTextField(10);
	private JLabel l1= new JLabel("Nom du beneficiaire"); 
	private JLabel l2= new JLabel("Montant a transferer"); 
	private JPanel cadrePrincipal;
	private JPanel commande1; 
	private JPanel commande2; 
	private JPanel commande3;
	
	//joueur qui effectue l'action
	private Joueur jcourant; 
	//liste des joueurs de la partie 
	private LinkedList<Joueur> ListJoueur; 
	//fenêtre qui gère l'affichage de la partie 
	private FenetreInterface fen ;

	public MenuTransfert(int longueur, int largeur,Joueur jcourant,LinkedList<Joueur> tab, FenetreInterface f){
		
		super("Menu Transfert"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setSize(new Dimension(longueur,largeur));
		this.jcourant = jcourant;   
		ListJoueur = tab; 
		
		cadrePrincipal = new JPanel(new GridLayout(3,1));
		this.setContentPane(cadrePrincipal);
		
		commande1 = new JPanel(new FlowLayout()); 
		commande2 = new JPanel(new FlowLayout()); 
		commande3 = new JPanel(new BorderLayout()); 
		
		cadrePrincipal.add(commande1); 
		cadrePrincipal.add(commande2); 
		cadrePrincipal.add(commande3); 
		
		commande1.add(l1); 
		commande1.add(t1); 
		commande2.add(l2); 
		commande2.add(t2); 
		t2.setText("0"); 
		commande3.add(b1,BorderLayout.CENTER);
		fen = f; 
		
		//l'écouteur transférer est éjouté au bouton de validation du transfert, il va appeler les méthodes sur les joueurs concernés pour mettre à jour leur somme 
		//la mise en paramètre de la fenêtre interface permet de récupérer dans l'écouteur la liste de joueur et de mettre à jour l'affichage graphique en même temps que le transfert 
		b1.addActionListener(new EcouteurTransferer(this, fen)); 
	
		
		
		this.setVisible(true);
	}
	
	public JTextField getNom(){ 
		return t1; 
	} 
	public JTextField getMontant(){
		return t2; 
	}
	public Joueur getJoueurCourant(){
		return jcourant; 
	}
	public LinkedList<Joueur>  getListJoueur(){
			return ListJoueur;
	}
	
	public FenetreInterface getFenetre(){return fen;}
}
