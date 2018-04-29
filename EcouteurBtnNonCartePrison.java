import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import java.util.*;

//quand je suis en prison et que je possède une carte prison, une fenêtre apparait pour me proposer de l'utiliser, elle possède deux boutons oui et non 
public class EcouteurBtnNonCartePrison implements ActionListener{

    private MaFenetreCartePrison fen; 
    private FenetreInterface fi;
    
   
    
    public EcouteurBtnNonCartePrison(MaFenetreCartePrison fen, FenetreInterface fi){

        this.fen = fen; 
        this.fi = fi;
        
    }
    
    public void actionPerformed(ActionEvent ae){
        //l'affichage du jeu va alors être mis en place comme si le joueur n'avait pas eu la carte 
        fi.setTextInfo("Lancez les des et faites un double pour sortir");
        fi.pack() ;
        //fermeture de la fenêtre de choix 
        fen.dispose();
        
    }
}
