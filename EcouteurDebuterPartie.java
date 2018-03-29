import java.awt.event.*;
import java.util.*;
import javax.swing.*; 
import java.awt.*; 

public class EcouteurDebuterPartie implements ActionListener {
	
	private MenuPrincipal2 m2; 
	private LinkedList<String> Nom = new LinkedList<String>();  
	private LinkedList<JTextField> text;// = new LinkedList<JTextField>();  
	private int nbJoueur; 
	LinkedList<Joueur> ListJoueur= new LinkedList<Joueur>();
	 

	
	public EcouteurDebuterPartie(MenuPrincipal2 f){ 
		m2=f; 
		nbJoueur = m2.getNbJoueur(); 
		
	} 
	
	public void actionPerformed(ActionEvent e){ 
		//créaton de l'interface à compléter : 
		text = m2.getTextField(); 
		for(JTextField t : text){							//je complète le tableau des noms des joueurs
			Nom.add(t.getText()); 
		}
		
		for(String nom : Nom){ 
			ListJoueur.add(new Joueur(nom,100000,0));
			System.out.println(nom); 
		}
			
	
	
		
		
	}
	
	public LinkedList<Joueur> getNom(){ 
		return ListJoueur; 
	}
}
