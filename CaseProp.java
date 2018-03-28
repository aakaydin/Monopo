


public class CaseProp extends Case implements Achetable{
	
	public int prix; 
	public Joueur propri;
	public int couleur;
	public boolean achete = false;
	
	public CaseProp( int pos, String name, int prix ){
		
		super(pos, name);
		this.prix = prix;
		propri = null;
		
		
		
		
		}
		
		
		
	
	 public  void Acheter( Joueur J  ){
		
		
		propri = J;
		J.setArgent(-prix);
		
		
		}
	
	
	
	}
