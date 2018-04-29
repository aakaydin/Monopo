import java.awt.* ;
import javax.swing.*;

public class CaseDepart extends Case {
	
	private String description ;
	private int x ;	
	
	//à chaque case on va associer un JPanel descriptif
	JPanel panel = new JPanel();
	
	
	public CaseDepart(){
		super(0, "Case depart") ; 
		//valeur qui va être versée au joueur quand il tombe sur la case départ 
		x = 20000 ;
		JLabel lab = new JLabel("Vous etes sur la case depart.");
		panel.add(lab); 
	}
	
	
	public JPanel getPanel(){return panel;}
	
	 
	public String toString(){ 
		return description ;
	}
	
	//méthode qui va s'appliquer au joueur et lui verser l'argent 
	public void action(Joueur j){
		j.setArgent(x);
	}
	
}
