


public class CaseProp extends Case implements Achetable{
	
	public int prix; 
	public Joueur propri;
	public int couleur;
	public boolean achete = false;
	
	public CaseProp( int pos, String name, int prix, Joueur propr, int coul){
		
		super(pos, name);
		this.prix = prix;
		propri = propr;
		couleur = coul;
		
		
		
		}
		
		
		
	
	 public  void Acheter( Joueur J  ){
		
		
		propri = J;
		J.virement(-prix);
		
		
		}
	
	
	
	}
