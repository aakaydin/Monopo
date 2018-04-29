import java.awt.event.*;
import java.util.*;

public class EcouteurSuivant1 implements ActionListener {
	
	private MenuPrincipal m1; 
	private MenuPrincipal2 m2;
	private int nbJoueur; 
	private int nbIA; 
	
	//cet écouteur va permettre de passer du premier menu ou on indique le nombre du joueur et la présence d'une interface graphique 
	//au deuxième menu où on rentre les noms des différents joueurs
	public EcouteurSuivant1(MenuPrincipal f, MenuPrincipal2 m2){ 
		super();
		m1=f; 
		this.m2 = m2; 
		
	} 
	
	public void actionPerformed(ActionEvent e){ 
		
		//il faut vérifier que la case où on rentre le nombre de joueurs n'est pas vide 
		if(m1.getnbJoueur().getText()!= null){
			nbJoueur = Integer.parseInt(m1.getnbJoueur().getText()); 
		} 
		//si on a une intelligence artificielle il faut l'ajouter dans la partie 
		if(m1.getIA()){
			nbIA = 1; 
		} 
		//on règle le nombre de joueurs 
		m2.setNbJoueur(nbJoueur); 
		//on règle le nombre d'IA qui pour l'instant ne peut être égal qu'à 0 ou 1
		m2.setNbIA(nbIA); 
		m2.FinishFrame(nbJoueur, nbIA); 
		m2.setVisible(true); 
		m1.setVisible(false); 
	}
	
	//getteurs 
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
