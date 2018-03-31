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
	
	private JPanel affichageJoueur = new JPanel() ;
	
	public PanelCase(Color col, JLabel n, PanelPlateau f ){
		super();
		
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
	public void dessinerJoueur(/*Joueur j*/){
		//Color c = j.getCouleur() ; en commentaire pour pouvoir faire les tests
		JLabel jl = new JLabel(" ");
		jl.setOpaque(true);
		jl.setBackground(Color.MAGENTA);
		affichageJoueur.add(jl);
		this.repaint();
	}
	
	public void dessinerJoueur2(/*Joueur j*/){
		//Color c = j.getCouleur() ; en commentaire pour pouvoir faire les tests
		JLabel jl = new JLabel("J1 ");
		jl.setOpaque(true);
		jl.setForeground(Color.BLACK);
		jl.setBackground(Color.WHITE);
		affichageJoueur.add(jl);
		this.repaint(); 
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
