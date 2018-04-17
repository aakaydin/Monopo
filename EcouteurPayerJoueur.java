import java.awt.event.* ;
import java.util.* ; 

public class EcouteurPayerJoueur implements ActionListener{
	
	Joueur j ; 
	Joueur proprietaire ;
	CaseProp c ;
	FenetreInterface fen ;
	
	
	public EcouteurPayerJoueur(Joueur prop, Joueur jj, CaseProp cas){
		j = jj ;
		proprietaire = prop ; 
		c = cas ;
		
	}
	
		public void setJoueur(Joueur jj){
		j = jj;
	}
		
	
	public void setFenetreInterface(FenetreInterface f){
		fen = f ;
	}
	
	public void actionPerformed(ActionEvent ae){
		int prix = c.getPrix() ;
		j.setArgent(-prix);
		
		proprietaire.setArgent(prix) ;
		fen.changerPanelJoueur(j);
	}
		
		
		
}