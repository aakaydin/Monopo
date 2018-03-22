public class CaseTaxe extends Case{

    //Attributs
    int valAPayer; 
    
    //Constructeur 
    public CaseTaxe(String nom , int position, String description , int valeur){
        super("Case taxe" , position, description);
        valAPayer = valeur; 
    }
    
    public int getValAPayer(){
        return valAPayer;
    }
    
    //Est finalement dans la classe Jouer
    //faire action sur le joueur 
    /*public void paieTaxe(Joueur joueur){
        jouer.setArgent(-valAPayer);
        //récupérer la case cagnotte du plateau et augmenter sa somme
        caseCagnotte.ajoutCagnotte(valAPayer);
        */

}
