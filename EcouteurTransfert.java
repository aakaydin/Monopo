import java.awt.event.* ;
import java.util.* ; 

public class EcouteurTransfert implements ActionListener{
	
	
	
	private MenuBanque mb;
	
	
	public EcouteurTransfert(MenuBanque m){
		mb = m;
		
	}
	
	public void actionPerformed(ActionEvent ae){
		MenuTransfert t = new MenuTransfert(400,300,mb.getJoueurCourant(),mb.getListJoueur());  
	}
}

