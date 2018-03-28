import java.awt.event.*;

public class EcouteurBtnNonCartePrison implements ActionListener{

    private MaFenetreCartePrison fen; 
    
    public EcouteurBtnNonCartePrison(MaFenetreCartePrison fen){
        this.fen = fen; 
    }
        
    public void actionPerformed(ActionEvent ae){
        fen.setReponse(false);
        fen.dispose();
    }
}
