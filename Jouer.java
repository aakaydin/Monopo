public class Jouer{
    
    Joueur joueurCourant; 
    int position;
    //boolean joueEncore = true;  
    boolean rejouera = false; 
    Case caseCourante; 
    
    
    //Constructeur 
    public Jouer(MenuPrincipal partie){
        joueurCourant = partie.getJoueurCourant(); 
        
    }
    
    
    //Un tour : 
    public void Tour(){
     
     joueurCourant.setSommeDes(0); 
     
     
    //On teste l'état du joueur : en prison ou non 
    if(joueurCourant.getEnPrison() == true){
        if(joueurCourant.getCartePrison() == true){
            
            MaFenetreCartePrison fenCartePrison = new MaFenetreCartePrison(); 
            boolean reponse = fenCartePrison.getReponse(); //ecouteur ok? Boolean false par défaut -> pose problème? quel ordre des étapes? 
            
            if(reponse == true){
                joueurCourant.setEnPrison(false); 
                joueurCourant.lancerLesDes(); 
            }else if (reponse == false){
                joueurCourant.lancerLesDes(); 
                
                if(joueurCourant.getDe1() == joueurCourant.getDe2()){
                    joueurCourant.setEnPrison(false); 
                }else if(joueurCourant.getDe1() != joueurCourant.getDe2() && joueurCourant.getNbToursEnPrison() >= 3){
                    joueurCourant.setArgent(-50000); //est-ce la somme que l'on choisit?
                    joueurCourant.setEnPrison(false); 
                }else{
                    joueurCourant.resteEnPrison();
                    /*joueEncore = false; */ //inutile pour le moment
                }
            }
        }
    }
    
    
    if(joueurCourant.getEnPrison() == false){
        if(joueurCourant.getSommeDes() == 0 ){
            joueurCourant.lancerLesDes(); 
        }
        
        if(joueurCourant.getDe1() == joueurCourant.getDe2()){
            rejouera = true; 
        }
        
        joueurCourant.avancer(joueurCourant.getSommeDes()); 
        
        caseCourante = joueurCourant.getCaseCourante(); //cette méthode doit-elle être dans Joueur?
        
        /*Si on pouvait getter toutes les cases du plateau ce serait bien. Comme ça par exemple pour cagnotte on pourrait directement reverser l'argent*/ 
        /*Faire tous les affichages, faire tous les boutons : pour les différentes cases (pas que chance)*/
        if (caseCourante instanceof CaseAllerPrison){ 
            caseCourante = (CaseAllerPrison) caseCourante;
            joueurCourant.allerEnPrison(); //problème de downcast? 
        }
        
        if (caseCourante instanceof CaseTaxe){
            caseCourante = (CaseTaxe) caseCourante;
            int val = caseCourante.getValAPayer(); 
            Plateau plateau = partie.getPlateau(); //à mettre dans MenuPrincipal 
            CaseCagnotte caseCagnotte = plateau.getCaseCagnotte(); 
            caseCagnotte.ajoutCagnotte(val , joueurCourant); 
        }
        
        if(caseCourante instanceof CaseCagnotte){
            caseCourante = (CaseCagnotte) caseCourante;
            caseCourante.recupereCagnotte(joueurCourant); 
        }
        
        if(caseCourante instanceof CaseChance){ 
            caseCourante = (CaseChance) caseCourante; 
            caseCourante.tirerCarte(joueurCourant);
        }
        
        
        if(caseCourante instanceof CaseDepart){
            caseCourante = (CaseDepart) caseCourante;
            caseCourante.action(joueurCourant);
        }
        
            
            
            
            
        
    joueurCourant.lancerLesDes(); 
    position = joueurCourant.getPos(); 
    
    
    
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
