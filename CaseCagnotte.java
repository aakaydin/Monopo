import java.awt.* ;
import javax.swing.*;

public class CaseCagnotte extends Case{

/*
o	Possède un nom
o	Class où est accumulé l’argent des taxes et amendes 
o	Doit être remis à 0 si un joueur passe sur la case cagnotte
o	Permet de collecter tout l’argent de la cagnotte
*/

    //Attributs 
    int valAccumulee; 
    JPanel panel = new JPanel() ;
    
    //Constructeur 
    public CaseCagnotte(){
        super(14 , "Cagnotte"); 
        valAccumulee = 0; 
        
    }
    
    
    public JPanel getPanel(){ return panel;}
    
    //permet d'ajouter une somme d'argent à la cagnotte
    public void ajoutCagnotte(int somme){
        valAccumulee = valAccumulee + somme; 
       
    }
    
    //classe qui va s'appliquer au joueur 
    public void recupereCagnotte(Joueur joueur){
        joueur.setArgent(valAccumulee); 
        valAccumulee = 0; 
    }
    
    //permet de régler le panel en focntion de la valeur actuelle de la cagnotte 
    public void setPanel(){
	    	panel.removeAll();
		JLabel lab = new JLabel("Vous avez de la chance, vous gagnez "+valAccumulee);
		panel.add(lab);
		panel.repaint(); 
	}
    
    
    
}
