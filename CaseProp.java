import java.awt.* ;
import javax.swing.*;

public class CaseProp extends Case{
	
	private int prix; 
	private Joueur propri;
	private int couleur;
	private boolean achete = false;
	
	//k=j'ai déjà créer l'écouteur payer 
	private JPanel panel = new JPanel(new BorderLayout());
	
	private JLabel labavantachat ;
	private JLabel apresachat ;
	private JButton acheter ; 
	
	private JButton payer ;
	private JLabel labpropri = new JLabel("Vous etes chez vous");
	private JLabel danspropri ;
	
		
		
	
	public CaseProp( int pos, String name, int prix){
		
		super(pos, name);
		this.prix = prix;
		propri = null ; 

	}
		
	
	
	public JPanel getPanel(){return panel ;}
	
	public void setProprietaire(Joueur j){
		propri = j;
	}
	
	public int getPrix(){return prix;}
	

		
	public void setDescriptionPanel(Joueur j){
		panel.removeAll();
		if(!achete){
			labavantachat = new JLabel(this.getNom() + " - PRIX : "+ prix);
			panel.add(labavantachat, BorderLayout.NORTH);
			acheter = new JButton("Acheter");
			acheter.addActionListener(new EcouteurAcheter(j, this , acheter));
			panel.add(acheter, BorderLayout.CENTER);
			
		} else if(j == propri){
			panel.add(labpropri, BorderLayout.NORTH);
		} else {
			danspropri = new JLabel("Vous etes chez "+propri.getNom()+", vous lui devez "+prix);
			panel.add(danspropri, BorderLayout.NORTH);
			payer = new JButton("Payer");
			payer.addActionListener(new EcouteurPayerJoueur(propri, j, this));
			panel.add(payer, BorderLayout.CENTER);
		}
		panel.repaint();
	}		
	
	public void setAchete(boolean b){
		achete = b ;
	}		


	}
