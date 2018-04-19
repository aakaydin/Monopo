import java.util.*;
import java.awt.*;
import javax.swing.*;

public class MaisonVerte{ 
	//modifier attribut position; 
	private int prix;
	private int prixHypotheque;
	private int position;
	//private int positionX; 
	//private int positionY;  
	//private CasePropriete Propriete;
    private LinkedList<Case> listeCases;
    private CaseProp caseAssociee;
	
	public MaisonVerte(int position,int prix,int PHypotheque){  //propriete){
		this.position = position;
		this.prix = prix;
		this.prixHypotheque = PHypotheque; //chaque maison a un prix d'hypotheque different selon la propriete
		//Propriete = propriete; //chaque maison a un prix different selon la propriete
	} 
    
    public MaisonVerte(int position , Plateau p){
        this.position = position; 
        
        listeCases = p.getCases(); 
        Case c = listeCases.get(position); 
        
        if (c instanceof CaseProp){
            caseAssociee = (CaseProp) c;
        
            prix = caseAssociee.getPrix()/10; 
            prixHypotheque = prix/2; 
            
        }else{
            System.out.println("On ne peut mettre de maison que sur les cases propriétés");
        }
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
