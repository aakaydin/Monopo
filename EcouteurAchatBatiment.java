import java.awt.event.* ;
import java.util.* ; 
import javax.swing.*;


public class EcouteurAchatBatiment implements ActionListener{

    //fenêtre de jeu 
    private FenetreInterface fen; 
    //liste des cases 
    private Plateau plateau; 
    private int numProp;
    //fenêtre qui permet d'acheter des batiments qui va être ouverte par cet écouteur 
    private MaFenetreAchatBatiment fenAchat;
    private JButton btn;
    //string qui permet de savoir si on veut une maison ou un hotel 
    private String nat; 
    
    public EcouteurAchatBatiment(FenetreInterface f , Plateau pl , JButton btn , String nature){ //pas besoin de case propriete en attribut 
        fen = f; 
        plateau = pl;
        btn = btn; 
        nat = nature; 
    }
    
    public void actionPerformed(ActionEvent ae){
       
        //Ouvre une fenêtre 
        fenAchat = new MaFenetreAchatBatiment(plateau, fen , nat);
    }
    
     
}
