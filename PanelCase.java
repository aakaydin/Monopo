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
	
	private JPanel affichageJoueur = new JPanel() ;
	int place ;
	
	public PanelCase(Color col, JLabel n, PanelPlateau f, int i ){
		super();
		
		place = i;
		c = col ;
		nom = n ;
		fen = f;
		this.setLayout(new BorderLayout()); 
		JPanel p = new JPanel();
		p.setOpaque(true);
		p.setBackground(c);
		this.add(p, BorderLayout.NORTH);
		
		this.add(nom, BorderLayout.CENTER);
		LineBorder blackline = new LineBorder(Color.BLACK, 1);
		this.setBorder(blackline);
		
		this.add(affichageJoueur, BorderLayout.EAST);
	}
	
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		
	}
	
	//deux méthode pour les test car Joueur n'est pas encore fonctionnel 
	
	public int getPlace(){return place;}
	public void dessinerJoueur(Joueur j){
		//Color c = j.getCouleur() ; en commentaire pour pouvoir faire les tests
		
		affichageJoueur.add(j.getLabel());
		//this.repaint(); 
	}
	
	public void retirerJoueur(Joueur j){
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
	
}
