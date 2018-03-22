


public class Joueur {
	
	
	private String nom;
	private int position;
	private int somme;
	private  int dette;
	private boolean endette;
	public	Case[] immobilier;
	public  boolean estVivant = true ;
	public  boolean sonTour;
	public  boolean enPrison =false;
	public  boolean cartePrison;
	public  boolean passerSonTour = false;
	public  int tourEnPrison;
	public  int dee1;
	public  int dee2;
	
	
	//private avatar
	
		
		
	// Constructeur avec nom + somme + position	
	public Joueur( String name , int mani, int pos){
		
		nom = name;
		somme = mani;
		position = pos;
		}
	
	// Constructeur avec nom + somme 
	public Joueur( String name , int mani){
		
		nom = name;
		somme = mani;
		}
	
	// Constructeur avec nom 
	public Joueur( String name ){
		
		nom = name;
		}
	
	
	// Getteurs
	
	public String getNom(){
		
		
		return nom;
		
		}
	
	public int getPos(){
		
		
		return position;
		
		}
	
	public int getSomme(){
		
		
		return somme;
		
		}
	
	public int getDette(){
		
		
		return dette;
		
		}
	
	public void setPos( newpos){
		
		
		 position =newpos ;
		
		}
	
	
	// Methode pour ajouter/retirer d'argent du joueur
	public void setArgent( int mani){
		
		somme = somme + mani;
		
		}
	
	public void sedEndette(){
		
		endette = true;
		
		
		}
	
	
	public void setDette( int mani){
		
		dette = dette - mani;
		
		}
	
	public boolean AvoirHotel(){
		
		
		
		
		}
	
	
	// Methode inecessairement complique pour deplacer un par un 
	public void deplacer( int newpos){  // 
		
		
		if( newpos > position){ 
		
		while(position != newpos){
			
			
			position++;
			
			
			}
		
		}else{ 
			
			while(position != 0){
			
			
			position++;
			
			
			}
			
			for(int i = 0; i < newpos ;i++  ){
			
			position++;
			
			
			}
			}
		
		
		}
	
	
	// Methode pour ded 
	public void tuer(){
		
		estVivant = false;
		
		
		}

	public vendre 
}

