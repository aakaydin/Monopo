import java.awt.* ;
import javax.swing.*;

public class CaseAllerPrison extends Case{

    //Pas de nouvel attribut 
    JPanel panel = new JPanel() ;
    
    //Constructeur 
    public CaseAllerPrison(){
        super(21 , "Allez en prison!" ); 
        JLabel prison = new JLabel("Vous vous retrouvez en prison");
        panel.add(prison); 
    }
    
    public JPanel getPanel(){return panel;}
	
}
