import java.util.*;
import java.awt.*;
import javax.swing.*;

public class MaisonVerte{ 
	
	//prix de la maison
	private int prix;
	//prix de vente de la maison
	private int prixHypotheque;
	//numéro de la case sur laquelle se trouve la maison
	private int position;
	
	//liste des cases du plateau
    	private LinkedList<Case> listeCases;
	//case associée à la maison
    	private CaseProp caseAssociee;
	
	public MaisonVerte(int position,int prix,int PHypotheque){  
		this.position = position;
		this.prix = prix;
		this.prixHypotheque = PHypotheque; //chaque maison a un prix d'hypotheque different selon la propriete
		e
	} 
    
	public MaisonVerte(int position , Plateau p){
		//initialisation de la poistion de la maison
		this.position = position;
		//récupéartion de la liste des cases du plateau 
		listeCases = p.getCases(); 
		//récupéartion de la case associée 
		Case c = listeCases.get(position); 
		//si il s'agit bien d'une case propriété alors il faut que je change les attributs de ma maison
		if (c instanceof CaseProp){
  			caseAssociee = (CaseProp) c;
    			prix = caseAssociee.getPrix()/10; 
    			prixHypotheque = prix/2; 
		}else{ //sinon rien ne se passe, mais le message d'erreur qui est associé est prise en compte dans ecouteurBtnMaison
    			System.out.println("On ne peut mettre de maison que sur les cases propriétés");
		}
	}
	
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
