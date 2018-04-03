import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FenetreInterface extends JFrame{
	
		private PanelPlateau plateau = new PanelPlateau();
		//private PanelPlateau plateau = new PanelPlateau();
		public Plateau p ;	
		//private Joueur jTour = new Jouer();
		//private Joueur[] jojo = new Joueur[2];  
		//private Joueur JC = new Joueur("Camille",0,0);
		
		public JPanel panelTemp = new JPanel();
		
		
		JPanel panelEast = new JPanel( new BorderLayout());
		JPanel panelSouth = new JPanel( new FlowLayout() );
		JPanel panelNorth = new JPanel( new FlowLayout() );
		
			
		private JLabel label;
		private JLabel label1;
		private JLabel label2;
			
		private JButton btn;
		private JButton btn1;
		private JButton finTour;	
		private JButton lanceDe;	
		
		private Joueur jcourant; 
	
		public AffichageDe aff = new AffichageDe( 1 , 1);
		JPanel cadrePrincipal = new JPanel(new BorderLayout());
		
		private LinkedList<Joueur> ListJoueur = new LinkedList<Joueur>();
		
		
	
	public FenetreInterface( int longue , int large, Plateau pl, Joueur jcourant, LinkedList<Joueur> LJ){
	
		
		super(" Monopoly");
		
		p = pl ;
		this.jcourant = jcourant; 
		ListJoueur = LJ;
		
		
		this.setSize(new Dimension(longue,large));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	
		
		
		// 
		
		cadrePrincipal.setBackground(Color.CYAN);
		panelSouth.setBackground(Color.CYAN);
		panelNorth.setBackground(Color.CYAN);
		
		this.setContentPane(cadrePrincipal);
		
		//Creation des widgets
		
		
		label = new JLabel (" Joueur : " + jcourant.getNom());
		label1 = new JLabel(" Somme: " +jcourant.getSomme() );	
		label2 = new JLabel(" ");	
		
		
		btn = new JButton(" Next ");
		btn1 = new JButton(" Prev");
		finTour = new JButton(" End Turn");
		finTour.addActionListener(new EcouteurFinTour(this,jcourant, ListJoueur));
		lanceDe = new JButton(" Lancer les Des ");
		
		panelTemp = p.getCases().get(0).getPanel();
		
		aff = new AffichageDe( jcourant.de1 , jcourant.de2);
		
		
		
		// Lien entre les buttons et les listeners
		
		//btn.addActionListener( new EcouteurNext( this) );
		lanceDe.addActionListener( new EcouteurLancerLesDes(jcourant, this, p) ); //est-ce que mon écouteur va bien changer son joueur quand je change le joueur de la fenêtre ? rep Aydin : non 
		
		
		
		
		// Ajout des Gadgets dans les panels
		
		
		
		
		
		
		panelEast.add(aff , BorderLayout.CENTER );			
		panelEast.add(lanceDe , BorderLayout.NORTH	 );	
		
		panelNorth.add(finTour);
		
		panelSouth.add(label1 );
		panelSouth.add(label);
		
		//ligne de test
		plateau.getPanelCase(jcourant.getPos()).dessinerJoueur(jcourant);
		
		
		// Ajout des panels avec tout les widgets dans un case de borderLayout
		
		cadrePrincipal.add(plateau , BorderLayout.CENTER);
		
		cadrePrincipal.add(panelTemp , BorderLayout.WEST);
		
		cadrePrincipal.add(panelEast , BorderLayout.EAST);
		
		cadrePrincipal.add(panelSouth , BorderLayout.SOUTH);
		
		cadrePrincipal.add(panelNorth , BorderLayout.NORTH);
		
		 this.setVisible(true);
		 
		 
		}
		
		public PanelPlateau getPanelPlateau(){return plateau;}
		public Plateau getPlateau(){return p;}
		public JPanel getPanelTemp(){return panelTemp;}
		public JPanel getPanelSouth(){return panelSouth;}
		public JPanel getPanelEast(){return panelEast;}
		
		//ne fonctionne pas 
		public void changerPanel(JPanel p){
			
			cadrePrincipal.remove(panelTemp);
			
			panelTemp = p ;	
				
			panelTemp.repaint();
			
			cadrePrincipal.add(panelTemp, BorderLayout.WEST);	
			
		}
		
		public void setJoueur(Joueur j){
			
			jcourant = j;
			
		}
		
		public void changerPanelJoueur(Joueur j){
			panelSouth.removeAll();
			panelSouth.add(new JLabel("Joueur : " +j.getNom()));
			panelSouth.add(new JLabel("Somme : "+j.getSomme()));
			
			cadrePrincipal.add(panelSouth, BorderLayout.SOUTH);
			panelSouth.repaint();
			
		}
		
		public void changerJoueurEcouteurDe(Joueur j){
			//il faut changer le bouton des des 
			jcourant = j;
			panelEast.remove(lanceDe);
			lanceDe = new JButton("Lancer les des");
			lanceDe.addActionListener(new EcouteurLancerLesDes(jcourant, this, p)); 
			panelEast.add(lanceDe,  BorderLayout.NORTH);
			panelEast.repaint();
			
			
		}
		
		public PanelCase getPanelCase(int i){
			return plateau.getPanelCase(i);
		}
		
   public static void main(String[] a){
	    
	   LinkedList lj = new LinkedList<Joueur>();
	   lj.add(new Joueur("Cam",0,0));
	   lj.add(new Joueur("Lisa",10,2));
	   
		FenetreInterface fi = new FenetreInterface( 1200, 600, new Plateau(), new Joueur("Cam",0,4), lj );
		
		JPanel p = new JPanel();
		p.add(new JLabel("dguileza"));
		
		fi.changerPanel(p);
		JPanel p2 = new JPanel();
		
		p2.add(new JLabel("dge"));
		fi.changerPanel(p2);
		Joueur claire = new Joueur("Claire", 0,0);
		claire.setArgent(1000);
		fi.changerPanelJoueur(claire);
		claire.setArgent(05);
		System.out.println(claire.getSomme());
		fi.changerPanelJoueur(claire);
		
		//fi.changerPanel(p);
		
		//test carte chance panel
		
		
		
		
    } 
	
	
	
	
	
	
}
