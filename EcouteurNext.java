import java.awt.event.*;
import java.util.*;

public class EcouteurNext implements ActionListener{

	private FenetreInterface fen;
	
	public EcouteurNext( FenetreInterface fenetre){
		
		fen = fenetre;
		
		} 


    //actionPerformed indique les instructions a executer au clic du bouton
    public void actionPerformed(ActionEvent e){

			fen.pTemp++;
			fen.panelTemp = fen.P.getCases().get(fen.pTemp).getPanel();
			
			System.out.println(" Next Case");
			
			//System.out.println(fen.getPrivateMessage());

    }

}
