import java.awt.* ;
import javax.swing.*;

public class CaseProp extends Case{
	
	private int prix; 
	//prend en attribut le propriétaire
	private Joueur propri;
	//possède aussi un attribut du joueur se trouvant sur la case 
	private Joueur joueurcase ;
	private int couleur;
	private boolean achete = false;
    //prix d'hypotheque du terrain
    private int prixHypotheque; 
    //prix d une maison
    private int prixBatiment ;

	
	//j'ai déjà créé l'écouteur payer 
	private JPanel panel = new JPanel(new BorderLayout());
	
	private JLabel labavantachat ;
	private JLabel apresachat ;
	private JButton acheter = new JButton("Acheter"); 
	
	private JButton payer ;
	private JLabel labpropri = new JLabel("Vous etes chez vous");
	private JLabel danspropri ;
	
	
   	private int nbMaisons = 0; 
    	private int nbHotel = 0; 
	
	EcouteurAcheter ecouteurAcheter ;
	EcouteurPayerJoueur ecouteurPayerJoueur ;
	
	

		
	
	public CaseProp( int pos, String name, int prix, int prixBatiment){
		
		super(pos, name);
		this.prix = prix;
        this.prixBatiment = prixBatiment ;
		propri = new Joueur("a",0,0) ; //joueur aléatoire juste pour l'instanciation
        prixHypotheque = (int)prix/2 ;
        
	}
		
	
	
	public JPanel getPanel(){return panel ;}
	
	public void setProprietaire(Joueur j){
		propri = j;
	}
	
    public int getPrixBatiment(){ return prixBatiment;}
    
	public Joueur getPropri(){return propri;}
    
	public int getPrix(){return prix;}
	
	public boolean getAchete(){return achete;}


	public void setDescriptionPanel(Joueur j){
		joueurcase = j ;
		ecouteurAcheter = new EcouteurAcheter(j, this, acheter) ;
		ecouteurPayerJoueur = new EcouteurPayerJoueur(propri, j, this) ;
		panel.removeAll();
		if(!achete){
			labavantachat = new JLabel(this.getNom() + " - PRIX : "+ prix);
			panel.add(labavantachat, BorderLayout.NORTH);
			
			acheter.addActionListener(ecouteurAcheter);
			panel.add(acheter, BorderLayout.CENTER);
			
		} else if(j == propri){
			panel.add(labpropri, BorderLayout.NORTH);
		} else {
			danspropri = new JLabel("Vous etes chez "+propri.getNom()+", vous lui devez "+prix);
			panel.add(danspropri, BorderLayout.NORTH);
			payer = new JButton("Payer");
			payer.addActionListener(ecouteurPayerJoueur);
			panel.add(payer, BorderLayout.CENTER);
		}
		panel.repaint();
	}		
	
	public void setAchete(boolean b){
		achete = b ;
	}		
	
	public void setFenetreEcouteurAcheter(FenetreInterface f){
		ecouteurAcheter.setFenetreInterface(f);
	}
	
	public void setFenetreEcouteurPayerJoueur(FenetreInterface f){
		ecouteurPayerJoueur.setFenetreInterface(f);
	}
	
	public int getPrixHypotheque(){ 
		return prixHypotheque; 
	}
    
    
    public int getNbMaisons(){ return nbMaisons; }
    public int getNbHotel(){ return nbHotel; }
    
    public void ajoutMaison(){
        nbMaisons = nbMaisons + 1; 
        if(nbMaisons == 1){ //en moyennant par rapport aux variations du "vrai" jeu 
            prix = prix * 5; 
        }
        else if (nbMaisons == 2){
            prix = prix * 3; 
        }
        else if (nbMaisons == 3){
            prix = (int) (prix * 2.5); 
        }
        else if (nbMaisons == 4){
            prix = (int) (prix * 1.3); 
        }
    }
    
    public void ajoutHotel(){
        nbHotel = nbHotel + 1; 
        nbMaisons = 0; 
        prix = (int) (prix * 1.25); 
    }
    
    public void vendre(){
        //on garde le proprietaire precedent et il sera changé au prochain achat 
        achete = false ;
        nbMaisons = 0 ;
        nbHotel = 0;
    }
    
    public void retirerMaison(){nbMaisons --;}
    public void retirerHotel(){nbHotel --;}
        
    
    


	}
