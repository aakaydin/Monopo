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
        //setPanel(); pourquoi Aydin ?
    }
    
    
    public JPanel getPanel(){ return panel;}
    
    public void ajoutCagnotte(int somme , Joueur joueur){
        valAccumulee = valAccumulee + somme; 
        joueur.setArgent(-somme);
    }
    
    
    public void recupereCagnotte(Joueur joueur){
        joueur.setArgent(valAccumulee); //A FAIRE (en plus de set somme (et pourrait faire des valeurs négatives)) 
        valAccumulee = 0; 
    }
    
    public void setPanel(){
	    	panel.removeAll();
		JLabel lab = new JLabel("Vous avez de la chance, vous gagnez "+valAccumulee);
		panel.add(lab);
	}
    
    
    
}
