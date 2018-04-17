import java.awt.* ;
import javax.swing.*;

public class CaseDepart extends Case {
	
	private String description ;
	private int x ;
	//priavet String texetAffiche ; affichage du texte sur le plateau 
	//si toutes les cases ont un prix alors il faut aussi :
	
	
	//à chaque case on va associer un JPanel descriptif
	JPanel panel = new JPanel();
	
	public CaseDepart(){
		super(0, "Case depart") ; 
		x = 20000 ;
		//String desription = "Vous passez par la case départ et vous recevez " + x + " M.";
		//couleur = Color.GREY //les couleurs devraient être dans Case 
		//texteAffiche = "CASE DEPART" ; //le texte affcie devrait être dans Case 
		JLabel lab = new JLabel("Vous etes sur la case depart.");
		panel.add(lab); 
	}
	
	//methode qui pourrait être dans Case 
	public String toString(){ 
		return description ;
	}
	
	public JPanel getPanel(){return panel;}
	
	public void action(Joueur j){
		j.setArgent(x);
	}
	
	//fait-on une méthode afficher pour l'interface graphique plus tard ?
	
	
}
