import java.util.*;

public class Joueur {
	
	
	private String nom;
	private int position;
	private int somme;
	private  int dette;
	private boolean endette;
	public	LinkedList<Case> immobilier = new LinkedList<Case>();
	public  boolean estVivant = true ;
	public  boolean sonTour;
	public  boolean enPrison =false;
	public  boolean cartePrison = false ;
	public  boolean passerSonTour = false;
	public  int nbToursEnPrison;
	public  int de1;
	public  int de2;
	private  int sommeDes; 
	public boolean passageCaseDep = false ; 
	
	
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
	public boolean getCarteSortirPrison(){return cartePrison;}
	
	public String getNom(){
		
		
		return nom;
		
		}
	
	public void addCase(Case c){
		
		immobilier.add(c);
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
	
	public void setPos( int newpos){
		
		
		 position =newpos ;
		
		}
	
	public int getSommeDes(){
		return de1 + de2 ;
	}
	
	public void setCarteSortirPrison(boolean b){
		cartePrison = b ;
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
	
	
	public boolean getEnPrison(){
        	return enPrison; 
    	}
    
	
    	public void setEnPrison(boolean b){
        	enPrison = b; 
    	}
    
	
    	public boolean getCartePrison(){
        	return cartePrison; 
    	}
    
	
    	public int getDe1(){
        	return de1;
    	}
    
	
    	public int getDe2(){
        	return de2;
    	}
    
	
    	public void setSommeDes(int val){
        	sommeDes = 0; 
    	}
        
    
    	public int getNbToursEnPrison(){
        	return nbToursEnPrison;
    	}
    
	
    	public Case getCaseCourante(){
        	return caseCourante;
    	}
    
	
    	public void setSonTour(boolean b){
        	sonTour = b; 
    	}

	
	
	// Methode inecessairement complique pour deplacer un par un 
	public void teleporter( int newpos){
		
		
		if( newpos > position){ 
		
		while(position != newpos){
			
			
			position++;
			
			
			}
		
		}else{ 
			
			while(position != 0){
			passageCaseDep = true ; 
			
			position++;
			
			
			}
			
			for(int i = 0; i < newpos ;i++  ){
			
			position++;
			
			
			}
			}
		
		
		}
	
	
	public void avancer (int nbCases){
		position = position + nbCases;
	}
	
	
	public void recevoirArgentDep(){
		passageCaseDep = false ;
		somme = somme + 200 ;
	}
	
	public void lancerLesDes(){
		
		de1 = (int)(Math.random()*6+1);
		de2 = (int)(Math.random()*6+1);
	}
	
	// Methode pour ded 
	public void tuer(){
		
		estVivant = false;
		
		
	}
	
	
	public void allerEnPrison(){
		enPrison = true ;
		this.setPos(7);
	}
	
	
	public void resteEnPrison(){
        	nbToursEnPrison = nbToursEnPrison + 1;
    	}
	



}

