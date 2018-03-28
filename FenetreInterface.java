import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FenetreInterface extends JFrame{
	
		private FenetrePlateau FP = new FenetrePlateau();
		public Plateau P = new Plateau();
			
		public JPanel panelTemp;
		//public int pTemp = 5;
			
		private JLabel label;
		private JLabel label1;
		private JLabel label2;
			
		private JButton btn;
		private JButton btn1;	
	
	
	public FenetreInterface( int longue , int large ){
	
		
		super(" Monopoly");
		
		this.setSize(new Dimension(longue,large));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ɲħ
		
		JPanel cadrePrincipal = new JPanel(new BorderLayout());
		JPanel monPanelCommande = new JPanel( new FlowLayout() );
		JPanel plateau = FP.getPane();
		
		// On fait de sorte que notre fenetre soit CYAN pour les deux panels
		
		cadrePrincipal.setBackground(Color.CYAN);
		monPanelCommande.setBackground(Color.CYAN);
		
		
		this.setContentPane(cadrePrincipal);
		
		//Creation des widgets
		
		label = new JLabel(" lol  ");
		label1 = new JLabel(" rofl ");	
		label2 = new JLabel(" lmao");	
		
		btn = new JButton(" Next ");
		btn1 = new JButton(" Prev");
		
		panelTemp = P.getCases().get(14).getPanel();
		
		
		
		// Lien entre les buttons et les listeners
		
		btn.addActionListener( new EcouteurNext( this) );
		
	
		
		// Ajout des Gadgets dans monPanelCommande
		
		
		monPanelCommande.add(btn1 );	// Button Prev
		monPanelCommande.add(btn );		// Button Next
		
		
		
		
		// Ajout de monPanel avec tout les widgets dans un case de borderLayout
		
		cadrePrincipal.add(plateau , BorderLayout.CENTER);
		
		cadrePrincipal.add(panelTemp , BorderLayout.WEST);
		
		cadrePrincipal.add(label1 , BorderLayout.EAST);
		
		cadrePrincipal.add(monPanelCommande , BorderLayout.SOUTH);
		
		 this.setVisible(true);
		}
	
	

	
	
	
	
	
    public static void main(String[] a){
		new FenetreInterface( 1200, 600 );
    }
	
	
	
	
	
	
	}
