import java.awt.event.*;
import java.util.*;

public class EcouteurNouvellePartie implements ActionListener {
	FenetreFinPartie fen ;
	
	public EcouteurNouvellePartie(FenetreFinPartie ffp){
		fen = ffp ;
	}
	
	public void actionPerformed(ActionEvent ae){
		fen.dispose();
		MenuPrincipal m1 = new MenuPrincipal(400,300);
		
	}
	
}
