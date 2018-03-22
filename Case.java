


public class Case{

	private int position;
	private String nom;
	private String desc;
	

	// Constructeur avec position + nom  
	public Case( int pos , String name, String desc ){
		
		nom = name;
		position = pos;
		this.desc = desc;
		
		}
		
	// Constructeur avec position	
	public Case( int pos){
		
		
		position = pos;
		
		
		}
	
	
	
	// Getteurs
	
	public String getNom(){
		
		
		return nom;
		
		}
	
	public int getPos(){
		
		
		return position;
		
		}
	
	
}
