import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import java.util.*;

//si je commence un tour en prison
public class EcouteurBtnOuiCartePrison implements ActionListener {

    private MaFenetreCartePrison fen;
    private FenetreInterface fi ;

    public EcouteurBtnOuiCartePrison(MaFenetreCartePrison fen, FenetreInterface fi){
        this.fen = fen; 
        this.fi = fi; 
        
    }
    
    public void actionPerformed(ActionEvent ae){
        //changement des attributs du joueur 
        fen.getJoueur().setEnPrison(false);
        fen.getJoueur().setCarteSortirPrison(false);
        //le joueur doit pouvoir continuer son tour comme si il avait commencé hors de prison
        fi.setTextInfo("Vous sortez de prison, lancez les des"); 
        fi.pack();
        fen.dispose();
    }
}
