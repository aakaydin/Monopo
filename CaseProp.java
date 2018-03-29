import java.awt.* ;
import javax.swing.*;

public class CaseProp extends Case{
	
	private int prix; 
	private Joueur propri;
	private int couleur;
	private boolean achete = false;
	
	//k=j'ai déjà créer l'écouteur payer 
	private JPanel panel = new JPanel() ;
	
	private JLabel labavantachat ;
	private JLabel apresachat ;
	private JButton acheter ; 
	private JButton nepasacheter ;
	private JButton payer ;
	private JLabel labpropri = new JLabel("Vous êtes chez vous");
	private JLabel danspropri ;
	
		
		
	
	public CaseProp( int pos, String name, int prix){
		
		super(pos, name);
		this.prix = prix;
		propri = null ; 

	}
		
	
	
	public JPanel getPanel(){return panel ;}
	
	public void setProprietaire(Joueur j){
		propri = j;
		j.addCaseProp(this);
	}
	
	public int getPrix(){return prix;}
	

		
		public void setDescriptionPanel(Joueur j){
			panel.removeAll();
			if(!achete){
				labavantachat = new JLabel(this.getNom() + " : vous pouvez acheter cette propriété pour "+ prix);
				panel.add(labavantachat);
				acheter = new JButton("Acheter");
				acheter.addActionListener(new EcouteurAcheter(j, this));
				panel.add(acheter);
				
			} else if(j == propri){
				panel.add(labpropri);
			} else {
				danspropri = new JLabel("Vous êtes chez "+propri.getNom()+", vous lui devez "+prix);
				panel.add(danspropri);
				payer = new JButton("Payer");
				payer.addActionListener(new EcouteurPayerJoueur(propri, j, this));
				panel.add(payer);
			}
		}				


	}
