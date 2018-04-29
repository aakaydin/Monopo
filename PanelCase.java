import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.AbstractBorder ;
import javax.swing.border.LineBorder ;

//panel particulié qui permet de faire l'affichage des cases sur le plateau dans la fenêtre 
public class PanelCase extends JPanel {
	
	//couleur de la languette qui se trouve en haut 
	private Color c ; 
	
	//nom de la case sur laquelle je me trouve 
	private JLabel nom ;
	
	//PanelPlateau associé aux cases 
	private PanelPlateau fen ;
	
	//permet d'afficher les joueurs sur la case 
	private JLabel joueur ;
	
	//joueur se trouvant sur la case 
	private Joueur jc; 
	
	//panel permettang d'afficher le joueur sur la case 
	private JPanel affichageJoueur = new JPanel() ;
	
	//position de la case sur le plateau 
	int place ;
    
	//panel permettant l'affichage des maisons et hotels 
    	private JPanel affichageBatiments = new JPanel(); 
    
	//nombre de maisons se trouvant sur la case 
    	private int nbMaisons ; 
    
	//constructeur 
	public PanelCase(Color col, JLabel n, PanelPlateau f, int i ){
		super();
		
		//initialisation des attributs 
		place = i;
		c = col ;
		nom = n ;
		fen = f;
		
		//réglage du Layout 
		this.setLayout(new GridLayout(4 , 1 , 3 , 3)); 
		
		//création d'un panel de la couleur de la case 
		JPanel p = new JPanel();
		p.setOpaque(true);
		p.setBackground(c);
		
		//ajout des différents éléments au panel, ils vont être placés en colonne
		this.add(p/*, BorderLayout.NORTH*/);
		this.add(nom/*, BorderLayout.CENTER*/);
		
		//création d'une bordure autours de la case 
		LineBorder blackline = new LineBorder(Color.BLACK, 1);
		this.setBorder(blackline);
		
		this.add(affichageJoueur/*, BorderLayout.SOUTH*/);
        	this.add(affichageBatiments); 
	}
	
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		
	}
	
	
	//getteurs 
	public int getPlace(){return place;}
   	public Color getCouleur(){return c;}
	
	//les deux méthodes suivantes vont permettre de visualiser l'avancer du joueur sur le plateau 
	
	//méthode qui permet de dessiner un joueur si=ur une case 
	public void dessinerJoueur(Joueur j){
		
		jc = j;
		affichageJoueur.add(j.getLabel());
	}
	
	//méthode qui permet d'effacer un joueur d'une case 
	public void retirerJoueur(Joueur j){
		jc = j;
		affichageJoueur.remove(j.getLabel());
	}
	
	
	//méthode appelé lors de l'achat d'une maison par le joueur et qui colorie la bordure des cases de la couleur du propriétaire 
	public void setCouleurProp( Color c){
		
		LineBorder line = new LineBorder( c, 3);
		this.setBorder(line);		
				
	}
    
	//Pour l'ajout de maison 
	public void dessinerMaison(int nb){
		nbMaisons = nb ; 
		
		//on supprime tous ce qu'il y a dans le panel de batiment pour redessiner 
		affichageBatiments.removeAll() ; 
		JPanel pan = new JPanel(new GridLayout(1 , 3 , 5 , 1));
		
		//creation de panels maisons (petits carrés verts) qui sont ajoutés au panel 
		//tant que le nombre de maison n'a pas été atteint on dessine des carrés de couleur 
		for(int j = 1 ; j <= nb ; j++){
			JPanel maison = new JPanel(); 
			Color c = new Color(0x16B84E);
			maison.setBackground(c); 

			pan.add(maison);

			System.out.println("Je dessine la " + j + "-eme maison sur cette case numero " + place); 
		} 
		
		//quand le nombre de maison a été atteint on ajoute des panels vides 
		for(int j = 1 ; j <= 3 - nb ; j++){
			JPanel vide = new JPanel(); 

			pan.add(vide); 
		}
		//on ajoute le panel au panel de batiment 
		affichageBatiments.add(pan); 

	}

	//méthode qui permet d'effacer une maison 
	public void effacerMaison(){
		//on change le nombre de maison 
		nbMaisons = nbMaisons - 1 ;
		//on dessine les nouvelles maisons 
		this.dessinerMaison(nbMaisons);
		this.repaint(); 
	}

	//methode qui permet de dessiner un hotel, rappel : on ne peut avoir qu'un hotel par case
	public void dessinerHotel(){
		
		//on efface les bâtiments présents sur la case 
		affichageBatiments.removeAll();
		
		//creation du panel hotel qui est un petit carré rouge 
		JPanel hotel = new JPanel(); 
		Color c = new Color(0xB82010); 
		hotel.setBackground(c); 

		System.out.println("Je dessine l'hotel"); 
		
		//ajout de l'hotel au panel d'affichage des batiments 
		affichageBatiments.add(hotel); 

	}
	
	//méthode qui permet d'effacer l'hotel de ma case 
	public void effacerHotel(){
		affichageBatiments.removeAll();
	}


}
