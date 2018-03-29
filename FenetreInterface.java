import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FenetreInterface extends JFrame{
	
		private FenetrePlateau FP = new FenetrePlateau();
		public Plateau P = new Plateau();	
		//private Joueur jTour = new Jouer();
		//private Joueur[] jojo = new Joueur[2];  
		private Joueur JC = new Joueur("Camille",0,0);
		
		public JPanel panelTemp;
		
			
		private JLabel label;
		private JLabel label1;
		private JLabel label2;
			
		private JButton btn;
		private JButton btn1;
		private JButton finTour;	
		private JButton lanceDe;	
		
		JPanel cadrePrincipal = new JPanel(new BorderLayout());
		
	
		public AffichageDe aff = new AffichageDe( 1 , 1);
		
	
	public FenetreInterface( int longue , int large ){
	
		
		super(" Monopoly");
		
		this.setSize(new Dimension(longue,large));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		JPanel cadrePrincipal = new JPanel(new BorderLayout());
		
		JPanel panelEast = new JPanel( new BorderLayout());
		JPanel panelSouth = new JPanel( new FlowLayout() );
		JPanel panelNorth = new JPanel( new FlowLayout() );
		JPanel plateau = FP.getPane();
		
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
		
		panelTemp = P.getCases().get(0).getPanel();
		
		aff = new AffichageDe( JC.de1 , JC.de2);
		
		
		
		// Lien entre les buttons et les listeners
		
		//btn.addActionListener( new EcouteurNext( this) );
		lanceDe.addActionListener( new EcouteurLancerLesDes(JC , this) );
		
		
		
		
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
	
	
	public void changerPanel(JPanel p){
			panelTemp.removeAll();
			panelTemp = p ;
			
			cadrePrincipal.remove(panelTemp);
			panelTemp.updateUI();
			cadrePrincipal.add(panelTemp, BorderLayout.WEST);
			
	}
	
	
	
	
	
    public static void main(String[] a){
		FenetreInterface fi = new FenetreInterface( 1200, 600 );
		
		JPanel p = new JPanel();
		p.add(new JLabel("dguileza"));
		
		fi.changerPanel(p);
		
	    
    }
	
	
	
	
	
	
	}
