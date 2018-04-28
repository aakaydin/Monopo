import java.awt.* ;
import javax.swing.*;

public class CaseDepart extends Case {
	
	private String description ;
	private int x ;	
	
	//à chaque case on va associer un JPanel descriptif
	JPanel panel = new JPanel();
	
	
	public CaseDepart(){
		super(0, "Case depart") ; 
		x = 20000 ;
		JLabel lab = new JLabel("Vous etes sur la case depart.");
		panel.add(lab); 
	}
	
	
	public JPanel getPanel(){return panel;}
	
	 
	public String toString(){ 
		return description ;
	}
	
	
	public void action(Joueur j){
		j.setArgent(x);
	}
	
}
