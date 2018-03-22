import java.awt.event.*;
import java.util.*;

public class EcouteurSuivant1 implements ActionListener {
	
	private MenuPrincipal m1; 
	private int nbJoueur; 
	private int nbIA; 

	
	public EcouteurSuivant1(MenuPrincipal f){ 
		m1=f; 
		if(m1.getnbJoueur().getText()!= null && m1.getnbJoueur().getText()!="0"){
			nbJoueur = Integer.parseInt(m1.getnbJoueur().getText()); 
			System.out.println(m1.getnbJoueur());
			System.out.println(""+nbJoueur); 
		} 
		
		if(m1.getIA().getText()!=null && m1.getIA().getText()!="0"){
			nbIA = Integer.parseInt(m1.getIA().getText()); 
		} 
	} 
	
	public void actionPerformed(ActionEvent e){ 
		
		MenuPrincipal2 m2 = new MenuPrincipal2(400,300,nbJoueur, nbIA);
	}
	
	public int getnbJoueur(){
		return nbJoueur; 
	}
	
	public int getnbIA(){
		return nbIA; 
	}
}
