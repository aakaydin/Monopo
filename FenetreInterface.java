import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FenetreInterface extends JFrame{
	
		public PanelPlateau plateau = new PanelPlateau();
		//private PanelPlateau plateau = new PanelPlateau();
		public Plateau p ;	
		//private Joueur jTour = new Jouer();
		//private Joueur[] jojo = new Joueur[2];  
		//private Joueur JC = new Joueur("Camille",0,0);
		
		public JPanel panelTemp = new JPanel();
		public JPanel panelInfo = new JPanel(new GridLayout(3,1)) ; 
		
		public JLabel labInfo = new JLabel() ;
		
		public EcouteurLancerLesDes ecouteurdes ;
		
		JPanel panelWest = new JPanel( new GridLayout(2,1));
		JPanel panelEast = new JPanel( new GridLayout(5,1));
		JPanel panelSouth = new JPanel( new FlowLayout() );
		JPanel panelNorth = new JPanel( new FlowLayout() );
		
			
		private JLabel label;
		private JLabel label1;
		private JLabel label2;
	
		public JButton finTour;	
		public JButton lanceDe;	
		public JButton abandonner;	
		public JButton banque;
		public JButton payerDette;	
		
		
		public Joueur jcourant; 
	
		public AffichageDe aff = new AffichageDe( 1 , 1);
		JPanel cadrePrincipal = new JPanel(new BorderLayout());
		
		private LinkedList<Joueur> ListJoueur;
		
		//public boolean activeFin = false;
		//public boolean acitveDes = false;
		
		
		
	
	public FenetreInterface( int longue , int large, Plateau pl, Joueur jcourant, LinkedList<Joueur> LJ){
	
		
		super(" Monopoly");
		
		
		p = pl ;
		this.jcourant = jcourant; 
		ListJoueur = LJ;
		
		ecouteurdes = new EcouteurLancerLesDes(jcourant, this, p);
		
		
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
		
		
		finTour = new JButton(" End Turn");
		lanceDe = new JButton(" Lancer les Des ");
		abandonner = new JButton(" Abandonner ");
		banque = new JButton(" Banque");
		payerDette = new JButton(" Payer Credit");
		payerDette.setEnabled(false);  
		
		panelTemp = p.getCases().get(0).getPanel();
		
		panelInfo.add(new JLabel("	INFORMATION TOUR"));
		panelInfo.add(labInfo);
		
		panelWest.add(panelInfo);
		panelWest.add(panelTemp); 
		
		aff = new AffichageDe( jcourant.de1 , jcourant.de2);
		
		
		
		// Lien entre les buttons et les listeners
		
		
		lanceDe.addActionListener( ecouteurdes ); //est-ce que mon écouteur va bien changer son joueur quand je change le joueur de la fenêtre ? rep Aydin : non 
		finTour.addActionListener(new EcouteurFinTour(this,jcourant, ListJoueur));
		abandonner.addActionListener(new EcouteurAbandonner(this));
		banque.addActionListener(new EcouteurBanque(this));
		payerDette.addActionListener(new EcouteurPayerCredit(this));
		
		
		
		finTour.setEnabled( false);
		lanceDe.setEnabled( true);
		
		
		
		// Ajout des Gadgets dans les panels
		
		
		
		
		panelEast.add(banque);	
		panelEast.add(abandonner);
		panelEast.add(payerDette);		
		panelEast.add(aff);			
		panelEast.add(lanceDe);	
		
		
		
		panelNorth.add(finTour);
		
		panelSouth.add(label1 );
		panelSouth.add(label);
		//panelSouth.add(abandonner);	
		
		
		//ligne de test
		plateau.getPanelCase(jcourant.getPos()).dessinerJoueur(jcourant);
		
		
		// Ajout des panels avec tout les widgets dans un case de borderLayout
		
		cadrePrincipal.add(plateau , BorderLayout.CENTER);
		
		cadrePrincipal.add(panelWest , BorderLayout.WEST);
		
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
		public Joueur getJoueurCourant(){return jcourant;}
		
		//ne fonctionne pas 
		public void changerPanelTemp(JPanel p){
			
			panelWest.removeAll();
			
			panelTemp = p ;
				
				
			//panelTemp.repaint();
			
			panelWest.add(panelInfo);
			panelWest.add(panelTemp);	
			 
			
		}
		
		public void setTextInfo(String s){
			
			labInfo.setText(s);
				
		}
		
		public Joueur getJoueur(){
			return jcourant;
		}
		
		public LinkedList<Joueur> getLesJoueurs(){
			return ListJoueur ;
		}
		
		public void setJoueur(Joueur j){
			
			jcourant = j;
			
		}
		
		public void changerPanelJoueur(Joueur j){
			
			//ce code fonctionne
			label.setText("Joueur : " +j.getNom());
			label1.setText("Somme : " +j.getSomme());
			panelSouth.repaint();
			
		}
		
		public void changerJoueurEcouteurDe(Joueur j){
			//il faut changer le bouton des des 
			panelEast.repaint();
			jcourant = j;
			panelEast.remove(lanceDe);
			lanceDe = new JButton("Lancer les des");
			lanceDe.addActionListener(new EcouteurLancerLesDes(jcourant, this, p)); 
			panelEast.add(lanceDe,  BorderLayout.NORTH);
			/*ecouteurdes.setJoueur(j);
			panelEast.repaint();*/
			
			
			
		}
		
		public PanelCase getPanelCase(int i){
			return plateau.getPanelCase(i);
		}
		
		public JLabel getL1(){ 
			return label1; 
		}
		
		public JButton getPayerDette(){ 
			return payerDette; 
		}
	
	/**
		
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
	
	*/
	
	
	
	
}
