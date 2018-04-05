import java.awt.event.* ;
import java.util.* ; 

public class EcouteurBanque implements ActionListener{
	
	private FenetreInterface fen;
	
	public EcouteurBanque(FenetreInterface f){ //on va récupérer le joueur courant via cette écouteur, car le joueur courant est dans fen
		fen = f;
	}
	
	public void actionPerformed(ActionEvent ae){
		MenuBanque mb = new MenuBanque(400,300,fen.getJoueur(),fen.getLesJoueurs()); //importe le joueur courant et la list de joueur; 
	}
	
	
}
