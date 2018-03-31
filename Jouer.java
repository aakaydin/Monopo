import java.awt.* ;
import javax.swing.*;
import java.util.*;

public class Jouer{
    
    
    int position;
    //boolean joueEncore = true;  
    boolean rejouera = false; 
    Case caseCourante = new Case(0,"c","a");
	
	
	JPanel panelCase ;
	JPanel lancerLesDes = new JPanel();
	JLabel lab = new JLabel("Vous pouvez lancer les des");

	JLabel lab2 = new JLabel("Finir tour");
	JPanel finirtour = new JPanel();
	
	//Partie partie ;
	Plateau plateau ; //il faudra ensuite utiliser celui de Partie
	FenetreInterface fen ;
    Joueur joueurCourant ; //pour les tests 
    
    //Constructeur 
    public Jouer(Plateau p, FenetreInterface f, Joueur j){//va prendre en parametre un plateau, un joueur courant et une fenetre 
        joueurCourant = j;
        plateau = p;
        joueurCourant = j;
        lancerLesDes.add(lab);
        finirtour.add(lab2);
        //fen = f ; quand on aura fait partie
        
        
    }
    
    public void testerPrison(){
		joueurCourant.setSommeDes(0); 
     
     
    //On teste l'état du joueur : en prison ou non 
		if(joueurCourant.getEnPrison() == true){
			if(joueurCourant.getCartePrison() == true){
            
				MaFenetreCartePrison fenCartePrison = new MaFenetreCartePrison(); 
				boolean reponse = fenCartePrison.getReponse(); //ecouteur ok? Boolean false par défaut -> pose problème? quel ordre des étapes? 
            
				if(reponse == true){
					joueurCourant.setEnPrison(false); 
					
                
				}
			}
		}
		
		fen.changerPanel(lancerLesDes);
		//rendre actif les dés 
		
		
	}

	
		
	public void traitementEstEnPrison(){
		if(joueurCourant.getDe1() == joueurCourant.getDe2()){
			joueurCourant.setEnPrison(false); 
                    
                    joueurCourant.avancer(joueurCourant.getDe1() + joueurCourant.getDe2()); //fait avancer
                    //appel méthode traitementCase
                    this.Tour();
                 
		}else if(joueurCourant.getDe1() != joueurCourant.getDe2() && joueurCourant.getNbToursEnPrison() >= 3){
			joueurCourant.setArgent(-50000); //est-ce la somme que l'on choisit?
			joueurCourant.setEnPrison(false); 
                    
                    joueurCourant.avancer(joueurCourant.getDe1() + joueurCourant.getDe2()); //fait avancer
                    this.Tour();
                    //appel méthode traitementCase
		}else{
                    joueurCourant.resteEnPrison();
                    
                    fen.changerPanel(finirtour);
                    //rend actif le bouton finir tour 
		}
                
	}
    //Un tour : 
    public void Tour(){
        
        /*if(joueurCourant.getDe1() == joueurCourant.getDe2()){
            rejouera = true; 
            //on peut donc rejouer quand on sort de prison ? 
        }*/
        
        //joueurCourant.avancer(joueurCourant.getSommeDes()); 
        int position = joueurCourant.getPos();
        LinkedList<Case> mesCases = plateau.getCases();
		caseCourante = mesCases.get(position);
        
   
        
        /*Si on pouvait getter toutes les cases du plateau ce serait bien. Comme ça par exemple pour cagnotte on pourrait directement reverser l'argent*/ 
        /*Faire tous les affichages, faire tous les boutons : pour les différentes cases (pas que chance)*/
        if (caseCourante instanceof CaseAllerPrison){ 
            caseCourante = (CaseAllerPrison) caseCourante;
            panelCase = caseCourante.getPanel();
            fen.getPanelCase(joueurCourant.getPos()).retirerJoueur(joueurCourant);
            
            joueurCourant.allerEnPrison(); //problème de downcast?
            fen.getPanelCase(joueurCourant.getPos()).dessinerJoueur(joueurCourant);
			fen.getPanelPlateau().repaint(); 
        }
        
        if (caseCourante instanceof CaseTaxe){
			//ces lignes de code serait plutot dans la classe caseTaxe 
            CaseTaxe caseCour = (CaseTaxe) caseCourante;
            caseCour.setDescriptionPanel(joueurCourant);
            panelCase = caseCourante.getPanel();
            int val = caseCour.getValAPayer(); 
            caseCour.setDescriptionPanel(joueurCourant);
            panelCase = caseCourante.getPanel();
            //pour getter les cases il va falloir les numéroter
            
            ((CaseCagnotte)plateau.getCases().get(14)).ajoutCagnotte(val);
        }
        
        if(caseCourante instanceof CaseCagnotte){
            CaseCagnotte caseCour = (CaseCagnotte) caseCourante;
            caseCour.setPanel() ;
            panelCase = caseCourante.getPanel();
            caseCour.recupereCagnotte(joueurCourant); 
        }
        
        if(caseCourante instanceof CaseChance){ 
            CaseChance caseCour = (CaseChance) caseCourante;
            CarteChance carteChance = caseCour.creerCarteChance(joueurCourant);
            carteChance.tirerCarte(); 
			panelCase = carteChance.getPanel();
        }
        
        
        if(caseCourante instanceof CaseDepart){
            CaseDepart caseCour = (CaseDepart) caseCourante;
            panelCase = caseCour.getPanel();
            caseCour.action(joueurCourant);
        }
        //il faut rajouter si on tombe sur la case prison
        if(caseCourante instanceof CasePrison){
			CasePrison caseCour = (CasePrison) caseCourante;
			panelCase = caseCour.getPanel();
			joueurCourant.setEnPrison(true);
		}
        
        if(caseCourante instanceof CaseProp){
			CaseProp caseCour = (CaseProp) caseCourante ;
			caseCour.setDescriptionPanel(joueurCourant);
			panelCase = caseCour.getPanel() ; 
		}
            
		
		 
            
     joueurCourant.setSommeDes(0);  

	fen.changerPanel(finirtour);
    
     //faire changement d'affcihage dans la fenêtre qui doit afficher finir tour 
       
  
    //la ligne suivante doit se trouver dans l'écouteur du bouton fintour
    //joueurCourant.setSonTour(false); //faire setSonTour ou faire une méthode fin du tour qui passe directement la main au prochain joueur du tableau
    
    
    //ne pas oublier le bouton 
    //tour terminé 
    //acheter une maison qui s'active quand le joueurCurrent n'a pas sa liste de maison vide (immobilier != 0) 
    //abandonner la partie 
    

	}
	
	public Joueur getJoueur(){return joueurCourant;}

}
