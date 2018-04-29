import java.awt.* ;
import javax.swing.*;
import java.util.ArrayList;

public class CarteChance {
	
	public String texteAffiche = " CARTE CHANCE " ;
	
	//dans les cas les plus simples, la carte possède une simple description pour son panel 
	public String description ; 
	
	//panel associé à la carte chance qui va s'afficher sur le plateau pour guider le joueur
	public JPanel panelCarteChance = new JPanel(new BorderLayout());
	
	//ecouteur pour faire les actions pour la carte taxe 
	public EcouteurPayerTaxe ecouteurTaxe ;
	
	//FenetreInterface pour mettre à jour l'affichage en fonction de la carte tirée 
	public FenetreInterface fen ;
	
	//joueur qui tire la carte
	public Joueur joueur ;
	
	//liste d'entiers qui permet de faire le tirage au sort de la méthode qui va s'appliquer au tirage 
	ArrayList<Integer> listCart = new ArrayList<Integer>() ; 
	int i = 0 ; //va donner la valeur de la méthode utilisée 
	
	//quand un joueur arrive sur une case on va créer une carte chance avec en attribut se joueur pour que les méthodes puisse s'executer 
	public CarteChance(Joueur j, FenetreInterface f){
		description = "" ; 
		joueur = j ;
		fen = f ;
 
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
		 for(int i =95; i <100 ; i ++){
			 listCart.add(5);
		 }
	}
	
	//getteurs et setteurs 
	public Joueur getJoueur(){
		return joueur ;
	}
	
	public String getDescription(){
		return description ;
	}
	
	public JPanel getPanel(){
		return panelCarteChance ;
	}
	
	public void setJoueur(Joueur j){
		joueur = j ;
	}
	
	//méthode tirer carte qui va sélectionner une carte et effectuer la méthode associée 
	public int tirerCarte(){
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
		
		return i;
	}
	
	//une méthode par type de carte chance 
	//pour l'instant les méthode s'executent toutes seuls mais on pourra peut être faire 
	public void carteAllerEnPrison(){
		description = "Direction la prison !";
		joueur.setEnPrison(true) ;
	}
	
	public void carteRelancerDes(){
		description = "Vous pouvez rejouer !";
		//il faut désactiver fin tour et rendre actif les dés 
		fen.finTour.setEnabled( false );
		fen.lanceDe.setEnabled( true );
		
	}
	
	public void cartePayerFacture(){
		//creation du panel associé qui ne comporte pas une simple description
		description = "Versez 1000 M au systeme de collecte des factures.";
		JButton payer = new JButton("Payer");
		ecouteurTaxe = new EcouteurPayerTaxe(joueur, -1000, fen, payer);
		payer.addActionListener(ecouteurTaxe);
		panelCarteChance.add(payer, BorderLayout.SOUTH); //problème, ce bouton ne s'affiche pas 
		panelCarteChance.repaint();
	}
	public void carteSortirPrison(){
		description = "Carte sortir de prison";
		//va changer l'attribut de joueur pour qu'il sorte de prison 
		joueur.setCarteSortirPrison(true) ;
	}
	
	public void carteMourir(){
		description = "Fin de la partie ! :(";
		joueur.tuer() ; 
		fen.dispose();
		FenetreFinPartie finpartie = new FenetreFinPartie(fen.getLesJoueurs());
		//devrait se faire ouvrir une fenêtre fin de partie
		//ou alors faire changer une variable et en début du tour suivant si cette variable est vrai alors ecouteur fin tour ouvre fenetre fin jeu
	}
	
	
	
	
}
