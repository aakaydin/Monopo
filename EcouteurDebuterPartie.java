import java.awt.event.*;
import java.util.*;
import javax.swing.*; 
import java.awt.*; 


//cet écouteur dans la fenêtre où sont rentré les noms des joeurs va permettre de commencer la partie en lancant le premier tour 
public class EcouteurDebuterPartie implements ActionListener {
	
	//fenêtre de création des joueurs 
	private MenuPrincipal2 m2; 
	//liste des noms des joueurs 
	private LinkedList<String> Nom = new LinkedList<String>();  
	private LinkedList<JTextField> text;
	private int nbJoueur; 
	private int nbIA; //ne peut être égal que à  ou  dans notre version du jeu 
	private LinkedList<Joueur> ListJoueur= new LinkedList<Joueur>();
	//joueur qui va commencer la partie 
	private Joueur jcourant; 
	 

	
	public EcouteurDebuterPartie(MenuPrincipal2 f){ 
		//les différentes données seront récupérées à partir de la fenêtre MenuPrincipal (fenêtre où sont isncrits les noms des jouers) 
		m2=f;  
	} 
	
	//getteurs 
	public LinkedList<Joueur> getListJoueur(){return ListJoueur;}
	
	
	public void actionPerformed(ActionEvent e){ 
		
		nbJoueur = m2.getNbJoueur();
		nbIA = m2.getNbIA();
		
		//créaton de l'interface à compléter : 
		text = m2.getTextField(); 
		for(JTextField t : text){ //je complète le tableau des noms des joueurs
			Nom.add(t.getText());
				 
		}
		
		//permettra de créer plusieurs intelligences artificielles, mais dans notre version nous n'en avons q'une ou zero
		for( int i =0 ; i < nbIA ; i++){
			Nom.add("Bob");	
		}
		//pour chaque nom de joeuur je créé le joueur associé que je place dans la liste des joueurs 
		for(String nom : Nom){ 
			
			ListJoueur.add(new Joueur(nom, 100000, 0));
			System.out.println(nom); 
			//si mon joueur est l'intelligence artificielle alors je dis que mon joueur est l'IA dans ses attributs, l'IA a forcément été ajoutée en dernière à la liste de joueurs
			if( nom == "Bob") ListJoueur.getLast().estIA = true;
		}
		
		//on déninit le joueur courant qui est le premier joueur de la liste
		int rangJoueur = 0;
		jcourant = ListJoueur.get(rangJoueur);
		jcourant.setSonTour(true); 
		
		//afficage du jeu
		Plateau plateau = new Plateau() ; 
		FenetreInterface fen = new FenetreInterface(1200,600,plateau,jcourant, ListJoueur) ; 
		fen.changerPanelJoueur(jcourant);
		for(Joueur jj : ListJoueur){
			fen.getPanelCase(jj.getPos()).dessinerJoueur(jj);
			fen.getPanelPlateau().repaint();
		}
		
		//création de l'objet jouer qui permet de lancer un tour 		
		Jouer jouer = new Jouer(plateau, fen, jcourant);		
		jouer.testerPrison();
				
		m2.setVisible(false); 
		
	}
	
	
}
