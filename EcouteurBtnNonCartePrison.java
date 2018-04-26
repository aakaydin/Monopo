import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import java.util.*;

public class EcouteurBtnNonCartePrison implements ActionListener{

    private MaFenetreCartePrison fen; 
    private FenetreInterface fi;
    
   
    
    public EcouteurBtnNonCartePrison(MaFenetreCartePrison fen, FenetreInterface fi){
        this.fen = fen; 
        this.fi = fi;
        
    }
        
    public void actionPerformed(ActionEvent ae){
        fi.setTextInfo("Lancez les des et faites un double pour sortir");
        fi.pack() ;
        fen.dispose();
    }
}
