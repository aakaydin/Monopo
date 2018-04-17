import java.awt.event.*;
import java.awt.* ;
import javax.swing.*;
import java.util.*;


public class EcouteurBtnNonCartePrison implements ActionListener{

    private MaFenetreCartePrison fen; 
    private FenetreInterface fi ; 
    
    private JPanel pan = new JPanel();
    private JLabel lab = new JLabel("Faite un double pour sortir de prison"); 
    
    public EcouteurBtnNonCartePrison(MaFenetreCartePrison fen, FenetreInterface fi){
        this.fen = fen; 
        this.fi = fi;
        
        pan.add(lab); 
    }
        
    public void actionPerformed(ActionEvent ae){
        fi.changerPanelInfo(pan);
        fi.pack();
        fen.dispose();
        
    }
}
