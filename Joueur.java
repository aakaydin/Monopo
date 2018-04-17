import java.util.*;
import java.awt.*;

import javax.swing.*;


public class Joueur implements Comparable {
	
	
	private String nom;
	private int position;
	private int somme;
	
	//ce qui concerne la banque :
	//pour savoir si le joueur est endette 
	private  int dette;
	private boolean endette;
	private int mensualite = 0;      //remboursement du credit par tour; 
	//pour les transferts
	private int sommeTransfere;
	
	//argument pour l'ordre des joueurs et le demarrage du jeu 
	private boolean sonTour = false ; 
	
	//le joueur et son immobilier 
	public	LinkedList<Case> immobilier = new LinkedList<Case>();
	public  boolean estVivant = true ;
	
	//pour savoir si le joueur est en prison 
	public  boolean enPrison =false;
	public  boolean cartePrison = false; 
	//il faut calculer le nombre de tours qu'il passe en prison car il doit sortir au bout de 3
	public  int nbToursEnPrison = 0;
	
	//récupération du score aux dés du joueur 
	public  int de1;
	public  int de2;
	private  int sommeDes; 
	
	//repérage du passage par la case départ du joueur 
	public boolean passageCaseDep = false ; 
	
	//permet de récupérer la case sur laquelle se trouve le joueur 
	private Case caseCourante;
	
	//ce qui concerne l'immobilier avec les terrains, les maisons et les hotels que le joueur possède 
	private LinkedList<Hotel> MesHotels; 
	private LinkedList<MaisonVerte> MesMaisons;  
	private LinkedList<CaseProp> MesProprietes;  
	
	//permet de tuer le joueur ce qui met fin à la partie
	private boolean vivre = true; 
	
	
	//permet de placer le joueur sur le plateau pour l'affichage graphique 
	private JLabel label ;
	//permet d'associer le joueur à une couleur pour l'affichage graphique 
	public Color col ;
	
