import java.awt.event.*;
import java.util.*;

public class EcouteurNouvellePartie implements ActionListener {
	
	FenetreFinPartie fen;
	
	public EcouteurNouvellePartie(FenetreFinPartie ffp){ //Permet de commencer une nouvelle partie après arrêt d'une autre partie (sans réexecuter Principal) par le biais de FenetreFinPartie
		fen = ffp;
	}
	
	public void actionPerformed(ActionEvent ae){
		
		fen.dispose();
		MenuPrincipal m1 = new MenuPrincipal(400,300);
		
	}
	
}
