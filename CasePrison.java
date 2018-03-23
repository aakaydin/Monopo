import java.awt.*;
import javax.swing.*;

public class CasePrison extends Case{

    //Pas de nouvel attribut 
        
    JPanel panel = new JPanel() ;
    //Constructeur 
    public CasePrison(){
        super(7 , "Prison"); 
    }
    
   /* public JPanel getPanel(){return panel;}
	public void setDescriptionPanel(Joueur j){
		JLabel = new JLabel("Vous etes en prison");
		if(j.getCarteSortirPrison()){
			JButton sortir = new JButton("Utiliser carte sortir de prison");
			//si il dit non il devra lancer les dés
			JButton non = new JButton("Non merci");
		} else {
			JLabel label = new JLabel("Vous devez lancer les dés pour sortir de prison");
			JButton lancerdes = new JButton("Lancer les des pour sortir de prison"):
			
			panel.add(lancerdes);*/ 
    //soit il a la carte
    //soit il doit lancer les dés
    //si ca fait trois tours qu'il lance les dés et ne fais pas un double il doit payer pour sortir 
    
    //la méthode pour sortir de prison est-elle ici ?
    //j'auria srajouté en attribut une liste de joueurs qui est dans la prison -> quelle utilité? 
    
     /*public void sortirPrison(Joueur joueur){
        int avance = joueur.getvaleurDes(); 
        joueur.setEstEnPrison(false); 
        int position = joueur.getPosition();
        joueur.setPosition(position + avance); 
    }*/
    
    
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
