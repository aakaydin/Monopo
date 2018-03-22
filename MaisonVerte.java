public class MaisonVerte{ 
	//modifier attribut position; 
	private int prix;
	private int prixHypotheque;
	private int position;
	//private int positionX; 
	//private int positionY;  
	//private CasePropriete Propriete;
	
	public MaisonVerte(int position,int prix,int PHypotheque){  //propriete){
		this.position = position;
		this.prix = prix;
		this.prixHypotheque = PHypotheque; //chaque maison a un prix d'hypotheque different selon la propriete
		//Propriete = propriete; //chaque maison a un prix different selon la propriete
	} 
	
	/*public int getX(){
		return positionX; 
	} 
	
	public int getY(){
		return positionY; 
	} */
	
	public int getPosition(){
		return position; 
	}
	
	public int getPrixHypotheque(){ 
		return prixHypotheque; 
	}  
	
	public int getPrix(){ 
		return prix; 
	}
	
	
	
	


}
