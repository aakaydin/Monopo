import java.awt.* ;
import javax.swing.*;

public class CaseTaxe extends Case{

    	//Attributs
    	int valAPayer; 
    	JPanel panel = new JPanel(new BorderLayout()) ;
    
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
	
	//permet de connecter le bouton payer au joueur se trouvant sur la case pour changer la somme du bon joueur 
	public void setDescriptionPanel(Joueur j, FenetreInterface f){
		panel.removeAll();
		JLabel lab = new JLabel("TAXE ! Vous devez payer "+valAPayer);
       		panel.add(lab, BorderLayout.NORTH);
        	JButton payer = new JButton("Payer");
        	payer.addActionListener(new EcouteurPayerTaxe(j, -valAPayer, f,payer));
       		panel.add(payer, BorderLayout.SOUTH);
       		panel.repaint();
	}
		


}
