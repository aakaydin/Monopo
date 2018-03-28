import java.awt.event.*;


public class EcouteurBtnOuiCartePrison implements ActionListener {

    private MaFenetreCartePrison fen; 
    
    public EcouteurBtnOuiCartePrison(MaFenetreCartePrison fen){
        this.fen = fen; 
    }
    
    public void actionPerformed(ActionEvent ae){
        fen.setReponse(true);
        fen.dispose();
    }
}
