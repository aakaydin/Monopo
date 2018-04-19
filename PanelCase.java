import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.border.AbstractBorder ;
import javax.swing.border.LineBorder ;



public class PanelCase extends JPanel {
	
	//couleur de la languette qui se trouve en haut 
	private Color c ; 
	private JLabel nom ;
	
	private PanelPlateau fen ;
	private JLabel joueur ;
	private Joueur jc; 
	
	private JPanel affichageJoueur = new JPanel() ;
	int place ;
	
	public PanelCase(Color col, JLabel n, PanelPlateau f, int i ){
		super();
		
		place = i;
		c = col ;
		nom = n ;
		fen = f;
		this.setLayout(new GridLayout(4 , 1 , 3 , 3)); 
		JPanel p = new JPanel();
		p.setOpaque(true);
		p.setBackground(c);
		this.add(p/*, BorderLayout.NORTH*/);
		this.add(nom/*, BorderLayout.CENTER*/);
		LineBorder blackline = new LineBorder(Color.BLACK, 1);
		this.setBorder(blackline);
		
		this.add(affichageJoueur/*, BorderLayout.SOUTH*/);
	}
	
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		
	}
	
	//deux méthode pour les test car Joueur n'est pas encore fonctionnel 
	
	public int getPlace(){return place;}
    public Color getCouleur(){return c;}
	
	public void dessinerJoueur(Joueur j){
		//Color c = j.getCouleur() ; en commentaire pour pouvoir faire les tests
		
		jc = j;
		affichageJoueur.add(j.getLabel());
		//this.repaint(); 
	}
	
	public void retirerJoueur(Joueur j){
		jc = j;
		affichageJoueur.remove(j.getLabel());
		//this.repaint(); 
	}
	
	//vrai méthode pour dessiner joueur
	/*public void dessinerJoueur(Joueur j){
		Color c = j.getCouleur() ; en commentaire pour pouvoir faire les tests
		JLabel jl = new JLabel(j.getNom());
		jl.setOpaque(true);
		jl.setForeground(Color.WHITE);
		jl.setBackground(c);
		affichageJoueur.add(jl);
		this.repaint();
	}*/
	
	
	/////////////////////////////////////
	
	public void setCouleurProp( Color c){
		
			nom.setForeground(c);
		
    }
    
    
    //Pour l'ajout de maison 
    public void dessinerMaison(int nb){
        JPanel pan = new JPanel(new GridLayout(1 , 3 , 5 , 1));
        
        for(int j = 1 ; j <= nb ; j++){
            JPanel maison = new JPanel(); 
            Color c = new Color(0x16B84E);
            maison.setBackground(c); 
            
            pan.add(maison);
            
            System.out.println("Je dessine la " + j + "-eme maison sur cette case numero " + place); 
        } 
        
        this.add(pan /*, BorderLayout.SOUTH*/); 
        
        this.repaint();
    }
    
    
    public void dessinerHotel(){
        JPanel hotel = new JPanel(); 
        Color c = new Color(0xB82010); 
        hotel.setBackground(c); 
        
        System.out.println("Je dessine l'hotel"); 
        
        this.add(hotel /*, BorderLayout.SOUTH*/); 
        
        this.repaint();
    }
	
}
