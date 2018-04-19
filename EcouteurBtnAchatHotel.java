import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class EcouteurBtnAchatHotel implements ActionListener {
    
    private MaFenetreAchatBatiment fen; 
    private Plateau plateau; 
    private FenetreInterface fenInt;
    
    public EcouteurBtnAchatHotel(MaFenetreAchatBatiment f , Plateau p , FenetreInterface fI){
        fen = f; 
        plateau = p;
        fenInt = fI; 
    }
    
    public void actionPerformed(ActionEvent ae){
        int res = fen.getEntreeNum(); 
        fen.setNumPropri(res); 
        fen.dispose();
        
        
        //Appliquer les méthodes à la caseProp de ce numéro (un attribut de Case) 
         
        
        System.out.println("Recuperation numero prop " + res); 
        
        fenInt.achatHotel(res);
        
        
        Hotel h = new Hotel(res , plateau); 
        fenInt.getJoueur().ajouterHotel(h);
    }

}
