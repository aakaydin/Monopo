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
	
	JLabel labprison = new JLabel("Vous sortez de prison, lancez les des");
	
	JPanel sortirprison = new JPanel();
	
	JPanel panlancerdesprison = new JPanel();
	
	JLabel lablancerdesprison = new JLabel("Faites un double pour sortir de prison");
	
	JPanel panpayersortirprison = new JPanel();
	
	JLabel labpayersortirprison = new JLabel("3 tours en prison : payez 50000 et oust");
	
	//voir comment faire un JPanel de commentaires spéciaux 
	
	
	
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
        sortirprison.add(labprison);
        panlancerdesprison.add(lablancerdesprison);
        
        fen = f ;
     
    }
    
    public void testerPrison(){
		joueurCourant.setSommeDes(0); 
     
		
		//On teste l'état du joueur : en prison ou non 
		if(joueurCourant.getEnPrison() == true){
			if(joueurCourant.getCartePrison() == true){
            
				MaFenetreCartePrison fenCartePrison = new MaFenetreCartePrison(joueurCourant); 
				if(!joueurCourant.getEnPrison()){
					fen.changerPanel(sortirprison);
				} else {
					fen.changerPanel(panlancerdesprison);
				}	
			}else{
				fen.changerPanel(panlancerdesprison);
			}
		}else{
			fen.changerPanel(lancerLesDes);
		}
		//rendre actif les dés 

	}

	
		
	public void traitementEstEnPrison(){
		if(joueurCourant.getDe1() == joueurCourant.getDe2()){
			joueurCourant.setEnPrison(false); 
			joueurCourant.avancer(joueurCourant.getDe1() + joueurCourant.getDe2()); //fait avancer
			//appel méthode traitementCasefen.getPanelCase(j.getPos()).dessinerJoueur(j);
			fen.getPanelCase(joueurCourant.getPos()).dessinerJoueur(joueurCourant);
			fen.getPanelPlateau().repaint();
			
			
			this.Tour();
                 
		}else if(joueurCourant.getDe1() != joueurCourant.getDe2() && joueurCourant.getNbToursEnPrison() >= 3){
			joueurCourant.setArgent(-50000); //est-ce la somme que l'on choisit?
			joueurCourant.setEnPrison(false); 
                    
            joueurCourant.avancer(joueurCourant.getDe1() + joueurCourant.getDe2()); //fait avancer
			//appel méthode traitementCasefen.getPanelCase(j.getPos()).dessinerJoueur(j);
			fen.getPanelCase(joueurCourant.getPos()).dessinerJoueur(joueurCourant);
			fen.getPanelPlateau().repaint();
            this.Tour();
                    //appel méthode traitementCase
		}else{
			joueurCourant.resteEnPrison();
			fen.getPanelCase(joueurCourant.getPos()).dessinerJoueur(joueurCourant);
			fen.getPanelPlateau().repaint();
                    
                    
		}
		
		fen.changerPanelJoueur(joueurCourant);
		fen.getPanelTemp().repaint();
                
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
            caseCour.setDescriptionPanel(joueurCourant, fen);
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
            CarteChance carteChance = caseCour.creerCarteChance(joueurCourant, fen);
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
			caseCour.setFenetreEcouteurAcheter(fen);
			caseCour.setFenetreEcouteurPayerJoueur(fen);
			fen.changerPanel(panelCase);
			fen.getPanelTemp().repaint();
		}
            
	
     joueurCourant.setSommeDes(0);  
        

	}
	
	public Joueur getJoueur(){return joueurCourant;}

}
