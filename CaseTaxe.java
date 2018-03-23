import java.awt.* ;
import javax.swing.*;

public class CaseTaxe extends Case{

    //Attributs
    int valAPayer; 
    JPanel panel = new JPanel() ;
    
    //Constructeur 
    public CaseTaxe(String nom , int position, int valeur){
        super(position, "Case taxe");
        valAPayer = valeur; 

        
    }
    
    public int getValAPayer(){
        return valAPayer;
    }
    
    public JPanel getPanel(){
		return panel ;
	}
	
	public void setDescriptionPanel(Joueur j){
		JLabel lab = new JLabel("TAXE ! Vous devez payer "+valAPayer);
        panel.add(lab);
        JButton payer = new JButton("Payer");
        payer.addActionListener(new EcouteurPayer(j, valAPayer));
	}
		
    
    //Est finalement dans la classe Jouer
    //faire action sur le joueur 
    /*public void paieTaxe(Joueur joueur){
        jouer.setArgent(-valAPayer);
        //récupérer la case cagnotte du plateau et augmenter sa somme
        caseCagnotte.ajoutCagnotte(valAPayer);
        */

}
