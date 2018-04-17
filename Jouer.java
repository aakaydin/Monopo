import java.awt.* ;
import javax.swing.*;
import java.util.*;

public class Jouer{
    
    //à chaque nouveau tour on crée un objet jouer qui va executer ses différentes méthodes 
    
    //liste des cases de la partie 
    Plateau plateau ; 
    //fenêtre d'intéreaction avec les joeurs 
	FenetreInterface fen ;
	
	//à chaque tour il y a un joueur courant : le joueur dont c'est le  tour de jouer 
	private  Joueur joueurCourant ; 
    
    // 
    
    
    
    
    int position;
     
    //on a un attribut qui est la case courante, c'est à dire la case sur laquelle se trouve le joueur 
    Case caseCourante = new Case(0,"c","a");
	//on récupère le panel de la case du joueur pour l'affichage graphique 
	JPanel panelCase ;
    
    //Constructeur 
    public Jouer(Plateau p, FenetreInterface f, Joueur j){
        
        joueurCourant = j;
        plateau = p;
        fen = f ;
     
		System.out.println(" LOL");
    
    }
    
    public void testerPrison(){
		joueurCourant.setSommeDes(0); 
     
		
		//On teste l'état du joueur : en prison ou non 
		if(joueurCourant.getEnPrison() == true){
			if(joueurCourant.getCartePrison() == true){
            
				MaFenetreCartePrison fenCartePrison = new MaFenetreCartePrison(joueurCourant, fen); 
				
			}else{
				fen.setTextInfo("Faites un double pour sortir de prison");
			}
		}else{
			fen.setTextInfo("Vous pouvez lancer les des");
		}
		//rendre actif les dés 

	}

	
		
	public void traitementEstEnPrison(){
		if(joueurCourant.getDe1() == joueurCourant.getDe2()){
			joueurCourant.setEnPrison(false); 
			joueurCourant.avancer(joueurCourant.getDe1() + joueurCourant.getDe2()); //fait avancer
			//appel méthode traitementCasefen.getPanelCase(j.getPos()).dessinerJoueur(j);
			fen.getPanelCase(joueurCourant.getPos()).dessinerJoueur(joueurCourant);
			//fen.getPanelPlateau().repaint();
			fen.setTextInfo("Vous avez fait un double et sortez!");
			
			this.Tour();
                 
		}else if(joueurCourant.getDe1() != joueurCourant.getDe2() && joueurCourant.getNbToursEnPrison() >= 3){
			joueurCourant.setArgent(-50000); //est-ce la somme que l'on choisit?
			joueurCourant.setEnPrison(false); 
			fen.setTextInfo("3 tours en prison : payez 50000 et oust");
                    
            joueurCourant.avancer(joueurCourant.getDe1() + joueurCourant.getDe2()); //fait avancer
			//appel méthode traitementCasefen.getPanelCase(j.getPos()).dessinerJoueur(j);
			fen.getPanelCase(joueurCourant.getPos()).dessinerJoueur(joueurCourant);
			//fen.getPanelPlateau().repaint();
            this.Tour();
                    //appel méthode traitementCase
		}else{
			joueurCourant.resteEnPrison();
			fen.getPanelCase(joueurCourant.getPos()).dessinerJoueur(joueurCourant);
			//fen.getPanelPlateau().repaint();
			fen.setTextInfo("Vous restez en prison"); 
                    
                    
		}
		
		fen.changerPanelJoueur(joueurCourant);
		//fen.getPanelTemp().repaint();
        fen.repaint();
        fen.pack();
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
           
            
            fen.getPanelCase(joueurCourant.getPos()).retirerJoueur(joueurCourant);
            
            joueurCourant.allerEnPrison(); //problème de downcast?
            fen.getPanelCase(joueurCourant.getPos()).dessinerJoueur(joueurCourant);
			//fen.getPanelPlateau().repaint(); 
        }
        
        if (caseCourante instanceof CaseTaxe){
			//ces lignes de code serait plutot dans la classe caseTaxe 
            CaseTaxe caseCour = (CaseTaxe) caseCourante;
            
    
            int val = caseCour.getValAPayer(); 
            caseCour.setDescriptionPanel(joueurCourant, fen);
            panelCase = caseCourante.getPanel();   
            

            //pour getter les cases il va falloir les numéroter
            
            ((CaseCagnotte)plateau.getCases().get(14)).ajoutCagnotte(val);
        }
        
        if(caseCourante instanceof CaseCagnotte){
            CaseCagnotte caseCour = (CaseCagnotte) caseCourante;
            caseCour.setPanel() ;
            panelCase = caseCourante.getPanel();
           
            
            caseCour.recupereCagnotte(joueurCourant); 
            fen.changerPanelJoueur(joueurCourant);
        }
        
        if(caseCourante instanceof CaseChance){ 
            CaseChance caseCour = (CaseChance) caseCourante;
            CarteChance carteChance = caseCour.creerCarteChance(joueurCourant, fen);
            carteChance.tirerCarte(); 
			panelCase = carteChance.getPanel();
			
			if(joueurCourant.getEnPrison()){
				fen.getPanelCase(joueurCourant.getPos()).retirerJoueur(joueurCourant);
				joueurCourant.setPos(7);
				fen.getPanelCase(joueurCourant.getPos()).dessinerJoueur(joueurCourant);
				
			}
        }
        
        
        if(caseCourante instanceof CaseDepart){
            CaseDepart caseCour = (CaseDepart) caseCourante;
            panelCase = caseCour.getPanel();
            caseCour.action(joueurCourant);
            
        }
        
        if(caseCourante instanceof CasePrison){
			CasePrison caseCour = (CasePrison) caseCourante;
			panelCase = caseCour.getPanel();
			joueurCourant.setEnPrison(true);
			
		}
        
        if(caseCourante instanceof CaseProp){
			CaseProp caseCour = (CaseProp) caseCourante ;
			caseCour.setDescriptionPanel(joueurCourant);
			panelCase = caseCour.getPanel() ; 
			caseCour.setFenetreEcouteurAcheter(fen);
			caseCour.setFenetreEcouteurPayerJoueur(fen);
			
			
		}
            
	fen.changerPanelTemp(panelCase); 
     joueurCourant.setSommeDes(0);  
     fen.repaint();
     fen.pack();

	}
	
	public Joueur getJoueur(){return joueurCourant;}

}
