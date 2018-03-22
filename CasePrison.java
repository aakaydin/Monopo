public class CasePrison extends Case{

    //Pas de nouvel attribut 
        
        
    //Constructeur 
    public CasePrison(){
        super(7 , "Prison"); 
    }
    
    //la méthode pour sortir de prison est-elle ici ?
    //j'auria srajouté en attribut une liste de joueurs qui est dans la prison -> quelle utilité? 
    
     public void sortirPrison(Joueur joueur){
        int avance = joueur.getvaleurDes(); 
        joueur.setEstEnPrison(false); 
        int position = joueur.getPosition();
        joueur.setPosition(position + avance); 
    }
    
    
    /*avoir un boolean estEnPrison dans joueur 
     * int lanceDes dans joueur
     * 
     * 
     * QUAND SORTIR DE PRISON 
     * .à chaque tour passer en prison : lancer les dés 
     * 
     * if(valDe1 == valDe2 || nbToursPrison == 3){
     *  joueur.sortirPrison; //dans la classe joueur? jouer? 
     * } else {
     *   nbToursPrison = nbToursPrison + 1;
     * }
     * 
     * if(aCartePrison == true){
     *  //demander s'il veut sortir de prison 
     *  //bouton oui 
     *      joueur.lancerDes
     * }
     * 
     */
     
   
    
    
    
    
}
