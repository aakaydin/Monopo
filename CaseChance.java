public class CaseChance extends Case {
	

	public CaseChance( int pos, String name){
		
		super(pos, name);
		
		}
	
	//première méthode inutile, juste au cas où
	public CarteChance creerCarteChance(Joueur j, FenetreInterface f){
		CarteChance cartelucky = new CarteChance(j,f);
		return cartelucky; 
	}
	
	public void tirerCarte(Joueur j, FenetreInterface f){
		CarteChance cartelucky = new CarteChance(j,f);
		cartelucky.tirerCarte();
	}
}
