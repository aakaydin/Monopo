import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import java.util.*;


public class EcouteurBtnOuiCartePrison implements ActionListener {

    private MaFenetreCartePrison fen; 
    private FenetreInterface fi ;
    
    
    
    
    public EcouteurBtnOuiCartePrison(MaFenetreCartePrison fen, FenetreInterface fi){
        this.fen = fen; 
        this.fi = fi; 
        
    }
    
    public void actionPerformed(ActionEvent ae){
        fen.getJoueur().setEnPrison(false);
        fen.getJoueur().setCarteSortirPrison(false);
        
        fi.setTextInfo("Vous sortez de prison, lancez les des"); 
        fi.pack();
        fen.dispose();
    }
}
