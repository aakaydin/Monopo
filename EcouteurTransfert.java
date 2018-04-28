import java.awt.event.* ;
import java.util.* ; 

public class EcouteurTransfert implements ActionListener{
	
	
	
	private MenuBanque mb;
	private FenetreInterface fen ;
	
	
	public EcouteurTransfert(MenuBanque m, FenetreInterface f){
		mb = m;
		fen = f ; 
		
	}
	
	//va ouvrir la fenêtre adaptée aux transferts 
	public void actionPerformed(ActionEvent ae){
		MenuTransfert t = new MenuTransfert(400,300,mb.getJoueurCourant(),mb.getListJoueur(), fen);  
	}
}

