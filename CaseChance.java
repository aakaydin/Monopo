public class CaseChance extends Case {
	

	public CaseChance( int pos, String name){
		
		super(pos, name);
		
		}
	
	//première méthode inutile, juste au cas où
	public CarteChance creerCarteChance(Joueur j){
		CarteChance cartelucky = new CarteChance(j);
		return cartelucky; 
	}
	
	public void tirerCarte(Joueur j){
		CarteChance cartelucky = new CarteChance(j);
		cartelucky.tirerCarte();
	}
}
