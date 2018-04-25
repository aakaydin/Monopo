import java.awt.event.* ;
import java.util.* ; 
import javax.swing.*;


public class EcouteurAchatBatiment implements ActionListener{

    private FenetreInterface fen; 
    private Plateau plateau; 
    private int numProp;
    private MaFenetreAchatBatiment fenAchat;
    private JButton btn; 
    private String nat; 
    
    public EcouteurAchatBatiment(FenetreInterface f , Plateau pl , JButton btn , String nature){ //pas besoin de case propriete en attribut 
        fen = f; 
        plateau = pl;
        btn = btn; 
        nat = nature; 
    }
    
    public void actionPerformed(ActionEvent ae){
        //Ne s'active que si les trois cases de la même couleur ont le même propriétaire et que ce propriétaire n'est pas null 
        //Récupérer les propriétés d'un joueur 
        //Vérifier qu'il ait toutes les différentes cases d'une même couleur 
    
        //Ouvre une fenêtre 
        fenAchat = new MaFenetreAchatBatiment(plateau, fen , nat);
    }
    
     
}
