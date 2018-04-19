import java.awt.*;
import javax.swing.*;

public class FenetreErreurAchatBatiment extends JFrame{

    private JLabel text;
    
    
    public FenetreErreurAchatBatiment(int erreur){
        super("Erreur"); 
        setSize (500 , 100); 
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        
        JPanel cadrePrincipal  = new JPanel(); 
        this.setContentPane(cadrePrincipal);
        
        if(erreur == 1){
            text = new JLabel("La case demandee n'est pas une propriete!");
        }else if(erreur == 2){
            text = new JLabel("Vous n'etes pas proprietaire de cette case."); 
        }else if(erreur == 3){
            text = new JLabel("Vous ne possedez pas toutes les cases de cette couleur."); 
        }else if(erreur == 4){
            text = new JLabel("Vous avez deja 4 maisons. Pensez a les remplacer par un hotel!"); 
        }else if(erreur == 5){
            text = new JLabel("Vous devez construire uniformement. Achetez des maisons sur les autres terrains de cette couleur.");
        }else if(erreur == 6){
            text = new JLabel("Vous devez avoir 4 maisons avant de pouvoir construire un hotel."); 
        }else if(erreur == 7){
            text = new JLabel("Vous ne pouvez avoir qu'un hotel par case"); 
        }else if(erreur == 8){
            text = new JLabel("Vous ne pouvez pas avoir de maison sur une case avec un hotel"); 
        }
            
        text.setForeground(Color.RED); 

        
        cadrePrincipal.add(text);
        
        setVisible(true); 
        
    }
}
