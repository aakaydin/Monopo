public class Banque { 
	
	
	/*private Joueur J1; 
	private Joueur J2; 
	private int Capital;
	private int dette;
	
	public void transfere(j1,j2){ 
		j2.setArgent(j1.transfertArgent()); 
	}
	
	
	public void hypotheque (j){ 
		 //en cas d'impayé il faut un indicateur pour actionner l'hypotheque
			dette = j.getDette(); 
			if(j.avoirHotel() == true && dette >0){ //il faut une liste d'hotel et savoir si le joeur en a encore
				while(j.getListHotel != null){ 
				dette = dette - j.getHotelPlusChere().getPrixHypotheque(); // j'enlève à la dette le prix de l'hypotheque d'un hotel
				j.getListHotel.remove(getListHotel.indexOf(j.getHotelPlusChere())); // j'enlève l'hotel de la liste
				}
				j.avoirHotel()== false; //je sors de la boucle
			else if(j.avoirMaison()== true && dette >0){ 
				while(j.getListMaison != null){ 
				dette = dette - j.getMaisonPlusChere().getPrixHypotheque(); // j'enlève à la dette le prix de l'hypotheque d'une maison
				j.getListMaison.remove(getListMaison.indexOf(j.getMaisonPlusChere())); // j'enlève la maison de la liste
				}
				}
				j.avoirMaison()== false;
			else if(j.avoirPropriete()== true && dette >0){ 
				while(j.getListPropriete != null){ 
				dette = dette - j.getProprietePlusChere().getPrixHypotheque(); 
				j.getListPropriete.remove(getListPropriete.indexOf(j.getProprietePlusChere()));
				}
				j.avoirPropriete()== false;
			else if(dette >0){ // si la dette n'est toujours pas nulle il faut prélever sur le compte
				j.setcompte(j.getcompte()-dette); 
				if(j.getcompte()<0){ //s'il n'y a plus d'argent le joueur a perdu
					j.abandon(); 
					System.out.prinln("joueur"+j.getnum()+"a perdu"); 
				} 
			}
			
		} */
		
		public void credit(j,somme){ 
			if(j.getCapital()>1000000){ 
				if(somme <= 1000000 ){ 
					j.setCompte(somme); // on crédite le compte de la somme
					int taux = 0.07;
					int tour = 7;
					int remboursement = 12*(somme x (taux/12))/(1-Math.pow(1+(taux/12),-tour*12).     
					j.remboursement_tour(remboursement); //le joueur doit rembourser cette somme a chaque tour
					j.setDette(147975*7); //on doit rembourser en 7 tours.
				}
			else if(j.getCapital()>100000){ 
				if (somme <= 100000){ 
					int taux = 0.05;         
					int tour = 7;
					int remboursement = 12*(somme x (taux/12))/(1-Math.pow(1+(taux/12),-tour*12);
					j.setCompte(somme);
					j.remboursement_tour(remboursement);
					j.setDette(remboursement*7); 
					  
				}
			else if(j.getCapital()>10000){ 
				if (somme <= 10000){ 
					int taux = 0.03;         
					int tour = 7;
					int remboursement = 12*(somme x (taux/12))/(1-Math.pow(1+(taux/12),-tour*12);
					j.setCompte(somme);
					j.remboursement_tour(remboursement);
					j.setDette(remboursement*7);
				} 
			else if(j.getCapital()>1000){ 
				if (somme <= 1000){ 
					int taux = 0.03;         
					int tour = 7;
					int remboursement = 12*(somme x (taux/12))/(1-Math.pow(1+(taux/12),-tour*12);
					j.setCompte(somme);
					j.remboursement_tour(remboursement);
					j.setDette(remboursement*7);
				}
			}
			j.setEndette()== true; 
		} 
		
		
			
					
			
		
				 
			
			 
			
			 
		} 
		


