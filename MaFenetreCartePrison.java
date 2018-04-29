import java.awt.*;
import javax.swing.*;

public class MaFenetreCartePrison extends JFrame{

	private JLabel indications; 
	private JButton btnOui; 
	private JButton btnNon;
	private boolean reponse = false;  

	private Joueur jcourant ;

	FenetreInterface fen ; 

	public MaFenetreCartePrison(Joueur j, FenetreInterface f){ 
		super("Carte Prison"); 

		setSize (1000 , 100); 
		
		//il faut bien utiliser le joueur dont c'est le tour
		jcourant = j;
		fen = f;  

		JPanel cadrePrincipal = new JPanel (); 
		this.setContentPane(cadrePrincipal); 

		//Instructions 
		indications = new JLabel("Vous etes en prison or vous possedez une carte vous permettant d en sortir! Voulez-vous l utiliser?"); 
		cadrePrincipal.add(indications); 

		//Boutons 
		btnOui = new JButton("Oui"); 
		cadrePrincipal.add(btnOui); 
		//ajout de l'écouteur associé au bouton
		EcouteurBtnOuiCartePrison ecouteurBtnOui = new EcouteurBtnOuiCartePrison(this, fen); 
		btnOui.addActionListener(ecouteurBtnOui); 

		btnNon = new JButton("Non"); 
		cadrePrincipal.add(btnNon);
		//ajout de l'écouteur associé au bouton 
		EcouteurBtnNonCartePrison ecouteurBtnNon = new EcouteurBtnNonCartePrison(this, fen); 
		btnNon.addActionListener(ecouteurBtnNon); 


		setVisible(true);
	}

	public void setReponse(boolean res){
		reponse = res; 
	}

	public boolean getReponse(){
		return reponse;
	}

	public Joueur getJoueur(){
		return jcourant;
	}

}
