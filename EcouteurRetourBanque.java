import java.awt.event.* ;
import java.util.* ; 

public class EcouteurRetourBanque implements ActionListener{
	
	private MenuBanque mb;
	
	public EcouteurRetourBanque(MenuBanque m){
		mb = m;
		
	}
	
	//la méthode de cette classe va fermer la fenêtre de la banque 
	public void actionPerformed(ActionEvent ae){
		mb.setVisible(false); 
	}
}
