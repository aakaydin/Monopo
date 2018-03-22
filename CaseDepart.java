import java.awt.* ;
import javax.swing.*;

public class CaseDepart extends Case {
	
	private String description ;
	private int x ;
	//priavet String texetAffiche ; affichage du texte sur le plateau 
	//si toutes les cases ont un prix alors il faut aussi :
	private int prix = 0;
	private int position = 0; 
	
	public CaseDepart(){
		super.("Case départ", position) ; 
		x = 200 ;
		String desription = "Vous passez par la case départ et vous recevez " + x + " M.";
		//couleur = Color.GREY //les couleurs devraient être dans Case 
		//texteAffiche = "CASE DEPART" ; //le texte affcie devrait être dans Case 
	}
	
	//methode qui pourrait être dans Case 
	public String toString(){ 
		return description ;
	}
	
	public void action(Joueur j){
		j.setArgent(x);
	}
	
	//fait-on une méthode afficher pour l'interface graphique plus tard ?
	
	
}
