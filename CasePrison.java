import java.awt.*;
import javax.swing.*;

public class CasePrison extends Case{

    //Pas de nouvel attribut 
        
    
    
    JPanel panel = new JPanel() ;
    
    Joueur j ;
    //Constructeur 
    public CasePrison(){
        super(7 , "Prison"); 
        JLabel arriveprison = new JLabel("Pas de chance, vous tombez en prison");
        panel.add(arriveprison);
    }
    
    //il va y avoir deux cas de Panel différent 
	//j'ai l'impression que l'affichage dans le cas du déjà en prison a été pris en compte par Lisa, il fadra discuter de où on met le code
	//soit on fait en sorte de ne récupérer que lui et l'autre partie du code (beaucoup plus conséquente) est dans la classe jouer soit on récupère les deux et on place une condition en paramètre sur l'état du joueur
		
	public JPanel getPanelArrivePrison(){
		return panel ;
	}
	

    
}
