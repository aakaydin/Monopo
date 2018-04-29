import java.awt.event.* ;
import java.util.* ; 

//méthode qui va ouvrir un menu banque : fenêtre où le joueur pourra prendre un crédit ou faire un transfert 
public class EcouteurBanque implements ActionListener{
	
	private FenetreInterface fen;
	
	public EcouteurBanque(FenetreInterface f){ //on va récupérer le joueur courant via cette écouteur, car le joueur courant est dans fen
		fen = f;
	}
	
	public void actionPerformed(ActionEvent ae){
		MenuBanque mb = new MenuBanque(400,300,fen.getJoueur(),fen.getLesJoueurs(), fen); //importe le joueur courant et la list de joueur; 
	}
	
	
}
