import java.awt.event.* ;
import java.util.* ; 

//ecouteur qui va permettre de rendre invisible la fenêtre de femeture 
public class EcouteurFinaliserTransaction implements ActionListener{
	
	private MenuCredit mc;
	
	public EcouteurFinaliserTransaction(MenuCredit m){
		mc = m;
		
	}
	
	public void actionPerformed(ActionEvent ae){
		mc.setVisible(false); 
	}
}
