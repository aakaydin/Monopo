public class CaseChance extends Case {
	

	public CaseChance( int pos, String name){
		
		super(pos, name);
		
	}
	
	//méthode qui va créer une carteChance lorsqu'on arrive sur la case avec en paramètre le joueur et la FenetreInterface pour pouvoir intéragir avec eux 
	public CarteChance creerCarteChance(Joueur j, FenetreInterface f){
		CarteChance cartelucky = new CarteChance(j,f);
		return cartelucky; 
	}

}
