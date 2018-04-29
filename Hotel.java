import java.util.*;
import java.awt.*;
import javax.swing.*;


public class Hotel{ 
	
	//Attributs 
	//prix d'achat
	private int prix;
	//prix de vente en cas d'hypothèque 
	private int prixHypotheque;
	//position sur le plateau 
	private int position;
	//liste de cases du plateau 
	private LinkedList<Case> listeCases;
	private CaseProp caseAssociee;
	JPanel dessinHotel; 
	
	public Hotel(int position, int prix,int PHypotheque){  
		this.position = position;  
		this.prix = prix;
		this.prixHypotheque = PHypotheque; //chaque hotel a un prix d'hypotheque different selon la propriete	
	} 
	
	public Hotel(int position , Plateau p){
		this.position = position; 
		//on récupère la liste des cases du plateau 
		listeCases = p.getCases(); 
		//on récupère la case à la position de l'hotel 
		Case c = listeCases.get(position); 
		//si il s'agit bien d'une case propriété alors on règle les prix de l'hotel en fonction de la case associée 
		if (c instanceof CaseProp){
			caseAssociee = (CaseProp) c;
			prix = caseAssociee.getPrix()/10; 
			prixHypotheque = prix/2; 
			//sinon rien n'a lieu (le message d'erreur est pris en compte à un autre endroit dans ecouteurBtnAchatHotel 
		}else{
			System.out.println("On ne peut mettre de maison que sur les cases propriétés");
		}
	}     
	//getteurs 
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
