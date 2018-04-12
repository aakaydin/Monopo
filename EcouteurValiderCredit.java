import java.util.*;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.* ;

public class EcouteurValiderCredit implements ActionListener{
	
	private MenuCredit mc; 
	private int somme ;
	private Joueur jcourant; 
	private JTextField text; 
	private JLabel label;
	private FenetreInterface fen; 
	
	
	
	public EcouteurValiderCredit(MenuCredit m){
		mc = m; 
		text = mc.getMontant(); 
		jcourant = mc.getJoueurCourant(); 
		label = mc.getL2();
		fen = m.getFenetre();  
	}
	
		
	
	public void actionPerformed(ActionEvent ae){
		somme = Integer.parseInt(text.getText());
		jcourant.credit(somme);
		if(jcourant.getDette()!=0){
			label.setText("la somme credite est : "+somme+" et vos mensualite seront de : "+jcourant.getMensualite());  
		}else{ 
			label.setText("vous n'avez pas assez de capital pour emprunter");
		}
		label.setVisible(true);
		fen.getL1().setText("Somme : " +mc.getJoueurCourant().getSomme());
		fen.getPayerDette().setEnabled(true); 											//je rend disponible le bouton payer credit
		
		
		
		
		
		
	}
}
