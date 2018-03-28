import java.awt.* ;
import javax.swing.*;
import java.util.*;

public class Jouer{
    
    Joueur joueurCourant = new Joueur("Camille",0,0); //pour les tests 
    int position;
    //boolean joueEncore = true;  
    boolean rejouera = false; 
    Case caseCourante ;
	//Principal
	Plateau plateau = new Plateau(); //il faudra ensuite utiliser celui de Partie
	JPanel panelCase ;
	JPanel lancerLesDes = new JPanel();
    
    
    //Constructeur 
    public Jouer(){
        //joueurCourant = partie.getJoueurCourant(); 
        JButton lancerDes = new JButton("Lancer les des");
        lancerDes.addActionListener(new EcouteurLancerLesDes(joueurCourant));
        lancerLesDes.add(lancerDes);
        
    }
    
    public void TesterPrison(){
		joueurCourant.setSommeDes(0); 
     
     
    //On teste l'état du joueur : en prison ou non 
    if(joueurCourant.getEnPrison() == true){
        if(joueurCourant.getCartePrison() == true){
            
            MaFenetreCartePrison fenCartePrison = new MaFenetreCartePrison(); 
            boolean reponse = fenCartePrison.getReponse(); //ecouteur ok? Boolean false par défaut -> pose problème? quel ordre des étapes? 
            
            if(reponse == true){
                joueurCourant.setEnPrison(false); 
            }else if (reponse == false){
                //faire setMethode de la classe principale pour que le Panel changeant soit celui de lancer des dés 
                //si on ne clique pas sur le bouton est-ce qu'on passe quand même aux lignes suivantes 
                //est-ce qu'on fait un boolean a choisi puis un while tant que le joueur n'a pas lancer les des ... 
                
                if(joueurCourant.getDe1() == joueurCourant.getDe2()){
                    joueurCourant.setEnPrison(false); 
                }else if(joueurCourant.getDe1() != joueurCourant.getDe2() && joueurCourant.getNbToursEnPrison() >= 3){
                    joueurCourant.setArgent(-50000); //est-ce la somme que l'on choisit?
                    joueurCourant.setEnPrison(false); 
                }else{
                    joueurCourant.resteEnPrison();
                    /*joueEncore = false; */ //inutile pour le moment
                }
                //afficher sur le panel changeant si on est sorti de prison où non 
            }
        }
    }
}
	
		
		
    //Un tour : 
    public void Tour(){
     
    joueurCourant.setSommeDes(0); 
	
	if(joueurCourant.getEnPrison() == false){
        if(joueurCourant.getSommeDes() == 0 ){
			//faire setMethode de la classe principale pour que le Panel changeant soit celui de lancer des dés 
                //si on ne clique pas sur le bouton est-ce qu'on passe quand même aux lignes suivantes 
                //est-ce qu'on fait un boolean a choisi puis un while tant que le joueur n'a pas lancer les des ... 
        }
        
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
            joueurCourant.allerEnPrison(); //problème de downcast? 
        }
        
        if (caseCourante instanceof CaseTaxe){
			//ces lignes de code serait plutot dans la classe caseTaxe 
            CaseTaxe caseCourante = (CaseTaxe) caseCourante;
            caseCourante.setDescriptionPanel(joueurCourant);
            panelCase = caseCourante.getPanel();
            int val = caseCourante.getValAPayer(); 
            caseCourante.setDescriptionPanel(joueurCourant);
            panelCase = caseCourante.getPanel();
            //pour getter les cases il va falloir les numéroter
            
            ((CaseCagnotte)plateau.getCases().get(14)).ajoutCagnotte(val);
        }
        
        if(caseCourante instanceof CaseCagnotte){
            CaseCagnotte caseCourante = (CaseCagnotte) caseCourante;
            caseCourante.setPanel() ;
            panelCase = caseCourante.getPanel();
            caseCourante.recupereCagnotte(joueurCourant); 
        }
        
        if(caseCourante instanceof CaseChance){ 
            CaseChance caseCourante = (CaseChance) caseCourante;
            CarteChance carteChance = caseCourante.creerCarteChance(joueurCourant);
            carteChance.tirerCarte(); 
			panelCase = carteChance.getPanel();
        }
        
        
        if(caseCourante instanceof CaseDepart){
            CaseDepart caseCourante = (CaseDepart) caseCourante;
            panelCase = caseCourante.getPanel();
            caseCourante.action(joueurCourant);
        }
        //il faut rajouter si on tombe sur la case prison
        if(caseCourante instanceof CasePrison){
			CasePrison caseCourante = (CasePrison) caseCourante;
			panelCase = caseCourante.getPanel();
			joueurCourant.setEnPrison(true);
		}
        
        if(caseCourante instanceof CaseProp){
			CaseProp caseCourante = (CaseProp) caseCourante ;
			caseCourante.setDescriptionPanel(joueurCourant);
			panelCase = caseCourante.getPanel() ; 
		}
            
		
		 
            
            
       
    
    
    
    //faire affichage de la case
    
    //[...] est-ce que toutes les actions sont contenues dans les classes de cases associées 
    
    
    
    joueurCourant.setSonTour(false); //faire setSonTour ou faire une méthode fin du tour qui passe directement la main au prochain joueur du tableau
    
    
    //ne pas oublier le bouton 
    //tour terminé 
    //acheter une maison qui s'active quand le joueurCurrent n'a pas sa liste de maison vide (immobilier != 0) 
    //abandonner la partie 
    
    }
}

}
