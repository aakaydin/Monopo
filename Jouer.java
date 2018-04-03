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

	
	
	
	//Partie partie ;
	Plateau plateau ; 
	FenetreInterface fen ;
	
    Joueur joueurCourant ; 
    
    //Constructeur 
    public Jouer(Plateau p, FenetreInterface f, Joueur j){
        joueurCourant = j;
        plateau = p;
        joueurCourant = j;
        lancerLesDes.add(lab);
        
        fen = f ;
     
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
            CaseAllerPrison caseCour = (CaseAllerPrison) caseCourante;
            panelCase = caseCour.getPanel();
            fen.changerPanel(panelCase);
            
            fen.getPanelTemp().repaint();
            
            fen.getPanelCase(joueurCourant.getPos()).retirerJoueur(joueurCourant);
            
            joueurCourant.allerEnPrison(); //problème de downcast?
            fen.getPanelCase(joueurCourant.getPos()).dessinerJoueur(joueurCourant);
			fen.getPanelPlateau().repaint(); 
        }
        
        if (caseCourante instanceof CaseTaxe){
			//ces lignes de code serait plutot dans la classe caseTaxe 
            CaseTaxe caseCour = (CaseTaxe) caseCourante;
            
    
            int val = caseCour.getValAPayer(); 
            caseCour.setDescriptionPanel(joueurCourant);
            panelCase = caseCourante.getPanel();   
            fen.changerPanel(panelCase);
            fen.getPanelTemp().repaint();

            //pour getter les cases il va falloir les numéroter
            
            ((CaseCagnotte)plateau.getCases().get(14)).ajoutCagnotte(val);
        }
        
        if(caseCourante instanceof CaseCagnotte){
            CaseCagnotte caseCour = (CaseCagnotte) caseCourante;
            caseCour.setPanel() ;
            panelCase = caseCourante.getPanel();
            fen.changerPanel(panelCase);
            fen.getPanelTemp().repaint();
            
            caseCour.recupereCagnotte(joueurCourant); 
        }
        
        if(caseCourante instanceof CaseChance){ 
            CaseChance caseCour = (CaseChance) caseCourante;
            CarteChance carteChance = caseCour.creerCarteChance(joueurCourant);
            carteChance.tirerCarte(); 
			panelCase = carteChance.getPanel();
			fen.changerPanel(panelCase);
			fen.getPanelTemp().repaint();
			if(joueurCourant.getEnPrison()){
				fen.getPanelCase(joueurCourant.getPos()).retirerJoueur(joueurCourant);
				joueurCourant.setPos(7);
				fen.getPanelCase(joueurCourant.getPos()).dessinerJoueur(joueurCourant);
				fen.getPanelPlateau().repaint(); 
			}
        }
        
        
        if(caseCourante instanceof CaseDepart){
            CaseDepart caseCour = (CaseDepart) caseCourante;
            panelCase = caseCour.getPanel();
            caseCour.action(joueurCourant);
            fen.changerPanel(panelCase);
            fen.getPanelTemp().repaint();
        }
        
        if(caseCourante instanceof CasePrison){
			CasePrison caseCour = (CasePrison) caseCourante;
			panelCase = caseCour.getPanel();
			joueurCourant.setEnPrison(true);
			fen.changerPanel(panelCase);
			fen.getPanelTemp().repaint();
		}
        
        if(caseCourante instanceof CaseProp){
			CaseProp caseCour = (CaseProp) caseCourante ;
			caseCour.setDescriptionPanel(joueurCourant);
			panelCase = caseCour.getPanel() ; 
			fen.changerPanel(panelCase);
			fen.getPanelTemp().repaint();
		}
            
		
		 
            
     joueurCourant.setSommeDes(0);  
     //changer l'affichage du panel joueur au cas oùla somme de celui-ci aurait changer 
     fen.changerPanelJoueur(joueurCourant);
     fen.getPanelSouth().repaint();

		
    
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