	// Constructeur avec nom + somme + position	
	public Joueur( String name , int mani, int pos){
		
		nom = name;
		somme = mani;
		position = pos;
		label = new JLabel(nom);
		label.setOpaque(true);
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		
		col = Color.BLACK; 
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
	
	public String getNom(){return nom;}
	
	public int getPos(){return position;}
	
	public int getSomme(){return somme;}
	
	public int getDette(){return dette;}
	
	public int getSommeDes(){return de1 + de2 ;}
	
	public boolean estVivant(){return estVivant;}
	
	public boolean getEnPrison(){return enPrison; }
	
	public boolean getCartePrison(){return cartePrison;}
	
	public int getDe1(){return de1;}
	
	public int getDe2(){return de2;}
	
	public int getNbToursEnPrison(){return nbToursEnPrison;}
	
	public Case getCaseCourante(){return caseCourante;}
	 
	public int getSommeTransfere(){return sommeTransfere;}
	
	public boolean getSonTour(){return sonTour;}
	 
	//Methode pour récupérer les propriétés 
	public LinkedList<Hotel> getMesHotels(){ return MesHotels;}
	public LinkedList<MaisonVerte> getMesMaisons(){ return MesMaisons;}
	public LinkedList<CaseProp> getMesProprietes(){ return MesProprietes;}
	public LinkedList<Case> getCases(){return immobilier ;} //il ne faut laisser que un des deux parceque là c'est inutile
	
	public int  getMensualite(){return mensualite;}
	
	public boolean getPassCaseDep(){return passageCaseDep;}
	
	//Methode qui calcul le capital du joueur 
	public int getCapital(){ 
		int capital = this.getSomme(); 
		if(MesHotels!=null){
			for(Hotel h : MesHotels){
				capital = capital + h.getPrixHypotheque(); 
			} 
		}else if(MesMaisons!=null){
			for(MaisonVerte m : MesMaisons){
				capital = capital + m.getPrixHypotheque(); 
			}
		}else if(MesProprietes!=null){
			for(CaseProp p : MesProprietes){
				capital = capital + p.getPrixHypotheque(); 
			}
		}
		return capital; 
	}
	 
	 
	//Setteurs
	public void addCase(Case c){immobilier.add(c);}

	public void setPos( int newpos){position =newpos ;}
	
	public void setCarteSortirPrison(boolean b){cartePrison = b ;}
	
	// Methode pour ajouter/retirer d'argent du joueur
	public void setArgent(int mani){somme = somme + mani;}
		
	public void setEndette(boolean b){endette = b;}
	
	public void setDette( int mani){dette = dette + mani;}
	
    public void setEnPrison(boolean b){enPrison = b;}
    
    public void setSommeDes(int val){sommeDes = val;}
    
    public void setSommeTransfert(int somme){ sommeTransfere = somme ;}
    
    public void tuer(){estVivant = false;}
    
    public void  setMensualite(int m){mensualite = m;}
	
	public void setSonTour(boolean b){sonTour = b;}
	
	public void setAbandon(){vivre = false;}
	
	public void setPassCaseDep(boolean b){passageCaseDep = b;}
        

		//Methodes pour faire avancer le joueur 
	public void avancer (int nbCases){
		
		position = position + nbCases;
		//il faut prendre en compte le fait qu'on puisse revenir au début du plateau 
		if(position > 27){
			position = position - 28;
			//quand on passe par la case départ on reçoit de l'argent 
			if(position !=0){
				this.setArgent(10000); //moitier de ce qu'on recoit quand on tombe sur la case départ
				passageCaseDep = true ; 
			}
		} //on ne peut pas dépasser le numéro de case 27 et notre première case est la case numéro 0
	}
	
	//Methode qui fait lancer les des au joueur, les des prennent une valeur aléatoire 
	public void lancerLesDes(){
		
		de1 = (int)(Math.random()*6+1);
		de2 = (int)(Math.random()*6+1);
	}
	
	//Methode qui envoie le joueur en prison
	public void allerEnPrison(){
		//modification de son état
		enPrison = true ;
		//modification de sa position
		this.setPos(7);
		//il faut redessiner le joueur 
	}
	
	//Methode quand le joueur passe un tour en prison et qui compte le nombre de tours passés en prison
	public void resteEnPrison(){
        	nbToursEnPrison = nbToursEnPrison + 1;
    	}
    
    
	//Methode qui permet de faire un transfert d'argent entre deux joueurs 
    public void transfere(Joueur j2){ 
		j2.setArgent(this.getSommeTransfere()); 
		this.setArgent(-(this.getSommeTransfere())); 
	}
	
	public boolean avoirHotel(){ 				 //vérifie si j'ai des hotels
		if(this.getMesHotels()!=null){ 
			return true; 
		}else{ 
			return false; 
		}
	}
	
	//les méthodes suivantes sont utilisées pour les hypothèques et les demandes de crédit 
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
	
	//methode qui compte les remboursements 
	public void remboursementTour(int remboursement){
		somme = somme-remboursement;
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
	
	//Methode pour afficher le joueur 
	public String toString(){
		return "	Joueur "+ getNom()+"   Somme : "+getSomme()+"   Valeur immobilier : "+getValImmobilier();
	}
	
	//Methode pour le crédit 
	public void credit(int somme){ 
			if(this.getCapital()>=1000000){ 
				if(somme <= 1000000 ){ 
					this.setArgent(somme); // on crédite le compte de la somme
					double taux = 0.07;
					int tour = 7;
					int remboursement = (int)(12*(somme * (taux/12))/(1-Math.pow(1+(taux/12),-tour*12))); 
					System.out.println("remboursement"+remboursement);  
					this.setMensualite(remboursement); //le joueur doit rembourser cette somme a chaque tour
					this.setDette(remboursement*7); //on doit rembourser en 7 tours.
				}
			}else if(this.getCapital()>=100000){ 
				if (somme <= 100000){ 
					double taux  = 0.05;         
					int tour = 7;
					int remboursement = (int)(12*(somme * (taux/12))/(1-Math.pow(1+(taux/12),-tour*12))); 
					System.out.println("remboursement"+remboursement);  
					this.setArgent(somme);
					this.setMensualite(remboursement);
					this.setDette(remboursement*7); 
					  
				}
			}else if(this.getCapital()>=10000){ 
				if (somme <= 10000){ 
					double taux = 0.03;         
					int tour = 7;
					int remboursement = (int)(12*(somme * (taux/12))/(1-Math.pow(1+(taux/12),-tour*12))); 
					this.setArgent(somme);
					this.setMensualite(remboursement);
					this.setDette(remboursement*7);
				}
			}else if(this.getCapital()>=1000){ 
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
	
	





