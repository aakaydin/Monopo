import java.awt.*;
import javax.swing.*;

//classe qui ne concerne que le traitement à faire quand on arrive en prison en lancant les dés et en tombant sur la case prison 
public class CasePrison extends Case{
	
	JPanel panel = new JPanel();
	public CasePrison(){
		super(7 , "Prison"); 
		JLabel arriveprison = new JLabel("Pas de chance, vous tombez en prison");
		panel.add(arriveprison);
    	}
		
	public JPanel getPanel(){
		return panel ;
	}
	

    
}
