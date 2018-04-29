import java.util.*;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.* ;

public class EcouteurValiderCredit implements ActionListener{
	
	//fenêtre dans lesquelles ont été rentrées les valeurs par le joueur 
	private MenuCredit mc; 
	//somme du credit 
	private int somme ;
	//joueur qui fait la demande 
	private Joueur jcourant; 
	//pour récupéerer la somme demandée 
	private JTextField text; 
	//va indiquer si le credit est autorisé ou non 
	private JLabel label;
	
	private FenetreInterface fen; 
	
	public EcouteurValiderCredit(MenuCredit m){
		//révupération des données entrées
		mc = m; 
		text = mc.getMontant(); 
		jcourant = mc.getJoueurCourant(); 
		label = mc.getL2();
		fen = m.getFenetre();  
	}
	
		
	
	public void actionPerformed(ActionEvent ae){
		//conversion de la données String en int 
		somme = Integer.parseInt(text.getText());
		//méthode qui va régler le crédit du joueur, ne va rien changer si son patrimine ne lui permet pas de faire un emprunt 
		jcourant.credit(somme);
		if(jcourant.getDette()!=0){
			label.setText("la somme credite est : "+somme+" et vos mensualite seront de : "+jcourant.getMensualite());  
		}else{ 
			
			label.setText("vous n'avez pas assez de capital pour emprunter");
		}
		label.setVisible(true);
		//changement de l'affichage graphique sur l'interface 
		fen.changerPanelJoueur(mc.getJoueurCourant());
		
		//activation et desactivation des boutons 
		fen.getPayerDette().setEnabled(true); 											//je rend disponible le bouton payer credit
		mc.getValiderCredit().setEnabled(false); 
		
		
		
		
		
	}
}
