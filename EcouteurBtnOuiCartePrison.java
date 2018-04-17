import java.awt.event.*;
import java.awt.* ;
import javax.swing.*;
import java.util.*;


public class EcouteurBtnOuiCartePrison implements ActionListener {

    private MaFenetreCartePrison fen; 
    private FenetreInterface fi ; 
    
    private JPanel pan = new JPanel();
    private JLabel lab = new JLabel("Vous sortez de prison, lancer les des"); 
    
    public EcouteurBtnOuiCartePrison(MaFenetreCartePrison fen, FenetreInterface fi){
        this.fen = fen; 
        this.fi = fi ;
        
        pan.add(lab);
    }
    
    public void actionPerformed(ActionEvent ae){
        fen.getJoueur().setEnPrison(false);
        fen.getJoueur().setCarteSortirPrison(false);
        fi.changerPanelInfo(pan);
        fi.pack();
        fen.dispose();
        
        
        
        
        
    }
}
