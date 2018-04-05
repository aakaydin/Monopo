import java.util.*;
import java.awt.*;

import javax.swing.*;


public class Joueur implements Comparable {
	
	
	private String nom;
	private int position;
	private int somme;
	private  int dette;
	private boolean endette;
	public	LinkedList<Case> immobilier = new LinkedList<Case>();
	public  boolean estVivant = true ;
	public  boolean sonTour;
	public  boolean enPrison =false;
	public  boolean cartePrison = false; //a changer
	public  boolean passerSonTour = false;
	public  int nbToursEnPrison = 0;
	public  int de1;
	public  int de2;
	private  int sommeDes; 
	public boolean passageCaseDep = false ; 
	private JLabel label ;
	private int sommeTransfere;
	private LinkedList<Hotel> MesHotels; 
	private LinkedList<MaisonVerte> MesMaisons;  
	private LinkedList<CaseProp> MesProprietes;  
	private boolean vivre = true; 
	private int mensualite = 0;      //remboursement du credit par tour; 
	
	private Case caseCourante;
	
	
	//private avatar
	
		
		
	// Constructeur avec nom + somme + position	
	public Joueur( String name , int mani, int pos){
		
		nom = name;
		somme = mani;
		position = pos;
		label = new JLabel(nom);
		label.setOpaque(true);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		}
	
	// Constructeur avec nom + somme 
	public Joueur( String name , int mani){
		
		nom = name;
		somme = mani;
		label = new JLabel(nom);
		label.setOpaque(true);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		}
	
	// Constructeur avec nom 
	public Joueur( String name ){
		
		nom = name;
		label = new JLabel(nom);
		label.setOpaque(true);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		}
	
	
	// Getteurs
	public JLabel getLabel(){return label;}
	
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
		
	public boolean estVivant(){return estVivant;}
	
	public void setEndette(boolean b){
		
		endette = b;
		
		
		}
	
	
	public void setDette( int mani){
		
		dette = dette + mani;
		
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
    	
    	public boolean getSonTour(){return sonTour;}

	
	
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
		if(position > 27){
			position = position - 28;
			this.setArgent(10000); //moitier de ce qu'on recoit quand on tombe sur la case départ
		} //on ne peut pas dépasser le numéro de case 27 et notre première case est la case numéro 0
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
		//il faut redessiner le joueur 
	}
	
	
	public void resteEnPrison(){
        	nbToursEnPrison = nbToursEnPrison + 1;
    	}
    
    public void setSommeTransfert(int somme){ 
		sommeTransfere =somme; 
	}
	public int getSommeTransfere(){
		return sommeTransfere; 
	}
    public void transfere(Joueur j2){ 
		j2.setArgent(this.getSommeTransfere()); 
	}
	
	public LinkedList<Hotel> getMesHotels(){ 
		return MesHotels;
	}
	public LinkedList<MaisonVerte> getMesMaisons(){ 
		return MesMaisons;
	}
	public LinkedList<CaseProp> getMesProprietes(){ 
		return MesProprietes;
	}
	
	public boolean avoirHotel(){ 				 //vérifie si j'ai des hotels
		if(this.getMesHotels()!=null){ 
			return true; 
		}else{ 
			return false; 
		}
	}
	
	
	public boolean avoirMaison(){                 //vérifie si j'ai des maisons
		if(this.getMesMaisons()!=null){ 
			return true; 
		}else{ 
			return false; 
		}
	}
	
	public boolean avoirPropriete(){                 //vérifie si j'ai des maisons
		if(this.getMesProprietes()!=null){ 
			return true; 
		}else{ 
			return false; 
		}
	}
	
	public Hotel getHotelPlusChere(){ 
		Hotel H = new Hotel(0,0,0); 
		for(int i = 0; i<MesHotels.size(); i++){
			Hotel h = MesHotels.get(i);
			if(H.getPrixHypotheque()<h.getPrixHypotheque()){ 
				H = h; 
			} 
		}
		return H; 
	}
	
	public MaisonVerte getMaisonPlusChere(){ 
		MaisonVerte M = new MaisonVerte(0,0,0); 
		for(int i = 0; i<MesMaisons.size(); i++){
			MaisonVerte m = MesMaisons.get(i);
			if(M.getPrixHypotheque()<m.getPrixHypotheque()){ 
				M = m; 
			} 
		}
		return M; 
	}
	
	public CaseProp getProprietePlusChere(){ 
		CaseProp P = new CaseProp(0,"coucou",0); 
		for(int i = 0; i<MesMaisons.size(); i++){
			CaseProp p = MesProprietes.get(i);
			if(P.getPrixHypotheque()<p.getPrixHypotheque()){ 
				P = p; 
			} 
		}
		return P; 
	}
	
	public void remboursementTour(int remboursement){
		somme = somme-remboursement;
	}
	
	public int  getMensualite(){
		return mensualite;
	}
	public void  setMensualite(int m){
		mensualite = m;
	}
	
	public void setAbandon(){ 
		vivre = false; 
	}
		
		 	
	public LinkedList<Case> getCases(){
		return immobilier ;
	}
	
	public int getValImmobilier(){
		int somme = 0;
		for(Case c : immobilier){
			CaseProp cp = (CaseProp)c;
			somme = somme + cp.getPrix() ;
		}
		return somme ;
	}
	
	public int compareTo(Object o){
		Joueur j = (Joueur)o;
		if(this.getSomme() > j.getSomme()){
			return -1 ;
		} else if (this.getSomme() < j.getSomme()){
			return 1;
		} else {
			if(this.getValImmobilier() > j.getValImmobilier()){
				return -1 ;
			} else if(this.getValImmobilier() < j.getValImmobilier()){
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	public String toString(){
		return "	Joueur "+ getNom()+"   Somme : "+getSomme()+"   Valeur immobilier : "+getValImmobilier();
	}	
	
	public void credit(int somme){ 
			if(this.getSomme()>1000000){ 
				if(somme <= 1000000 ){ 
					this.setArgent(somme); // on crédite le compte de la somme
					double taux = 0.07;
					int tour = 7;
					int remboursement = (int)(12*(somme * (taux/12))/(1-Math.pow(1+(taux/12),-tour*12)));  
					this.setMensualite(remboursement); //le joueur doit rembourser cette somme a chaque tour
					this.setDette(remboursement*7); //on doit rembourser en 7 tours.
				}
			}else if(this.getSomme()>100000){ 
				if (somme <= 100000){ 
					double taux  = 0.05;         
					int tour = 7;
					int remboursement = (int)(12*(somme * (taux/12))/(1-Math.pow(1+(taux/12),-tour*12))); 
					this.setArgent(somme);
					this.setMensualite(remboursement);
					this.setDette(remboursement*7); 
					  
				}
			}else if(this.getSomme()>10000){ 
				if (somme <= 10000){ 
					double taux = 0.03;         
					int tour = 7;
					int remboursement = (int)(12*(somme * (taux/12))/(1-Math.pow(1+(taux/12),-tour*12))); 
					this.setArgent(somme);
					this.setMensualite(remboursement);
					this.setDette(remboursement*7);
				}
			}else if(this.getSomme()>1000){ 
				if (somme <= 1000){ 
					double taux = 0.03;         
					int tour = 7;
					int remboursement = (int)(12*(somme * (taux/12))/(1-Math.pow(1+(taux/12),-tour*12))); 
					this.setArgent(somme);
					this.setMensualite(remboursement);
					this.setDette(remboursement*7);
				}
			}
			this.setEndette(true); 
		} 
		 
			 
	}
	
	





