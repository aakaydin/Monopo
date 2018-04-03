import java.awt.* ;
import javax.swing.*;
import java.util.ArrayList;
//il faudrait créer une classe CarteChance par type de carte chance 
//méthodes avec toutes les actions et on peut faire un choix aléatoire ensuite de la méthode 
//on peut mettre plus de poids pour certaines actions 
//case possède un getJoueur qui donne le joueur qui se reouvent sur la case 
//mettre méthode JPanel dans chaque actions différentes pour le panel de droite 
public class CarteChance {
	
	public String texteAffiche = " CARTE CHANCE " ;
	public String description ; 
	public JPanel panelCarteChance = new JPanel(new BorderLayout());
	
	public Joueur joueur ;
	//liste d'entiers qui permet de faire le tirage au sort de la méthode qui va s'appliquer au tirage 
	ArrayList<Integer> listCart = new ArrayList<Integer>() ; 
	int i = 0 ; //va donner la valeur de la méthode utilisée 
	
	//quand un joueur arrive sur une case il va créer une carte chance avec en attribut se joueur pour que les méthodes puisse s'executer 
	public CarteChance(Joueur j){
		description = "" ; 
		joueur = j ;
 
		/* 1: sortir de prison (20%)
		 * 2: aller en prison (25%)
		 * 3: facture (25%)
		 * 4: relancer dés (25%)
		 * 5: mourir(5%) 
		 */
		 for(int i =0; i <20 ; i ++){
			 listCart.add(1);
		 }
		 for(int i =20; i <45 ; i ++){
			 listCart.add(2);
		 }
		 for(int i =45; i <70 ; i ++){
			 listCart.add(3);
		 }
		 for(int i =70; i <95; i ++){
			 listCart.add(4);
		 }
		 for(int i =95; i <5 ; i ++){
			 listCart.add(5);
		 }
	}
	
	public void setJoueur(Joueur j){
		joueur = j ;
	}
	
	public Joueur getJoueur(){
		return joueur ;
	}
	
	public String getDescription(){
		return description ;
	}
	
	public JPanel getPanel(){
		return panelCarteChance ;
	}
	
	public void tirerCarte(){
		int random = (int)(Math.random()*listCart.size()) ;
		i = listCart.get(random); 
		if(i ==1){
			this.carteAllerEnPrison();
		} else if(i == 2){
			this.carteRelancerDes();
		} else if (i == 3){
			this.cartePayerFacture();
		} else if ( i == 4){
			this.carteSortirPrison() ;
		} else {
			this.carteMourir();
		}
		//ajout de la description associée 
		JLabel d2 = new JLabel(description);
		JLabel d1 = new JLabel(texteAffiche) ;
		panelCarteChance.add(d1, BorderLayout.NORTH);
		panelCarteChance.add(d2, BorderLayout.CENTER);
	}
	
	//une méthode par type de carte chance 
	//pour l'instant les méthode s'executent toutes seuls mais on pourra peut être faire 
	public void carteAllerEnPrison(){
		description = "Direction la prison !";
		joueur.setEnPrison(true) ;
	}
	
	public void carteRelancerDes(){
		description = "Vous pouvez rejouer !";
		//rend actif le bouton pour relancer les des 
		
	}
	
	public void cartePayerFacture(){
		
		description = "Versez 1000 M au systeme de collecte des factures.";
		JButton payer = new JButton("Payer");
		payer.addActionListener(new EcouteurPayerTaxe(joueur, -1000));
		panelCarteChance.add(payer, BorderLayout.CENTER); 
		panelCarteChance.repaint();
	}
	public void carteSortirPrison(){
		description = "Carte sortir de prison";
		
		joueur.setCarteSortirPrison(true) ;
	}
	
	public void carteMourir(){
		description = "Fin de la partie ! :(";
		joueur.tuer() ; 
	}
	
	//une méthode tirerCarte qui va sélectionner une méthode parmi les autres ; il faut que les méthodes aient des possibilités différentes de sortir, on fait une liste d'entiers avec 5 valeurs différentes, chacune de ces 5 valeurs correspond à une méthode 

}
