import java.awt.event.*;
import java.util.*;

public class EcouteurSuivant1 implements ActionListener {
	
	private MenuPrincipal m1; 
	private MenuPrincipal2 m2;
	private int nbJoueur; 
	private int nbIA; 
	

	
	public EcouteurSuivant1(MenuPrincipal f, MenuPrincipal2 m2){ 
		super();
		m1=f; 
		this.m2 = m2; 
		
	} 
	
	public void actionPerformed(ActionEvent e){ 
		
		
		if(m1.getnbJoueur().getText()!= null){
			nbJoueur = Integer.parseInt(m1.getnbJoueur().getText()); 
		} 
		
		if(m1.getIA().getText()!=null){
			nbIA = Integer.parseInt(m1.getIA().getText()); 
		} 
		m2.setNbJoueur(nbJoueur); 
		m2.setNbIA(nbIA); 
		m2.FinishFrame(nbJoueur, nbIA); 
		m2.setVisible(true); 
		m1.setVisible(false); 
	}
	
	public int getnbJoueur(){
		return nbJoueur; 
	}
	
	public int getnbIA(){
		return nbIA; 
	}
	
	public MenuPrincipal2 getM2(){ 
		return m2; 
	}
}
