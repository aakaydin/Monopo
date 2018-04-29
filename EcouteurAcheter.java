import java.awt.event.* ;
import java.util.* ; 
import javax.swing.*;

//classe utilisée pour acheter une propriété 
public class EcouteurAcheter implements ActionListener{
	
	//joueur se trouvant sur la case 
	Joueur j ;
	//case associée qui va potentiellement être achetée 
	CaseProp c ;
	//fenêtre interface pour faire la mise à jour de l'interface d'une manière coordonnée avec l'action du joueur 
	public FenetreInterface fen ;
	JButton but;
	
	public EcouteurAcheter(Joueur jj, CaseProp cas , JButton button){
		j = jj ;
		c = cas ;
		but = button;
		
	}
	//permet de faire le réglage de la fenêtre interface
	public void setFenetreInterface(FenetreInterface f){
		fen = f ;
	}
	//permet de faire le réglage du joueur 	
	public void setJoueur(Joueur jj){
		j = jj;
	}
		
	//méthode d'achat
	public void actionPerformed(ActionEvent ae){
		
		//on ne peut acheter qu'une fois la propriété
		but.setEnabled(false);
		//changements joueur : somme d'argent du joueur et ajout de la propriété à la liste de ses propriétés 
		j.setArgent(-c.getPrix());
		j.getMesProprietes().add(c); 
		//changements sur la case 
		c.setProprietaire(j);
		c.setAchete(true);
		//changement de l'affichage 
		fen.changerPanelJoueur(j);
		fen.plateau.getPanelCase( j.getPos()).setCouleurProp( j.col);
		fen.plateau.repaint();
		
		
	}
}
