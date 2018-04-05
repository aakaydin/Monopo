import java.awt.event.* ;
import java.util.* ; 

public class EcouteurRetourBanque implements ActionListener{
	
	private MenuBanque mb;
	
	public EcouteurRetourBanque(MenuBanque m){
		mb = m;
		
	}
	
	public void actionPerformed(ActionEvent ae){
		mb.setVisible(false); 
	}
}
