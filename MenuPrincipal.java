import java.util.*;
import javax.swing.*; 
import java.awt.*; 

public class MenuPrincipal extends JFrame{
	
	//zones où est rentré le nombre de joueurs et le nombre d'IA (qui ne peut être que un) 
	private JTextField t1 = new JTextField(20); 
	private JTextField t2 = new JTextField(20);
	private JLabel l1 = new JLabel("nombre de joueur");
	private JLabel l2 = new JLabel("nombre d'IA");
	//bouton qui va permettre d'afficher la case suivante
	private JButton b1 = new JButton("Suivant"); 
	//ecouteur associé 
	private EcouteurSuivant1 e1; 
	//autre fenêtre avec un ecouteur associé, fenêtre de champ de saisi du nom des joueurs 
	private MenuPrincipal2 m2 = new MenuPrincipal2(400,300); 
	
	public MenuPrincipal(int longueur, int largeur){ 

		super("Menu Principal"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setSize(new Dimension(longueur,largeur)); 
		
		JPanel cadrePrincipal = new JPanel(new BorderLayout()); 	//je créer mon JPanel principal
		JPanel commande1 = new JPanel(new GridLayout(2,1)); 		//je créer un JPanel pour prise des noms et nombres de Joueur
		JPanel commande2 = new JPanel(new FlowLayout()); 
				
		this.setContentPane(cadrePrincipal); 
		cadrePrincipal.add(commande1, BorderLayout.CENTER); 
		cadrePrincipal.add(commande2, BorderLayout.SOUTH); 
				
		commande1.add(l1); 											//organisation de mon Panel commande
		commande1.add(t1); 
		t1.setText("0"); 
		commande1.add(l2); 
		commande1.add(t2);
		t2.setText("0"); 
		commande2.add(b1);
		
		//on va créer un ecouteur qui permettra de créer la nouvelle fenêtre pour lancer le nom des jouerus 
		e1 = new EcouteurSuivant1(this,m2);
		b1.addActionListener(e1);  
		
		
		
		this.setVisible(true);


	}
	
	public JTextField getnbJoueur(){ 
		return t1; 
	} 
	
	public JTextField getIA(){ 
		return t2; 
	} 
	
	public EcouteurSuivant1 getEcouteurSuivant1(){ 
		return e1; 
	}
	
	public MenuPrincipal2 getM2(){
		return m2; 
	}
	
}
