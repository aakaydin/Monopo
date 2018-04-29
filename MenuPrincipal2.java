import java.util.*;
import javax.swing.*; 
import java.awt.*; 

//fenêtre où vont être entré les noms des différents joueurs de la partie 
public class MenuPrincipal2 extends JFrame{
	
	//difféents éléments qui seront affichés dans la fenêtre, il ya les champs à remplir et les labels associés 
	private JTextField t1 = new JTextField(10); 
	private JLabel l1 = new JLabel("nom du joueur1");
	private JTextField t2 = new JTextField(10); 
	private JLabel l2 = new JLabel("nom du joueur2");
	private JTextField t3 = new JTextField(10); 
	private JLabel l3 = new JLabel("nom du joueur3");
	private JTextField t4 = new JTextField(10); 
	private JLabel l4 = new JLabel("nom du joueur4");
	private JLabel l5 = new JLabel("ERREUR: Attention il faut mettre un nombre de joueur > 0 !!!");
	private JLabel l6 = new JLabel("ERREUR: Attention le nombre de joueur maximum est 4 !!!");
	private JButton b1 = new JButton("Debuter la partie");
	private JButton b2 = new JButton("Retour");
	
	//attributs qui permettent d'avoir le nombre de joueurs et d'intelligence artficielle, la fenêtre va changer en fonction du nombre de joueurs qui se sont inscrits pour la partie 
	private int nbJoueur; 
	private int nbIA; 

	private LinkedList<JTextField> text = new LinkedList<JTextField>(); 			//permet de stocker les noms des joueurs
	private EcouteurDebuterPartie e2; 
	private JPanel cadrePrincipal; 
	
	private boolean fenetreFinie =false; 						//sert pour le renvoie de ma LinkedList text qui ne doit pas être null quand je clique sur le bouton; 
	
	
	public MenuPrincipal2(int longueur, int largeur){ 

		super("Menu Principal"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setSize(new Dimension(longueur,largeur)); 
		
		cadrePrincipal = new JPanel(new GridLayout(8,2));
		this.setContentPane(cadrePrincipal);
		
		//ecouteur qui va lancer le premier tour de ma partie lorsque l'utilisateur appuiera sur lebouton Lancer la partie 
		e2 = new EcouteurDebuterPartie(this);
		b1.addActionListener(e2); 
	 
		
		
	}
	
	public int getNbJoueur(){ 
		return nbJoueur; 
	}
	
	public int getNbIA(){ 
		return nbIA; 
	}
	
	public LinkedList<JTextField> getTextField(){ 
		if(fenetreFinie == true){								//si ma fenetre est finie alors je renvoie mes texts, ce qui sera toujours le cas ici		 return text; 
		}else{ 
			return null;
		} 
	}
	
	public EcouteurDebuterPartie getEcouteurDebuterPartie(){ 
		return e2; 
	}
	
	public void setNbJoueur(int nbJoueur){
		this.nbJoueur = nbJoueur; 
	} 
	
	public void setNbIA(int nbIA){ 
		this.nbIA = nbIA; 
	}
	 
	public boolean FinishFrame(int nbJoueur, int nbIA){ //initialise ma fenetre en fonction du nbJoueur; 
		
		if(nbJoueur ==1){
			this.cadrePrincipal.add(l1); 
			cadrePrincipal.add(t1);
			cadrePrincipal.add(b1);
			text.add(t1); 
		}else if (nbJoueur ==2){ 
			cadrePrincipal.add(l1); 
			cadrePrincipal.add(t1);
			text.add(t1); 
			cadrePrincipal.add(l2); 
			cadrePrincipal.add(t2);
			text.add(t2); 
			cadrePrincipal.add(b1);
		}else if (nbJoueur ==3){ 
			cadrePrincipal.add(l1); 
			cadrePrincipal.add(t1);
			text.add(t1); 
			cadrePrincipal.add(l2); 
			cadrePrincipal.add(t2);
			text.add(t2); 
			cadrePrincipal.add(l3); 
			cadrePrincipal.add(t3);
			text.add(t3); 
			cadrePrincipal.add(b1);
		}else if (nbJoueur ==4){ 
			cadrePrincipal.add(l1); 
			cadrePrincipal.add(t1);
			text.add(t1); 
			cadrePrincipal.add(l2); 
			cadrePrincipal.add(t2);
			text.add(t2); 
			cadrePrincipal.add(l3); 
			cadrePrincipal.add(t3);
			text.add(t3); 
			cadrePrincipal.add(l4); 
			cadrePrincipal.add(t4);
			text.add(t4); 
			cadrePrincipal.add(b1);
		}else if (nbJoueur ==0){
			cadrePrincipal.add(l5); 
			cadrePrincipal.add(b2);
		}else{ 
			cadrePrincipal.add(l6);
			cadrePrincipal.add(b2);
		} 
		
		fenetreFinie = true;				//cela permet d'indiquer que la fenetre a bien été finie, et que les noms sont bien stockés dans text, pour éviter les erreurs de pointeur null lorsque j'utilise text pour la création des joueurs, dans l'écouteur débuterPartie
		return fenetreFinie;  
	}
		
	
	
		
	
	
	
}
