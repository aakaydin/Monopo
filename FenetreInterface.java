import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FenetreInterface extends JFrame{
	
		private FenetrePlateau FP = new FenetrePlateau();
		//private PanelPlateau plateau = new PanelPlateau();
		public Plateau p ;	
		//private Joueur jTour = new Jouer();
		//private Joueur[] jojo = new Joueur[2];  
		private Joueur JC = new Joueur("Camille",0,0);
		
		public JPanel panelTemp;
		
		
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
	
		public AffichageDe aff = new AffichageDe( 1 , 1);
		JPanel cadrePrincipal = new JPanel(new BorderLayout());
	
	public FenetreInterface( int longue , int large, Plateau pl){
	
		
		super(" Monopoly");
		
		p = pl ;
		JPanel plateau = FP.getPane();
		
		this.setSize(new Dimension(longue,large));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	
		
		
		// 
		
		cadrePrincipal.setBackground(Color.CYAN);
		panelSouth.setBackground(Color.CYAN);
		panelNorth.setBackground(Color.CYAN);
		
		this.setContentPane(cadrePrincipal);
		
		//Creation des widgets
		
		label1 = new JLabel(" Somme: " +JC.getSomme() );
		label = new JLabel (" Joueur Courant: " + JC.getNom());	
		label2 = new JLabel(" ");	
		
		
		btn = new JButton(" Next ");
		btn1 = new JButton(" Prev");
		finTour = new JButton(" End Turn");
		lanceDe = new JButton(" Lancer les Des ");
		
		panelTemp = p.getCases().get(0).getPanel();
		
		aff = new AffichageDe( JC.de1 , JC.de2);
		
		
		
		// Lien entre les buttons et les listeners
		
		//btn.addActionListener( new EcouteurNext( this) );
		lanceDe.addActionListener( new EcouteurLancerLesDes(JC, this, p) ); //est-ce que mon écouteur va bien changer son joueur quand je change le joueur de la fenêtre ? rep Aydin : non 
		
		
		
		
		// Ajout des Gadgets dans les panels
		
		
		
		
		
		
		panelEast.add(aff , BorderLayout.CENTER );			
		panelEast.add(lanceDe , BorderLayout.NORTH	 );	
		
		panelNorth.add(finTour);
		
		panelSouth.add(label1 );
		panelSouth.add(label);
		
		
		
		
		// Ajout des panels avec tout les widgets dans un case de borderLayout
		
		cadrePrincipal.add(plateau , BorderLayout.CENTER);
		
		cadrePrincipal.add(panelTemp , BorderLayout.WEST);
		
		cadrePrincipal.add(panelEast , BorderLayout.EAST);
		
		cadrePrincipal.add(panelSouth , BorderLayout.SOUTH);
		
		cadrePrincipal.add(panelNorth , BorderLayout.NORTH);
		
		 this.setVisible(true);
		}
		
		//ne fonctionne pas 
		public void changerPanel(JPanel p){
			panelTemp.removeAll();
			panelTemp = p ;
			
			cadrePrincipal.remove(panelTemp);
			panelTemp.updateUI();
			cadrePrincipal.add(panelTemp, BorderLayout.WEST);
			
		}
		
		public void changerPanelJoueur(Joueur j){
			JC = j;
			panelSouth.removeAll();
			cadrePrincipal.remove(panelSouth);
			panelTemp.updateUI();
			cadrePrincipal.add(panelSouth, BorderLayout.SOUTH);
		}
		
		public void changerJoueur(Joueur j){
			//il faut changer le bouton des des 
			JC = j;
			panelEast.remove(lanceDe);
			lanceDe = new JButton("Lancer les des");
			lanceDe.addActionListener(new EcouteurLancerLesDes(JC, this, p)); 
			panelEast.add(lanceDe,  BorderLayout.NORTH);
			
		}
			
		
    public static void main(String[] a){
		FenetreInterface fi = new FenetreInterface( 1200, 600, new Plateau() );
		
		JPanel p = new JPanel();
		p.add(new JLabel("dguileza"));
		
		fi.changerPanel(p);
		
		
		
    }
	
	
	
	
	
	
}
