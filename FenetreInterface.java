import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FenetreInterface extends JFrame{
	
		private FenetrePlateau FP = new FenetrePlateau();
		public Plateau P = new Plateau();	
		public JPanel panelTemp;
		
			
		private JLabel label;
		private JLabel label1;
		private JLabel label2;
			
		private JButton btn;
		private JButton btn1;
		private JButton finTour;	
		private JButton lanceDe;	
	
		private AffichageDe aff = new AffichageDe();
		
	
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
		
		label = new JLabel (" Joueur Courant:               ");
		label1 = new JLabel(" Somme:                        ");	
		label2 = new JLabel(" ");	
		
		btn = new JButton(" Next ");
		btn1 = new JButton(" Prev");
		finTour = new JButton(" End Turn");
		lanceDe = new JButton(" Lancer les Des ");
		
		panelTemp = P.getCases().get(0).getPanel();
		
		
		
		// Lien entre les buttons et les listeners
		
		btn.addActionListener( new EcouteurNext( this) );
		
	
		
		// Ajout des Gadgets dans les panels
		
		
		
		
		
		
		panelEast.add(aff , BorderLayout.CENTER );			
		panelEast.add(lanceDe , BorderLayout.NORTH	 );	
		
		panelNorth.add(finTour);
		
		panelSouth.add(label1 );
		panelSouth.add(label);
		
		
		
		// Ajout de monPanel avec tout les widgets dans un case de borderLayout
		
		cadrePrincipal.add(plateau , BorderLayout.CENTER);
		
		cadrePrincipal.add(panelTemp , BorderLayout.WEST);
		
		cadrePrincipal.add(panelEast , BorderLayout.EAST);
		
		cadrePrincipal.add(panelSouth , BorderLayout.SOUTH);
		
		cadrePrincipal.add(panelNorth , BorderLayout.NORTH);
		
		 this.setVisible(true);
		}
	
	

	
	
	
	
	
    public static void main(String[] a){
		new FenetreInterface( 1200, 600 );
    }
	
	
	
	
	
	
	}
