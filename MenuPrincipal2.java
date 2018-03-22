import java.util.*;
import javax.swing.*; 
import java.awt.*; 

public class MenuPrincipal2 extends JFrame{
	
	
	private JTextField t1 = new JTextField(10); 
	private JLabel l1 = new JLabel("nom du joueur1");
	private JTextField t2 = new JTextField(10); 
	private JLabel l2 = new JLabel("nom du joueur2");
	private JTextField t3 = new JTextField(10); 
	private JLabel l3 = new JLabel("nom du joueur3");
	private JTextField t4 = new JTextField(10); 
	private JLabel l4 = new JLabel("nom du joueur4");
	private int nbJoueur; 
	private int nbIA; 
	
	public MenuPrincipal2(int longueur, int largeur, int nbJoueur,int nbIA){ 

		super("Menu Principal"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setSize(new Dimension(longueur,largeur)); 
		
		JPanel cadrePrincipal = new JPanel(new GridLayout(8,2));
		this.setContentPane(cadrePrincipal);
		this.nbJoueur = nbJoueur;
		this.nbIA = nbIA; 
		
		if(nbJoueur ==1){
			cadrePrincipal.add(l1); 
			cadrePrincipal.add(t1);
		}else if (nbJoueur ==2){ 
			cadrePrincipal.add(l1); 
			cadrePrincipal.add(t1);
			cadrePrincipal.add(l2); 
			cadrePrincipal.add(t2);
		}else if (nbJoueur ==3){ 
			cadrePrincipal.add(l1); 
			cadrePrincipal.add(t1);
			cadrePrincipal.add(l2); 
			cadrePrincipal.add(t2);
			cadrePrincipal.add(l3); 
			cadrePrincipal.add(t3);
		}else{ 
			cadrePrincipal.add(l1); 
			cadrePrincipal.add(t1);
			cadrePrincipal.add(l2); 
			cadrePrincipal.add(t2);
			cadrePrincipal.add(l3); 
			cadrePrincipal.add(t3);
			cadrePrincipal.add(l4); 
			cadrePrincipal.add(t4);
		}
		
		t1.setText(""+nbJoueur); 
		this.setVisible(true); 
		
			
			
		
		
		
		
		
		
		
		
		
		
		

	 


	}
}
