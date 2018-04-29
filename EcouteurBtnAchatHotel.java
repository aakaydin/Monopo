import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class EcouteurBtnAchatHotel implements ActionListener {
    

	private MaFenetreAchatBatiment fen; 
	private Plateau plateau; 
	private FenetreInterface fenInt;

	public EcouteurBtnAchatHotel(MaFenetreAchatBatiment f , Plateau p , FenetreInterface fI){
		fen = f; 
		plateau = p;
		fenInt = fI; 
	}

	public void actionPerformed(ActionEvent ae){
		//on veut vérifier que le joueur a bien rentrer un entier comme numéro de case où il veut placer son hotel 
		boolean num = fen.getEntreeNumNature(); 
		int res; 
		if(num == false){
			FenetreErreurAchatBatiment f = new FenetreErreurAchatBatiment(9);
			fen.dispose();
		}else{
			//on récupère le numéro de la propriété 
			res = fen.getEntreeNumInt(); 
			fen.setNumPropri(res); 
			fen.dispose();

			System.out.println("Recuperation numero prop " + res); 
			//permet de réaliser l'achat si cela est possible 
			fenInt.achatHotel(res);
			Hotel h = new Hotel(res , plateau); 
			fenInt.getJoueur().ajouterHotel(h);
			
			fenInt.plateau.repaint();
            		fenInt.pack();
		}

	}

}
