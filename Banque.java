public class Banque { 
	
	
	private Joueur J1; 
	private Joueur J2; 
	private int Capital;
	private int dette;
	
	public Banque(){
	}
	
	
	
	public void hypotheque(Joueur j){ 
		 //en cas d'impayé il faut un indicateur pour actionner l'hypotheque
			dette = j.getDette(); 
			if(j.avoirHotel() == true && dette >0){ //il faut une liste d'hotel et savoir si le joeur en a encore
				while(j.getMesHotels() != null){ 
				dette = dette - j.getHotelPlusChere().getPrixHypotheque(); // j'enlève à la dette le prix de l'hypotheque d'un hotel
				j.getMesHotels().remove(j.getMesHotels().indexOf(j.getHotelPlusChere())); // j'enlève l'hotel de la liste
				}
				
			}else if(j.avoirMaison()== true && dette >0){ 
				while(j.getMesMaisons()!= null){ 
				dette = dette - j.getMaisonPlusChere().getPrixHypotheque(); // j'enlève à la dette le prix de l'hypotheque d'une maison
				j.getMesMaisons().remove(j.getMesMaisons().indexOf(j.getMaisonPlusChere())); // j'enlève la maison de la liste
				}
			}else if(j.avoirPropriete()== true && dette >0){ 
				while(j.getMesProprietes()!= null){ 
				dette = dette - j.getProprietePlusChere().getPrixHypotheque(); 
				j.getMesProprietes().remove(j.getMesProprietes().indexOf(j.getProprietePlusChere()));
				}
			}else if(dette >0){ // si la dette n'est toujours pas nulle il faut prélever sur le compte
				j.setArgent(j.getSomme()-dette); 
				if(j.getSomme()<0){ //s'il n'y a plus d'argent le joueur a perdu
					j.tuer(); 
					System.out.println("joueur"+j.getNom()+"a perdu"); 
				} 
			}
			
		} 
		
		public void credit(Joueur j,int somme){ 
			if(j.getSomme()>1000000){ 
				if(somme <= 1000000 ){ 
					j.setArgent(somme); // on crédite le compte de la somme
					double taux = 0.07;
					int tour = 7;
					int remboursement = (int)(12*(somme * (taux/12))/(1-Math.pow(1+(taux/12),-tour*12)));  
					j.remboursementTour(remboursement); //le joueur doit rembourser cette somme a chaque tour
					j.setDette(147975*7); //on doit rembourser en 7 tours.
				}
			}else if(j.getSomme()>100000){ 
				if (somme <= 100000){ 
					double taux  = 0.05;         
					int tour = 7;
					int remboursement = (int)(12*(somme * (taux/12))/(1-Math.pow(1+(taux/12),-tour*12))); 
					j.setArgent(somme);
					j.remboursementTour(remboursement);
					j.setDette(remboursement*7); 
					  
				}
			}else if(j.getSomme()>10000){ 
				if (somme <= 10000){ 
					double taux = 0.03;         
					int tour = 7;
					int remboursement = (int)(12*(somme * (taux/12))/(1-Math.pow(1+(taux/12),-tour*12))); 
					j.setArgent(somme);
					j.remboursementTour(remboursement);
					j.setDette(remboursement*7);
				}
			}else if(j.getSomme()>1000){ 
				if (somme <= 1000){ 
					double taux = 0.03;         
					int tour = 7;
					int remboursement = (int)(12*(somme * (taux/12))/(1-Math.pow(1+(taux/12),-tour*12))); 
					j.setArgent(somme);
					j.remboursementTour(remboursement);
					j.setDette(remboursement*7);
				}
			}
			j.setEndette(true); 
		} 
		
		
			
					
			
		
				 
			
			 
			
			 
		} 
		



