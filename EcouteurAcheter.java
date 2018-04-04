import java.awt.event.* ;
import java.util.* ; 
import javax.swing.*;

public class EcouteurAcheter implements ActionListener{
	
	Joueur j ; 
	CaseProp c ;
	JButton but;
	
	public EcouteurAcheter(Joueur jj, CaseProp cas , JButton button){
		j = jj ;
		c = cas ;
		but = button;
	}
	
	public void actionPerformed(ActionEvent ae){
		
		but.setEnabled(false);
		
		j.setArgent(-c.getPrix());
		j.addCase(c);
		c.setProprietaire(j);
		c.setAchete(true);
	}
}
