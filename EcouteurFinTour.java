import java.awt.event.*;
import java.util.*;

public class EcouteurFinTour implements ActionListener {
	
	private FenetreInterface fen; 
	private Joueur jcourant; 

	
	public EcouteurFinTour(FenetreInterface f,Joueur jcourant){ 
		
		fen = f; 
		this.jcourant = jcourant; 
		
	} 
	
	public void actionPerformed(ActionEvent e){ 
		
		jcourant.setSonTour(false); 
		
		
	 
	}
}
