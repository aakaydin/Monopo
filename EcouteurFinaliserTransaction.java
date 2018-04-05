import java.awt.event.* ;
import java.util.* ; 

public class EcouteurFinaliserTransaction implements ActionListener{
	
	private MenuCredit mc;
	
	public EcouteurFinaliserTransaction(MenuCredit m){
		mc = m;
		
	}
	
	public void actionPerformed(ActionEvent ae){
		mc.setVisible(false); 
	}
}
