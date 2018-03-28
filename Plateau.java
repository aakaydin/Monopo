import java.awt.* ;
import javax.swing.*;
import java.util.*;

public class Plateau  {
	
	private LinkedList<Case> cases ;
	
	int nbCases = 28 ; 
	
	//objet qui va seulement servir à initialiser les rapports entre plateau et case 

	
	public Plateau(){
		
		cases = new LinkedList<Case>();
		
		CaseDepart cdep = new CaseDepart();
		cases.add(cdep);
		CaseProp p = new CaseProp(1, "Belleville", 6000);
		cases.add(p);
		p = new CaseProp(2, "Lecourbe", 6000);
		cases.add(p);
		
		CaseChance cch = new CaseChance(4, "CHANCE");
		cases.add(cch);
		
		p = new CaseProp(4, "Vaugirard", 10000 );
		cases.add(p);
		p = new CaseProp(5, "Courcelles", 10000);
		cases.add(p);
		p = new CaseProp(6, "Republique", 12000);
		cases.add(p);
		
		CasePrison cpr = new CasePrison();
		cases.add(cpr);
		
		p = new CaseProp(8, "Neuilly", 14000);
		cases.add(p);
		p = new CaseProp(9, "Paradis", 14000);
		cases.add(p);
		
		CaseTaxe ctaxe = new CaseTaxe("TAXE", 10, 2000);
		cases.add(ctaxe);
		
		p = new CaseProp(11, "Mozart", 18000);
		cases.add(p);
		p = new CaseProp(12, "Saint-Michel", 18000);
		cases.add(p);
		p = new CaseProp(13, "Pigalle", 20000);
		cases.add(p);
		
		CaseCagnotte ccagn = new CaseCagnotte() ;
		cases.add(ccagn) ;
		
		p = new CaseProp(15, "Matignon", 22000);
		cases.add(p);
		p = new CaseProp(16, "Malesherbes", 22000);
		cases.add(p);
		p = new CaseProp(17, "Henri-Martin", 24000);
		cases.add(p);
		
		cch = new CaseChance(18, "CHANCE");
		cases.add(cch);
		
		p = new CaseProp(19, "Saint-Honore", 26000);
		cases.add(p);
		p = new CaseProp(20, "La bourse", 26000);
		cases.add(p);
		
		CaseAllerPrison casgopri = new CaseAllerPrison();
		cases.add(casgopri);
		
		p = new CaseProp(22, "Breteuil", 30000);
		cases.add(p);
		p = new CaseProp(23, "Foch", 30000);
		cases.add(p);
		p = new CaseProp(24, "Capucines", 32000);
		cases.add(p);
		
		cch = new CaseChance(25, "CHANCE");
		cases.add(cch);
		
		p = new CaseProp(26, "Champs-Elysee", 30000);
		cases.add(p);
		p = new CaseProp(27, "Paix", 32000);
		cases.add(p);
		
	 
	}
	
	public LinkedList<Case> getCases(){return cases;}
	
	public int getNbCase(){ return cases.size() ;}
	   
       
	

}
